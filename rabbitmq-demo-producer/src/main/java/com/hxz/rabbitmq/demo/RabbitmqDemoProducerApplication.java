package com.hxz.rabbitmq.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hxz.rabbitmq.demo")
public class RabbitmqDemoProducerApplication implements CommandLineRunner{
	@Autowired
	private Producer producer;

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqDemoProducerApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		for(int i = 0;i < 100;i++){
			producer.produceMsg("index"+ i,"extraContent");
		}
	}
}
