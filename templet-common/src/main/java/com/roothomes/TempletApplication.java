package com.roothomes;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.apec.framework.base.BaseApplication;
import com.apec.framework.common.enumtype.RoutingKey;
import com.apec.framework.mq.ConsumerConfig;
import com.apec.framework.mq.ProducerConfig;
import com.apec.framework.springcloud.SpringCloudConfig;

/**
 * @author roothomes
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableScheduling
@Import(value = {SpringCloudConfig.class, ProducerConfig.class, ConsumerConfig.class})
public class TempletApplication extends BaseApplication{

    public static void main(String[] args) 
    {
    	System.out.println("TempletApplication ==> 启动应用");
    	ProducerConfig.setKey(RoutingKey.TEST);
        RoutingKey[] routingKeys = {};
        ProducerConfig.setKeyArray(routingKeys);
        new SpringApplicationBuilder(TempletApplication.class).web(true).run(args);
    }
}
