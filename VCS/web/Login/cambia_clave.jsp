<%-- 
    Document   : cambia_clave
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
        <%  HttpSession sesion = request.getSession();
            String nombres = (String) session.getAttribute("nombre_usuario");
            String apellidos = (String) session.getAttribute("apellido_usuario");
            String usuario = (String) session.getAttribute("usuario");
            usuario=usuario.toUpperCase();
        %>
        <% String ruta = request.getContextPath();%>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="../css/bootstrap.min.css" >
        <link rel="stylesheet" href="../css/login.css" >
        <link rel="stylesheet" href="../css/principal.css" >
        <script src="../js/angular.min.js"></script>
        <script src="../js/login.js"></script>
        <script src="../js/jquery.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <!-- This is what you need -->
        <script src="../js/sweetalert-dev.js"></script>
        <link rel="stylesheet" href="../css/sweetalert.css">
        <!--.......................-->
    </head>    

    <body ng-controller="ControladorLogin">
        <form role="form" action=""  method="POST" id="frm_login" name="frm_login">
        </form>
        <div class="container">
            <div class="row">
                <jsp:include page="../vistas/cabecera_pagina.jsp"/>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <div class="list-group" id="ajaxResponse" ng-open="carga2()"></div>
                </div>
            <div id="icono" class="col-md-9">
                <br/>
                <fieldset>
                    <legend><h1 class="alineado3">CAMBIO DE CLAVE</h1></legend>
                    <fieldset class="legendas2"><legend class="legendas opcion_iluminada">DATOS DEL USUARIO</legend>
                        <table class="table table-hover table-responsive" >
                            <tr>
                                <td align="left"><label for="txt_usuario">USUARIO:</label></td>
                                <td><%=usuario%></td>
                            </tr>
                            <tr>
                                <td align="left"><label for="txt_nombres">NOMBRES:</label></td>
                                <td><%=nombres%></td>
                            </tr>
                            <tr>
                                <td align="left"><label for="txt_apellidos">APELLIDOS:</label></td>
                                <td><%=apellidos%></td>
                            </tr>
                            <tr>
                                <td align="left"><label for="txt_new_clave">NUEVA CLAVE:</label><label class="text-danger">(*)</label></td>
                                <td><input type="password" class="form-control" id="txt_new_clave" name="txt_new_clave" ng-model="txt_new_clave"/></td>
                            </tr>
                            <tr>
                                <td align="left" width=333px><label for="txt_new_clave2">INGRESE NUEVAMENTE SU NUEVA CLAVE:</label><label class="text-danger">(*)</label></td>
                                <td align="left"><input type="password" class="form-control" id="txt_new_clave2" name="txt_new_clave2" ng-model="txt_new_clave2"/></td>
                            </tr>
                        </table>
                    </fieldset>
                </fieldset>
                <br><br>
                <center><button type="button" class="btn btn-primary" onclick="cambia_clave();"><span class="glyphicon glyphicon-ok"></span> Grabar</button>
                </center>
            </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <jsp:include page="../vistas/pie_pagina.jsp"/>
                </div>
            </div>
            <form action="" method="POST" id="frm_carga" name="frm_carga">
                <input type="hidden" value="<%=ruta%>" id="ruta_principal" name="ruta_principal" />
                <input type="hidden" value="blank" id="nombre_pagina" name="nombre_pagina" />
                <input type="hidden" value="1" id="id_modulo_padre" name="id_modulo_padre" />
            </form>
        </div>
    </body>
    
</html>
