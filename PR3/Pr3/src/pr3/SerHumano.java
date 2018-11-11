/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr3;

/**
 *
 * @author fer_n
 */
public class SerHumano extends Ser{
    private int velocidad;

    public SerHumano(int velocidad, int diaNacimiento) {
        super(diaNacimiento);
        this.velocidad = velocidad;
    }
    
    public float getVelocidad() {
        return velocidad;
    }

    //gedianacimiento

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
}
