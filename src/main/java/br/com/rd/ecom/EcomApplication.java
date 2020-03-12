package br.com.rd.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcomApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/ecom");
		SpringApplication.run(EcomApplication.class, args);
	}
}