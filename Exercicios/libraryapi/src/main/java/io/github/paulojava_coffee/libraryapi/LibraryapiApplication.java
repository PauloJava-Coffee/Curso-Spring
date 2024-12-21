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
       var contexto =  SpringApplication.run(LibraryapiApplication.class, args);
       AutorRepository autorRepository = contexto.getBean(AutorRepository.class);
       
       salvarRegistro(autorRepository);
    }

    public static void salvarRegistro(AutorRepository repository) {
        Autor autor = new Autor();
        autor.setNome("José");
        autor.setNacionalidade("BR");
        autor.setDataNascimento(LocalDate.of(1995, 1 , 13));
        
       var autorSalvo = repository.save(autor);
       
        System.out.println("Autor Salvo: " + autorSalvo);
        
    }

}
