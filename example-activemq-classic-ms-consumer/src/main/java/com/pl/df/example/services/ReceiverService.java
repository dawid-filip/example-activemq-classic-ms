package com.pl.df.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.pl.df.example.configurations.JmsConfig;
import com.pl.df.example.controllers.dto.TestValue;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class ReceiverService {

	@Autowired
	private Gson gson;
	
	@JmsListener(destination = JmsConfig.TEST_VALUE_QUEUE) //, containerFactory = "jmsFactory")
	public void receiveTestValueObjectMessage(String testValueJson) {
		TestValue testValue = gson.fromJson(testValueJson, TestValue.class);
		log.info("<- Recive " + testValue.toString() + " message from <" + JmsConfig.TEST_VALUE_QUEUE + "> queue");
	}
	
	@JmsListener(destination = JmsConfig.TEST_STRING_QUEUE) //, containerFactory = "jmsFactory")
	public void receiveTestStringValueMessage(String testStringValueJson) {
		String testStringValue = gson.fromJson(testStringValueJson, String.class);
		log.info("<- Recive " + testStringValue + " message from <" + JmsConfig.TEST_STRING_QUEUE + "> queue");
	}
	
	
}
