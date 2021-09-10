<%-- 
    Document   : ejemplo1.jsp
    Created on : 5/09/2021, 7:44:48 a. m.
    Author     : santi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">        
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <%
                String titulo;
                titulo = "Bienvenidos al grupo S2.";
                out.println(titulo);
            %>
        </h1>
    </body>
</html>
