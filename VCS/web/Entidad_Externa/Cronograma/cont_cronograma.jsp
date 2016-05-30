<%-- 
    Document   : cont_cronograma
    Created on : 11/01/2016, 09:27:00 PM
    Author     : Geovanny Barrera
--%>
<br>
<form method="POST" id="frm_ficha" name="frm_ficha" target="_new">
<fieldset>
    <legend><h1 class="alineado3">CRONOGRAMA DE ACTIVIDADES</h1></legend>
    <div style='height:100%; width:110%; overflow:auto;'>
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
                <td rowspan="2" align="center"><br><label>ACTIVIDADES</label></td>
                <td colspan="15" align="center"><label>SEMANAS</label></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td align="center"><label>1</label></td>
                <td align="center"><label>2</label></td>
                <td align="center"><label>3</label></td>
                <td align="center"><label>4</label></td>
                <td align="center"><label>5</label></td>
                <td align="center"><label>6</label></td>
                <td align="center"><label>7</label></td>
                <td align="center"><label>8</label></td>
                <td align="center"><label>9</label></td>
                <td align="center"><label>10</label></td>
                <td align="center"><label>11</label></td>
                <td align="center"><label>12</label></td>
                <td align="center"><label>13</label></td>
                <td align="center"><label>14</label></td>
                <td align="center"><label>15</label></td>
                <td align="center"><label>TOTAL</label></td>
                <td><label></label></td>
            </tr>
            <tr>
                <td><input type="text" class="form-control" readonly="readonly"  id="txt_actividad_1" name="txt_actividad_1"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_1_1" name="txt_semana_1_1" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(1,1,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)" ></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_1_2" name="txt_semana_1_2" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(1,2,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_1_3" name="txt_semana_1_3" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(1,3,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_1_4" name="txt_semana_1_4" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(1,4,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_1_5" name="txt_semana_1_5" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(1,5,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_1_6" name="txt_semana_1_6" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(1,6,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_1_7" name="txt_semana_1_7" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(1,7,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_1_8" name="txt_semana_1_8" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(1,8,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_1_9" name="txt_semana_1_9" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(1,9,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_1_10" name="txt_semana_1_10" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(1,10,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_1_11" name="txt_semana_1_11" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(1,11,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_1_12" name="txt_semana_1_12" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(1,12,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_1_13" name="txt_semana_1_13" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(1,13,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_1_14" name="txt_semana_1_14" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(1,14,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_1_15" name="txt_semana_1_15" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(1,15,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="form-control alineado2" readonly="readonly" id="txt_tot_actividad_1" name="txt_tot_actividad_1" value="0"></td>
                <td align="center"> h </td>
            </tr>
            <tr>
                <td><input type="text" class="form-control" readonly="readonly"  id="txt_actividad_2" name="txt_actividad_2"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_2_1" name="txt_semana_2_1" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(2,1,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_2_2" name="txt_semana_2_2" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(2,2,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_2_3" name="txt_semana_2_3" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(2,3,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_2_4" name="txt_semana_2_4" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(2,4,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_2_5" name="txt_semana_2_5" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(2,5,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_2_6" name="txt_semana_2_6" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(2,6,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_2_7" name="txt_semana_2_7" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(2,7,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_2_8" name="txt_semana_2_8" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(2,8,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_2_9" name="txt_semana_2_9" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(2,9,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_2_10" name="txt_semana_2_10" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(2,10,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_2_11" name="txt_semana_2_11" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(2,11,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_2_12" name="txt_semana_2_12" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(2,12,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_2_13" name="txt_semana_2_13" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(2,13,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_2_14" name="txt_semana_2_14" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(2,14,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_2_15" name="txt_semana_2_15" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(2,15,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="form-control alineado2" readonly="readonly" id="txt_tot_actividad_2" name="txt_tot_actividad_2" value="0"></td>
                <td align="center"> h </td>
            </tr>
            <tr>
                <td><input type="text" class="form-control" readonly="readonly"  id="txt_actividad_3" name="txt_actividad_3"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_3_1" name="txt_semana_3_1" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(3,1,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_3_2" name="txt_semana_3_2" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(3,2,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_3_3" name="txt_semana_3_3" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(3,3,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_3_4" name="txt_semana_3_4" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(3,4,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_3_5" name="txt_semana_3_5" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(3,5,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_3_6" name="txt_semana_3_6" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(3,6,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_3_7" name="txt_semana_3_7" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(3,7,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_3_8" name="txt_semana_3_8" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(3,8,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_3_9" name="txt_semana_3_9" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(3,9,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_3_10" name="txt_semana_3_10" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(3,10,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_3_11" name="txt_semana_3_11" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(3,11,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_3_12" name="txt_semana_3_12" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(3,12,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_3_13" name="txt_semana_3_13" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(3,13,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_3_14" name="txt_semana_3_14" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(3,14,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_3_15" name="txt_semana_3_15" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(3,15,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="form-control alineado2" readonly="readonly" id="txt_tot_actividad_3" name="txt_tot_actividad_3" value="0"></td>
                <td align="center"> h </td>
            </tr>
            <tr>
                <td><input type="text" class="form-control" readonly="readonly"  id="txt_actividad_4" name="txt_actividad_4"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_4_1" name="txt_semana_4_1" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(4,1,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_4_2" name="txt_semana_4_2" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(4,2,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_4_3" name="txt_semana_4_3" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(4,3,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_4_4" name="txt_semana_4_4" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(4,4,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_4_5" name="txt_semana_4_5" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(4,5,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_4_6" name="txt_semana_4_6" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(4,6,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_4_7" name="txt_semana_4_7" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(4,7,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_4_8" name="txt_semana_4_8" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(4,8,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_4_9" name="txt_semana_4_9" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(4,9,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_4_10" name="txt_semana_4_10" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(4,10,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_4_11" name="txt_semana_4_11" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(4,11,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_4_12" name="txt_semana_4_12" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(4,12,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_4_13" name="txt_semana_4_13" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(4,13,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_4_14" name="txt_semana_4_14" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(4,14,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_4_15" name="txt_semana_4_15" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(4,15,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="form-control alineado2" readonly="readonly" id="txt_tot_actividad_4" name="txt_tot_actividad_4" value="0"></td>
                <td align="center"> h </td>
            </tr>
            <tr>
                <td><input type="text" class="form-control" readonly="readonly"  id="txt_actividad_5" name="txt_actividad_5"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_5_1" name="txt_semana_5_1" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(5,1,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_5_2" name="txt_semana_5_2" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(5,2,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_5_3" name="txt_semana_5_3" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(5,3,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_5_4" name="txt_semana_5_4" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(5,4,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_5_5" name="txt_semana_5_5" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(5,5,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_5_6" name="txt_semana_5_6" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(5,6,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_5_7" name="txt_semana_5_7" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(5,7,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_5_8" name="txt_semana_5_8" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(5,8,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_5_9" name="txt_semana_5_9" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(5,9,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_5_10" name="txt_semana_5_10" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(5,10,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_5_11" name="txt_semana_5_11" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(5,11,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_5_12" name="txt_semana_5_12" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(5,12,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_5_13" name="txt_semana_5_13" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(5,13,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_5_14" name="txt_semana_5_14" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(5,14,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_5_15" name="txt_semana_5_15" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(5,15,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="form-control alineado2" readonly="readonly" id="txt_tot_actividad_5" value="0" name="txt_tot_actividad_5"></td>
                <td align="center"> h </td>
            </tr>
            <tr>
                <td><input type="text" class="form-control" readonly="readonly"  id="txt_actividad_6" name="txt_actividad_6"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_6_1" name="txt_semana_6_1" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(6,1,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_6_2" name="txt_semana_6_2" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(6,2,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_6_3" name="txt_semana_6_3" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(6,3,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_6_4" name="txt_semana_6_4" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(6,4,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_6_5" name="txt_semana_6_5" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(6,5,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_6_6" name="txt_semana_6_6" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(6,6,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_6_7" name="txt_semana_6_7" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(6,7,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_6_8" name="txt_semana_6_8" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(6,8,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_6_9" name="txt_semana_6_9" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(6,9,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_6_10" name="txt_semana_6_10" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(6,10,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_6_11" name="txt_semana_6_11" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(6,11,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_6_12" name="txt_semana_6_12" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(6,12,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_6_13" name="txt_semana_6_13" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(6,13,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_6_14" name="txt_semana_6_14" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(6,14,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="text-primary form-control" id="txt_semana_6_15" name="txt_semana_6_15" value="0" onkeypress="return controltag(event)" onkeyup="suma_act_parcial(6,15,event);suma_tot_gral()" maxlength="3" style="padding:0" onClick="this.setSelectionRange(0, this.value.length)"></td>
                <td><input type="text" class="form-control alineado2" readonly="readonly" id="txt_tot_actividad_6" name="txt_tot_actividad_6" value="0"></td>
                <td align="center"> h </td>
            </tr>

            <tr>
                <td colspan="14"></td>
                <td colspan="2"><label>TOTAL</label></td>
                <td><input type="text" class="form-control alineado2" readonly="readonly" id="txt_sum_total" name="txt_sum_total"></td>
                <td align="center">h</td>
            </tr>
        </table>
        
        <br>
    </fieldset>
    </div>
</fieldset>

<input type="hidden" value="I" id="accion_form" name="accion_form"/>
<br><br><center><button type="button" class="btn btn-primary" onclick="graba();"><span class="glyphicon glyphicon-ok"></span> Grabar</button>
</center>
</form>