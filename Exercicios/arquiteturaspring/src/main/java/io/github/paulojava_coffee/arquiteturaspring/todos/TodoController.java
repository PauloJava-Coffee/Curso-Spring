/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.arquiteturaspring.todos;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author barbo
 */
@RestController
@RequestMapping("/todos")
public class TodoController {

    TodoService service;
    

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    private TodoEntity buscarporId(@PathVariable("id") Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    private TodoEntity salvar(@RequestBody TodoEntity todo) {
        try{
        return service.salvar(todo);
        }catch(IllegalArgumentException e){ 
            var erro = e.getMessage();
            
            throw new ResponseStatusException(HttpStatus.CONFLICT, erro);
        }
    }

    @PutMapping("{id}")
    private void atualizarStatus(@PathVariable("id") Integer id, @RequestBody TodoEntity todo) {
        todo.setId(id);
        service.atualizarStatus(todo);
    }

}
