package com.shicky.quizservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(QuizServiceApplication.class, args);
		System.out.println("QUIZ SERVICE INITILIAIZED SUCCESFULLY");
	}

}
