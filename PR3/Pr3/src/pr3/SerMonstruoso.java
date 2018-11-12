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
public class SerMonstruoso extends Ser{
    
    private int nConvertidos;

    public SerMonstruoso(int diaNacimiento) {
        super(diaNacimiento);
        nConvertidos = 0;
    }

    public int getnConvertidos() {
        return nConvertidos;
    }

    public void addConvertido() {
        nConvertidos++;
    }    

    @Override
    public String toString() {
        return "SerMonstruoso: " + " Numero de convertidos = " + nConvertidos + "\n";
    }
    
    
}
