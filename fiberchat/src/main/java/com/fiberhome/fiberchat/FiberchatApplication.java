package com.fiberhome.fiberchat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fiberhome.fiberchat.dao")
public class FiberchatApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiberchatApplication.class, args);
	}
}
