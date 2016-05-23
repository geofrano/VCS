<%-- 
    Document   : ingresar_empresa
    Created on : 05-mar-2016, 14:33:29
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
        <title>Empresa o Institución</title>
        <% String ruta = request.getContextPath();%>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="../../css/bootstrap.min.css">
        <link rel="stylesheet" href="../../css/principal.css">
        <link rel="stylesheet" href="../../css/sweetalert.css">
        <script src="../../js/angular.min.js"></script>
        <script src="carta_compromiso.js"></script>
        <script src="../../js/jquery.js"></script>
        <script src="../../js/bootstrap.min.js"></script>
        <script src="../../js/sweetalert-dev.js"></script>
    </head>
    <body ng-controller="ControladorVCS" onload="modif_empr()">
        <div class="container">
            <div class="row" align="center">
                <h4 class="title-c">Empresa o Institución</h4>
            </div>
            <br>
            <div class="row">
                <div class="col-md-12">
                    <form id="frm_empresa_ingreso" name="frm_empresa_ingreso" action="" method="POST">
                        <div class="form-group">
                            <fieldset class="legendas2"><legend class="legendas opcion_iluminada">Información de la Empresa</legend>
                                <table class="table table-hover table-responsive">
                                    <tr>
                                        <td>
                                            <label>Nombre de la Empresa: </label><label class="text-danger">(*)</label>
                                        </td>
                                        <td class="tamanio1" colspan="3">
                                            <input type="text" class="text-primary form-control" id="txt_nom_empresa_ing" name="txt_nom_empresa_ing" maxlength="250">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>Dirección: </label><label class="text-danger">(*)</label>
                                        </td>
                                        <td class="tamanio1" colspan="3">
                                            <input type="text" class="text-primary form-control" id="txt_direccion_ing" name="txt_direccion_ing" maxlength="500">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>Teléfono: </label><label class="text-danger">(*)</label>
                                        </td>
                                        <td class="tamanio4">
                                            <input type="text" class="text-primary form-control" id="txt_telefono_ing" name="txt_telefono_ing" maxlength="10">
                                        </td>
                                        <td>
                                            <label>Tipo: </label><label class="text-danger">(*)</label>
                                        </td>
                                        <td>
                                            <select name="cmb_tipo_emp" id="cmb_tipo_emp" class="form-control" ng-open="carga_combo_tipo_empr()"></select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>Actividad Principal: </label><label class="text-danger">(*)</label>
                                        </td>
                                        <td class="tamanio1" colspan="3">
                                            <input type="text" class="text-primary form-control" id="txt_actividad_empresa_ing" name="txt_actividad_empresa_ing" maxlength="250">
                                        </td>
                                    </tr>
                                </table>
                            </fieldset>
                            <br>
                            <fieldset class="legendas2"><legend class="legendas opcion_iluminada">Representante Legal</legend>
                                <table class="table table-hover table-responsive">
                                    <tr>
                                        <td>
                                            <label>Apellidos: </label><label class="text-danger">(*)</label>
                                        </td>
                                        <td class="tamanio1">
                                            <input type="text" class="text-primary form-control" id="txt_apellido_repr_legal_ing" name="txt_apellido_repr_legal_ing" maxlength="250">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>Nombres: </label><label class="text-danger">(*)</label>
                                        </td>
                                        <td class="tamanio1">
                                            <input type="text" class="text-primary form-control" id="txt_nombre_repr_legal_ing" name="txt_nombre_repr_legal_ing" maxlength="250">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>Cargo: </label><label class="text-danger">(*)</label>
                                        </td>
                                        <td class="tamanio1">
                                            <input type="text" class="text-primary form-control" id="txt_cargo_repr_legal_ing" name="txt_cargo_repr_legal_ing" maxlength="250">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>Teléfono: </label><label class="text-danger">(*)</label>
                                        </td>
                                        <td class="tamanio1">
                                            <input type="text" class="text-primary form-control" id="txt_fono_repr_legal_ing" name="txt_fono_repr_legal_ing" maxlength="15">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <input type="hidden" value="<%=ruta%>" id="ruta_principal" name="ruta_principal" />
                                        </td>
                                    </tr>
                                </table>
                            </fieldset>
                        </div>
                        <div class="form-group center-block text-center">
                            <button type="button" class="btn btn-success" onclick="carga_modifica_empr2()">Guardar</button>
                            <button type="button" class="btn btn-danger" onclick="window.close()">Cerrar</button>
                        </div>
                        <input type="hidden" id="id_ue" name="id_ue" value="" />
                        <input type="hidden" id="id_ar" name="id_ar" value="" />
                        <input type="hidden" id="accion" name="accion" value="" />
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>