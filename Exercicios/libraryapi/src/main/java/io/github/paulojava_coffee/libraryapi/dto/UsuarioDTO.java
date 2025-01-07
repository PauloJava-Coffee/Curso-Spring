/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.dto;

import java.util.List;

/**
 *
 * @author santa
 */
public record UsuarioDTO(String login,String senha, List<String> roles) {

}
