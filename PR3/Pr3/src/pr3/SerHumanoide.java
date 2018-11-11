/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr3;

import java.util.Comparator;

/**
 *
 * @author fer_n
 */
public class SerHumanoide extends Ser{
    private int velocidad;

    public SerHumanoide(int velocidad, int diaNacimiento) {
        super(diaNacimiento);
        this.velocidad = velocidad;
    }
    
    public int getVelocidad() {
        return velocidad;
    }

    //gedianacimiento

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    /**
     * Funcion que determina si un humano se reproduce 
     * @param temperatura la temperatura actual de la simulacion
     * @return cuantos hijos produce
     */
    public int reproduccion (float temperatura){
        int nacimientos = 0;
        if(temperatura>= 22){                                       //Temperatura Mayor o igual a 22 grados
            int prob = numeroAleatorio(1,15);                           //Probabilidad de reproducción: 1/15
            if(prob==1){
                nacimientos = numeroAleatorio(1,3);                     //Cantidad de hijos concebidos
            }
        }else if (temperatura > 18 && temperatura < 22){            //Temperatura Menor a 22 y mayor a 18 grados
            int prob = numeroAleatorio(1,30);                           //Probabilidad de reproducción: 1/30
            if(prob==1){
                nacimientos = numeroAleatorio(1,3);                     //Cantidad de hijos concebidos
            }
        }else{
            int prob = numeroAleatorio(1,50);                           //Probabilidad de reproducción: 1/50
            if(prob==1){
                nacimientos = numeroAleatorio(1,3);                     //Cantidad de hijos concebidos
            }
        }
        return nacimientos;
    }
    
    /**
     * Funcion que determina si el humano muere por causas naturales u otras causas
     * @return true si muere
     */
    public boolean muerte(){
        int prob = numeroAleatorio(1,500);                           //Muerte por causas naturales
        
        if(prob == 1){
            return true;
        }
        
        prob = numeroAleatorio(1,500);                              //Muerte por otras causas (accidentes, inanición, enfermedades, etc.) 
        
        if(prob == 1){
            return true;
        }
        
        return false;
    }
    
    public static Comparator<SerHumanoide> comparador = new Comparator<SerHumanoide>() {
        @Override
        public int compare(SerHumanoide h, SerHumanoide h1) {
            return (h.getVelocidad() - h1.getVelocidad());
        }
    };

}
