package com.example.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.config.JavaConfig;
import com.example.model.DemoBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={JavaConfig.class})
@ActiveProfiles("prod")
public class DemoBeanTest {
	
	@Autowired
	private DemoBean demoBean;
	
	@Test
	public void demoBeanProfilesTest(){
		
		System.out.println( "junit : " + demoBean.getContent() );
	}
	
}
 