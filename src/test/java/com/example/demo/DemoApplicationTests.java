package com.example.demo;

import com.example.demo.component.BlogProperties;
import com.example.demo.service.HelloWorldController;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private BlogProperties blogProperties;

	@Test
	public void getHello() {
		Assert.assertEquals(blogProperties.getName(), "baod2");
		Assert.assertEquals(blogProperties.getTitle(), "Spring Boot");
		System.out.println(blogProperties.getDesc());
	}

	/**
	 * Spring Boot HelloWorldController 测试
	 */
	@Test
	public void testSayHello() {
		assertEquals("Hello,World!",new HelloWorldController().sayHello());
	}

}
