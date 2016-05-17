<%-- 
    Document   : cont_cronograma
    Created on : 11/01/2016, 09:27:00 PM
    Author     : Geovanny Barrera
--%>
<br>
<form method="POST" id="frm_ficha" name="frm_ficha" target="_new">
<fieldset>
    <legend><h1 class="alineado3">CRONOGRAMA DE ACTIVIDADES</h1></legend>

    <fieldset class="legendas2"><legend class="legendas opcion_iluminada">CRONOGRAMA DE ACTIVIDADES</legend>
        <input type="hidden" name="txt_cod_act_1" id="txt_cod_act_1"/>
        <input type="hidden" name="txt_cod_act_2" id="txt_cod_act_2"/>
        <input type="hidden" name="txt_cod_act_3" id="txt_cod_act_3"/>
        <input type="hidden" name="txt_cod_act_4" id="txt_cod_act_4"/>
        <input type="hidden" name="txt_cod_act_5" id="txt_cod_act_5"/>
        <input type="hidden" name="txt_cod_act_6" id="txt_cod_act_6"/>
        <input type="hidden" name="txt_horas_actividad" id="txt_horas_actividad"/>
        <input type="hidden" name="txt_id_carta_comp" id="txt_id_carta_comp"/>
        <input type="hidden" name="contador" id="contador"/>
        
        <table class="table table-hover table-responsive table-bordered" >
            <tr>
                <td rowspan="2" align="center"><label>ACTIVIDADES</label></td>
                <td colspan="7" align="center"><label>SEMANAS</label></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td><label>1</label></td>
                <td><label>2</label></td>
                <td><label>3</label></td>
                <td><label>4</label></td>
                <td><label>5</label></td>
                <td><label>6</label></td>
                <td><label>7</label></td>
                <td><label>TOTAL</label></td>
                <td><label></label></td>
            </tr>
            <tr>
                <td><input type="text" class="form-control" readonly="readonly"  id="txt_actividad_1" name="txt_actividad_1"></td>
                <td><input type="checkbox" id="txt_semana_1_1" name="txt_semana_1_1" onclick="suma_act_parcial(1,1)"></td>
                <td><input type="checkbox" id="txt_semana_1_2" name="txt_semana_1_2" onclick="suma_act_parcial(1,2)"></td>
                <td><input type="checkbox" id="txt_semana_1_3" name="txt_semana_1_3" onclick="suma_act_parcial(1,3)"></td>
                <td><input type="checkbox" id="txt_semana_1_4" name="txt_semana_1_4" onclick="suma_act_parcial(1,4)"></td>
                <td><input type="checkbox" id="txt_semana_1_5" name="txt_semana_1_5" onclick="suma_act_parcial(1,5)"></td>
                <td><input type="checkbox" id="txt_semana_1_6" name="txt_semana_1_6" onclick="suma_act_parcial(1,6)"></td>
                <td><input type="checkbox" id="txt_semana_1_7" name="txt_semana_1_7" onclick="suma_act_parcial(1,7)"></td>
                <td><input type="text" class="form-control" readonly="readonly" id="txt_tot_actividad_1" name="txt_tot_actividad_1"></td>
                <td align="center"> h </td>
            </tr>
            <tr>
                <td><input type="text" class="form-control" readonly="readonly"  id="txt_actividad_2" name="txt_actividad_2"></td>
                <td><input type="checkbox" id="txt_semana_2_1" name="txt_semana_2_1" onclick="suma_act_parcial(2,1)"></td>
                <td><input type="checkbox" id="txt_semana_2_2" name="txt_semana_2_2" onclick="suma_act_parcial(2,2)"></td>
                <td><input type="checkbox" id="txt_semana_2_3" name="txt_semana_2_3" onclick="suma_act_parcial(2,3)"></td>
                <td><input type="checkbox" id="txt_semana_2_4" name="txt_semana_2_4" onclick="suma_act_parcial(2,4)"></td>
                <td><input type="checkbox" id="txt_semana_2_5" name="txt_semana_2_5" onclick="suma_act_parcial(2,5)"></td>
                <td><input type="checkbox" id="txt_semana_2_6" name="txt_semana_2_6" onclick="suma_act_parcial(2,6)"></td>
                <td><input type="checkbox" id="txt_semana_2_7" name="txt_semana_2_7" onclick="suma_act_parcial(2,7)"></td>
                <td><input type="text" class="form-control" readonly="readonly" id="txt_tot_actividad_2" name="txt_tot_actividad_2"></td>
                <td align="center"> h </td>
            </tr>
            <tr>
                <td><input type="text" class="form-control" readonly="readonly"  id="txt_actividad_3" name="txt_actividad_3"></td>
                <td><input type="checkbox" id="txt_semana_3_1" name="txt_semana_3_1" onclick="suma_act_parcial(3,1)"></td>
                <td><input type="checkbox" id="txt_semana_3_2" name="txt_semana_3_2" onclick="suma_act_parcial(3,2)"></td>
                <td><input type="checkbox" id="txt_semana_3_3" name="txt_semana_3_3" onclick="suma_act_parcial(3,3)"></td>
                <td><input type="checkbox" id="txt_semana_3_4" name="txt_semana_3_4" onclick="suma_act_parcial(3,4)"></td>
                <td><input type="checkbox" id="txt_semana_3_5" name="txt_semana_3_5" onclick="suma_act_parcial(3,5)"></td>
                <td><input type="checkbox" id="txt_semana_3_6" name="txt_semana_3_6" onclick="suma_act_parcial(3,6)"></td>
                <td><input type="checkbox" id="txt_semana_3_7" name="txt_semana_3_7" onclick="suma_act_parcial(3,7)"></td>
                <td><input type="text" class="form-control" readonly="readonly" id="txt_tot_actividad_3" name="txt_tot_actividad_3"></td>
                <td align="center"> h </td>
            </tr>
            <tr>
                <td><input type="text" class="form-control" readonly="readonly"  id="txt_actividad_4" name="txt_actividad_4"></td>
                <td><input type="checkbox" id="txt_semana_4_1" name="txt_semana_4_1" onclick="suma_act_parcial(4,1)"></td>
                <td><input type="checkbox" id="txt_semana_4_2" name="txt_semana_4_2" onclick="suma_act_parcial(4,2)"></td>
                <td><input type="checkbox" id="txt_semana_4_3" name="txt_semana_4_3" onclick="suma_act_parcial(4,3)"></td>
                <td><input type="checkbox" id="txt_semana_4_4" name="txt_semana_4_4" onclick="suma_act_parcial(4,4)"></td>
                <td><input type="checkbox" id="txt_semana_4_5" name="txt_semana_4_5" onclick="suma_act_parcial(4,5)"></td>
                <td><input type="checkbox" id="txt_semana_4_6" name="txt_semana_4_6" onclick="suma_act_parcial(4,6)"></td>
                <td><input type="checkbox" id="txt_semana_4_7" name="txt_semana_4_7" onclick="suma_act_parcial(4,7)"></td>
                <td><input type="text" class="form-control" readonly="readonly" id="txt_tot_actividad_4" name="txt_tot_actividad_4"></td>
                <td align="center"> h </td>
            </tr>
            <tr>
                <td><input type="text" class="form-control" readonly="readonly"  id="txt_actividad_5" name="txt_actividad_5"></td>
                <td><input type="checkbox" id="txt_semana_5_1" name="txt_semana_5_1" onclick="suma_act_parcial(5,1)"></td>
                <td><input type="checkbox" id="txt_semana_5_2" name="txt_semana_5_2" onclick="suma_act_parcial(5,2)"></td>
                <td><input type="checkbox" id="txt_semana_5_3" name="txt_semana_5_3" onclick="suma_act_parcial(5,3)"></td>
                <td><input type="checkbox" id="txt_semana_5_4" name="txt_semana_5_4" onclick="suma_act_parcial(5,4)"></td>
                <td><input type="checkbox" id="txt_semana_5_5" name="txt_semana_5_5" onclick="suma_act_parcial(5,5)"></td>
                <td><input type="checkbox" id="txt_semana_5_6" name="txt_semana_5_6" onclick="suma_act_parcial(5,6)"></td>
                <td><input type="checkbox" id="txt_semana_5_7" name="txt_semana_5_7" onclick="suma_act_parcial(5,7)"></td>
                <td><input type="text" class="form-control" readonly="readonly" id="txt_tot_actividad_5" name="txt_tot_actividad_5"></td>
                <td align="center"> h </td>
            </tr>
            <tr>
                <td><input type="text" class="form-control" readonly="readonly"  id="txt_actividad_6" name="txt_actividad_6"></td>
                <td><input type="checkbox" id="txt_semana_6_1" name="txt_semana_6_1" onclick="suma_act_parcial(6,1)"></td>
                <td><input type="checkbox" id="txt_semana_6_2" name="txt_semana_6_2" onclick="suma_act_parcial(6,2)"></td>
                <td><input type="checkbox" id="txt_semana_6_3" name="txt_semana_6_3" onclick="suma_act_parcial(6,3)"></td>
                <td><input type="checkbox" id="txt_semana_6_4" name="txt_semana_6_4" onclick="suma_act_parcial(6,4)"></td>
                <td><input type="checkbox" id="txt_semana_6_5" name="txt_semana_6_5" onclick="suma_act_parcial(6,5)"></td>
                <td><input type="checkbox" id="txt_semana_6_6" name="txt_semana_6_6" onclick="suma_act_parcial(6,6)"></td>
                <td><input type="checkbox" id="txt_semana_6_7" name="txt_semana_6_7" onclick="suma_act_parcial(6,7)"></td>
                <td><input type="text" class="form-control" readonly="readonly" id="txt_tot_actividad_6" name="txt_tot_actividad_6"></td>
                <td align="center"> h </td>
            </tr>
            <tr>
                <td colspan="7"></td>
                <td><label>TOTAL</label></td>
                <td><input type="text" class="form-control" readonly="readonly" id="txt_sum_total" name="txt_sum_total"></td>
                <td align="center">h</td>
            </tr>
        </table>
    </fieldset>
    
</fieldset>

<input type="hidden" value="I" id="accion_form" name="accion_form"/>
<br><br><center><button type="button" class="btn btn-primary" onclick="graba();"><span class="glyphicon glyphicon-ok"></span> Grabar</button>
</center>
</form>