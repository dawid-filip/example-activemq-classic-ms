package com.pl.df.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//(scanBasePackages = {
//		"com.pl.df.lib", 
//		"com.pl.df.producer",
//		"com.pl.df.lib.configurations"
//})
//(scanBasePackages = {
//	"com.pl.df.lib", 
//	"com.pl.df.producer",
//	"com.pl.df.lib.example.controllers.dto",
//	"com.pl.df.lib.example.configurations"
//})
public class ExampleActivemqClassicMsProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleActivemqClassicMsProducerApplication.class, args);
	}
	
}
