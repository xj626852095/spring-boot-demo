package com.example.service;

import com.example.annotation.Action;

public class FunctionService {
	
	@Action(name="注解式拦截的操作...")
	public void sayHello(String word){
		System.out.println("hello "+word);
	}
	
}
