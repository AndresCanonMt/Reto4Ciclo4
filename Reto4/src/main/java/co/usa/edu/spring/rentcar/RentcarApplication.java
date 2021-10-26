package co.usa.edu.spring.rentcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"co.usa.edu.spring.rentcar.model"})
@SpringBootApplication
public class RentcarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentcarApplication.class, args);
	}

}
