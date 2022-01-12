package com.musib.sb.kafka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.musib.sb.kafka.producer.KafkaProducer;

@SpringBootApplication
public class ApacheKafkaBasicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApacheKafkaBasicsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(KafkaProducer kafkaProducer) {
		return args -> kafkaProducer.sendMessage();
	}

}
