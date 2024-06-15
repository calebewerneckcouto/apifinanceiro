package com.financeiro.br;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@EntityScan(basePackages = "com.financeiro.br.model")
@ComponentScan(basePackages = {"com.financeiro.br"})
@EnableJpaRepositories(basePackages = {"com.financeiro.br.repository"})
@EnableTransactionManagement
@EnableWebMvc
public class FinanceiroApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(FinanceiroApplication.class, args);
    }
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .exposedHeaders("header1", "header2") // Specify headers to expose here
                .allowCredentials(true)
                .maxAge(3600);
    }
}
