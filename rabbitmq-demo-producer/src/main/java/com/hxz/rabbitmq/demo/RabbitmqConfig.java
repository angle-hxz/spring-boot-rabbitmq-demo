package com.hxz.rabbitmq.demo;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

/**
 *
 * Created by hxz on 1/5/17.
 */
@Configuration
public class RabbitmqConfig {
    public final static String TEST_MESSAGE = "demo.message";
    public final static String TEST_MESSAGES = "demo.messages";

    @Bean
    Queue queueMessage(){
        return new Queue(TEST_MESSAGE,false);
    }

    @Bean
    Queue queueMessages(){
        return new Queue(TEST_MESSAGES,false);
    }

    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange("exchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage,TopicExchange topicExchange){
        return BindingBuilder.bind(queueMessage).to(topicExchange).with(TEST_MESSAGE);
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages,TopicExchange topicExchange){
        return BindingBuilder.bind(queueMessages).to(topicExchange).with(TEST_MESSAGES);
    }

    @Bean
    public MappingJackson2MessageConverter mappingJackson2MessageConverter(){
        return new MappingJackson2MessageConverter();
    }
}
