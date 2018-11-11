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
public class SerMonstruo extends Ser{
    
    private int nConvertidos;

    public SerMonstruo(int diaNacimiento) {
        super(diaNacimiento);
        nConvertidos = 0;
    }

    public int getnConvertidos() {
        return nConvertidos;
    }

    public void addConvertido() {
        nConvertidos++;
    }    
}
