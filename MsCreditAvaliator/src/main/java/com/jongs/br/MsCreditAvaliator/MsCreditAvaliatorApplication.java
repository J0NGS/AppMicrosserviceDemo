package com.jongs.br.MsCreditAvaliator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsCreditAvaliatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCreditAvaliatorApplication.class, args);
	}

}
