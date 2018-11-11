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
public class CazaVampiro extends SerHumanoide{
    private int asesinatos;

    public CazaVampiro(int velocidad, int diaNacimiento) {
        super(velocidad, diaNacimiento);
        asesinatos = 0;
    }

    public int getAsesinatos() {
        return asesinatos;
    }

    public void addAsesinato() {
        asesinatos++;
    }
    
    
    
}
