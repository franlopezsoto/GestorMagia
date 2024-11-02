package org.example.gestormagia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.example.gestormagia")
public class GestorMagiaApplication {
    public static void main(String[] args) {
        SpringApplication.run(GestorMagiaApplication.class, args);
    }
}
