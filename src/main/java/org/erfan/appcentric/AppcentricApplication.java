package org.erfan.appcentric;

import org.erfan.appcentric.domain.Enum.UserRole;
import org.erfan.appcentric.entity.UserEntity;
import org.erfan.appcentric.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class AppcentricApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppcentricApplication.class, args);
        browse();
	}

    private static void browse() {
        String url = "http://localhost:8083/swagger-ui.html";
        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


	@Bean
	public CommandLineRunner demoData(UserRepository userRepository) {
		return args -> {
			UserEntity userEntity = new UserEntity();
			if (userRepository.findByFirstName("Erfan").isEmpty()) {
                userEntity.setFirstName("Erfan");
                userEntity.setLastName("Bhuiyan");
                userEntity.setEmail("mderfan2@gmail.com");
                userEntity.setPassword("1234");
                userEntity.setUserType(UserRole.SuperAdmin);
                userRepository.save(userEntity);
            }
		};
	}

}
