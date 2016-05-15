<%-- 
    Document   : cont_carta_compromiso
    Created on : 11/01/2016, 09:32:43 PM
    Author     : Geovanny Barrera
--%>
<% String ruta = request.getContextPath();%>
<h1 class="alineado3">Carta Compromiso Interinstitucional</h1>
<div class="form-group">
    <form id="frm_carta_comp" name="frm_carta_comp" action="" method="POST">
        <input type="hidden" id="accion_form" name="accion_form" value="M" />
        <fieldset class="legendas2"><legend class="legendas opcion_iluminada">Información General</legend>
            <table class="table table-hover table-responsive">
                <tr>
                    <td><label>Código: </label></td>
                    <td><div class="second">
                         <input type="text" class="text-primary form-control" readonly="readonly" id="txt_codigo" name="txt_codigo" maxlength="50">
                        </div>
                    </td>
                    <td><label>No: </label></td>
                    <td align="center">
                        <input type="text" class="text-primary form-control disabled" readonly="readonly" id="txt_numero" name="txt_numero" maxlength="50">
                    </td>
                </tr>
                <tr>
                    <td><label>Nombre de la Empresa<br>o Institución: </label></td>
                    <td colspan="3">
                        <input type="hidden" id="id_empresa" name="id_empresa"/>
                        <input type="text" title="Seleccione la empresa dando clic sobre este campo" data-toggle="modal" data-target="#consultar_empresa" class="text-primary form-control" id="txt_nombre_empresa" name="txt_nombre_empresa" readonly="readonly" maxlength="250" />
                        <!-- Modal content-->
                        <div class="modal fade" id="consultar_empresa" role="dialog">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Consultar Empresa o Institución</h4>
                                    </div>
                                    <div class="modal-body">
                                        <input type="hidden" value="I" id="tipo_accion" name="tipo_accion"/>
                                        <input type="hidden" value="" id="cont" name="cont"/>
                                        <div class="list-group" id="div_datos"></div>
                                        <table class="table table-hover table-responsive">
                                            <tr>
                                                <td><label>Empresa o Institución:</label></td>
                                                <td>
                                                    <input type="text" class="text-primary form-control" id="txt_nombre_emp" title="Empresa o Institución" name="txt_nombre_emp" maxlength="1000">
                                                </td>
                                                <td>
                                                    <div id="div_consulta" name="div_consulta">
                                                        <img width="30px" height="30px" id="img_consulta" name="img_consulta" class="img-circle" title="Consultar" src="../../images/consultar.jpg" ng-click="consultar_empresa()"/></div>
                                                    <div id="div_consulta2" name="div_consulta2" style="display:none">
                                                        <img width="30px" height="30px" id="img_cargando" name="img_cargando" title="Cargando..." src="../../images/cargando.svg" /></div>
                                                </td>
                                                <td>
                                                    <img width="30px" height="30px" class="img-circle" src="../../images/agregar.jpg" title="Agregar Empresa o Institucion" ng-click="ventana_ing_empresa()"/>
                                                </td>
                                            </tr>
                                        </table>
                                        <div id="div_datos"></div>
                                        <table id="tbl_empresa" class="table table-hover table-responsive">
                                            <tr>
                                                <th>Nombre de Empresa</th>
                                                <th>Dirección</th>
                                                <th>Teléfono</th>
                                                <th>Actividad Princpial</th>
                                                <th colspan="2">Representante Legal</th>
                                                <th>Cargo</th>
                                                <th></th>
                                            </tr>
                                        </table>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-success" data-dismiss="modal" ng-click="datos_empresa()" id="btn_aceptar_emp" name="btn_aceptar_emp">Aceptar</button>
                                        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        <input type="hidden" id="existe_empresa" value="0"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td><label>Dirección: </label></td>
                    <td>
                        <input type="text" readonly="readonly" class="text-primary form-control" id="txt_direccion" name="txt_direccion" maxlength="500">
                    </td>
                    <td><label>Teléfono: </label></td>
                    <td>
                        <input type="text" readonly="readonly" class="text-primary form-control" id="txt_telefono" name="txt_telefono" maxlength="10">
                    </td>
                </tr>
                <tr>
                    <td><label>Actividad Principal de<br>la Empresa o Institución: </label></td>
                    <td colspan="3">
                        <input type="text" readonly="readonly" class="text-primary form-control" id="txt_actividad_empresa" name="txt_actividad_empresa" maxlength="250">
                    </td>
                </tr>
                <tr>
                    <td><label>Apellidos y Nombres del<br>Estudiante: </label></td>
                    <td colspan="3">
                        <input type="hidden" id="txt_id_est" name="txt_id_est" />
                        <input type="text" title="Seleccione el estudiante dando clic sobre este campo" data-toggle="modal" data-target="#consultar_estudiante" class="text-primary form-control" id="txt_nombre_estudiante" name="txt_nombre_estudiante" maxlength="1000" readonly="readonly" >
                        <!-- Modal content-->
                        <div class="modal fade" id="consultar_estudiante" role="dialog">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Consultar Estudiante</h4>
                                    </div>
                                    <div class="modal-body">
                                        <input type="hidden" value="I" id="tipo_accion_est" name="tipo_accion_est"/>
                                        <input type="hidden" value="" id="cont_est" name="cont_est"/>
                                        <div class="list-group" id="div_datos_est"></div>
                                        <table class="table table-hover table-responsive">
                                            <tr>
                                                <td><label>Estudiante:</label></td>
                                                <td>
                                                    <input type="text" class="text-primary form-control" id="txt_nombre_est_mod" name="txt_nombre_est_mod" title="Estudiante" maxlength="1000">
                                                </td>
                                                <td><label>Cedula:</label></td>
                                                <td>
                                                    <input type="text" class="text-primary form-control" id="txt_ced_est_mod" name="txt_ced_est_mod" title="Cedula" maxlength="15" onkeypress="return controltag(event,1)" >
                                                </td>
                                                <td>
                                                    <div id="div_consulta_est" name="div_consulta_est">
                                                        <img width="30px" height="30px" id="img_consulta" name="img_consulta" class="img-circle" title="Consultar" src="../../images/consultar.jpg" ng-click="consultar_estudiante()"/></div>
                                                    <div id="div_consulta2_est" name="div_consulta2_est" style="display:none">
                                                        <img width="30px" height="30px" id="img_cargando" name="img_cargando" alt="Cargando..." src="../../images/cargando.svg" /></div>
                                                </td>
                                            </tr>
                                        </table>
                                        <table id="tbl_estudiante" class="table table-hover table-responsive">
                                            <tr>
                                                <th>Nombre de Estudiante</th>
                                                <th>Cedula</th>
                                                <th>Carrera</th>
                                                <th>Ciclo</th>
                                                <th></th>
                                            </tr>
                                        </table>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-success" data-dismiss="modal" ng-click="datos_estudiantes()" id="btn_aceptar_est" name="btn_aceptar_est">Aceptar</button>
                                        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        <input type="hidden" id="existe_estudiante" value="0"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td><label>Carrera de Grado: </label></td>
                    <td>
                        <select name="cmb_carrera" disabled="disabled" id="cmb_carrera" class="form-control" onchange="carga_codigo();carga_combo_tutor()"></select>
                    </td>
                    <td><label>Ciclo o Semestre<br>que cursa: </label></td>
                    <td>
                        <select name="cmb_ciclos" id="cmb_ciclos" disabled="disabled" class="form-control"></select>
                    </td>
                </tr>
            </table>
        </fieldset><br><br>
        <div id="div_campos_bloq" name="div_campos_bloq" class="first" style="display:none">
        <fieldset class="legendas2"><legend class="legendas opcion_iluminada">Descripción Estratégica de Intervención</legend>
            <table class="table table-hover table-responsive">
                <tr>
                    <td>
                        <label>Tipo de Actividad Académica: </label>
                    </td>
                    <td>
                        <select name="cmb_tipo_actividad" id="cmb_tipo_actividad" class="form-control" onchange="carga_codigo()"></select>
                    </td>
                    <td><label>Duración: </label></td>
                    <td>
                        <select name="cmb_horas" id="cmb_horas" class="form-control"></select>
                    </td>
                </tr>
                <tr>
                    <td><label>Objetivo de la Actividad Académica: </label></td>
                    <td>
                        <textarea class="text-primary form-control" id="txt_obj_act_academica" 
                                  name="txt_obj_act_academica" maxlength="10000" rows="5"></textarea>
                    </td>
                    <td colspan="2">
                        <table>
                            <tr>
                                <td>
                                    <label>Fecha Inicio: </label>
                                </td>
                                <td>
                                    <div class="form-group">
                                        <div class='input-group date' id='datetimepicker6' ng-disabled="true">
                                            <input type="text" class="form-control" id="txt_fecha_ini" name="txt_fecha_ini" ng-model="txt_fecha_ini" onkeypress="return controltag(event)" />
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-calendar"></span>
                                            </span>
                                        </div>
                                    </div> 
                                    <!-- <input type="text" class="text-primary form-control" id="txt_fecha_inicio" name="txt_fecha_inicio" maxlength="100">-->
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Fecha Final: </label>
                                </td>
                                <td>
                                    <div class="form-group">
                                        <div class='input-group date' id='datetimepicker7'>
                                            <input type="text" class="form-control" id="txt_fecha_fin" name="txt_fecha_fin" ng-model="txt_fecha_fin" onkeypress="return controltag(event)" />
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-calendar"></span>
                                            </span>
                                        </div>
                                    </div>
                                    <!--<input type="text" class="text-primary form-control" id="txt_fecha_fin" name="txt_fecha_fin" maxlength="100">-->
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Horario Previsto: </label>
                                </td>
                                <td class="text-center">
                                    <input type="text" class="text-primary form-control" id="txt_horario" name="txt_horario" maxlength="300">
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td><label>Nombre Programa: </label></td>
                    <td colspan="3">
                        <select name="cmb_programa" id="cmb_programa" class="form-control"  onchange="carga_codigo()"></select>
                    </td>
                </tr>
                <tr>
                    <td><label>Área que Requiere la Actividad Académica: </label></td>
                    <td>
                        <input type="text" class="text-primary form-control" id="txt_area_academica" name="txt_area_academica" maxlength="300">
                    </td>
                    <td><label>Responsable del Área: </label></td>
                    <td>
                        <input type="text" class="text-primary form-control" id="txt_respon_area" name="txt_respon_area" maxlength="600">
                    </td>
                </tr>
                <tr>
                    <td colspan="4" class="alineado3">
                        <label class="text-uppercase">Actividades Previstas a ser Desarrolladas en la Actividad Académica</label>
                        <label>(Señale aquellas que prevén Resultados y Productos)</label>
                    </td>
                </tr>
                <tr><td colspan="4">
                        <table class="table table-hover table-responsive">
                            <tr>
                                <td><label>1.</label></td>
                                <td colspan="3" class="tamanio2">
                                    <input type="text" class="text-primary form-control" id="txt_actividad_1" name="txt_actividad_1">
                                </td>
                            </tr>
                            <tr>
                                <td><label>2.</label></td>
                                <td class="tamanio2">
                                    <input type="text" class="text-primary form-control" id="txt_actividad_2" name="txt_actividad_2" >
                                </td>
                            </tr>
                            <tr>
                                <td><label>3.</label></td>
                                <td class="tamanio2">
                                    <input type="text" class="text-primary form-control" id="txt_actividad_3" name="txt_actividad_3">
                                </td>
                            </tr>
                            <tr>
                                <td><label>4.</label></td>
                                <td class="tamanio2">
                                    <input type="text" class="text-primary form-control" id="txt_actividad_4" name="txt_actividad_4">
                                </td>
                            </tr>
                            <tr>
                                <td><label>5.</label></td>
                                <td class="tamanio2">
                                    <input type="text" class="text-primary form-control" id="txt_actividad_5" name="txt_actividad_5">
                                </td>
                            </tr>
                            <tr>
                                <td><label>6.</label></td>
                                <td class="tamanio2">
                                    <input type="text" class="text-primary form-control" id="txt_actividad_6" name="txt_actividad_6">
                                </td>
                            </tr>
                        </table>

                    </td>
                </tr>

                <tr>
                    <td colspan="4" class="alineado3">
                        <label class="text-uppercase">Resultados Previstos de Actividad Académica</label>
                    </td>
                </tr>
                <tr>
                    <td colspan="4">
                        <table class="table table-hover table-responsive">
                            <tr>
                                <td><label>1.</label></td>
                                <td colspan="3" class="tamanio2">
                                    <input type="text" class="text-primary form-control" id="txt_resultado_1" name="txt_resultado_1">
                                </td>
                            </tr>
                            <tr>
                                <td><label>2.</label></td>
                                <td class="tamanio2">
                                    <input type="text" class="text-primary form-control" id="txt_resultado_2" name="txt_resultado_2" >
                                </td>
                            </tr>
                            <tr>
                                <td><label>3.</label></td>
                                <td class="tamanio2">
                                    <input type="text" class="text-primary form-control" id="txt_resultado_3" name="txt_resultado_3">
                                </td>
                            </tr>
                            <tr>
                                <td><label>4.</label></td>
                                <td class="tamanio2">
                                    <input type="text" class="text-primary form-control" id="txt_resultado_4" name="txt_resultado_4">
                                </td>
                            </tr>
                            <tr>
                                <td><label>5.</label></td>
                                <td class="tamanio2">
                                    <input type="text" class="text-primary form-control" id="txt_resultado_5" name="txt_resultado_5">
                                </td>
                            </tr>
                            <tr>
                                <td><label>6.</label></td>
                                <td class="tamanio2">
                                    <input type="text" class="text-primary form-control" id="txt_resultado_6" name="txt_resultado_6">
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td colspan="4" class="alineado3">
                        <label class="text-uppercase">RECURSOS: PRODUCTOS ENTREGABLES PREVISTOS DE LA ACTIVIDAD ACADÉMICA Y LOS MATERIALES FÍSICOS QUE SE GENERAN EN LA INTERVENCIÓN</label>
                    </td>
                </tr>
                <tr>
                    <td colspan="4">
                        <table class="table table-hover table-responsive">
                            <tr>
                                <td><label>1.</label></td>
                                <td colspan="3" class="tamanio2">
                                    <input type="text" class="text-primary form-control" id="txt_producto_1" name="txt_producto_1">
                                </td>
                            </tr>
                            <tr>
                                <td><label>2.</label></td>
                                <td class="tamanio2">
                                    <input type="text" class="text-primary form-control" id="txt_producto_2" name="txt_producto_2" >
                                </td>
                            </tr>
                            <tr>
                                <td><label>3.</label></td>
                                <td class="tamanio2">
                                    <input type="text" class="text-primary form-control" id="txt_producto_3" name="txt_producto_3">
                                </td>
                            </tr>
                            <tr>
                                <td><label>4.</label></td>
                                <td class="tamanio2">
                                    <input type="text" class="text-primary form-control" id="txt_producto_4" name="txt_producto_4">
                                </td>
                            </tr>
                            <tr>
                                <td><label>5.</label></td>
                                <td class="tamanio2">
                                    <input type="text" class="text-primary form-control" id="txt_producto_5" name="txt_producto_5">
                                </td>
                            </tr>
                            <tr>
                                <td><label>6.</label></td>
                                <td class="tamanio2">
                                    <input type="text" class="text-primary form-control" id="txt_producto_6" name="txt_producto_6">
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td><label>Nombre del Tutor: </label></td>
                    <td colspan="3">
                        <!--<input type="text" class="text-primary form-control" readonly="readonly" id="txt_nombre_tutor" name="txt_nombre_tutor" maxlength="250">-->
                        <select name="cmb_tutor" id="cmb_tutor" class="form-control"></select>
                    </td>
                </tr>

            </table>
        </fieldset><br><br>
        <fieldset class="legendas2"><legend class="legendas opcion_iluminada">Aceptación y Legalización</legend>
            <table class="table table-hover table-responsive">
                <tr>
                    <td><label>Apellidos y Nombres <br>del Representante Legal: </label></td>
                    <td>
                        <input type="text" readonly="readonly" class="text-primary form-control" id="txt_nombre_repr_legal" name="txt_nombre_repr_legal" maxlength="250">
                    </td>
                    <td><label>Cargo: </label></td>
                    <td>
                        <input type="text" readonly="readonly" class="text-primary form-control" id="txt_cargo_repr_legal" name="txt_cargo_repr_legal" maxlength="150">
                    </td>
                    <td><label>Teléfono: </label></td>
                    <td>
                        <input type="text" readonly="readonly" class="text-primary form-control" id="txt_fono_repr_legal" name="txt_fono_repr_legal" maxlength="15">
                    </td>
                </tr>
                <tr>
                    <td><label>Apellidos y Nombres <br>Delegado UPS: </label></td>
                    <td>
                        <input type="text" class="text-primary form-control" readonly="readonly" id="txt_nombre_deleg_ups" name="txt_nombre_deleg_ups" maxlength="250">
                    </td>
                    <td><label>Cargo: </label></td>
                    <td>
                        <input type="text" class="text-primary form-control" readonly="readonly" id="txt_cargo_deleg_ups" name="txt_cargo_deleg_ups" maxlength="250">
                    </td>
                    <td><label>Teléfono: </label></td>
                    <td>
                        <input type="text" class="text-primary form-control" readonly="readonly" id="txt_fono_deleg_ups" name="txt_fono_deleg_ups" maxlength="15">
                    </td>
                </tr>
                <tr>
                    <td><label>Lugar y Fecha <br>de Suscripción: </label></td>
                    <td colspan="5">
                        <input type="hidden" id="txt_ciudad" name="txt_ciudad" ng-value="{{sede}}"/>
                        <input type="text" class="text-primary form-control" 
                               readonly="readonly" id="txt_lugar_fecha_suscrip" 
                               name="txt_lugar_fecha_suscrip" maxlength="500"
                               ng-value="sede">
                    </td>
                </tr>
                <br>
                <tr>
                    <td colspan="5">
                        <input type="hidden" value="<%=ruta%>" id="ruta_principal" name="ruta_principal" />
                    </td>
                </tr>
            </table>
        </fieldset>
        <br>
        <br>
        <div class="form-group center-block text-center">
            <button ng-click="guarda_carta_comp()" type="button" class="btn btn-success" ><span class="glyphicon glyphicon-saved"></span> Grabar</button>
        </div>
        </div>
        <div id="llenaDato"></div>
    </form>               
</div>