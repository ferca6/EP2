/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author alumno
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        ArrayList <Usuario> usuarios;
        //ArrayList <Objeto> objetos;
        //ArrayList <Alquiler> alquileres;
        
        usuarios = new ArrayList<Usuario>();
        //objetos = new ArrayList<Objeto>();
        //alquileres = new ArrayList<Alquiler>();
        
        Scanner keyboard = new Scanner(System.in);
        int opcion = 0;
        OutputStream pantalla = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                System.out.print((char)b);
            }
        };
        PrintStream screen = new PrintStream(pantalla);
        PrintStream fich = null;
        
        try {
            fich = new PrintStream("Guardar saldos.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        while(opcion != 11){
            opcion = imprimirMenu();
            
            switch(opcion){
                case 1:
                    System.out.println("Alta de usuario: ");
                    altaUsuario(keyboard,usuarios);
                    
                    break;
                case 2:
                    System.out.println("Alta de objeto: ");
                    altaObjeto(keyboard,usuarios);
                    break;
                case 3:
                    System.out.println("Alquiler de objeto: ");
                    alquilarObjeto(keyboard,usuarios);
                    break;
                case 4:
                    System.out.println("Listar todo los objetos: ");
                    //listarObjetos(usuarios,objetos,alquileres);
                    mostrarUsuarios(usuarios,4,screen);
                    break;
                case 5:
                    System.out.println("Baja de objeto: ");
                    bajaObjeto(keyboard,usuarios);
                    break;
                case 6:
                    System.out.println("Mostrar saldos: ");
                    mostrarUsuarios(usuarios,6,screen);
                    break;
                case 7:
                    System.out.println("Modificar importe de un objeto");
                    modificarImporte(keyboard,usuarios);
                    break;
                case 8:
                    System.out.println("Guardar Saldos");
                    mostrarUsuarios(usuarios,6,fich);
                    break;
                case 9:
                    System.out.println("Eliminar Usuario");
                    eliminarUsuario(keyboard,usuarios);
                    break;
                case 10:
                    System.out.println("Listar más asiudos");
                    listarAsiduos(usuarios);
                    break;
                case 11:
                    System.out.println("Salir: ");
                    System.exit(0);
                    break;
                    
            }
            //static ids!!!!!!
            
        }    
    }
    //MENU
    /**
     * Funcion que muestra el menu
     * @return opcion, la opcion seleccionada
     */
    public static int imprimirMenu(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("1 – Alta de usuario\n" +
                           "2 – Alta de objeto\n" +
                           "3 – Alquiler de objeto\n" +
                           "4 – Listar todos los objetos\n" +
                           "5 – Baja de objeto\n" +
                           "6 – Mostrar saldos\n" +
                           "7 - Modificar importe de un objeto\n" +
                           "8 - Guardar Saldos en fichero\n" +
                           "9 - Eliminar Usuario\n" +
                           "10 - Listar mas asiduos\n" +
                           "11 – Salir\n");
        int opcion = keyboard.nextInt();
        return opcion;
    }
    
    //OPCIONES DEL MENU
    /**
     * Opcion 1. Registra un nuevo usuario
     * @param keyboard el Scanner para leer datos de teclado
     * @param usuarios el ArrayList con todos los usuarios del sistema
     */
    public static void altaUsuario(Scanner keyboard,ArrayList<Usuario> usuarios) {
        System.out.println("Introduzca su nombre: ");
        String nombre = keyboard.next();
        String email;
        do{
            System.out.println("Introduzca su email: ");    
            email = keyboard.next();
        }while(!validarEmail(email));
        
        System.out.println("Introduzca su Direccion: ");
        String dir = keyboard.next();
        
        System.out.println("Introduzca su poblacion: ");
        String pobl = keyboard.next();
        
        System.out.println("Introduzca su provincia: ");
        String prov = keyboard.next();
        
        Usuario user = new Usuario(nombre,email,dir,pobl,prov);   
        usuarios.add(user);     
    }
    
    /**
     * Opcion 2. Registra un nuevo objeto 
     * @param keyboard el Scanner para leer datos de teclado
     * @param usuarios el ArrayList con todos los usuarios del sistema
     * @throws ParseException 
     */
    public static void altaObjeto(Scanner keyboard, ArrayList<Usuario> usuarios) throws ParseException {
        
        if(!estaVacia(usuarios)){
            
            Usuario user = (Usuario) mostrarLista(keyboard, usuarios);     
            
            System.out.println("Introduzca la descripcion del objeto: ");
            String descripcion = keyboard.next();
            boolean ok;
            Date fechaFin,fechaIni;
            float coste = 0;
            do{
                
                System.out.println("Introduzca el intervalo de fechas (DD/MM/YYYY): ");
            
                fechaIni = introducirFecha(keyboard,"fecha de inicio");
                fechaFin = introducirFecha(keyboard,"fecha de fin");
               
            }while(!comprobarOrdenFechas(fechaFin,fechaIni));
            
            do{
                ok = true;
                System.out.println("Introduzca el coste por dia: ");
                try{
                    coste = keyboard.nextFloat();     //comprobar coste > 0
                }catch(NumberFormatException e){
                    ok = false;
                }
                
            }while(!ok || coste <= 0);
            
            Objeto obj = new Objeto(descripcion,fechaIni,fechaFin,coste);
            user.addObjeto(obj);
        }
    }
    
    /**
     * Opcion 3. Se realiza un alquiler entre un objeto y una persona
     * @param keyboard el Scanner para leer datos de teclado
     * @param usuarios el ArrayList con todos los usuarios del sistema
     * @throws ParseException 
     */
    public static void alquilarObjeto(Scanner keyboard, ArrayList<Usuario> usuarios) throws ParseException {
        
        if(!estaVacia(usuarios)){
            Usuario user = (Usuario) mostrarLista(keyboard,usuarios);    //usuario que quiere alquilar
            ArrayList<Objeto> objetos = new ArrayList<Objeto>();
            for(Usuario u: usuarios){
                objetos.addAll(u.getObjetos());
            }
            if(!estaVacia(objetos)){
                Objeto obj = (Objeto) mostrarLista(keyboard,objetos);
                Date fechaFin,fechaIni;
                do{

                    System.out.println("Introduzca el intervalo de fechas (DD/MM/YYYY): ");

                    fechaIni = introducirFecha(keyboard,"fecha de inicio");
                    fechaFin = introducirFecha(keyboard,"fecha de fin");

                }while(!comprobarOrdenFechas(fechaFin,fechaIni) && !comprobarIntervalo(fechaIni,fechaFin,obj.getFechaIni(),obj.getFechaFin()));


                float importeProp = diferenciaFechas(fechaFin,fechaIni)*obj.getCoste();
                user.addGastado(importeProp);
                Alquiler alquiler = new Alquiler(user,obj,fechaIni,fechaFin,importeProp, (float) (importeProp*0.1));
                obj.addAlq(alquiler);
            }
        }        
    }

    /**
     * Opcion 5. Se marca un objeto como no disponible para su alquiler
     * @param keyboard el Scanner para leer datos de teclado
     * @param usuarios el ArrayList con todos los usuarios del sistema
     */
    public static void bajaObjeto(Scanner keyboard, ArrayList<Usuario> usuarios) {
        if(!estaVacia(usuarios)){
            Usuario user = (Usuario) mostrarLista(keyboard,usuarios);
            ArrayList<Objeto> objetos = user.getObjetos();
            
            if(!estaVacia(objetos)){
                Objeto obj = (Objeto) mostrarLista(keyboard,objetos);
                obj.baja();  
            }
        }
    }
    
    /**
     * Funcion que muestra los usuarios por pantalla
     * @param usuarios el ArrayList con todos los usuarios del sistema
     * @param opt la opcion del menu donde se llama a esta funcion
     * @param p PrintStream para imprimir en fichero o pantalla
     * @return coste
     */
    public static void mostrarUsuarios(ArrayList<Usuario> usuarios, int opt, PrintStream p) {
        float cont = 0;
        for(Usuario u : usuarios){
            p.print(u.toString()+"\n");
            cont = cont + mostrarObjetosUsuario(u.getObjetos(),opt, p);
        }
        if(opt == 6){
            System.out.println("Importe total acumulado para la startup :" + cont +"euros");
        }
    }
    
    /**
     * Funcion que muestra los objetos de un usuario (si es opcion 4)
     * @param objetos el ArrayList con todos los objetos del sistema
     * @param opt la opcion del menu donde se llama a esta funcion
     * @param p PrintStream para imprimir en fichero o pantalla
     * @return coste
     */
    public static float mostrarObjetosUsuario(ArrayList<Objeto> objetos, int opt,PrintStream p) {
        float cont = 0;
        for(Objeto o: objetos){
            if(opt==4){
                p.println(o.toString()+"\n");
            }
            cont = cont + mostrarAlquileresObjeto(o.getAlqs(), opt,p);          
        }
        return cont;
    }
    
    /**
     * Funcion que imprime los alquileres de cada objeto
     * @param alquileres
     * @param opt la opcion del menu donde se llama a esta funcion
     * @param p PrintStream para imprimir en fichero o pantalla
     * @return coste
     */ 
    public static float mostrarAlquileresObjeto(ArrayList<Alquiler> alquileres, int opt,PrintStream p) {
        float cont = 0;
        for(Alquiler a : alquileres){
            p.println(a.toString()+"\n");
            cont = cont + a.getImporteStart();
        }
        return cont;
    }
    
    /**
     * Opcion 8. Modifica el importe de un objeto
     * @param keyboard el Scanner para leer datos de teclado
     * @param usuarios el ArrayList con todos los usuarios del sistema
     */
    public static void modificarImporte(Scanner keyboard, ArrayList<Usuario> usuarios) {    //reutilizar?
        if(!estaVacia(usuarios)){
            Usuario user = (Usuario) mostrarLista(keyboard,usuarios);
            ArrayList<Objeto> objetos = user.getObjetos();
            
            if(!estaVacia(objetos)){
                Objeto obj = (Objeto) mostrarLista(keyboard,objetos);
                boolean ok;
                float coste = 0;
                do{
                    ok = true;
                    System.out.println("Introduzca el nuevo importe: ");
                    try{
                        coste = keyboard.nextFloat();     //comprobar coste > 0
                    }catch(NumberFormatException e){
                        ok = false;
                    }
                    obj.setCoste(coste);
                }while(!ok || coste <= 0);
            }
        }
        
    }
    
    /**
     * Opcion 9. Funcion que elimina un usuario
     * @param keyboard el Scanner para leer datos de teclado
     * @param usuarios el ArrayList con todos los usuarios del sistema
     */
    public static void eliminarUsuario(Scanner keyboard, ArrayList<Usuario> usuarios) {
        if(!estaVacia(usuarios)){
            Usuario user = (Usuario) mostrarLista(keyboard,usuarios);
            user.baja();
            for(Objeto o: user.getObjetos()){
                o.baja();
            }
        }
    }
    
    /**
     * Funcion que lista a los usuarios que mas dinero han gastado en la pagina
     * @param usuarios 
     */
    public static void listarAsiduos(ArrayList<Usuario> usuarios) {
        ArrayList<Usuario> asiduos = usuarios;
        Collections.sort(asiduos,Collections.reverseOrder());//ordenar lista
        for(Usuario u: asiduos){
            System.out.print(u);
        }
    }

    
    //FUNCIONES AUXILIARES
    
    /**
     * Funcion para introducir una fecha, la lee de teclado y le cambia el formato
     * @param keyboard el Scanner para leer datos de teclado
     * @param s cadena para diferencia si es la fecha inicial o la final
     * @return la fecha en formato Date
     * @throws ParseException 
     */
    public static Date introducirFecha(Scanner keyboard, String s) throws ParseException{ 
        String f;
        
        Date fecha;
        do{
            System.out.println("Introduzca la "+ s +" (dd/MM/yyyy): ");
            f = keyboard.next();
            System.out.print(f);
        }while(!comprobarFecha(f));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
            fecha = dateFormat.parse(f);
        
        //fecha =  new SimpleDateFormat("DD/MM/YYYY").parse(f); // Creamos un date con la entrada en el formato especificado 
        System.out.print(fecha);
        return fecha;
    }
    
    /**
     * Funcion que muestra una lista y recoge la seleccion del usuario
     * @param keyboard el Scanner para leer datos de teclado
     * @param lista el ArrayList a imprimir
     * @return el objeto del ArrayList que el usuario a seleccionado
     */
    public static Object mostrarLista(Scanner keyboard,ArrayList lista) { 
        Objeto obj;
        Usuario user;
        Object ob;
        for(Object o : lista){
            
            if(o.getClass().getSimpleName().equals("Objeto")){
                obj = (Objeto)o;
            
                if(obj.getDisponibilidad()){
                    System.out.println(o.toString());
                }
            }else if(o.getClass().getSimpleName().equals("Usuario")){
                user = (Usuario)o;
                if(user.getActivo()){
                    System.out.println(o.toString());
                }
            }else{
                System.out.println(o.toString());
            }
        }
        int id = 0;
        boolean ok = true;
        do{
           System.out.println("Seleccione el que desee: ");
           try{
                id = keyboard.nextInt(); 
           }catch(NumberFormatException e){
                ok = false;
            }
           ob = lista.get(id-1);
        }while((id > lista.size() || id <= 0) || (!ok));
        
        return ob;     
    }
    
    /**
     * Funcion que calcula la diferencia entre dos fechas en dias
     * @param f1 es la fecha final del intervalo
     * @param f2 es la fecha inicial del intervalo
     * @return el numero de dias de diferencia
     */
    public static int diferenciaFechas(Date f1, Date f2){
        
        long difMili = f1.getTime() - f2.getTime();
        long dif = (difMili / (1000*60*60*24));
        return (int) dif;
    }
    
    //COMPROBACIONES
    /**
     * Funcion que comprueba si un email es valido mediante el uso de una ER
     * @param email la cadena a comprobar
     * @return true si la cadena es un email valido
     */
    public static boolean validarEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    }
    
    /**
     * Funcion que comprueba si la fecha final es anterior a la fecha inicial
     * @param f1 es la fecha final del intervalo
     * @param f2 es la fecha inicial del intervalo
     * @return true si el intervalo es correcto
     */
    public static boolean comprobarOrdenFechas (Date f1, Date f2){
        if(diferenciaFechas(f1,f2) <= 0){
            System.out.println("Fecha final es menor que la fecha inicial");
            return false;
        }else{
            return true;
        }
    }
    
    /**
     * Funcion que comprueba si una fecha es correcta ("DD/MM/YYYY")
     * @param s la cadena que contiene la fecha
     * @return true si la fecha es correcta
     */
    public static boolean comprobarFecha(String s){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //dateFormat.setLenient(false);
        try {
            dateFormat.parse(s.trim());
        }catch (ParseException pe) {
            System.out.println("Fecha introducida de manera erronea");
            return false;
        }
        return true;
    }

    /**
     * Funcion que indica si un ArrayList esta vacio
     * @param lista el ArrayList a comprobar
     * @return true si el ArrayList esta vacio
     */
    public static boolean estaVacia(ArrayList lista){
        if(lista.isEmpty()){
            System.out.println("No hay usuarios u objetos registrados por el momento");
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Funcion que comprueba si un intervalo de fechas esta dentro de otro
     * @param fI fecha inicial del alquiler
     * @param fF fecha final del alquiler
     * @param foI fecha inicial del objeto
     * @param foF fecha final del objeto
     * @return true si esta en el intervalo
     */
    public static boolean comprobarIntervalo(Date fI,Date fF,Date foI,Date foF){
        boolean ok = false;
        
        if(foI.before(fI) && fI.before(foF)){
            if(foI.before(fF) && fF.before(foF) && fI.before(fF)){
                ok= true;
            }
        } else {
            ok = false;
        }
        return ok;
    }

}
