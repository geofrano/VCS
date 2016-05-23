<%-- 
    Document   : Consultar Oficio Informe del Tutor
    Created on : 09/01/2016, 09:14:29 PM
    Author     : Geovanny Barrera
--%>
<div id="frm_consulta" name="frm_consulta">
<form id="frm_datos" name="frm_datos" action="" method="POST">
<fieldset>
    <legend><h1 class="alineado3">Consultar Empresas</h1></legend>
    <br>
    <div class="list-group" id="div_datos"></div>
    <table class="table table-hover table-responsive">
        <tr title="Ingrese el nombre de la empresa o institucion">
            <td><label>Nombre de la institucion:</label></td>
            <td>
                <input type="text" class="text-primary form-control" id="txt_nombre_emp" title="Nombre de la empresa" name="txt_nombre_emp" maxlength="800">
            </td>
            <td><div id="div_consulta" name="div_consulta">
                <img width="30px" height="30px" id="img_consulta" name="img_consulta" class="img-circle" title="Consultar" src="../../images/consultar.jpg" ng-click="consultar_empresa()"/></div>
                <div id="div_consulta2" name="div_consulta2" style="display:none">
                <img width="30px" height="30px" id="img_cargando" name="img_cargando" title="Cargando..." src="../../images/cargando.svg" /></div>
            </td>
            <td></td>
        </tr>
    </table>
    <input type="hidden" id="existe_empresa" name="existe_empresa" value="0"/>
</fieldset>
<input type="hidden" id="existe_data" value="0"/>

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
</form>
</div>
<div id="div_imprime" class="form-group center-block text-center" style="display:none">
    <button onclick="imprime_excel()" type="button" class="btn btn-success" ><span class="glyphicon glyphicon-saved"></span> Imprimir</button>
</div>
<div id="div_ingreso" style="display:none">
</div>
<form method="POST" action="" id="frm_ficha" name="frm_ficha">
    <input type="hidden" readonly="readonly" id="txt_id_carta_comp" name="txt_id_carta_comp"/>
    <input type="hidden" readonly="readonly" id="txt_institucion" name="txt_institucion" ng-value="institucion"/>
    <input type="hidden" readonly="readonly" id="txt_sede" name="txt_sede" ng-value="sede"/>
</form>