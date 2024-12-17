/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aluno.produtosapi.controller;

import com.aluno.produtosapi.entities.Produtos;
import com.aluno.produtosapi.repositories.ProdutosRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author barbo
 */
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutosRepository repository;

    @GetMapping("/{id}")
    private Produtos findById(@PathVariable("id") String id) {
        Optional<Produtos> produto = repository.findById(id);

        return produto.isPresent() ? produto.get() : null;
    }

    @PostMapping
    public void salvar(@RequestBody Produtos produto) {
        System.out.println("Produto recebido " + produto);
        repository.save(produto);
    }

    @Transactional
    @PutMapping
    public void alterar(@RequestBody Produtos dados) {
        Optional<Produtos> resultado = repository.findById(dados.getId());
        if (resultado.isPresent()) {
            Produtos produto = resultado.get();
            produto.setNome(dados.getNome());
            produto.setDescricao(dados.getDescricao());
            produto.setPreco(dados.getPreco());
        
        }
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable("id") String id) {
        repository.deleteById(id);
    }
}
