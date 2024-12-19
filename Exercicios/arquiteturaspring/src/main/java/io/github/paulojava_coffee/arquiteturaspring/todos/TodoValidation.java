/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

/**
 *
 * @author barbo
 */
@Component
public class TodoValidation {
    
    
    private  TodoRepository repository;

    public TodoValidation(TodoRepository repository) {
        this.repository = repository;
    }
    
    
    
    public void validar(TodoEntity todo){
        
          if(descricaoJaexiste(todo.getDescricao())){
              throw new IllegalArgumentException("Já existe uma atividde com essa descrição");
          }
        
    }
    
    private Boolean descricaoJaexiste(String descricao){
        return  repository.existsByDescricao(descricao);
    }
}
