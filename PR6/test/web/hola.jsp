<%-- 
    Document   : hola
    Created on : 18-dic-2018, 11:59:49
    Author     : fer_n
--%>

<%@ page info="Primer ejemplo JSP" %>
<!-- Incluimos paquete java.util (mediante una directiva page) -->
<%@ page import="java.util.*"%>
<%! String mensaje = "Mi primerita p�gina JSP"; %>
<%=mensaje %>
<br>
<!-- La siguiente l�nea muestra la fecha -->
Hoy es: <%= new Date() %>
<br>