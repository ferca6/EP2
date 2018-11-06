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
public class Vampiro extends Ser{
    
    private int nConvertidos;

    public Vampiro(int nConvertidos, int diaNacimiento) {
        super(diaNacimiento);
        this.nConvertidos = nConvertidos;
    }

    public int getnConvertidos() {
        return nConvertidos;
    }

    public void setnConvertidos(int nConvertidos) {
        this.nConvertidos = nConvertidos;
    }
    
    //gedianacimiento
    //setDiaNacimiento
}
