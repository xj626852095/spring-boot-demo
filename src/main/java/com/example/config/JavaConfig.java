package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.example.model.DemoBean;
import com.example.service.FunctionService;

@Configuration
@ComponentScan("com.example")
@EnableAspectJAutoProxy
@PropertySource("classpath:test.properties")
public class JavaConfig {
	
	@Value("啦啦啦啦啦")
	private String normal;
	
	@Value("${book.author}")
	private String bookAuthor;
	
	@Autowired
	private Environment environment;
		
	
	public void outputResource(){
		System.out.println(" start outputResource ... ");
		System.out.println( normal );
		System.out.println( bookAuthor );
		System.out.println( environment.getProperty("book.name") );
	}
	
	@Bean
	public FunctionService functionService(){
		return new FunctionService();
	}
	
	@Bean
	@Profile("dev")
	public DemoBean devDemoBean(){
		return new DemoBean("from dev profile");
	}
	
	@Bean
	@Profile("prod")
	public DemoBean prodDemoBean(){
		return new DemoBean("from prod profile");
	}
	
	
	
	
}
