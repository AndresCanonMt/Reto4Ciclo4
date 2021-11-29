package co.usa.edu.reto;

import co.usa.edu.reto.crud.CrudGadgetRepository;
import co.usa.edu.reto.crud.CrudUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
@SpringBootApplication
public class RetoApplication implements CommandLineRunner {
    @Autowired
    private CrudUserRepository interfaceUser;
    @Autowired
    private CrudGadgetRepository interfaceGadget;
	public static void main(String[] args) {
		SpringApplication.run(RetoApplication.class, args);
	}
        @Override
        public void run(String...args)throws Exception{
            interfaceUser.deleteAll();
            interfaceGadget.deleteAll();
        }
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*").allowedOrigins("");
            }
        };
    }

}
