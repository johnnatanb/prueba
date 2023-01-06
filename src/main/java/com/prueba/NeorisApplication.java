package com.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class NeorisApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(NeorisApplication.class, args);
		run.registerShutdownHook();
	}

}
