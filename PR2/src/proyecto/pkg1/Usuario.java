/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg1;

import java.util.ArrayList;

/**
 * Clase que representa los usuarios
 * 
 */
public class Usuario implements Comparable<Usuario>{
    
    /**
     * Constructor de la clase usuario
     * @param idUsuario
     * @param nombre
     * @param email 
     */
    public Usuario(String nombre, String email,String direccion,String poblacion,String provincia) {
        this.idUsuario = nextID;
        this.nombre = nombre;
        this.email = email;
        objetos = new ArrayList<Objeto>();
        nextID++;
        activo = true;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.provincia = provincia;
        totalGastado = 0;
    }
    
    /**
     * Funcion que sobrecarga el metodo toString() para mostrar por pantalla el objeto
     * @return 
     */
    @Override
    public String toString(){
        return "PROPIETARIO " + idUsuario+"\n"+
                "Nombre del propietario: " + nombre+ "\n"+
                "Correo Electrónico: " +email+"\n"+
                "\n"+
                "   OBJETOS DEL PROPIETARIO " + idUsuario+"\n";//+
    }
    
    public void addObjeto(Objeto obj) {
        objetos.add(obj);
    }
    
    public void addGastado(float gastado){
        totalGastado = totalGastado + gastado;
    }
    
    public ArrayList<Objeto> getObjetos(){
        return objetos;
    }
    
    public void baja() {
        activo = false;
    }
    
    public float getGastado(){
        return totalGastado;
    }
    
    public boolean getActivo(){
        return activo;
    }
    @Override
    public int compareTo(Usuario u){
        if(this.totalGastado < u.getGastado()){
            return -1;
        } else if(this.totalGastado > u.getGastado()){
            return 1;
        } else{
            return 0;
        }
    }
    private int idUsuario;
    private String nombre;
    private String email;
    private ArrayList <Objeto> objetos;
    private static int nextID = 1;
    private boolean activo;
    private String direccion;
    private String poblacion;
    private String provincia;
    private float totalGastado;
    

    
}
