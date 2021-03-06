/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg1;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author alumno
 */
public class Objeto {
    
    public Objeto(int idObjeto, String descripcion, Date fechaIni, Date fechaFin, float coste) {
        this.idObjeto = idObjeto;
        this.descripcion = descripcion;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.coste = coste;
        alquileres = new ArrayList<Alquiler>();
        disponible = true;
    }
    
    public float getCoste(){
        return coste;
    }
    
    public int getSigId() {
        return alquileres.size()+1;
    }
    
    public void addAlq(Alquiler alq) {
        alquileres.add(alq);
    }
    
    public void bajaObjeto() {
        disponible = false;
    }
    
    /**
     * Funcion que sobrecarga el metodo toString() para mostrar por pantalla el objeto
     * @return 
     */
    public String toString(){
        return "    Código del objeto: " + idObjeto +"\n"+
                "   Descripción: " + descripcion +"\n"+
                "   Fecha de disponibilidad: " +fechaIni+ "-" +fechaFin+ "\n"+
                "   Coste del préstamo por día: "+coste+ "\n";
    }
    
    public boolean getDisponibilidad() {
        return disponible;
    }
    
    public Date getFechaIni(){
        return fechaIni;
    }
    
    public Date getFechaFin(){
        return fechaIni;
    }
    
    public ArrayList <Alquiler> getAlqs(){
        return alquileres;
    }
    
    private int idObjeto;
    private String descripcion;
    private Date fechaIni;
    private Date fechaFin;
    private float coste;    //coste por dia
    private  ArrayList <Alquiler> alquileres;
    private boolean disponible;

    

}
