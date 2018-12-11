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
        javax.servlet.http.HttpSession sesion = request.getSession(true);
        if(sesion.isNew()){
            
            Random rand = new Random(System.currentTimeMillis());
            int numeroSecreto = rand.nextInt(100)+1;
            System.out.println(numeroSecreto);
            String nombre = request.getParameter("nombre");
            System.out.println(nombre);
            
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<html>");
                out.println("<head>");
                out.println("<h1>Numero secreto</h1>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<div>");
                out.println("<form id=\"form1\" name=\"form1\" method=\"post\" action=\"Juego\">");
                out.println("<h1>Instrucciones de juego</h1>");
                out.println("<br>");
                out.println("<h1>Adivina el numero secreto</h1>");
                out.println("<h1>Introduce el numero y la aplicacion te devolvera si te vas por arriba o por abajo</h1>");
                out.println("Numero:<input align=\"right\" type=\"text\" name=\"numero\">");
                out.println("<input type=\"submit\" name=\"Submit\" value=\"Inicio de juego\" />");  
                out.println("<br>");
                out.println("</form>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }
        }else{
            try (PrintWriter out = response.getWriter()) {
                String numero = request.getParameter("numero");
                System.out.println(numero);
                int num = 0;
                String pista = "";
                try{
                    num = Integer.parseInt(numero);
                    
                }catch(Exception e){
                    System.out.println("lo has hecho como mal");
                }
                if(num == numeroSecreto){
                    System.out.println("has ganado");
                    out.println("<h1 align=\"center\">Felicidades "+nombre+"</h1>");
                    out.println("Volver a jugar:<a href=\"inicio.html\">Ir al enlace</a>");
                }else if(num < numeroSecreto){
                    pista = "Prueba con un numero mayor";
                }else{
                    pista = "Prueba con un numero menor";
                }
                out.println("<html>");
                out.println("<head>");
                out.println("<h1>Numero secreto</h1>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<div>");
                out.println("<form id=\"form1\" name=\"form1\" method=\"post\" action=\"Juego\">");
                out.println("<h1>Introduce el numero</h1>");
                out.println("Numero:<input align=\"right\" type=\"text\" name=\"numero\">");
                out.println("<input type=\"submit\" name=\"Submit\" value=\"Inicio de juego\" />");  
                out.println("<br>");
                out.println("<h1>"+pista+"</h1>");
                out.println("</form>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
                
                /*
                while(true){
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<h1>Numero secreto</h1>");            
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Juego</h1>");
                        out.println("<input align=\"right\" type=\"text\" name=\"numero\">");
                        numero = (int) request.getAttribute("numero");
                        System.out.println(numero);
                        if(numero == numeroSecreto){
                        System.out.println("asaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                        }
                        out.println("<input type=\"submit\" name=\"Submit\" value=\"Inicio de juego\" />");           
                        out.println("</body>");
                        out.println("</html>");
                    }
                */
                    
                    
                    
                    
                /* TODO output your page here. You may use following sample code. */
                
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
