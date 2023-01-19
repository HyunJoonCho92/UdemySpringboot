package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication //내가 설정클래스 파일
@ComponentScan
@ComponentScan(basePackages = "upload0118_1")
@ComponentScan(basePackages = "spring.mybatis0119_1")
@MapperScan(basePackages = "spring.mybatis0119_1")
@ComponentScan(basePackages = "websocket0119_2")
public class SecondApplication {
	public static void main(String[] args) {
		SpringApplication.run(SecondApplication.class, args);
		
	}
}