/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author santa
 */
@Controller
public class LoginViewController {
   
    @GetMapping("/login")
    public String paginalogin(){
        return "login";
    }
    
    @GetMapping("/")
    @ResponseBody
    public String paginaHome(Authentication authentication){
        return "Olá " + authentication.getName();
    }
}
