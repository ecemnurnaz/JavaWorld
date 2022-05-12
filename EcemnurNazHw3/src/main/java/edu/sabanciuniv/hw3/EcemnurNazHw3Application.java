package edu.sabanciuniv.hw3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import edu.sabanciuniv.mts.MTController;


@ComponentScan({"edu.sabanciuniv.mts"})
@EntityScan({"edu.sabanciuniv.mts"})
@EnableJpaRepositories({"edu.sabanciuniv.mts"})
@SpringBootApplication(scanBasePackageClasses = {MTController.class})
public class EcemnurNazHw3Application {

	public static void main(String[] args) {
		SpringApplication.run(EcemnurNazHw3Application.class, args);
	}

}
