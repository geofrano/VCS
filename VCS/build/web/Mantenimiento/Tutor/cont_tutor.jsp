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
                </tr>
            </table>
        </fieldset>
        <input type="hidden" id="existe_data" value="0"/>
        <div id="div_datos"></div>
        <table id="tbl_tutor" class="table table-hover table-responsive">
            <tr>
                <th>Id Parametro</th>
                <th>Descripción</th>
                <th>Valor</th>
                <th>Tipo</th>
                <th></th>
            </tr>

        </table>
    </form>
</div>
<div id="div_consul" style="display:none">

</div>