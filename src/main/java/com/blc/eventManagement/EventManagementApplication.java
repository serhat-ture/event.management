package com.blc.eventManagement;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventManagementApplication {
	//@SpringBootApplication class has a Configuration component,
	// that's why we put ModelMapper class in here
	@Bean
	public ModelMapper modelMapper() {

		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(EventManagementApplication.class, args);
	}


}
