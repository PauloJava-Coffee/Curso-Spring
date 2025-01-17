/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.pauloJava_coffee.resource_server;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author santa
 */
@RestController
public class RSController {
    
    @GetMapping("/publico")
    public ResponseEntity<String> endPublic(){
        return ResponseEntity.ok("End Publico");
    }
    
     @GetMapping("/privado")
    public ResponseEntity<String> endPrivate(){
        return ResponseEntity.ok("End privado");
    }
}
