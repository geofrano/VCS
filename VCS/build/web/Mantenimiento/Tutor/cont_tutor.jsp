<%-- 
    Document   : cont_tutor
    Created on : 05-may-2016, 20:19:47
    Author     : Hp
--%>
<div id="frm_consulta" name="frm_consulta">
    <form id="frm_datos" name="frm_datos" action="" method="POST">
        <fieldset>
            <legend><h1 class="alineado3">Mantenimiento - Tutores</h1></legend>
            <br>
            <div class="list-group" id="div_datos"></div>
            <table class="table table-hover table-responsive">
                <tr>
                    <td><label>Nombre del Tutor</label></td>
                    <td>
                        <input type="text" class="text-primary form-control" id="txt_nombre_tutor" title="Nombre del tutor" name="txt_nombre_tutor" maxlength="800">
                    </td>
                    <td><label>Carrera</label></td>
                    <td>
                        <select name="cmb_carrera" id="cmb_carrera" class="form-control"></select>
                    </td>
                    <td>
                        <div id="div_consulta" name="div_consulta">
                            <img width="30px" height="30px" id="img_consulta" name="img_consulta" class="img-circle" title="Consultar" src="../../images/consultar.jpg" ng-click="consulta_tutor()"/></div>
                        <div id="div_consulta2" name="div_consulta2" style="display:none">
                            <img width="30px" height="30px" id="img_cargando" name="img_cargando" title="Cargando..." src="../../images/cargando.svg" /></div>
                    </td>
                    <td>
                        <img width="30px" height="30px" class="img-circle" src="../../images/agregar.jpg" title="Agregar Parametro" data-toggle="modal" data-target="#campos_parametro" onclick="asigna_accion_ingreso();" />
                    </td>
                </tr>
            </table>
        </fieldset>
        <input type="hidden" id="existe_data" value="0"/>
        <div id="div_datos"></div>
        <table id="tbl_tutor" class="table table-hover table-responsive">
            <tr>
                <th colspan="2">Id Tutor</th>
                <th colspan="2">Descripción</th>
                <th colspan="2">Nombre</th>
                <th colspan="4">Carrera</th>
            </tr>
        </table>
        <div class="modal fade" id="campos_parametro" role="dialog">
            <div class="modal-dialog modal-open">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="title-c">Tutor</h4>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" value="I" id="tipo_accion" name="tipo_accion"/>
                        <input type="hidden" value="" id="cont" name="cont"/>
                        <div class="list-group" id="div_datos"></div>
                        <div class="form-group">
                            <table class="table table-hover table-responsive">
                                <tr>
                                    <td>
                                        <label>Id Tutor: </label><label class="text-danger"></label>
                                    </td>
                                    <td class="tamanio1">
                                        <input type="text" readonly="readonly" class="text-primary form-control" id="txt_id_tutor" name="txt_id_tutor" maxlength="100">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Descripción: </label><label class="text-danger">(*)</label>
                                    </td>
                                    <td class="tamanio1">
                                        <input type="text" class="text-primary form-control" id="txt_descripcion" name="txt_descripcion" maxlength="200">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Nombre: </label><label class="text-danger">(*)</label>
                                    </td>
                                    <td class="tamanio1">
                                        <input type="text" class="text-primary form-control" id="txt_nombre" name="txt_nombre" maxlength="4000">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Carrera: </label><label class="text-danger">(*)</label>
                                    </td>
                                    <td>
                                        <select name="cmb_carrera_in" id="cmb_carrera_in" class="form-control" ng-open="carga_cmb_tutor()" onchange="asigna_codigo()"></select>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="form-group center-block text-center">
                            <button type="button" class="btn btn-success" onclick="modificar_tutor();">Guardar</button>
                            <button type="button" class="btn btn-danger" data-dismiss="modal" ng-click="consulta_tutor()">Cerrar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<div id="div_consul" style="display:none">

</div>