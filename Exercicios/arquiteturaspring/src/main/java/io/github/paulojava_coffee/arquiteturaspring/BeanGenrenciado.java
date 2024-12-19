/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.arquiteturaspring;

import io.github.paulojava_coffee.arquiteturaspring.todos.TodoEntity;
import io.github.paulojava_coffee.arquiteturaspring.todos.TodoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author barbo
 */
@Component
public class BeanGenrenciado {

    /*
    
    FORMAS DE INJETAR AS DEPENDÊNCIAS
    
    
     */
 /*
    
    Injeção direta no atributo usando @Autowired
    obs: alternativa menos indicado segundo o meu professor
    
     */
    @Autowired
    private TodoValidation validar;


    /*
    
     Injeção via construtor, froma mais indicada 
     pois torna as dependências obrigatórias
    
     */
    // @Autowired OPCIONAL 
    public BeanGenrenciado(TodoValidation validar) {
        this.validar = validar;
    }

    public void validarTodo() {
        var todo = new TodoEntity();
        validar.validar(todo);
    }

    /*
    
    Injeção via método seter e @Autowired forma
    pontual de se injetar já que a dependência 
    se torna opcional
    
     */
    
    @Autowired
    public void setValidar(TodoValidation validar) {
        this.validar = validar;
    }
}
