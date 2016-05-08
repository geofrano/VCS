<%-- 
    Document   : consultar_carta_compromiso.jsp
    Created on : 09/01/2016, 09:14:29 PM
    Author     : Geovanny Barrera
--%>
<div id="frm_consulta" name="frm_consulta">
    <form id="frm_datos" name="frm_datos" action="" method="POST">
        <fieldset>
            <legend><h1 class="alineado3">Consultar Carta Compromiso</h1></legend>
            <br>
            <div class="list-group" id="div_datos"></div>
            <table class="table table-hover table-responsive">
                <tr>
                    <td><label>Nombre del Estudiante:</label></td>
                    <td>
                        <input type="text" class="text-primary form-control" id="txt_nombre_est" title="Nombre del estudiante" name="txt_nombre_est" maxlength="800">
                    </td>
                    <td><div id="div_consulta" name="div_consulta">
                            <img width="30px" height="30px" id="img_consulta" name="img_consulta" class="img-circle" title="Consultar" src="../../images/consultar.jpg" ng-click="consultar_estudiante()"/></div>
                        <div id="div_consulta2" name="div_consulta2" style="display:none">
                            <img width="30px" height="30px" id="img_cargando" name="img_cargando" title="Cargando..." src="../../images/cargando.svg" /></div>
                    </td>
                    <td>
                        <img width="30px" height="30px" class="img-circle" src="../../images/agregar.jpg" title="Agregar una Carta Compromiso" ng-click="carga_ingreso()"/>
                    </td>
                </tr>
            </table>
        </fieldset>
        <input type="hidden" id="existe_data" value="0"/>
        <div id="div_datos"></div>
        <table id="tbl_estudiante" class="table table-hover table-responsive">
            <tr>
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
<div id="div_consul" style="display:none">

</div>