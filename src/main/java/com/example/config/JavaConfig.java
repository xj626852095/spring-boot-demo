package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.example.service.FunctionService;

@Configuration
@ComponentScan("com.example")
@EnableAspectJAutoProxy
public class JavaConfig {
	
	@Bean
	public FunctionService functionService(){
		return new FunctionService();
	}
	
}
