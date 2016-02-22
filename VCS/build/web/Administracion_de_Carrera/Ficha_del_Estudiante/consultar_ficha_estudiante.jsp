<%-- 
    Document   : principal
    Created on : 09/01/2016, 09:14:29 PM
    Author     : Geovanny Barrera
--%>
<div id="frm_consulta" name="frm_consulta">
<form id="frm_datos" name="frm_datos" action="" method="POST">
<fieldset>
    <legend><h1 class="alineado3">Consultar Ficha del Estudiante</h1></legend>
    <br>
    <div class="list-group" id="div_datos"></div>
    <table class="table table-hover table-responsive">
        <tr>
            <td><label>Nombre del Estudiante:</label></td>
            <td>
                <input type="text" class="text-primary form-control" id="txt_nombre_est" name="txt_nombre_est" maxlength="800">
            </td>
            <td>
                <img width="30px" height="30px" class="img-circle" src="../../images/consultar.jpg" ng-click="consultar_estudiante()"/>
            </td>
            <td>
                <img width="30px" height="30px" class="img-circle" src="../../images/agregar.jpg" ng-click="carga_ingreso()"/>
            </td>
        </tr>
    </table>
</fieldset>
<input type="hidden" id="existe_data" value="0"/>

<div id="div_datos"></div>
<table id="tbl_estudiante" class="table table-hover table-responsive">
    <tr>
        <th>Id Carta Compromiso</th>
        <th>Nombre Estudiante</th>
        <th>Lugar Suscripción</th>
        <th>Fecha Suscripción</th>
    </tr>

</table>
</form>
</div>
<div id="div_ingreso" style="display:none">

</div>
