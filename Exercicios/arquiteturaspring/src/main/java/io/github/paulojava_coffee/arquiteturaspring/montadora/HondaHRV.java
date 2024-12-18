 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.arquiteturaspring.montadora;

import java.awt.Color;

/**
 *
 * @author barbo
 */
public class HondaHRV extends Carro {
    
    public HondaHRV(Motor motor){
        super(motor);
        setModelo("HRV");
        setCor(Color.red);
        setMontadora(Montadora.HONDA);
    }
}
