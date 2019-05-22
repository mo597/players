package com.fr.adaming;

import org.apache.log4j.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class PlayersApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(PlayersApplication.class, args);
		
		Logger logger = Logger.getLogger(PlayersApplication.class);

		
		logger.trace("TRACE");
		logger.debug("DEBUG");
		logger.info("INFO");
		logger.warn("WARN");
		logger.error("ERROR");
		logger.fatal("FATAL");
	
	}

}
