package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import web.config.Tools;

//@SpringBootApplication()
@SpringBootApplication(exclude={SecurityAutoConfiguration.class})	

public class Tariquia2Application {

	public static void main(String[] args) {
		SpringApplication.run(Tariquia2Application.class, args);
	}

}
