package jp.co.example.ecommerce_a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Ec202210aApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ec202210aApplication.class, args);
	}

	/**
	 * WebAPIをコールするためのrestTemplate.
	 * 
	 * @return restTemplate
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
