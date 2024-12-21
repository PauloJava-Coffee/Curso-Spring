package io.github.paulojava_coffee.libraryapi;

import io.github.paulojava_coffee.libraryapi.model.Autor;
import io.github.paulojava_coffee.libraryapi.repository.AutorRepository;
import java.time.LocalDate;
import java.time.Month;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryapiApplication.class, args);

    }

}
