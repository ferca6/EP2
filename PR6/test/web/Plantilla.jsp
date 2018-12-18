<%-- 
    Document   : Plantilla
    Created on : 18-dic-2018, 12:00:56
    Author     : fer_n
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Plantilla</title>
</head>
<body>
<% String pie="Universidad de Valencia";
String encabezado="Clase práctica de JSP";
String indice="Contenidos"; %>
<table border=1>
<tr>
</tr>
<tr>
<td></td>
<td><%=encabezado%><!--Expresión--></td>
<td>
<table border=1>
<tr>
</tr>
<tr>
</tr>
<tr>
</tr>
<tr>
</tr>
</table>
</td>
<td><%=indice%><!--Expresión--></td>
<td>* Uso de Scriptlets</td>
<td>* Uso de Expresiones </td>
<td>* Uso de Directiva "include"</td>
</tr>
<tr>
<td><%@include file="contenido.jsp"%><!--Directiva include-->
</td>
<td></td>
<td><%=pie%><!--Expresión--></td>
</tr>
</table>
</body>
</html>

