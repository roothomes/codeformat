package com.roothomes.mq.mqClientHandler;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

import com.apec.framework.common.StringUtil;
import com.apec.framework.common.enumtype.MqHandlerResult;
import com.apec.framework.common.util.JsonUtil;
import com.apec.framework.mq.BaseClientHandler;
import com.roothomes.mq.service.IRabbitMQContent;
import com.roothomes.mq.vo.HeartBeatVo;

@Component
public class RabbitMQClientHandler extends BaseClientHandler 
{

    private static Logger _log = LoggerFactory.getLogger(RabbitMQClientHandler.class);
    
    @Override
    public MqHandlerResult handleMessage(Message message)
    {
        _log.info("{} {} ，消息开始---> {} ",IRabbitMQContent.SERVICE_NAME,IRabbitMQContent.MQ_HEARTbEAT_NAME,message);
        String json = new String(message.getBody());
        if(!StringUtil.isEmpty(json)){
        	HeartBeatVo vo = null;
            try{
                vo = JsonUtil.parseObject(json, HeartBeatVo.class);
                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                cal.add(Calendar.HOUR, -1);
                Date earliestTime = cal.getTime();
                //一个小时的有效时间
                boolean flagTime = (new Date(vo.getSendTime()).compareTo(earliestTime) > 0 );
                _log.info("是否为一个小时内消息:{}",flagTime);
                return MqHandlerResult.SUCCESS;
            }catch (Exception e){
                _log.error("{} {} ，消息格式错误 ---> {} \n {}",IRabbitMQContent.SERVICE_NAME,IRabbitMQContent.MQ_HEARTbEAT_NAME,json,e);
                return MqHandlerResult.REJECT;
            }
        }else{
        	 _log.info("{} {} ，消息内容为空---> {} ",IRabbitMQContent.SERVICE_NAME,IRabbitMQContent.MQ_HEARTbEAT_NAME,message);
            return MqHandlerResult.REJECT;
        }
    }

}
