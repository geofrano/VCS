<%-- 
    Document   : logout
    Created on : 10/01/2016, 01:29:46 PM
    Author     : Geovanny Barrera
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="VCS">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="cache-control" content="max-age=0" />
        <meta http-equiv="cache-control" content="no-cache" />
        <meta http-equiv="expires" content="0" />
        <meta http-equiv="pragma" content="no-cache" />
        <title>Sistema único de autenticación VCS</title>
        <% String ruta = request.getContextPath();%>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="../css/bootstrap.min.css" >
        <link rel="stylesheet" href="../css/login.css" >
        <script src="../js/angular.min.js"></script>
        <script src="../js/login.js"></script>
        <script src="../js/jquery.js"></script>
        <script src="../js/bootstrap.min.js"></script>
    </head>    

    <body ng-controller="ControladorLogin" onload="logout()">
        <form role="form" action=""  method="POST" id="frm_login" name="frm_login">
        </form>
        
    </body>
    
</html>
