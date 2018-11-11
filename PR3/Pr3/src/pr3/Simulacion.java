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
    private final ArrayList<SerHumanoide> humanos = new ArrayList<>();
    private final ArrayList<Vampiro> vampiros = new ArrayList<>();
    private final ArrayList<CazaVampiro> cazavampiros = new ArrayList<>();
    private final ArrayList<Zombie> zombies = new ArrayList<>();
    
    public Simulacion(){
    }

    public void crearEntorno()
    {
        dia = 0;
        temperatura = 20;
        humanos.clear();
        vampiros.clear();
        cazavampiros.clear();
        zombies.clear();
        generarSer(numeroAleatorio(4000,6000),'H');
        generarSer(numeroAleatorio(10,15),'C');
        generarSer(numeroAleatorio(15,20),'V');
        generarSer(numeroAleatorio(20,30),'Z');


    }
    /**
     * Todo lo que pasa en 1 dia
     */
    private void eventosDia(){
        cambioTemperatura();                                                    //cambio temperatura
    
        //humanos (reproduccion y muerte);
        for(SerHumanoide h: humanos){
            int hijos = h.reproduccion(temperatura);
            for(int i = 0; i < hijos; i++){
                humanos.add(new SerHumanoide(h.getVelocidad(),dia));
            }
            
            if(h.muerte()){
                humanos.remove(h);
            }
        }
        //cazavampiros (reproduccion y muerte como los humanos, caza de vampiros);              //IGUAAAAAAL ---> MODULAR
        for(CazaVampiro c: cazavampiros){
            int hijos = c.reproduccion(temperatura);                            
            for(int i = 0; i < hijos; i++){
                cazavampiros.add(new CazaVampiro(c.getVelocidad(),dia));
            }
            
            if(c.muerte()){
                cazavampiros.remove(c);
            }
            if(vampiros.size()>0){
                if(numeroAleatorio(1,3) == 1){
                    vampiros.remove(numeroAleatorio(0,vampiros.size()));
                }
            }
        }
        //vampiro (probabilidad de hambre, morder a humano y muerte inanicion)
        
        //zombies (probabilodad de convertir, muerte de zombie)
    }
    
    /**
     * Funcion que permite cambiar la temperatura (Pensado para calentamiento y enfriamiento global)
     * @param t la temperatura que se le va a sumar a la temperatura actual
     */
    public void cambioTemperatura(float t){
        temperatura = temperatura + t;
    }


    /**
     * Funcion que hace transcurrir d dias en el simulador
     * @param d cantidad de dias que deben pasar
     */
    public void transcurrirDia(int d){
        dia = dia + d;
        for(int i = 0; i < d; i++){
            eventosDia();
        }
    }
    
    /**
     * Función que genera un numero aleatorio entre un minimo y un maximo
     * @param min el minimo numero que puede salir
     * @param max el maximo numero que puede salir
     * @return el numero aleatorio generado
     */
    public int numeroAleatorio(int min, int max){
        Random r1 = new Random(System.currentTimeMillis());
        return (r1.nextInt(max-min+1)+min);
    }
    
    /**
     * Funcion que genera seres y los añade a la lista de estos 
     * @param i cantidad de seres a generar
     * @param ser el ser que va ha ser generado
     */
    private void generarSer(int i, char ser){
        switch(ser){
            case 'H':
                for(int j = 0; j < i; j++){
                    SerHumanoide h = new SerHumanoide(numeroAleatorio(60,100),dia);
                    humanos.add(h);
                }
                break;
            case 'C':
                for(int j = 0; j < i; j++){
                    CazaVampiro cv = new CazaVampiro(numeroAleatorio(60,100),dia);
                    cazavampiros.add(cv);
                }
                break;
            case 'V':
                for(int j = 0; j < i; j++){
                    Vampiro v = new Vampiro(dia);
                    vampiros.add(v);
                }
                break;
                
            case 'Z':
                for(int j = 0; j < i; j++){
                    Zombie z = new Zombie(dia);
                    zombies.add(z);
                }
                break;    
            default:
                System.out.println("No se ha encontrado el ser");
                System.exit(0);
        }
    }
    
    /**
     * Funcion toString sobrecargada
     * @return Como se debe mostrar la clase simulacion
     */
    @Override
    public String toString() {
        return "Dia: " + dia + "\nTemperatura:" + temperatura + "\nHumanos:" + humanos.size() + "\nVampiros=" + vampiros.size() + "\nCazavampiros=" + cazavampiros.size() + "\nZombies=" + zombies.size();
    }
    
    /**
     * Funcion que calcula la variacion de la temperatura cada dia
     */
    private void cambioTemperatura() {
        int prob = numeroAleatorio(1,100);
        
        if(temperatura>= 22){                                       //Temperatura Mayor o igual a 22 grados
            if(prob<45){
                cambioTemperatura((float) 0.5);                              //Probabilidad de subir medio grado: 45 %
            }else{
                cambioTemperatura((float) -0.5);                             //Probabilidad de bajar medio grado: 55 %
            }
        }else if (temperatura > 18 && temperatura < 22){            //Temperatura Menor a 22 y mayor a 18 grados
            if(prob < 5){
                //cambioGlobal(0); NO VARIA LA TEMPERATURA              //Probabilidad de no variar su temperatura: 5 %
            }else if(prob < 35){
                cambioTemperatura((float) -0.5);                             //Probabilidad de bajar medio grado: 30 %
            }else{
                cambioTemperatura((float) 0.5);                              //Probabilidad de subir medio grado: 65 %
            }
        }else{
            if(prob<45){                                            //Temperatura Menor o igual a 18 grados 
                cambioTemperatura((float) -0.5);                             //Probabilidad de bajar medio grado: 45 %
            }else{
                cambioTemperatura((float) 0.5);                              //Probabilidad de subir medio grado: 55 %
            }
        }
    }
}
