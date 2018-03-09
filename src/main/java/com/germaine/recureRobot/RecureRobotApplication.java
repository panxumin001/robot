package com.germaine.recureRobot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.germaine.recureRobot.mapper")
public class RecureRobotApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecureRobotApplication.class, args);
	}
}
