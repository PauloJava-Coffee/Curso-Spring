/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aluno.produtosapi.controller;

import com.aluno.produtosapi.entities.Produtos;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author barbo
 */
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
   @PostMapping 
    public void salvar(@RequestBody Produtos produto){
        System.out.println("Produto recebido " + produto);
    }
}
