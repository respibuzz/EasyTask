package io.github.com.respibuzz.EasyTask;

import jakarta.validation.Validator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
class EasyTaskApplication implements RepositoryRestConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(EasyTaskApplication.class, args);
	}

	@Bean
	public Validator validator(){
        return new LocalValidatorFactoryBean();
    }
	}

