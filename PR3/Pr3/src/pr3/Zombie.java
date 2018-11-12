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
public class Zombie extends SerMonstruoso{
     

    public Zombie(int diaNacimiento) {
        super(diaNacimiento);
    }
    
    public boolean convierte(int prob){
        if(numeroAleatorio(1,prob) == 1){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean muerte(int diaAct){
        if((diaAct-diaNacimiento)>=8){
            return true;
        }else{
            return false;
        }
    }
    
}
