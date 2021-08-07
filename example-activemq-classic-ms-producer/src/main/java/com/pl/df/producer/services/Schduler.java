package com.pl.df.producer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.pl.df.lib.dtos.TestValue;

import lombok.extern.log4j.Log4j2;

@Service
@EnableScheduling
@Log4j2
public class Schduler {

	@Autowired
	private ProducerService producerService;
	
	@Scheduled(fixedDelay = 1 * 10_000)
	public void start() {
		log.info("Starting sending messages...");
		TestValue sendTestResultMessage = producerService.sendTestValuetMessage();
		String sendStringMessage = producerService.sendStringValueMessage();
	}
	
}
