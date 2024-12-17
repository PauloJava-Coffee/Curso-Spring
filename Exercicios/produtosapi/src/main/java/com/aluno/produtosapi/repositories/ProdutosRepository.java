/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.aluno.produtosapi.repositories;

import com.aluno.produtosapi.entities.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author barbo
 */
public interface ProdutosRepository extends JpaRepository<Produtos,String> {

}
