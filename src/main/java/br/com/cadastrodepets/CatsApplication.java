package br.com.cadastrodepets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class CatsApplication {

	public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*");
    }
	
	public static void main(String[] args) {
		SpringApplication.run(CatsApplication.class, args);
	}

}
