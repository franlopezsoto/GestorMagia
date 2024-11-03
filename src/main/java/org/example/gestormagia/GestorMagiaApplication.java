package org.example.gestormagia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = "org.example.gestormagia")
@EnableJpaRepositories(basePackages = "org.example.gestormagia.repository")
@EntityScan(basePackages = "org.example.gestormagia.model")
@EnableAsync
public class GestorMagiaApplication {
    public static void main(String[] args) {
        SpringApplication.run(GestorMagiaApplication.class, args);
    }
}
