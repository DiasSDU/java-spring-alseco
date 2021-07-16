package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}
	/*
	@Bean
	public CommandLineRunner init(UserRepository userRepository){
		return args -> {
			userRepository.save(new User(new Long(2),"Dias","Dias",new Long(2030000)));
			userRepository.save(new User(new Long(4),"Ayan","Ayan",new Long(2030000)));
			userRepository.save(new User(new Long(3),"Dias","Dias22",new Long(3200000)));
		};
	}*/
}
