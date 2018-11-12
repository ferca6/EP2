/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author fer_n
 */
public class gestorDatos {
    
    public void guardarDatos(Simulacion s) {
        try{
            FileOutputStream fs = new FileOutputStream("config.bin");//Creamos el archivo
            ObjectOutputStream os = new ObjectOutputStream(fs);//Esta clase tiene el método writeObject() que necesitamos
            os.writeObject(s);//El método writeObject() serializa el objeto y lo escribe en el archivo
            os.close();//Hay que cerrar siempre el archivo
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Simulacion cargarDatos() {
        Simulacion s = new Simulacion();
        try{
            FileInputStream fis = new FileInputStream("config.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s = (Simulacion) ois.readObject();//El método readObject() recupera el objeto
            ois.close(); fis.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return s;
    }
}