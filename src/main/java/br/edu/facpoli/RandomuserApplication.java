package br.edu.facpoli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class RandomuserApplication {

	public static void main(String[] args) {
		SpringApplication.run(RandomuserApplication.class, args);
	}
}
