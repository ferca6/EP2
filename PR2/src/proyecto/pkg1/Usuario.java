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
public class Usuario {
    
    /**
     * Constructor de la clase usuario
     * @param idUsuario
     * @param nombre
     * @param email 
     */
    public Usuario(String nombre, String email) {
        this.idUsuario = nextID;
        this.nombre = nombre;
        this.email = email;
        objetos = new ArrayList<Objeto>();
        nextID++;
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
                "\n";//+
                //"   OBJETOS DEL PROPIETARIO " + idUsuario + "\n";
    }
    
    public void addObjeto(Objeto obj) {
        objetos.add(obj);
    }
    
    public ArrayList<Objeto> getObjetos(){
        return objetos;
    }
    
    private int idUsuario;
    private String nombre;
    private String email;
    private ArrayList <Objeto> objetos;
    private static int nextID = 1;
    

    
}
