<%-- 
    Document   : cont_carta_compromiso
    Created on : 11/01/2016, 09:32:43 PM
    Author     : Geovanny Barrera
--%>
<% String ruta = request.getContextPath();%>
<h1 class="alineado3">Carta Compromiso Interinstitucional</h1>
<div class="form-group">
    <form id="frm_carta_comp" name="frm_carta_comp" action="" method="POST">
        <fieldset><legend style="color:#DF0101;font-size: 100%;font-weight: bold;">Información General</legend>
            <table class="table table-hover table-responsive">
                <tr>
                    <td><label>Código: </label></td>
                    <td>
                        <input type="text" class="text-primary form-control" id="txt_codigo" name="txt_codigo" maxlength="50">
                    </td>
                    <td><label>No: </label></td>
                    <td>
                        <input type="text" class="text-primary form-control disabled" id="txt_numero" name="txt_numero" maxlength="50">
                    </td>
                </tr>
                <tr>
                    <td><label>Nombre de la Empresa o Institución: </label></td>
                    <td colspan="3">
                        <input type="text" class="text-primary form-control" id="txt_nombre_empresa" name="txt_nombre_empresa" maxlength="250" >
                    </td>
                </tr>
                <tr>
                    <td><label>Dirección: </label></td>
                    <td>
                        <input type="text" class="text-primary form-control" id="txt_direccion" name="txt_direccion" maxlength="500">
                    </td>
                    <td><label>Teléfono: </label></td>
                    <td>
                        <input type="text" class="text-primary form-control" id="txt_telefono" name="txt_telefono" maxlength="10">
                    </td>
                </tr>
                <tr>
                    <td><label>Actividad Principal de la Empresa o Institución: </label></td>
                    <td colspan="3">
                        <input type="text" class="text-primary form-control" id="txt_actividad_empresa" name="txt_actividad_empresa" maxlength="250">
                    </td>
                </tr>
                <tr>
                    <td><label>Apellidos y Nombres del Estudiante: </label></td>
                    <td colspan="3">
                        <input type="text" class="text-primary form-control" id="txt_nombre_estudiante" name="txt_nombre_estudiante" maxlength="250">
                    </td>
                </tr>
                <tr>
                    <td><label>Carrera de Grado: </label></td>
                    <td>
                        <span id="div_carrera" name="div_carrera" ng-open="carga_combo_carrera()"></span>
                    </td>
                    <td><label>Ciclo o Semestre que cursa: </label></td>
                    <td>
                        <span id="div_ciclos" name="div_ciclos" ng-open="carga_combo_ciclo()"></span>
                    </td>
                </tr>
            </table>
        </fieldset>
        <fieldset><legend style="color:#DF0101;font-size: 100%;font-weight: bold;">Descripción Estratégica de Intervención</legend>
            <table class="table table-hover table-responsive">
                <tr>
                    <td>
                        <label>Tipo de Actividad Académica: </label>
                    </td>
                    <td>
                        <span id="div_tipo_actividad" name="div_tipo_actividad" ng-open="carga_combo_tipo_actividad()"></span>
                    </td>
                    <td><label>Duración: </label></td>
                    <td>
                        <span id="div_horas" name="div_horas" ng-open="carga_combo_horas()"></span>
                    </td>
                </tr>
                <tr>
                    <td><label>Objetivo de la Actividad Académica: </label></td>
                    <td>
                        <textarea class="text-primary form-control" id="txt_obj_act_academica" name="txt_obj_act_academica" maxlength="100"></textarea>
                    </td>
                    <td colspan="2">
                        <table>
                            <tr>
                                <td>
                                    <label>Fecha Inicio: </label>
                                </td>
                                <td>
                                    <input type="text" class="text-primary form-control" id="txt_fecha_inicio" name="txt_fecha_inicio" maxlength="100">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Fecha Final: </label>
                                </td>
                                <td>
                                    <input type="text" class="text-primary form-control" id="txt_fecha_fin" name="txt_fecha_fin" maxlength="100">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Horario Previsto: </label>
                                </td>
                                <td class="text-center">
                                    <input type="text" class="text-primary form-control" id="txt_horario" name="txt_horario" maxlength="100">
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td><label>Nombre Programa: </label></td>
                    <td colspan="3">
                        <span id="div_programas" name="div_carrera" ng-open="carga_combo_programas()"></span>
                    </td>
                </tr>
                <tr>
                    <td><label>Área que Requiere la Actividad Académica: </label></td>
                    <td>
                        <input type="text" class="text-primary form-control" id="txt_area_academica" name="txt_area_academica" maxlength="50">
                    </td>
                    <td><label>Responsable del Área: </label></td>
                    <td>
                        <input type="text" class="text-primary form-control" id="txt_respon_area" name="txt_respon_area">
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
                        <input type="text" class="text-primary form-control" id="txt_nombre_tutor" name="txt_nombre_tutor" maxlength="250">
                    </td>
                </tr>

            </table>
        </fieldset>
        <fieldset><legend style="color:#DF0101;font-size: 100%;font-weight: bold;">Aceptación y Legalización</legend>
            <table class="table table-hover table-responsive">
                <tr>
                    <td><label>Apellidos y Nombres <br>del Representante Legal: </label></td>
                    <td>
                        <input type="text" class="text-primary form-control" id="txt_nombre_repr_legal" name="txt_nombre_repr_legal" maxlength="250">
                    </td>
                    <td><label>Cargo: </label></td>
                    <td>
                        <input type="text" class="text-primary form-control" id="txt_cargo_repr_legal" name="txt_cargo_repr_legal" maxlength="150">
                    </td>
                    <td><label>Teléfono: </label></td>
                    <td>
                        <input type="text" class="text-primary form-control" id="txt_fono_repr_legal" name="txt_fono_repr_legal" maxlength="15">
                    </td>
                </tr>
                <tr>
                    <td><label>Apellidos y Nombres <br>Delegado UPS: </label></td>
                    <td>
                        <input type="text" class="text-primary form-control" id="txt_nombre_deleg_ups" name="txt_nombre_deleg_ups" maxlength="250">
                    </td>
                    <td><label>Cargo: </label></td>
                    <td>
                        <input type="text" class="text-primary form-control" id="txt_cargo_deleg_ups" name="txt_cargo_deleg_ups" maxlength="250">
                    </td>
                    <td><label>Teléfono: </label></td>
                    <td>
                        <input type="text" class="text-primary form-control" id="txt_fono_deleg_ups" name="txt_fono_deleg_ups" maxlength="15">
                    </td>
                </tr>
                <tr>
                    <td><label>Lugar y Fecha <br>de Suscripción: </label></td>
                    <td colspan="5">
                        <input type="text" class="text-primary form-control" id="txt_lugar_fecha_suscrip" name="txt_lugar_fecha_suscrip" maxlength="250">
                    </td>
                </tr>
                <br>
                <tr>
                    <td colspan="4">
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
    </form>               
</div>