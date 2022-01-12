package com.musib.sb.kafka.producer;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class KafkaProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage() {
		Stream.of(1,2,3,4,5).forEach((i)-> {
			ListenableFuture<SendResult<String, String>> listenableFuture = this.kafkaTemplate.send("courses",
					"Course no "+i);
			listenableFuture.addCallback((result) -> {
				System.out.println(result);
			}, (ex) -> {
				ex.printStackTrace();
			});
			
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
	}

}
