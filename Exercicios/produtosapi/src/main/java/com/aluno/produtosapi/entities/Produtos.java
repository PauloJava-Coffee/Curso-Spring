/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aluno.produtosapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author barbo
 */
@Entity
@Getter
@Setter
@ToString
public class Produtos {
    
    @Id
    private String id;
    private String nome;
    private String descricao;
    private Double preco;
    
}
