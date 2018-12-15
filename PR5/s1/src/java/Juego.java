/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fer_n
 */
@WebServlet(urlPatterns = {"/Juego"})
public class Juego extends HttpServlet {
    
    //dentro del form podemos declarar variables hidden para pasar el nombre varias veces Tambien pasar el numero aleatorio secreto
    //input type hidden value nombre name 
    /**
     *
     * @throws ServletException
     * @throws IOException
     */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        javax.servlet.http.HttpSession sesion = null;
        sesion = request.getSession(true);
        PrintWriter out = response.getWriter();
        if(sesion.isNew()){
                Random rand = new Random(System.currentTimeMillis());
                int numeroSecreto = rand.nextInt(100)+1;
                int intentos = 1;
                System.out.println(numeroSecreto);
                String nombre = request.getParameter("nombre");
                System.out.println(nombre);
                
                sesion.setAttribute("intentos", intentos);
                sesion.setAttribute("nombre", nombre);
                sesion.setAttribute("nS",numeroSecreto);
                
                out.println("<html>");
                out.println("<head>");
                out.println("<center>");
                out.println("<h1>Numero secreto</h1>"); 
                out.println("</center>");
                out.println("</head>");
                out.println("<body BGCOLOR=\"#FDF5E6\">");
                out.println("<div>");
                out.println("<form id=\"form1\" name=\"form1\" method=\"post\" action=\"Juego\">");
                out.println("<center>");
                
                out.println("<h3>Instrucciones de juego</h3>");
                
                out.println("<br>");
                out.println("<p>Adivina el numero secreto"
                       +"Introduce el numero y la aplicacion te devolvera si te vas por arriba o por abajo"+ "</p>");
                //out.println("Numero:<input align=\"right\" type=\"text\" name=\"numero\">");
                out.println("<label for=\"numero\">Introduzca un numero</label>");
                out.println("<select name=\"numero\">");
                for(int i = 1; i<101; i++){
                    out.println("<option value=\""+i+"\">"+i+"</option>");
                }
                out.println("</select>");                
                out.println("<input type=\"submit\" name=\"Submit\" value=\"Inicio de juego\" />");  
                
                out.println("<br>");
                out.println("</center>");
                out.println("</form>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }else{
                String nombre = (String) sesion.getAttribute("nombre");
                int numProbado = 0;
                boolean fallo = false;
                boolean acierto = false;
                String pista = "";
                try{
                    numProbado = Integer.parseInt(request.getParameter("numero"));
                    
                }catch(Exception e){
                    fallo = true;
                    pista = "No ha introducido un numero o este esta no esta entre 1 y 100";
                }
                
                int intentos = (int) sesion.getAttribute("intentos");
                
                int numeroSecreto = (int) sesion.getAttribute("nS");
                
                if(!fallo){
                    if(numProbado < numeroSecreto){
                        intentos++;
                        pista = "prueba con un numero mayor"; 
                    }else if(numProbado > numeroSecreto){
                        intentos++;
                        pista = "prueba con un numero menor";                    
                    }else if(numProbado == numeroSecreto){
                        pista = "has acertado!";
                        acierto = true;
                    }
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<center>");
                    out.println("<h1>Numero secreto</h1>");   
                    out.println("</center>");
                    out.println("</head>");
                    out.println("<body BGCOLOR=\"#FDF5E6\">");
                    out.println("<div>");
                    if(!acierto){
                        out.println("<form id=\"form1\" name=\"form1\" method=\"post\" action=\"Juego\">");
                        out.println("<center>");
                        out.println("<label for=\"numero\">Introduzca un numero</label>");
                        //out.println("Numero:<input align=\"right\" type=\"text\" name=\"numero\">");
                        out.println("<select name=\"numero\">");
                        for(int i = 1; i<101; i++){
                            out.println("<option value=\""+i+"\">"+i+"</option>");
                        }
                        out.println("</select>");  
                        out.println("<input type=\"submit\" name=\"Submit\" value=\"Inicio de juego\" />");  
                        out.println("<br>");
                        out.println("<p><b>PISTA: </b>"+pista+"</p>");
                        out.println("</center>");
                        out.println("</form>");
                    }else{
                        System.out.println("has ganado");
                        out.println("<center>");
                        out.println("<h3 align=\"center\">Felicidades "+nombre+"</h3>");
                        out.println("<p align=\"center\">Numero de intentos"+intentos+"</p>");
                        out.println("Volver a jugar:<a href=\"inicio.html\">Ir al enlace</a>");
                        out.println("</center>");
                    }
                }else{
                    out.println("<center>");
                    out.println("<p align=\"center\">Error, "+pista+"</p>");
                    out.println("Volver a jugar:<a href=\"inicio.html\">Ir al enlace</a>");
                    out.println("</center>");
                }
                
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
                
                sesion.setAttribute("intentos",intentos);
                sesion.setAttribute("nombre", nombre);
                sesion.setAttribute("nS",numeroSecreto);
                
                if(acierto || fallo){
                    sesion.invalidate();
                }
            }
    }
            
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
