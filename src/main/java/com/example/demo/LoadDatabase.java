package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(ProductRepository repository) {
	  List<String> names = null;
	  
	  
    return args -> {
      repository.save(new Product( "TagDemo1",names));
      repository.save(new Product( "TagDemo2",Arrays.asList("1000-A-00259-0","1000-A-00126-0")));
      repository.save(new Product( "TagDemo3",Arrays.asList("A-A-00259-0","1000-A-00126-0")));
     // log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
    };
  }
}