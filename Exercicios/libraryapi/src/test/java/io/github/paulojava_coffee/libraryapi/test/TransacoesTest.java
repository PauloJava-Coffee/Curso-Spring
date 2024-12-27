/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.test;

import io.github.paulojava_coffee.libraryapi.service.TransacaoService;
import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author santa
 */
@SpringBootTest
public class TransacoesTest {
    
    @Autowired
    TransacaoService service;
    
    /*
    * Commit -> Salvar as alterações
    *RollBack -> Deletar as alterações
    *
    */
    
    @Test
    void transacaoSimples(){
        service.executar();
    }
    
    @Test
    void alterarSemAlterartest(){
        var id = UUID.fromString("f8ba66e0-1057-4cee-863d-ada74bc0c0f3");
        var data = LocalDate.of(1951, 12, 21);
        
        service.atualizarSemAtualizar(id, data);
    }
}
