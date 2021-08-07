package com.pl.df.example.controllers.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pl.df.example.controllers.dto.TestValue;
import com.pl.df.example.services.ProducerService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("active-mq-classic")
@Log4j2
public class ProducerRestController {

	@Autowired
	private ProducerService producer;
	
	// http://localhost:8080/active-mq-classic/send
	@GetMapping("/send")
	public List<Object> sendMessages() {
		log.info("Executing </send> REST API...");
		
		TestValue testValue = producer.sendTestValuetMessage();
		String testStringValue = producer.sendStringValueMessage();
		
		List<Object> list = new ArrayList<>();
		list.add(testValue.toString());
		list.add(testStringValue);
		
		return list;
	}
	
	// http://localhost:8080/active-mq-classic/send/test-value
	@GetMapping("/send/test-value")
	public TestValue sendTestValueMessage() {
		log.info("Executing </send/test-value> REST API...");
		return producer.sendTestValuetMessage();
	}
	
	// http://localhost:8080/active-mq-classic/send/test-string-value
	@GetMapping("/send/test-string-value")
	public String sendTestStringValueMessage() {
		log.info("Executing </send/test-string-value> REST API...");
		return producer.sendStringValueMessage();
	}
	
	
}
