package br.com.getmypersonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("br.com.getmypersonal.model")
@EnableJpaRepositories("br.com.getmypersonal.repository")
public class GetmypersonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetmypersonalApplication.class, args);
	}

}
