<%-- 
    Document   : principal
    Created on : 09/01/2016, 09:14:29 PM
    Author     : Geovanny Barrera
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
        <title>Ficha del Estudiante - Consulta</title>
        <% String ruta = request.getContextPath();%>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="../../css/bootstrap.min.css" >
        <link rel="stylesheet" href="../../css/principal.css" >
        <script src="../../js/angular.min.js"></script>
        <script src="ficha_estudiante.js"></script>
        <script src="../../js/jquery.js"></script>
        <script src="../../js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../../js/jquery.mockjax.js"></script>
        <script type="text/javascript" src="../../js/jquery.autocomplete.js"></script>
        <script type="text/javascript" src="../../js/estudiantes.js"></script>
        <script type="text/javascript" src="../../js/funciones_autocomplete.js"></script>

    </head>
    <body ng-controller="ControladorVCS">
        <div class="container">
            <div class="row">
                <jsp:include page="../../vistas/cabecera_pagina.jsp"/>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <div class="list-group" id="ajaxResponse" ng-open="carga2()"></div>
                </div>
                <div class="col-md-9">

                    <fieldset>
                        <legend><h1>Criterios de búsqueda</h1></legend><br>
                        <table class="table table-hover table-responsive">
                            <tr>
                                <td>Cod. Carta comp.:</td>
                                <td><input type="text" class="form-control" id="txt_cod_cart_comp" name="txt_cod_cart_comp" ng-model="txt_cod_cart_comp" /></td>
                                <td>Tipo de Actividad:</td>
                                <td><input type="text" class="form-control" id="txt_tipo_act" name="txt_tipo_act" ng-model="txt_ced_est" /></td>
                            </tr>
                            <tr>
                                <td>Nombre del estudiante:</td>
                                <td colspan="2"><input type="text" class="form-control" id="txt_nomb_est" name="txt_nomb_est" ng-model="txt_nomb_est" /></td>
                            <%--<div id="selction-ajax"></div>--%>
                            <td align="right"><input type="button" value="Consultar" ng-click="consulta_ficha_est()"/></td>
                            </tr>
                        </table>
                    </fieldset>
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
