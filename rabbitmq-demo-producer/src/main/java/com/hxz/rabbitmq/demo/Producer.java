package com.hxz.rabbitmq.demo;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * producer
 * Created by hxz on 1/5/17.
 */
@Service
public class Producer {
    @Autowired
    private RabbitMessagingTemplate rabbitMessagingTemplate;
    @Autowired
    private MappingJackson2MessageConverter mappingJackson2MessageConverter;

    public void produceMsg(String msg,String extraContent){
        rabbitMessagingTemplate.setMessageConverter(mappingJackson2MessageConverter);

        Map<String,Object> info = new HashMap<>();
        info.put("extraContent",extraContent);
        rabbitMessagingTemplate.convertAndSend("exchange",RabbitmqConfig.TEST_MESSAGE,msg,info);
    }

    public void produceMsg(List<String> msgs, String extraContent){
        rabbitMessagingTemplate.setMessageConverter(mappingJackson2MessageConverter);

        Map<String,Object> info = new HashMap<>();
        info.put("extraContent",extraContent);
        rabbitMessagingTemplate.convertAndSend("exchange",RabbitmqConfig.TEST_MESSAGES,msgs,info);
    }
}
