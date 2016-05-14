<%-- 
    Document   : mantenimiento_parametro
    Created on : 05-may-2016, 20:17:19
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="VCS">
    <head>
        <meta http-equiv="cache-control" content="max-age=0" />
        <meta http-equiv="cache-control" content="no-cache" />
        <meta http-equiv="expires" content="0" />
        <meta http-equiv="pragma" content="no-cache" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Administrativo VCS - UPS</title>
        <% String ruta = request.getContextPath();%>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="../../css/bootstrap.min.css" >
        <link rel="stylesheet" href="../../css/bootstrap-theme.min.css" >
        <link rel="stylesheet" href="../../css/bootstrap-datetimepicker.min.css" >
        <link rel="stylesheet" href="../../css/principal.css" >
        <link rel="stylesheet" href="../../css/sweetalert.css">
        <script src="../../js/angular.min.js"></script>
        <script src="parametro.js"></script>
        <script src="../../js/jquery.js"></script>
        <script src="../../js/bootstrap.min.js"></script>
        <script src="../../js/bootstrap-datetimepicker.min.js"></script>
        <script src="../../js/id.js"></script>
        <script src="../../js/moment.js"></script>
	<script src="../../js/sweetalert-dev.js"></script>

    </head>
    <body ng-controller="ControladorVCS" onload="carga_combo_tipo_parametro()">
        <div class="container">
            <div class="row">
                <jsp:include page="../../vistas/cabecera_pagina.jsp"/>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <div class="list-group" id="ajaxResponse" ng-open="carga2()"></div>
                </div>
            <div id="icono" class="col-md-9">
                <jsp:include page="cont_parametro.jsp"/>
            </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <jsp:include page="../../vistas/pie_pagina.jsp"/>
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