package com.hellow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class HellowApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellowApplication.class, args);
	}

}
