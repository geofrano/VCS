<%-- 
    Document   : cont_parametro
    Created on : 05-may-2016, 20:19:35
    Author     : Hp
--%>
<div id="frm_consulta" name="frm_consulta">
    <form id="frm_datos" name="frm_datos" action="" method="POST">
        <fieldset>
            <legend><h1 class="alineado3">Mantenimiento - Horas</h1></legend>
            <br>
            <div class="list-group" id="div_datos"></div>
            <table class="table table-hover table-responsive">
                <tr>
                    <td><label>Horas</label></td>
                    <td>
                        <select name="cmb_horas" id="cmb_horas" class="form-control" ng-open="carga_combo_horas()"></select>
                    </td>
                    <td><label>Actividad</label></td>
                    <td>
                        <select name="cmb_actividad" id="cmb_actividad" class="form-control" ng-open="carga_combo_tipo_actividad()"></select>
                    </td>
                    <td>
                        <div id="div_consulta" name="div_consulta">
                            <img width="30px" height="30px" id="img_consulta" name="img_consulta" class="img-circle" title="Consultar" src="../../images/consultar.jpg" ng-click="consulta_mapeo()"/></div>
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
        <table id="tbl_mapeo" class="table table-hover table-responsive">
            <tr>
                <th colspan="2">Id Parametro</th>
                <th colspan="2">Id Actividad</th>
                <th colspan="2">Desc. Actividad</th>
                <th colspan="2">ID Horas</th>
                <th colspan="2">Desc. Horas</th>
            </tr>
        </table>
        <div class="modal fade" id="campos_parametro" role="dialog">
            <div class="modal-dialog modal-open">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="title-c">Actvidad - Horas</h4>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" value="I" id="tipo_accion" name="tipo_accion"/>
                        <input type="hidden" value="" id="cont" name="cont"/>
                        <div class="list-group" id="div_datos"></div>
                        <div class="form-group">
                            <table class="table table-hover table-responsive">
                                <tr>
                                    <td>
                                        <label>Id Parametro: </label><label class="text-danger" ng-open="carga_codigo()"></label>
                                    </td>
                                    <td class="tamanio1">
                                        <input type="text" readonly="readonly" class="text-primary form-control" id="txt_id_parametro" name="txt_id_parametro" maxlength="100">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Actividad: </label><label class="text-danger">(*)</label>
                                    </td>
                                    <td>
                                        <select name="cmb_actividad_in" id="cmb_actividad_in" class="form-control" ng-open="carga_combo_tipo_actividad_in()"></select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Horas: </label><label class="text-danger">(*)</label>
                                    </td>
                                    <td>
                                        <select name="cmb_horas_in" id="cmb_horas_in" class="form-control" ng-open="carga_combo_horas_in()"></select>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="form-group center-block text-center">
                            <button type="button" class="btn btn-success" onclick="modificar_mapeo();">Guardar</button>
                            <button type="button" class="btn btn-danger" data-dismiss="modal" ng-click="consulta_mapeo()">Cerrar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<div id="div_consul" style="display:none">

</div>