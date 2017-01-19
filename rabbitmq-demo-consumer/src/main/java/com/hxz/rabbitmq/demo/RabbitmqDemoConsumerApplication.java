package com.hxz.rabbitmq.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hxz.rabbitmq.demo")
public class RabbitmqDemoConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqDemoConsumerApplication.class, args);
	}
}
