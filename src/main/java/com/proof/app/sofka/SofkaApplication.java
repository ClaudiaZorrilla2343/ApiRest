package com.proof.app.sofka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Para configurar la aplicacion de spring
@EnableAutoConfiguration
@SpringBootApplication
public class SofkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SofkaApplication.class, args);
	}

}
//