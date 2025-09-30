package be.info.hers.ProjetMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan(basePackages = {
		"be.info.hers.TrajetMicroService.Model",
		"be.info.hers.ProjetMicroservice.Model"
})
@SpringBootApplication
public class ProjetMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetMicroserviceApplication.class, args);
	}

}
