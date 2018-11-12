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
public class Vampiro extends SerMonstruoso{
    public Vampiro(int diaNacimiento) {
        super(diaNacimiento);
    }
    
    /**
     * Funcion que determina si el vampiro tiene hambre 
     * @return true si tiene hambre
     */
    public boolean accion(){
        if(numeroAleatorio(1,2) == 1){                  //num aleatorio entre 1 o 2 inclusive, si 1 hambriento/convierte, si 2 no hambriento/muerte humano
            return true;
        }else{
            return false;
        }
    }
      
}
