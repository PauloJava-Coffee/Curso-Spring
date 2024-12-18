/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.arquiteturaspring.montadora;

import io.github.paulojava_coffee.arquiteturaspring.montadora.api.CarroStatus;
import java.awt.Color;

/**
 *
 * @author barbo
 */
public class Carro {
    private String modelo;
    private Color cor;
    private Motor motor;
    private Montadora montadora;
    

    public Carro(Motor motor) {
        this.motor = motor;
       
    }
    
    
    

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Montadora getMontadora() {
        return montadora;
    }

    public void setMontadora(Montadora montadora) {
        this.montadora = montadora;
    }
    
  
    public  CarroStatus darIgnicao(Chave chave){
        if(chave.getMontadora() != this.montadora){
            return new CarroStatus("Impossível ligar o carro com essa chave");
        }else{
            return new CarroStatus("Carro ligado. Rodadno com o motor " + motor);
        }
    }
}
