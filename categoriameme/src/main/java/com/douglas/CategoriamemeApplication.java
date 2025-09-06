package com.douglas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.douglas.repository.CategoriaMemeRepository;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableJpaRepositories(basePackageClasses = CategoriaMemeRepository.class)
public class CategoriamemeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoriamemeApplication.class, args);
	}

}
