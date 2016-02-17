<%-- 
    Document   : principal
    Created on : 09/01/2016, 09:14:29 PM
    Author     : Geovanny Barrera
--%>
<fieldset>
    <legend><h1 class="alineado3">Criterios de búsqueda</h1></legend>
    <br>
    <table class="table table-hover table-responsive">
        <tr>
            <td><label>Nombre del Estudiante:</label></td>
            <td>
                <input type="text" class="text-primary form-control" id="txt_nombre_est" name="txt_nombre_est" maxlength="500">
            </td>
            <td>
                <img width="30px" height="30px" class="img-circle" src="../../images/consultar.jpg" ng-click="consultar_estudiante()"/>
            </td>
            <td>
                <img width="30px" height="30px" class="img-circle" src="../../images/agregar.jpg" ng-click="carga_ingreso()"/>
            </td>
        </tr>
    </table>
    <br>
    <div class="list-group" id="div_datos"></div>
</fieldset>

<div id="div_datos"></div>