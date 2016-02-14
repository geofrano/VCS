<%-- 
    Document   : carta_aceptacion
    Created on : 11/01/2016, 09:39:04 PM
    Author     : Geovanny Barrera
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="VCS">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Administrativo VCS - UPS</title>
        <% String ruta = request.getContextPath();%>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/login.css" >
        <script src="js/angular.min.js"></script>
        <script src="js/carga_pagina.js"></script>
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>

    </head>
    <body onload="carga()" ng-open="carga()" ng-controller="ControladorVCS">
         <form action="" method="POST" id="frm_carga" name="frm_carga">
            <input type="hidden" value="<%=ruta%>" id="ruta_principal" name="ruta_principal" />
            <input type="hidden" value="cont_carta_aceptacion" id="nombre_pagina" name="nombre_pagina" />
        </form>
    </body>
</html>
