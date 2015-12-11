package org.wojteks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.wojteks.domain.City;

@SpringBootApplication
public class SpringBootSampleDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSampleDataJpaApplication.class, args);
    }

    @Bean
    public City showExampleCity() {
        City city = new City("Test", "UK");
        return city;
    }

    @Bean
    public City showExampleCity2() {
        City city = new City("Test2", "UK");
        return city;
    }
}
