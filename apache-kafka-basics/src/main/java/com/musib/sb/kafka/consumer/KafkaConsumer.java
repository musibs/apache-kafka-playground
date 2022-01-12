package com.musib.sb.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	@KafkaListener(topics = "courses", groupId = "group_id")
	public void receiveMessage(String message) {
		System.out.println("Message "+message);
		if(message.contains("3")) {
			throw new RuntimeException();
		}
	}
	
}
