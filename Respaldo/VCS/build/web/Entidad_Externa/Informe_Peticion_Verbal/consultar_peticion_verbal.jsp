<%-- 
    Document   : Consultar informe_peticion_verbal
    Created on : 09/01/2016, 09:14:29 PM
    Author     : Geovanny Barrera
--%>
<div id="frm_consulta" name="frm_consulta">
<form id="frm_datos" name="frm_datos" action="" method="POST">
<fieldset>
    <legend><h1 class="alineado3">Consultar Informe de Petición Verbal</h1></legend>
    <br>
    <div class="list-group" id="div_datos"></div>
    <table class="table table-hover table-responsive">
        <tr title="Si no ha ingresado la Carta Compromiso no podra generar el Informe de Petición Verbal">
            <td><label>Nombre del Estudiante:</label></td>
            <td>
                <input type="text" class="text-primary form-control" id="txt_nombre_est" title="Nombre del estudiante" name="txt_nombre_est" maxlength="800">
            </td>
            <td><div id="div_consulta" name="div_consulta">
                <img width="30px" height="30px" id="img_consulta" name="img_consulta" class="img-circle" title="Consultar" src="../../images/consultar.jpg" ng-click="consultar_estudiante()"/></div>
                <div id="div_consulta2" name="div_consulta2" style="display:none">
                <img width="30px" height="30px" id="img_cargando" name="img_cargando" title="Cargando..." src="../../images/cargando.svg" /></div>
            </td>
            <td></td>
        </tr>
    </table>
</fieldset>
<input type="hidden" id="existe_data" value="0"/>

<div id="div_datos"></div>
<table id="tbl_estudiante" class="table table-hover table-responsive">
    <tr title="Si no ha ingresado la Carta Compromiso no podra generar el Informe de Petición Verbal">
        <th>Id Carta Compromiso</th>
        <th>Tipo de Actividad</th>
        <th colspan="2">Nombre Estudiante</th>
        <th>Lugar Suscripción</th>
        <th>Fecha Suscripción</th>
        <th colspan="4"></th>

    </tr>

</table>
</form>
</div>
<div id="div_ingreso" style="display:none">
</div>
<form method="POST" action="" id="frm_ficha" name="frm_ficha">
    <input type="hidden" readonly="readonly" id="txt_id_carta_comp" name="txt_id_carta_comp"/>
    <input type="hidden" readonly="readonly" id="txt_institucion" name="txt_institucion" ng-value="institucion"/>
    <input type="hidden" readonly="readonly" id="txt_sede" name="txt_sede" ng-value="sede"/>
</form>