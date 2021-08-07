package com.pl.df.example.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.pl.df.example.configurations.JmsConfig;
import com.pl.df.example.controllers.dto.TestValue;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class ProducerService {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Gson gson;
	
	public TestValue sendTestValuetMessage() {
		int id = createId();
		TestValue testValue = new TestValue(id, "Test value is " + id);
		jmsTemplate.convertAndSend(JmsConfig.TEST_VALUE_QUEUE, gson.toJson(testValue));
		
		log.info("-> Send " + testValue + " message into <" + JmsConfig.TEST_VALUE_QUEUE + "> queue");
		return testValue;
	}
	
	public String sendStringValueMessage() {
		String stringMessage = "Test string message is: " + createId();
		jmsTemplate.convertAndSend(JmsConfig.TEST_STRING_QUEUE, gson.toJson(stringMessage));
		
		log.info("-> Send " + stringMessage + " message into <" + JmsConfig.TEST_VALUE_QUEUE + "> queue");
		return stringMessage;
	}
	
	
	
	
	private int createId() {
		return new Random().nextInt(Integer.MAX_VALUE);
	}
	
}
