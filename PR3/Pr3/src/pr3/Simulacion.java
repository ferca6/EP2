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
    private ArrayList<Humano> humanos = new ArrayList<Humano>();
    private ArrayList<Vampiro> vampiros = new ArrayList<Vampiro>();
    private ArrayList<CazaVampiro> cazavampiros = new ArrayList<CazaVampiro>();
    private ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    
    
    public Simulacion(){
        dia = 0;
    }
    
    
    
    
    
    
    
    
    public void crearEntorno()
    {
        dia = 0;
        humanos.clear();
        vampiros.clear();
        cazavampiros.clear();
        zombies.clear();
        generarHumano(numeroAleatorio(4000,6000));
        generarCazaVampiro(numeroAleatorio(10,15));
        generarVampiro(numeroAleatorio(15,20));
        generarZombie(numeroAleatorio(20,30));    
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
    public void generarHumano(int i)
    {
        for(int j = 0; j < i; j++){
            Humano h = new Humano(numeroAleatorio(60,100),dia);
            humanos.add(h);
        }
    }
    public void generarCazaVampiro(int i)
    {
        for(int j = 0; j < i; j++){
            CazaVampiro cv = new CazaVampiro(numeroAleatorio(60,100),dia);
            cazavampiros.add(cv);
        }
    }
    public void generarVampiro(int i)
    {
        for(int j = 0; j < i; j++){
            Vampiro v = new Vampiro(0,dia);
            vampiros.add(v);
        }
    }
    public void generarZombie(int i)
    {
        for(int j = 0; j < i; j++){
            Zombie z = new Zombie(0,dia);
            zombies.add(z);
        }
    }
}
