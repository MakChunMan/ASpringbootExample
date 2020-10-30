package com.imagworkshop.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Play springbook on repl.it");
		};
	}

  @Bean
  public Docket api() { 
      return new Docket(DocumentationType.SWAGGER_2)  
        .select()       
        .apis(RequestHandlerSelectors.basePackage("com.imagworkshop.backend.controller")) 
        //.apis(RequestHandlerSelectors.any())              
        //.paths(PathSelectors.any())                          
        .build();                                           
  }

}