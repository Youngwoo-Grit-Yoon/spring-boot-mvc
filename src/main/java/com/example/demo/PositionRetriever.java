package com.example.demo;

import com.example.demo.domain.Aircraft;
import com.example.demo.repository.AircraftRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Consumer;

@AllArgsConstructor
@Configuration
public class PositionRetriever {
    private final AircraftRepository repository;

    @Bean
    Consumer<List<Aircraft>> retrieveAircraftPositions() {
        return acList -> {
          repository.deleteAll();
          repository.saveAll(acList);
          repository.findAll().forEach(System.out::println);
        };
    }
}
