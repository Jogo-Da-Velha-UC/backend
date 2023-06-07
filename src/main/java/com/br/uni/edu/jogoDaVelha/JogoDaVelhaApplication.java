package com.br.uni.edu.jogoDaVelha;

import com.br.uni.edu.jogoDaVelha.model.GameStruct;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JogoDaVelhaApplication{

	public static void main(String[] args) {
		SpringApplication.run(JogoDaVelhaApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
