package br.com.brunoeas.tourofheroes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Responsável pelas configurações de CORS
 *
 * @author Bruno Eduardo
 */
@Configuration
@EnableWebMvc
public class CorsConfiguration implements WebMvcConfigurer {

    /**
     * @return Configurações de CORS
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@SuppressWarnings("NullableProblems") final CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("*").allowedOrigins("*").allowedHeaders("*");
            }
        };
    }

}