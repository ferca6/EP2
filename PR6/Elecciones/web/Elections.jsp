<%-- 
    Document   : Elections
    Created on : 18-dic-2018, 12:29:55
    Author     : fer_n
--%>

<html>
    <head>
        <title>Elecciones</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="pie.jsp" method="post">
            <center>
                <h1>Elecciones</h1>
                <%
                    int npartidos = Integer.parseInt(request.getParameter("partidos"));
                    System.out.println(npartidos);
                    request.getSession().setAttribute("npartidos", npartidos);
                    
                    if(npartidos == 0){
                        %>
                        <h3>Numero de partidos no escogido</h3>
                        Empezar la representacion:<a href="inicio.html">Ir al enlace</a>
                        <% 
                    }else{
                        %>
                        <p><b>Introduzca los datos:</b></p>
                        <%
                        for(int i = 1; i <= npartidos; i++){
                            %>
                            <h3>Partido <%= i %>:</h3>
                                <label for="nombre">Introduzca su nombre </label>
                                <input type="text" name="nombre<%=i%>">
                                <br>
                                <label for="votos">Introduzca los votos </label>
                                <input type="text" name="votos<%=i%>">
                                <br>
                                <label for="color">Introduzca el color </label>
                                <input type="color" name="color<%=i%>" >
                                <br>
                            <%
                        }
                        %>
                        <br>
                        <br>
                        <input type="submit" name="Submit" value="Continuar" />
                        <%
                    }
            %>
            </center>
            
        </form>
    </body>
</html>

 
                           
