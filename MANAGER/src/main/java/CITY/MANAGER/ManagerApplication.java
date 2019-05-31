package CITY.MANAGER;

import CITY.MANAGER.repository.VilleRepository;
import CITY.MANAGER.entity.Ville;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class ManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerApplication.class, args);
	}



@Bean
public CommandLineRunner insertCity(VilleRepository repository){
	return (args -> {
		// Sauver une ville
		repository.save (new Ville ("Java sur mer ",1000,5000,30,30));
		repository.save (new Ville ("Martignas ",3000,8000,10,10));
	});
}
}