/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fer_n
 */
@WebServlet(urlPatterns = {"/Personalidad"})
public class Personalidad extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Personalidad</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Personalidad at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        processRequest(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String nombre = request.getParameter("nombre");
        System.out.println(nombre);
        int imagen = Integer.parseInt(request.getParameter("imagen"));
        out.println("<html>");
        out.println("<head>");
        out.println("<center>");
        out.println("<h1>Test de personalidad</h1>"); 
        out.println("</center>");
        out.println("</head>");
        out.println("<body BGCOLOR=\"#FDF5E6\">");
        out.println("<div style=\"margin-left: 35%; margin-right: 35%\">");
        out.println("<center>");
        if(nombre == ""){
            out.println("<h3>No ha escrito su nombre</h3>");
            out.println("Volver a inicio:<a href=\"test.html\">Ir al enlace</a>");
        }else if(imagen == 0){
            out.println("<h3>Imagen no escogida</h3>");
            out.println("Volver a inicio:<a href=\"test.html\">Ir al enlace</a>");
        }else{
            out.println("<p>Hola,"+nombre+" después de realizar el test podemos aventurarnos a decir que su\n" +
            "personalidad es la siguiente:</p>");
            out.println("<br>");
            switch(imagen){
                case 1:
                    out.println("<p>Te desentiendes de ti mismo y de tu entorno, en mayor medida que la mayoría\n" +
"de las personas. Detestas superficialidades, prefieres permanecer aislado que sufrir el\n" +
"impacto de un diálogo estéril. Pero las relaciones con amigos son intensas y profundas, lo\n" +
"que te proporciona tranquilidad y armonía espiritual indispensable para que te sientas\n" +
"bien. No te preocupas por el aislamiento, aunque sea durante largos periodos de tiempo. Es\n" +
"una circunstancia que no te desagrada.</p>");
                    break;
                case 2:
                    out.println("<p> Exiges libertad y vida sin compromiso. Determinas tu destino. Tienes talento\n" +
"artístico en el trabajo y en el ocio. Algunas veces, tu impulso por la libertad te lleva a\n" +
"proceder de manera opuesta a lo que se espera de ti. Tu estilo de vida es altamente\n" +
"individualista. Jamás imitas ciegamente lo que es convencional, al contrario, tratas de vivir\n" +
"de acuerdo con tus propias ideas y convicciones, aunque esto signifique nadar contra\n" +
"corriente.</p>");
                    break;
                
                case 3:
                    out.println("<p> Estás muy inclinada a correr ciertos riesgos y asumir importantes compromisos a\n" +
"cambio de tareas variadas e interesantes. En contraste, actividades rutinarias tienden a\n" +
"ejercer efecto paralizante sobre ti. Lo que más aprecias es desempeñar un papel activo en\n" +
"los acontecimientos. Procediendo así, tu capacidad de iniciativa se torna significativamente\n" +
"acentuada.</p>");
                    break;
                case 4:
                    out.println("<p> Valoras el amor y un estilo de vida simple y sin complicaciones. Los que te\n" +
"rodean te admiran porque tienes ambos pies firmemente plantados en el suelo y así se\n" +
"tornan dependientes de ti. Ofreces espacio y seguridad a los amigos íntimos. Tus dotes son\n" +
"consideradas humanas y cálidas. Rechazas lo trivial y extravagante. Tiendes a ser escéptico\n" +
"en relación a fantasías y modismos. Tu indumentaria tiene que ser práctica y discretamente\n" +
"elegante.</p>");
                    break;
                case 5:
                    out.println("<p>Tienes pleno dominio de la vida y depositas menos fe en la suerte que en tus\n" +
"actos. Solucionas problemas de modo simple y práctico. Tienes visión realista de los\n" +
"acontecimientos cotidianos y los manipulas sin dudas. Gran parte de la responsabilidad en\n" +
"el trabajo te es conferida porque todos saben que pueden depender de ti. Tu pronunciada\n" +
"fuerza de voluntad transmite auto-confianza a los otros. Jamás te sentirás totalmente\n" +
"satisfecho en cuanto no hayas realizado tus ideas.</p>");
                    break;
                case 6:
                    out.println("<p> Menosprecias formalidades sin causar dificultades a otros. Tus amistadas son\n" +
"hechas fácilmente, pero aprecias la privacidad y la independencia. Gustas distanciarte de\n" +
"todo y de todos, de tiempo en tiempo para contemplar el significado de la vida y alegrarte\n" +
"contigo mismo. Necesitas espacio, y por eso te refugias en lugares solitarios y bonitos.\n" +
"Pero, no eres una persona solitaria. Estás en paz contigo mismo y con el mundo, y gustas de\n" +
"la vida y de los que ella tiene para ofrecerte.</p>");
                    break;
                case 7:
                    out.println("<p>Amas una vida libre y espontánea, y tratas de disfrutarla en toda su plenitud, de\n" +
"acuerdo con el refrán: “sólo se vive una vez”. Te muestras interesado y abierto a todo lo\n" +
"que es nuevo; los cambios alimentan tu espíritu. Nada es peor que cuando te sientes\n" +
"privado de tu libertad. Vives tu ambiente como algo versátil y siempre en condiciones de\n" +
"brindarte con una sorpresa diaria.</p>");
                    break;
                case 8:
                    out.println("<p>Eres muy sensible. Rechazas analizar los acontecimientos solamente con un\n" +
"punto de vista frio y racional. Solo te importa lo que los sentimientos te dicen. Como\n" +
"efecto, avalas como significativo tener anhelos en la vida. Rechazas a quien desprecia el\n" +
"romanticismo y te dejas guiar solamente por la racionalidad. Rechazas cualquier limitación\n" +
"a la rica variedad de tus impulsos y emociones.</p>");
                    break;
                case 9:
                    out.println("<p>Tu sensibilidad representa lo que es duradero y de alta calidad. En consecuencia,\n" +
"gustas de rodearte de pequeñas preciosidades, que descubres donde quieres que sean ignoradas por otros. Siendo así, la cultura desempeña un papel especial en tu vida. Tienes\n" +
"un estilo personal elegante y exhaustivo, libre de las fantasías de los modismos. Lo ideal,\n" +
"sobre lo cual basas tu vida, es el placer asociado a la cultura. Valorizas un cierto nivel de\n" +
"cultura en las personas que quien te asocias.</p>");
                    break;
            }
            out.println("<br>");
            out.println("Volver a realizar el test:<a href=\"test.html\">Ir al enlace</a>");
            out.println("</center>");
            out.println("</form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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
