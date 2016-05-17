/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var app = angular.module("VCS", []);
app.controller("ControladorVCS", function($scope, $http) {
    $scope.institucion = "Universidad Politecnica Salesiana";
    $scope.sede = "Guayaquil";
    $scope.submitted = false;
    $scope.muestra_carrera = false;
    
    $scope.consultar_empresa = function () {
        var empresa = document.getElementById("txt_nombre_emp").value;
        var ruta = document.getElementById("ruta_principal").value;
        var cont = 0;
        
        var $tabla = $("#tbl_empresa");
        $tabla.find("tr:gt(0)").remove();
        document.getElementById("existe_empresa").value = "0";
        $("#div_consulta").css("display", "none");
        $("#div_consulta2").css("display", "block");
        
        $.ajax({
            type: 'POST',
            dataType: 'json',
            data: {empresa: empresa},
            url: ruta + '/F_Consulta_Empresa',
            success: function (data) {
                $.each(data.items, function (index, article) {
                    cont = cont + 1;
                    $tabla.append("<tr>\n" +
                            "<td>" + article.nombre_empresa + "\n" +
                            "<input type=\"hidden\" name=\"ue_id_" + cont + "\" id=\"ue_id_" + cont + "\" value=\"" + article.ue_id + "\">\n" +
                            "<input type=\"hidden\" name=\"ar_id_" + cont + "\" id=\"ar_id_" + cont + "\" value=\"" + article.ar_id + "\">\n" +
                            "<input type=\"hidden\" name=\"nombre_empresa_" + cont + "\" id=\"nombre_empresa_" + cont + "\" value=\"" + article.nombre_empresa + "\"></td>\n" +
                            "<td>" + article.direccion + "\n" +
                            "<input type=\"hidden\" name=\"direccion_" + cont + "\" id=\"direccion_" + cont + "\" value=\"" + article.direccion + "\"></td>\n" +
                            "<td>" + article.telefono + "\n" +
                            "<input type=\"hidden\" name=\"telefono_" + cont + "\" id=\"telefono_" + cont + "\" value=\"" + article.telefono + "\"></td>\n" +
                            "<td>" + article.actividad + "\n" +
                            "<input type=\"hidden\" name=\"actividad_" + cont + "\" id=\"actividad_" + cont + "\" value=\"" + article.actividad + "\"></td>\n" +
                            "<td colspan=\"2\">" + article.nombre + " " + article.apellido + "\n" +
                            "<input type=\"hidden\" name=\"representante_" + cont + "\" id=\"representante_" + cont + "\" value=\"" + article.nombre + " " + article.apellido + "\"></td>\n" +
                            "<td>" + article.cargo + "\n" +
                            "<input type=\"hidden\" name=\"cargo_" + cont + "\" id=\"cargo_" + cont + "\" value=\"" + article.cargo + "\"></td>\n" +
                            "<td><input type=\"hidden\" name=\"tele_repre_" + cont + "\" id=\"tele_repre_" + cont + "\" value=\"" + article.tele_repre + "\"></td>\n" +
                            //"<td><div name=\"div_inserta_" + cont + "\" id=\"div_inserta_" + cont + "\"><input type = \"radio\" name = \"grupo\" id = \"grupo\" value = \"" + cont + "\" onclick=\"habilita_btn()\"></div></td>\n" +
                            //"<td><div name=\"div_modificar_" + cont + "\" id=\"div_modificar_" + cont + "\"><img width=\"30px\" height=\"30px\" src=\"../../images/modificar.png\" title=\"Modificar\" onclick=\"carga_datos_empresa(" + cont + ",'M')\"/></div></td> \n" +
                            "</tr>\n");
                    document.getElementById("existe_empresa").value = "1";
                    //$("#btn_aceptar_emp").removeAttr('disabled');
                });
                var v = document.getElementById("existe_empresa").value;

                if (v == "0") {
                    $("#btn_aceptar_emp").attr('disabled','disabled');
                    $tabla.append("<tr><td colspan=\"9\" align=\"center\">No hay datos a mostrar</td></tr>");
                    $("#div_imprime").css("display", "none");
                }else{
                    $("#div_imprime").css("display", "block");
                }
                $("#div_consulta").css("display", "block");
                $("#div_consulta2").css("display", "none");
            }
        });
    };
    $scope.consultar_empresa_listado = function() {
        var empresa = document.getElementById("txt_nombre_emp").value;
        var ruta = document.getElementById("ruta_principal").value;
        var cont = 0;
        var $tabla = $("#tbl_estudiante");
        $tabla.find("tr:gt(0)").remove();
        document.getElementById("existe_data").value = "0";
        $("#div_consulta").css("display", "none");
        $("#div_consulta2").css("display", "block");
        $.ajax({
            type: 'POST',
            dataType: 'json',
            data: {id_est: empresa},
            //data: {id_cmb:'carrera'},
            //data: $('#formid').serialize(),
            url: ruta + '/F_Consulta_Estudiante',
            success: function(data) {
                $("#div_datos").html("");

                $.each(data.items, function(index, article) {
                    cont = cont + 1;
                    $tabla.append("<tr title=\"Si no ha ingresado la ficha del estudiante no podra generar el Informe Final\"><td><input type=\"hidden\" name=\"cc_id_" + cont + "\" id=\"cc_id_" + cont + "\" value=\"" + article.id_cc + "\" >" + article.id_cc + "</td>\n" +
                            "<td>" + article.cc_tipo_act + "</td>\n" +
                            "<td colspan=\"2\">" + article.nomb_est + "</td>\n" +
                            //"<td>" + article.emp_nombre + "</td>\n" +
                            "<td>" + article.lugar_suscrip + "</td>\n" +
                            "<td>" + article.fecha_suscrip + "</td>\n" +
                            "<td class=\"alineado3\">" +
                            "<div style=\"display:none\" name=\"div_imprimir_" + cont + "\" id=\"div_imprimir_" + cont + "\"><img width=\"30px\" height=\"30px\" src=\"../../images/imprimir.png\" title=\"Generar\" onclick=\"imprime(" + cont + ")\"/></div>" +
                            "</td>\n" +
                            "</tr>\n");

                    if (article.cc_estado >= 5) {//Solo si esta en estado 5 (ya se genero la ficha del estudiante)
                        $("#" + "div_imprimir_" + cont).css("display", "block");
                    }
                    document.getElementById("existe_data").value = "1";
                });
                var v = document.getElementById("existe_data").value;

                if (v == "0") {
                    $tabla.append("<tr><td colspan=\"8\" align=\"center\">No hay datos a mostrar</td></tr>");
                }
                $("#div_consulta").css("display", "block");
                $("#div_consulta2").css("display", "none");
            }
        });

    };

    $scope.carga2 = function() {
        var ruta = document.getElementById("ruta_principal").value;
        //var fullname = $('#fullname').val();
        $.ajax({
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            //data: {id_cmb:'carrera'},
            //data: $('#formid').serialize(),
            url: ruta + '/F_Menu_principal.jsp',
            success: function(data) {
                $("#ajaxResponse").html("");
                $.each(data.items, function(index, article) {
                    $("#ajaxResponse").append("");
                    if (article.id_modulo_padre == "1") {
                        $("#ajaxResponse").append("<a class=\"list-group-item active\" href=\"" + article.pagina_modulo + "\">" + article.nombre_modulo + "</a>");
                    } else {
                        $("#ajaxResponse").append("<a class=\"list-group-item\" href=\"" + article.pagina_modulo + "\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + article.nombre_modulo + "</a>\n");
                    }
                });
            }
        });
    };
    $scope.carga_autocomplete_est = function() {
        var ruta = document.getElementById("ruta_principal").value;
        //var fullname = $('#fullname').val();
        $.ajax({
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            //data: {id_cmb:'carrera'},
            //data: $('#formid').serialize(),
            url: ruta + '/F_carga_estudiantes',
            success: function(data) {
                $("#ajaxIconos").html("");
                $.each(data.items, function(index, article) {
                    if (article.id_modulo_padre == id_modulo_padre) {

                        $("#ajaxIconos").append("<a  href=\"" + article.pagina_modulo + "\">" +
                                " <img width=\"150px\" height=\"150px\" class=\"img-circle\" src=\"" + article.icono_modulo + "\"/> " +
                                article.nombre_modulo + "</a>");

                    }
                });
            }
        });
    };
    $scope.carga_iconos = function() {
        var ruta = document.getElementById("ruta_principal").value;
        var id_modulo_padre = document.getElementById("id_modulo_padre").value;
        //var fullname = $('#fullname').val();
        $.ajax({
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            //data: {id_cmb:'carrera'},
            //data: $('#formid').serialize(),
            url: ruta + '/F_Menu_principal.jsp',
            success: function(data) {
                $("#ajaxIconos").html("");
                $.each(data.items, function(index, article) {
                    if (article.id_modulo_padre == id_modulo_padre) {

                        $("#ajaxIconos").append("<a  href=\"" + article.pagina_modulo + "\">" +
                                " <img width=\"150px\" height=\"150px\" class=\"img-circle\" src=\"" + article.icono_modulo + "\"/> " +
                                article.nombre_modulo + "</a>");
                    }
                });
            }
        });
    };

});
function imprime(cont) {
    var ruta = document.getElementById("ruta_principal").value;
    document.getElementById("frm_ficha").action = ruta + "/Reportes/Empresas/imprime_excel.jsp";
    document.frm_ficha.target = "_empresas";
    document.frm_ficha.submit();
}//FIN imprime

function imprime_excel() {
    var ruta = document.getElementById("ruta_principal").value;
    document.getElementById("frm_ficha").action = ruta + "/F_genera_excel_empresas";//"/Reportes/Empresas/imprime_excel.jsp";
    document.frm_ficha.target = "_empresas";
    document.frm_ficha.submit();
}//FIN imprime