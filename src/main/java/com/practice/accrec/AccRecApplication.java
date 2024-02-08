package com.practice.accrec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
//@EnableFeignClients("com.practice.accrec")
@ComponentScan(basePackages = {"com.practice.accrec.*"})
public class AccRecApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccRecApplication.class, args);
	}

}
