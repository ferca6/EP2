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
public class CazaVampiro extends Ser{
    
    private float velocidad;

    public CazaVampiro(float velocidad, int diaNacimiento) {
        super(diaNacimiento);
        this.velocidad = velocidad;
    }
    
    
    public float getVelocidad() {
        return velocidad;
    }
    //getDiaNacimiento

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }

    //setDiaNacimiento
    
}
