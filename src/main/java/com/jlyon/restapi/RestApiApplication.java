package com.jlyon.restapi;

import org.fusesource.jansi.AnsiConsole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
		AnsiConsole.systemInstall();
		System.out.println("\n\n\u001b[32m Application Online\n\u001b[0m");
	}

}
