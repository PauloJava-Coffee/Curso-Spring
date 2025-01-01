/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.repository.specs;

import io.github.paulojava_coffee.libraryapi.model.GeneroLivro;
import io.github.paulojava_coffee.libraryapi.model.Livro;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import java.time.LocalDate;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author santa
 */
public class LivroSpecs {
    
    public static Specification<Livro> isbnEqual(String isbn){       
        return (root, query, cb) -> cb.equal(root.get("isbn"), isbn);
    }
    
    
    public static Specification<Livro> tituloLike(String titulo){
        // UPPER(LIVRO.TITULO) LIKE (%:PARAM%)
        return (root, query, cb) -> cb.like(cb.upper(root.get("titulo")),
                "%" + titulo.toUpperCase() + "%");
    }
    
    public static Specification<Livro> generoEqual(GeneroLivro genero){
        return (root, query, cb) -> cb.equal(root.get("genero"), genero);
    }
    
    public static Specification<Livro> anoPublicacaoEqual(Integer anoPublicacao){
        //AND TO_CHAR(DATA_PUBLICACAO, 'yyyy') = :anoPublicacao  
        return (root, query, cb) -> cb.equal(
                cb.function("to_char", String.class, root.get("dataPublicacao"),
                 cb.literal("YYYY")) , anoPublicacao.toString());
    }
    public static Specification<Livro> nomeAutorLike(String nome){
        
        return (root, query, cb) -> {
           Join<Object,Object> joinAutor = root.join("autor", JoinType.LEFT);
            
            return cb.like(cb.upper(joinAutor.get("nome")), "%" + nome.toUpperCase() + "%");
            //return cb.like(cb.upper(root.get("autor").get("nome")), "%" + nome.toUpperCase() + "%");
            
        };
    }
        
}
