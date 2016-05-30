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

    $scope.consultar_estudiante = function() {
        var estudiante = document.getElementById("txt_nombre_est").value;
        var ruta = document.getElementById("ruta_principal").value;
        var cont = 0;
        var $tabla = $("#tbl_estudiante");
        if (estudiante != ""){

            $tabla.find("tr:gt(0)").remove();
            document.getElementById("existe_data").value = "0";
            $("#div_consulta").css("display", "none");
            $("#div_consulta2").css("display", "block");
            $.ajax({
                type: 'POST',
                dataType: 'json',
                data: {id_est: estudiante},
                //data: {id_cmb:'carrera'},
                //data: $('#formid').serialize(),
                url: ruta + '/F_Consulta_Estudiante',
                success: function(data) {
                    $("#div_datos").html("");

                    $.each(data.items, function(index, article) {
                        cont = cont + 1;
                        $tabla.append("<tr title=\"Si no ha ingresado la ficha del estudiante no podra generar el Informe de Seguimiento\"><td><input type=\"hidden\" name=\"cc_id_" + cont + "\" id=\"cc_id_" + cont + "\" value=\"" + article.id_cc + "\" >" + article.id_cc + "</td>\n" +
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
        }else{
            alert("Favor ingrese el nombre del estudiante");
        }
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
    var id_cc = document.getElementById("cc_id_" + cont).value;
    document.getElementById("txt_id_carta_comp").value = id_cc;
    document.getElementById("frm_ficha").action = ruta + "/Administracion_de_Carrera/Informe_de_Seguimiento/imprime_informe_seguimiento.jsp";
    document.frm_ficha.target = "_new";
    document.frm_ficha.submit();
}//FIN imprime