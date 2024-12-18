/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.arquiteturaspring.montadora.configuration;

import io.github.paulojava_coffee.arquiteturaspring.montadora.Motor;
import io.github.paulojava_coffee.arquiteturaspring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author barbo
 */
@Configuration
public class MotadoraConfiguration {

    /**
     *
     * @return
     */
    @Bean
    public Motor motorAspirado() {
         var motor = new Motor();
        motor.setCavalos(120);
        motor.setCilindros(4);
        motor.setModelo("xPTO-0");
        motor.setLitragem(2.0);
        motor.setTipo(TipoMotor.TURBO);
        
        return motor;
    }

    @Bean(name = "motorEletrico")
    public Motor motorEletrico() {
        var motor = new Motor();
        motor.setCavalos(110);
        motor.setCilindros(2);
        motor.setModelo("Qulqr-01");
        motor.setLitragem(1.4);
        motor.setTipo(TipoMotor.ELETRICO);
        return motor;
    }

    @Bean(name = "motorTurbo")
    public Motor motorTurbo() {
        var motor = new Motor();
        motor.setCavalos(140);
        motor.setCilindros(8);
        motor.setModelo("xPTO-01");
        motor.setLitragem(1.5);
        motor.setTipo(TipoMotor.TURBO);
        return motor;
    }
}
