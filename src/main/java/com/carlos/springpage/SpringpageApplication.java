package com.carlos.springpage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringpageApplication implements CommandLineRunner{
	private static Logger LOG = LoggerFactory.getLogger(SpringApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringpageApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Servidor en funcionamiento");
	}
}
