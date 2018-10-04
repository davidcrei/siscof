package br.com.siscof.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"br.com.siscof.api.model"})
public class SiscofApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiscofApplication.class, args);
	}
}
