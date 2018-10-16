/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg1;

import java.util.Date;

/**
 *
 * @author alumno
 */
public class Alquiler {
    
    /**
     * Constructor de la clase alquiler
     * @param idAlquiler id del alquiler generado automaticamente
     * @param user el usuario que alquila el objeto
     * @param obj el objeto alquilado
     * @param fechaIni la fecha inicial del alquiler
     * @param fechaFin la fecha final del alquiler
     * @param importeProp el importe para el propietario
     * @param importeStart el importe para la start up
     */
    public Alquiler(int idAlquiler, Usuario user, Objeto obj, Date fechaIni, Date fechaFin, float importeProp, float importeStart) {
        this.idAlquiler = idAlquiler;
        this.user = user;
        this.obj = obj;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.importeProp = importeProp;
        this.importeStart = importeStart;        
    }
    
    /**
     * Funcion que sobrecarga el metodo toString() para mostrar por pantalla el objeto
     * @return 
     */
    @Override
    public String toString(){
        return "            Nombre del cliente: " + user +"\n"+
                "           Fechas del préstamo: " + fechaIni + "-" +fechaFin+ "\n"+
                "           Importe para el propietario: " +importeProp+ " euros" + "\n"+
                "           Importe para la startup: "+importeStart+ " euros" + "\n";
    }
    
    /**
     * Funcion que devuelve el importe para la startup
     * @return el importe de la startup
     */
    public float getImporteStart(){
        return importeStart;
    }
    
    private Usuario user;
    private Objeto obj;
    private Date fechaIni;
    private Date fechaFin;
    private int idAlquiler;
    private float importeProp;
    private float importeStart;

}
