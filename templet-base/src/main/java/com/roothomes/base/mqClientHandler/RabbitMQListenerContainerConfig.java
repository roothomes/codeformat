package com.roothomes.base.mqClientHandler;


import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.apec.framework.common.enumtype.RoutingKey;
import com.apec.framework.mq.ConsumerConfig;

@Configuration
public class RabbitMQListenerContainerConfig extends ConsumerConfig {
    @Autowired
    RabbitMQClientHandler clientHandler;

    @Bean
    public SimpleMessageListenerContainer orderToContractMessageListenerContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
//        container.setMessageConverter(messageConverter());
        container.setPrefetchCount(50);
        //如果设置手动消费，那么需要使用Channel.basicAck()进行数据返回，
        //所以MessageListener需要实现ChannelAwareMessageListener接口
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);//设置手动确认消息被消费
        container.setQueueNames(RoutingKey.TEST.getName());//添加监听队列
        container.setMessageListener(clientHandler);//如果设置AcknowledgeMode为手动，那么需要使用这个
        return container;
    }
    
}
