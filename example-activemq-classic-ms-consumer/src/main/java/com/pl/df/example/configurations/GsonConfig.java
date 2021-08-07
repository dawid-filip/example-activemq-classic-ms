package com.pl.df.example.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

@Configuration
public class GsonConfig {
	
	@Bean
	@Scope(value = WebApplicationContext.SCOPE_APPLICATION)
	public Gson getGson() {
		Gson gson = new Gson();
		gson.htmlSafe();
		return gson;
	}
	
}
