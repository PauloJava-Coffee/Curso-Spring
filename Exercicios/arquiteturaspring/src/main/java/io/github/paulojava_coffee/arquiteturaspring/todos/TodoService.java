/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.arquiteturaspring.todos;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author barbo
 */
@Service
public class TodoService {

    private final TodoRepository repository;
    @Autowired
    private TodoValidation validar;
    @Autowired
    private MailSender email;

    public TodoService(TodoRepository todoRepository) {
        this.repository = todoRepository;
    }

    public TodoEntity buscarPorId(Integer id) {
        /*
         No exemplo abaixo fazemos o retorno do registro
         encontrado , mas caso o id não exista, retornamos nulo,
         dispensando o uso de ' Optional '
         */
        return repository.findById(id).orElse(null);
    }

    public TodoEntity salvar(TodoEntity novoTodo) {
        validar.validar(novoTodo);
        return repository.save(novoTodo);
    }

    @Transactional
    public void atualizarStatus(TodoEntity todo) {
        repository.save(todo);

        String status = todo.getConcluido() == Boolean.TRUE ? "Concluido" : "Não concluido";
        email.enviar("Todo " + todo.getDescricao() + " foi atualizado para " + status);
    }

}
