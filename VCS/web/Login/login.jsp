<%-- 
    Document   : login
    Created on : 26/12/2015, 04:22:31 PM
    Author     : Geovanny Barrera
--%>
<%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="VCS">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    <body  ng-controller="ControladorLogin">
        <header>
            <div class="container">
                <h1>Sistema único de Autenticación VCS</h1>
            </div>
        </header>
        <div class="container">

            <%-- <div class="table-responsive">
                <table class="tabla_login">
                    <tr><td>adasd</td></tr>
                </table></div>--%>
            <div class="main row"></div>    
            <div class="row">
                <div class="col-md-8">
                    <div class="panel panel-default">
                        <div class="panel-body"><jsp:include page="../vistas/logo_login.jsp" /></div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <%-- <div class="page-header">
                                 <h3>Login Area</h3>
                                 </div>--%>
                            <form role="form" action=""  method="POST" id="frm_login" name="frm_login">
                                <div class="form-group">
                                    <label for="txt_usuario">Usuario</label>
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                        <input type="text" class="form-control" id="txt_usuario" name="txt_usuario" maxlength="20" placeholder="Ingrese su usuario" ng-model="txt_usuario" required="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    
                                    <label for="txt_clave">Contraseña</label>
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-star"></span></span>
                                        <input type="password" class="form-control" id="txt_clave" name="txt_clave" maxlength="20" placeholder="Ingrese su contraseña" ng-model="txt_clave" required="" >
                                    </div>
                                </div>
                                <hr/>
                                <%--<button type="button" class="btn btn-success"><span class="glyphicon glyphicon-arrow-left"></span> Back</button>--%>
                                <button ng-click="valida()" ng-submit="valida()" type="submit" class="btn btn-primary" onclick="valida();" onsubmit="valida();" ng-disabled="frm_login.txt_clave.$invalid || frm_login.txt_usuario.$invalid "><span class="glyphicon glyphicon-lock"></span> Iniciar Sesión</button>
                                <p><br/></p>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>{{institucion}}
        <input type="hidden" value="<%=ruta%>" id="ruta_principal" name="ruta_principal" />
        
    </body>
</html>
