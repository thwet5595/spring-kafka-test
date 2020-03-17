package com.thwet.kafka.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class TestApplication implements ApplicationRunner {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage() {
		for (int i = 0; i < 100; i++) {
			kafkaTemplate.send("secondtest", String.valueOf(i));
		}
		// kafkaTemplate.send("tutorialspoint", msg);
	}

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@KafkaListener(topics = "secondtest", groupId = "group1")
	public void listen_first(String message) {
		// System.out.println("Received Messasge in group - group-id: " +
		// message);
		System.out.println("Message 1..." + message);
	}

	@KafkaListener(topics = "secondtest", groupId = "group1")
	public void listen_second(String message) {
		// System.out.println("Received Messasge in group - group-id: " +
		// message);
		System.out.println("Message 2..." + message);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		sendMessage();
	}
}
