/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.validator;

import io.github.paulojava_coffee.libraryapi.exceptios.RegistroDuplicadoException;
import io.github.paulojava_coffee.libraryapi.model.Autor;
import io.github.paulojava_coffee.libraryapi.repository.AutorRepository;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.stereotype.Component;

/**
 *
 * @author santa
 */
@Component
public class AutorValidador {

    private final AutorRepository repository;

    public AutorValidador(AutorRepository repository) {
        this.repository = repository;
    }

    public void validar(Autor autor) {
     if(autorExiste(autor)){
         throw new RegistroDuplicadoException("Autor já cadastrado");
     }
    }
    
    private boolean autorExiste(Autor autor){
        Optional<Autor> optionalAutor = repository.findByNomeAndDataNascimentoAndNacionalidade(
                autor.getNome(), autor.getDataNascimento(), autor.getNacionalidade()
                );
        
        if(autor.getId() == null){
            return optionalAutor.isPresent();
        }
        
        return ! autor.getId().equals(optionalAutor.get().getId()) && optionalAutor.isPresent();
    }

}
