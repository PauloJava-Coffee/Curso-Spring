/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.arquiteturaspring;

import io.github.paulojava_coffee.arquiteturaspring.todos.TodoEntity;
import io.github.paulojava_coffee.arquiteturaspring.todos.TodoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author barbo
 */
@Component
@Scope("singleton")// VALOR PADRÃO , A MESMA ISTÂNCIA FUNCIONA PARA TODOS OS USUÁRIOS
//@Scope(BeanDefinition.SCOPE_PROTOTYPE) UMA INSTÂNCIA PARA CADA USUÁRIOS

//@Scope(BeanDefinition.SCOPE_PROTOTYPE) UMA INSTÂNCIA PARA CADA USUÁRIOS

//@Scope(WebApplicationContext.SCOPE_REQUEST)
//@Scope("request") O BEAN SÓ EXISTE DURANTE UMA REQUISIÇÃO

//@Scope("session") O BEAN GUARDA ESTÁDO DURANTE A SESSÃO DE UM USUÁRIO

//@Scope("application")  O BEAN GUARDA ESTÁDO DURANTE A SESSÃO DE VÁRIOS USUÁRIOS
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
