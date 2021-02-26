package br.com.brunoeas.tourofheroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Responsável por inicializar a aplicação
 *
 * @author Bruno Eduardo
 */
@EnableAutoConfiguration
@SpringBootApplication
public class TourOfHeroesBackendApplication {

    /**
     * Inicializa a aplicação
     */
    public static void main(final String[] args) {
        SpringApplication.run(TourOfHeroesBackendApplication.class, args);
    }

}