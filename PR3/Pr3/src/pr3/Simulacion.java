/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr3;

import java.util.ArrayList;
 import java.util.Random;
/**
 *
 * @author fer_n
 */
public class Simulacion {
    
    private int dia;
    private float temperatura;
    private ArrayList<Humano> humanos;
    private ArrayList<Vampiro> vampiros;
    private ArrayList<CazaVampiro> cazavampiros;
    private ArrayList<Zombie> zombies;
    
    public Simulacion(){
        dia = 0;
    }
    
    
    
    
    
    
    
    
    
    public void cambioGlobal(int t){
        temperatura = temperatura + t;
    }
    
    public void transcurrirDia(int d){
        dia = dia + d;
    }
    
    public int numeroAleatorio(int min, int max){
        Random r1 = new Random(System.currentTimeMillis());
        return (r1.nextInt(max-min+1)+min);
    }
}
