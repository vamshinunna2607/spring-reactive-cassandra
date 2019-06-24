package com.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("blocked")
	public String blocked() throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		Thread.sleep(60000);
		return "Im back after being blocked";
	}
	
	@GetMapping("open")
	public String open() {
		System.out.println(Thread.currentThread().getName());
		return "I was open";
	}
}
