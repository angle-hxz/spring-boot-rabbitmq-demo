package com.hxz.rabbitmq.demo;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 *
 * Created by hxz on 1/4/17.
 */
@Service
public class Consumer {
    @RabbitListener(queues = "demo.message")
    public void receiveMessage(String message){
        System.out.println("Received msg<" + message + ">");
    }
}
