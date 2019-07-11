package CITY.MANAGER;
import CITY.MANAGER.entity.Quartier;
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

		});
	}
}