<%-- 
    Document   : newjsp
    Created on : 10/01/2016, 01:29:46 PM
    Author     : Geovanny Barrera
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema único de autenticación VCS</title>
        <% String ruta = request.getContextPath();%>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/principal.css" >
        <script src="js/angular.min.js"></script>
        <script src="js/login.js"></script>
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>    

    <body>
        <div class="container">
            <div class="row">
                <jsp:include page="vistas/cabecera_pagina.jsp" />
            </div>
            <div class="row">
                <div class="col-md-4">2222222222</div>
                    <div class="col-md-8"><jsp:include page="vistas/pie_pagina.jsp" /></div>
            </div>

        </div>
    </body></html>
