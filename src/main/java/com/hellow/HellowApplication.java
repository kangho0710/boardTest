package com.hellow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan
@EnableAspectJAutoProxy
public class HellowApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellowApplication.class, args);
	}

}
