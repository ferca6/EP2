/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr3;

/**
 *
 * @author godof
 */
public class Humano extends Ser {
    
    private float velocidad;

    public Humano(float velocidad, int diaNacimiento) {
        super(diaNacimiento);
        this.velocidad = velocidad;
    }

    public float getVelocidad() {
        return velocidad;
    }

    //gedianacimiento

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }

    //setDiaNacimiento
}
