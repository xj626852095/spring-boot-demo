package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.JavaConfig;
import com.example.event.DemoPublisher;
import com.example.model.DemoBean;
import com.example.service.FunctionService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		//profile 不同环境发布
		context.getEnvironment().setActiveProfiles("prod");
		context.register(JavaConfig.class);
		context.refresh();
		DemoBean demoBean = context.getBean(DemoBean.class);
		System.out.println( "demoBean: " + demoBean.getContent() );
		
		//AOP 测试
		FunctionService functionService = context.getBean(FunctionService.class);
		functionService.sayHello("kevin");
		
		//spring el 和 资源调用
		JavaConfig javaConfig = context.getBean(JavaConfig.class);
		javaConfig.outputResource();
		
		//application event
		DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
		demoPublisher.publish(" 触发了事件 1 ");
		demoPublisher.publish(" 触发了事件 2 ");
		
		
	}
}
