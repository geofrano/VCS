<%-- 
    Document   : Index2.jsp
    Created on : 30/12/2015, 04:27:03 PM
    Author     : Geovanny Barrera
--%>
 <%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Principal</title>
        <% String ruta = request.getContextPath();%>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="../css/bootstrap.min.css" >
        <link rel="stylesheet" href="../css/login.css" >
        <script src="../js/angular.min.js"></script>
        <script src="../js/login.js"></script>
        <script src="../js/jquery.js"></script>
        <script src="../js/bootstrap.min.js"></script>
    </head>
    <body>
        <%  HttpSession sesion=request.getSession(true);
           String nombres = (String)session.getAttribute("nombre_usuario");
   String apellidos = (String)session.getAttribute("apellido_usuario");%>
        
        
        <h1>Hello World!</h1><p>Bienvenido <%=nombres%> <%=apellidos%></p>
    </body>
</html>
