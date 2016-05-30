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
                        $tabla.append("<tr><td><input type=\"hidden\" name=\"cc_id_" + cont + "\" id=\"cc_id_" + cont + "\" value=\"" + article.id_cc + "\">" + article.id_cc + "</td>\n" +
                                "<td>" + article.cc_tipo_act + "</td>\n" +
                                "<td colspan=\"2\">" + article.nomb_est + "</td>\n" +
                                //"<td>" + article.emp_nombre + "</td>\n" +
                                "<td>" + article.lugar_suscrip + "</td>\n" +
                                "<td>" + article.fecha_suscrip + "</td>\n" +
                                "<td><div style=\"display:none\" name=\"div_inserta_" + cont + "\" id=\"div_inserta_" + cont + "\"><input type = \"radio\" name = \"group1\" id = \"group1\" value = \"" + article.id_cc + "\" ></div>" +
                                "<div style=\"display:none\" name=\"div_imprimir_" + cont + "\" id=\"div_imprimir_" + cont + "\"><img width=\"30px\" height=\"30px\" src=\"../../images/imprimir.png\" title=\"Generar\" onclick=\"imprime(" + cont + ")\"/></div>" +
                                "</td>\n" +
                                "<td class=\"alineado3\">" +
                                "<div style=\"display:none\" name=\"div_modificar_" + cont + "\" id=\"div_modificar_" + cont + "\"><img width=\"30px\" height=\"30px\" src=\"../../images/modificar.png\" title=\"Modificar\" onclick=\"carga_ingreso(" + cont + ")\"/></div>" +
                                "</td>\n" +
                                "<td class=\"alineado3\">" +
                                "<div style=\"display:none\" name=\"div_eliminar_" + cont + "\" id=\"div_eliminar_" + cont + "\"><img width=\"20px\" height=\"10px\" src=\"../../images/eliminar.jpg\" title=\"Eliminar\" onclick=\"elimina(" + cont + ")\"/>" +
                                "</td></tr>\n");
                        var estado = parseInt(article.cc_estado);
                        if (estado >= 4) {//Solo si esta en estado 4 (ya se genero el doc)
                            $("#" + "div_imprimir_" + cont).css("display", "block");
                            $("#" + "div_eliminar_" + cont).css("display", "none");
                        }
                        if (article.cc_estado.trim() == "A") {
                            $("#" + "div_eliminar_" + cont).css("display", "none");
                            $("#" + "div_modificar_" + cont).css("display", "none");
                            $("#" + "div_inserta_" + cont).css("display", "block");
                        }
                        if (estado >= 0 && estado <=3) {
                            $("#" + "div_eliminar_" + cont).css("display", "none");
                            $("#" + "div_modificar_" + cont).css("display", "none");
                            $("#" + "div_inserta_" + cont).css("display", "block");
                        }
                        if (estado >= 4) {//ya fue ingresado
                            $("#" + "div_eliminar_" + cont).css("display", "none");
                            $("#" + "div_modificar_" + cont).css("display", "block");
                            $("#" + "div_inserta_" + cont).css("display", "none");
                        }
                        if (estado == 4){
                            $("#" + "div_modificar_" + cont).css("display", "block");
                            $("#" + "div_eliminar_" + cont).css("display", "block");
                            $("#" + "div_inserta_" + cont).css("display", "none");
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
        }else {
            alert("Ingrese el nombre del estudiante");
        }
    };

    $scope.carga_ingreso = function() {
        var estudiante = document.getElementById("txt_nombre_est").value;
        var ruta = document.getElementById("ruta_principal").value;
        var seleccionado = $("input[name='group1']:checked").val();
        if (seleccionado) {//Verifico que tenga seleccionado una Carta compromiso
            //document.getElementById("frm_datos").action = ruta + "/Administracion_de_Carrera/Ficha_del_Estudiante/ingresar_ficha_estudiante.jsp";
            //document.frm_datos.submit();
            $("#frm_consulta").css("display", "none");
            $("#div_ingreso").css("display", "block");
            //$scope.submitted = true;
            $.ajax({
                type: 'POST',
                //data: {id_cmb:'carrera'},
                //data: $('#formid').serialize(),
                url: ruta + '/Entidad_Externa/Cronograma/cont_cronograma.jsp',
                success: function(data) {
                    $("#div_ingreso").html("");
                    $("#div_ingreso").append(data);
                    $scope.carga_datos(seleccionado);
                }
            });
        } else {
            alert("No ha seleccionado una carta compromiso. Favor verifique");
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

    $scope.consulta_ficha_est = function() {

        $.ajax({
            type: 'POST',
            data: {id_cmb: 'tipo_actividad'},
            url: ruta + '/F_muestra_ficha_estudiante',
            success: function(result) {
                $('#div_tipo_actividad').html(result);
            }
        });
    };

    $scope.carga_datos = function(id_cart_comp) {
        var ruta = document.getElementById("ruta_principal").value;
        //document.getElementById("accion_form").value = "I";
        document.getElementById("txt_id_carta_comp").value=id_cart_comp;
        var id_cc = id_cart_comp;
        $.ajax({
            type: 'POST',
            dataType: 'json',
            data: {id_cc: id_cc, accion_form: 'I'},
            //data: {id_cmb:'carrera'},
            //data: $('#formid').serialize(),
            url: ruta + '/F_muestra_cronograma',
            success: function(data) {

                $.each(data.items, function(index, article) {
                    document.getElementById("txt_actividad_1").value = article.act_1;
                    document.getElementById("txt_actividad_2").value = article.act_2;
                    document.getElementById("txt_actividad_3").value = article.act_3;
                    document.getElementById("txt_actividad_4").value = article.act_4;
                    document.getElementById("txt_actividad_5").value = article.act_5;
                    document.getElementById("txt_actividad_6").value = article.act_6;
                    document.getElementById("txt_cod_act_1").value = article.cod_act_1;
                    document.getElementById("txt_cod_act_2").value = article.cod_act_2;
                    document.getElementById("txt_cod_act_3").value = article.cod_act_3;
                    document.getElementById("txt_cod_act_4").value = article.cod_act_4;
                    document.getElementById("txt_cod_act_5").value = article.cod_act_5;
                    document.getElementById("txt_cod_act_6").value = article.cod_act_6;
                    document.getElementById("txt_horas_actividad").value = article.num_horas;
                    
                    if (article.act_1.substring(2).replace(".", "").trim() == ""){//Si no tiene actividad lo bloqueo
                        document.getElementById("txt_semana_1_1").disabled="disabled";
                        document.getElementById("txt_semana_1_2").disabled="disabled";
                        document.getElementById("txt_semana_1_3").disabled="disabled";
                        document.getElementById("txt_semana_1_4").disabled="disabled";
                        document.getElementById("txt_semana_1_5").disabled="disabled";
                        document.getElementById("txt_semana_1_6").disabled="disabled";
                        document.getElementById("txt_semana_1_7").disabled="disabled";
                        document.getElementById("txt_semana_1_8").disabled="disabled";
                        document.getElementById("txt_semana_1_9").disabled="disabled";
                        document.getElementById("txt_semana_1_10").disabled="disabled";
                        document.getElementById("txt_semana_1_11").disabled="disabled";
                        document.getElementById("txt_semana_1_12").disabled="disabled";
                        document.getElementById("txt_semana_1_13").disabled="disabled";
                        document.getElementById("txt_semana_1_14").disabled="disabled";
                        document.getElementById("txt_semana_1_15").disabled="disabled";
                    }
                    if (article.act_2.substring(2).replace(".", "").trim() == ""){//Si no tiene actividad lo bloqueo
                        document.getElementById("txt_semana_2_1").disabled="disabled";
                        document.getElementById("txt_semana_2_2").disabled="disabled";
                        document.getElementById("txt_semana_2_3").disabled="disabled";
                        document.getElementById("txt_semana_2_4").disabled="disabled";
                        document.getElementById("txt_semana_2_5").disabled="disabled";
                        document.getElementById("txt_semana_2_6").disabled="disabled";
                        document.getElementById("txt_semana_2_7").disabled="disabled";
                        document.getElementById("txt_semana_2_8").disabled="disabled";
                        document.getElementById("txt_semana_2_9").disabled="disabled";
                        document.getElementById("txt_semana_2_10").disabled="disabled";
                        document.getElementById("txt_semana_2_11").disabled="disabled";
                        document.getElementById("txt_semana_2_12").disabled="disabled";
                        document.getElementById("txt_semana_2_13").disabled="disabled";
                        document.getElementById("txt_semana_2_14").disabled="disabled";
                        document.getElementById("txt_semana_2_15").disabled="disabled";

                    }
                    if (article.act_3.substring(2).replace(".", "").trim() == ""){//Si no tiene actividad lo bloqueo
                        document.getElementById("txt_semana_3_1").disabled="disabled";
                        document.getElementById("txt_semana_3_2").disabled="disabled";
                        document.getElementById("txt_semana_3_3").disabled="disabled";
                        document.getElementById("txt_semana_3_4").disabled="disabled";
                        document.getElementById("txt_semana_3_5").disabled="disabled";
                        document.getElementById("txt_semana_3_6").disabled="disabled";
                        document.getElementById("txt_semana_3_7").disabled="disabled";
                        document.getElementById("txt_semana_3_8").disabled="disabled";
                        document.getElementById("txt_semana_3_9").disabled="disabled";
                        document.getElementById("txt_semana_3_10").disabled="disabled";
                        document.getElementById("txt_semana_3_11").disabled="disabled";
                        document.getElementById("txt_semana_3_12").disabled="disabled";
                        document.getElementById("txt_semana_3_13").disabled="disabled";
                        document.getElementById("txt_semana_3_14").disabled="disabled";
                        document.getElementById("txt_semana_3_15").disabled="disabled";

                    }
                    if (article.act_4.substring(2).replace(".", "").trim() == ""){//Si no tiene actividad lo bloqueo
                        document.getElementById("txt_semana_4_1").disabled="disabled";
                        document.getElementById("txt_semana_4_2").disabled="disabled";
                        document.getElementById("txt_semana_4_3").disabled="disabled";
                        document.getElementById("txt_semana_4_4").disabled="disabled";
                        document.getElementById("txt_semana_4_5").disabled="disabled";
                        document.getElementById("txt_semana_4_6").disabled="disabled";
                        document.getElementById("txt_semana_4_7").disabled="disabled";
                        document.getElementById("txt_semana_4_8").disabled="disabled";
                        document.getElementById("txt_semana_4_9").disabled="disabled";
                        document.getElementById("txt_semana_4_10").disabled="disabled";
                        document.getElementById("txt_semana_4_11").disabled="disabled";
                        document.getElementById("txt_semana_4_12").disabled="disabled";
                        document.getElementById("txt_semana_4_13").disabled="disabled";
                        document.getElementById("txt_semana_4_14").disabled="disabled";
                        document.getElementById("txt_semana_4_15").disabled="disabled";
                    }
                    if (article.act_5.substring(2).replace(".", "").trim() == ""){//Si no tiene actividad lo bloqueo
                        document.getElementById("txt_semana_5_1").disabled="disabled";
                        document.getElementById("txt_semana_5_2").disabled="disabled";
                        document.getElementById("txt_semana_5_3").disabled="disabled";
                        document.getElementById("txt_semana_5_4").disabled="disabled";
                        document.getElementById("txt_semana_5_5").disabled="disabled";
                        document.getElementById("txt_semana_5_6").disabled="disabled";
                        document.getElementById("txt_semana_5_7").disabled="disabled";
                        document.getElementById("txt_semana_5_8").disabled="disabled";
                        document.getElementById("txt_semana_5_9").disabled="disabled";
                        document.getElementById("txt_semana_5_10").disabled="disabled";
                        document.getElementById("txt_semana_5_11").disabled="disabled";
                        document.getElementById("txt_semana_5_12").disabled="disabled";
                        document.getElementById("txt_semana_5_13").disabled="disabled";
                        document.getElementById("txt_semana_5_14").disabled="disabled";
                        document.getElementById("txt_semana_5_15").disabled="disabled";
                    }
                    if (article.act_6.substring(2).replace(".", "").trim() == ""){//Si no tiene actividad lo bloqueo
                        document.getElementById("txt_semana_6_1").disabled="disabled";
                        document.getElementById("txt_semana_6_2").disabled="disabled";
                        document.getElementById("txt_semana_6_3").disabled="disabled";
                        document.getElementById("txt_semana_6_4").disabled="disabled";
                        document.getElementById("txt_semana_6_5").disabled="disabled";
                        document.getElementById("txt_semana_6_6").disabled="disabled";
                        document.getElementById("txt_semana_6_7").disabled="disabled";
                        document.getElementById("txt_semana_6_8").disabled="disabled";
                        document.getElementById("txt_semana_6_9").disabled="disabled";
                        document.getElementById("txt_semana_6_10").disabled="disabled";
                        document.getElementById("txt_semana_6_11").disabled="disabled";
                        document.getElementById("txt_semana_6_12").disabled="disabled";
                        document.getElementById("txt_semana_6_13").disabled="disabled";
                        document.getElementById("txt_semana_6_14").disabled="disabled";
                        document.getElementById("txt_semana_6_15").disabled="disabled";
                    }
                    
                });
            }
        });
    };

});
function graba() {
    var ruta = document.getElementById("ruta_principal").value;
    var total_horas_act = document.getElementById("txt_horas_actividad").value;
    var total_horas = document.getElementById("txt_sum_total").value;
    
    if (parseInt(total_horas) != parseInt(total_horas_act)) {
        swal("Error!", "El número de horas a cumplir es incorrecto. Debe cumplir un total de "+total_horas_act+" horas. Favor verifique.", "info");
        document.getElementById("txt_direccion_est").focus();
    } else {
        swal({
            title: "Está segur@?",
            text: "Favor confirme que los datos ingresados son los correctos",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#337ab7",
            confirmButtonText: "Si,Guardar!",
            closeOnConfirm: false,
            showLoaderOnConfirm: true
        },
        function() {
            $.ajax({
                type: 'POST',
                //dataType: 'json',
                //data: {id_cc: id_cc},
                //data: {id_cmb:'carrera'},
                data: $('#frm_ficha').serialize(),
                url: ruta + '/F_graba_Cronograma',
                success: function(data) {
                    if (data.trim() == "SI") {
                        //swal("Exito!", "La ficha del estudiante ha sido ingresada", "success");
                        swal({
                            title: "Éxito!",
                            text: "El cronograma ha sido ingresado",
                            type: "success",
                            showCancelButton: false,
                            confirmButtonColor: "#337ab7",
                            confirmButtonText: "Ok",
                            closeOnConfirm: false
                        },
                        function() {
                            document.getElementById("frm_ficha").action = ruta + "/Entidad_Externa/Cronograma/imprime_cronograma.jsp";
                            //document.frm_ficha.target="_new";
                            //alert(document.getElementById("frm_ficha").action);
                            $("#frm_ficha").submit();
                            //location.reload();
                            //window.open(ruta + "/Administracion_de_Carrera/Ficha_del_Estudiante/ficha_estudiante.jsp", "_self");
                        });

                    } else {
                        swal("Error", "El cronograma no ha podido ser ingresado", "error");
                    }
                }
            });

        });

    }
}//FIN GRABA
function recarga() {
    location.reload();
}
function elimina(cont) {
    var id_cc = document.getElementById("cc_id_" + cont).value;
    var ruta = document.getElementById("ruta_principal").value;
    swal({
        title: "Está segur@?",
        text: "Realmente desea eliminar el cronograma de actividades",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#337ab7",
        confirmButtonText: "Eliminar",
        closeOnConfirm: false,
        showLoaderOnConfirm: true
    },
    function() {
        $.ajax({
            type: 'POST',
            data: {txt_id_carta_comp: id_cc, accion_form: 'E'},
            //data: {id_cmb:'carrera'},
            //data: $('#formid').serialize(),
            url: ruta + '/F_graba_Cronograma',
            success: function(data) {
                if (data.trim() == "SI") {
                    swal("Éxito", "El cronograma de actividades ha sido eliminado exitosamente", "success");
                    window.open(ruta + "/Entidad_Externa/Cronograma/Cronograma.jsp", "_self");
                } else {
                    swal("Error", "El cronograma de actividades no pudo ser eliminado", "error");
                }
            }
        });
    });

}
function carga_ingreso(cont) {
    var id_cc = document.getElementById("cc_id_" + cont).value;
    var ruta = document.getElementById("ruta_principal").value;
    //document.getElementById("frm_datos").action = ruta + "/Administracion_de_Carrera/Ficha_del_Estudiante/ingresar_ficha_estudiante.jsp";
    //document.frm_datos.submit();
    $("#frm_consulta").css("display", "none");
    $("#div_ingreso").css("display", "block");
    //$scope.submitted = true;
    $.ajax({
        type: 'POST',
        //data: {id_cmb:'carrera'},
        //data: $('#formid').serialize(),
        url: ruta + '/Entidad_Externa/Cronograma/cont_cronograma.jsp',
        success: function(data) {
            $("#div_ingreso").html("");
            $("#div_ingreso").append(data);
            document.getElementById("accion_form").value = "M";
            carga_datos(id_cc);
        }
    });
}
function carga_datos(id_cart_comp) {
    var ruta = document.getElementById("ruta_principal").value;
    
    var id_cc = id_cart_comp.trim();
    document.getElementById("txt_id_carta_comp").value=id_cc;
    //var accion = document.getElementById("accion_form").value;
    
    var id_cc = id_cart_comp;
        $.ajax({
            type: 'POST',
            dataType: 'json',
            data: {id_cc: id_cc, accion_form: 'M'},
            //data: {id_cmb:'carrera'},
            //data: $('#formid').serialize(),
            url: ruta + '/F_muestra_cronograma',
            success: function(data) {

                $.each(data.items, function(index, article) {
                    document.getElementById("txt_actividad_1").value = article.act_1;
                    document.getElementById("txt_actividad_2").value = article.act_2;
                    document.getElementById("txt_actividad_3").value = article.act_3;
                    document.getElementById("txt_actividad_4").value = article.act_4;
                    document.getElementById("txt_actividad_5").value = article.act_5;
                    document.getElementById("txt_actividad_6").value = article.act_6;
                    document.getElementById("txt_cod_act_1").value = article.cod_act_1;
                    document.getElementById("txt_cod_act_2").value = article.cod_act_2;
                    document.getElementById("txt_cod_act_3").value = article.cod_act_3;
                    document.getElementById("txt_cod_act_4").value = article.cod_act_4;
                    document.getElementById("txt_cod_act_5").value = article.cod_act_5;
                    document.getElementById("txt_cod_act_6").value = article.cod_act_6;
                    document.getElementById("txt_horas_actividad").value = article.num_horas;
                    
                    if (article.act_1.substring(2).replace(".", "").trim() == ""){//Si no tiene actividad lo bloqueo
                        document.getElementById("txt_semana_1_1").disabled="disabled";
                        document.getElementById("txt_semana_1_2").disabled="disabled";
                        document.getElementById("txt_semana_1_3").disabled="disabled";
                        document.getElementById("txt_semana_1_4").disabled="disabled";
                        document.getElementById("txt_semana_1_5").disabled="disabled";
                        document.getElementById("txt_semana_1_6").disabled="disabled";
                        document.getElementById("txt_semana_1_7").disabled="disabled";
                        document.getElementById("txt_semana_1_8").disabled="disabled";
                        document.getElementById("txt_semana_1_9").disabled="disabled";
                        document.getElementById("txt_semana_1_10").disabled="disabled";
                        document.getElementById("txt_semana_1_11").disabled="disabled";
                        document.getElementById("txt_semana_1_12").disabled="disabled";
                        document.getElementById("txt_semana_1_13").disabled="disabled";
                        document.getElementById("txt_semana_1_14").disabled="disabled";
                        document.getElementById("txt_semana_1_15").disabled="disabled";
                    }
                    if (article.act_2.substring(2).replace(".", "").trim() == ""){//Si no tiene actividad lo bloqueo
                        document.getElementById("txt_semana_2_1").disabled="disabled";
                        document.getElementById("txt_semana_2_2").disabled="disabled";
                        document.getElementById("txt_semana_2_3").disabled="disabled";
                        document.getElementById("txt_semana_2_4").disabled="disabled";
                        document.getElementById("txt_semana_2_5").disabled="disabled";
                        document.getElementById("txt_semana_2_6").disabled="disabled";
                        document.getElementById("txt_semana_2_7").disabled="disabled";
                        document.getElementById("txt_semana_2_8").disabled="disabled";
                        document.getElementById("txt_semana_2_9").disabled="disabled";
                        document.getElementById("txt_semana_2_10").disabled="disabled";
                        document.getElementById("txt_semana_2_11").disabled="disabled";
                        document.getElementById("txt_semana_2_12").disabled="disabled";
                        document.getElementById("txt_semana_2_13").disabled="disabled";
                        document.getElementById("txt_semana_2_14").disabled="disabled";
                        document.getElementById("txt_semana_2_15").disabled="disabled";

                    }
                    if (article.act_3.substring(2).replace(".", "").trim() == ""){//Si no tiene actividad lo bloqueo
                        document.getElementById("txt_semana_3_1").disabled="disabled";
                        document.getElementById("txt_semana_3_2").disabled="disabled";
                        document.getElementById("txt_semana_3_3").disabled="disabled";
                        document.getElementById("txt_semana_3_4").disabled="disabled";
                        document.getElementById("txt_semana_3_5").disabled="disabled";
                        document.getElementById("txt_semana_3_6").disabled="disabled";
                        document.getElementById("txt_semana_3_7").disabled="disabled";
                        document.getElementById("txt_semana_3_8").disabled="disabled";
                        document.getElementById("txt_semana_3_9").disabled="disabled";
                        document.getElementById("txt_semana_3_10").disabled="disabled";
                        document.getElementById("txt_semana_3_11").disabled="disabled";
                        document.getElementById("txt_semana_3_12").disabled="disabled";
                        document.getElementById("txt_semana_3_13").disabled="disabled";
                        document.getElementById("txt_semana_3_14").disabled="disabled";
                        document.getElementById("txt_semana_3_15").disabled="disabled";

                    }
                    if (article.act_4.substring(2).replace(".", "").trim() == ""){//Si no tiene actividad lo bloqueo
                        document.getElementById("txt_semana_4_1").disabled="disabled";
                        document.getElementById("txt_semana_4_2").disabled="disabled";
                        document.getElementById("txt_semana_4_3").disabled="disabled";
                        document.getElementById("txt_semana_4_4").disabled="disabled";
                        document.getElementById("txt_semana_4_5").disabled="disabled";
                        document.getElementById("txt_semana_4_6").disabled="disabled";
                        document.getElementById("txt_semana_4_7").disabled="disabled";
                        document.getElementById("txt_semana_4_8").disabled="disabled";
                        document.getElementById("txt_semana_4_9").disabled="disabled";
                        document.getElementById("txt_semana_4_10").disabled="disabled";
                        document.getElementById("txt_semana_4_11").disabled="disabled";
                        document.getElementById("txt_semana_4_12").disabled="disabled";
                        document.getElementById("txt_semana_4_13").disabled="disabled";
                        document.getElementById("txt_semana_4_14").disabled="disabled";
                        document.getElementById("txt_semana_4_15").disabled="disabled";
                    }
                    if (article.act_5.substring(2).replace(".", "").trim() == ""){//Si no tiene actividad lo bloqueo
                        document.getElementById("txt_semana_5_1").disabled="disabled";
                        document.getElementById("txt_semana_5_2").disabled="disabled";
                        document.getElementById("txt_semana_5_3").disabled="disabled";
                        document.getElementById("txt_semana_5_4").disabled="disabled";
                        document.getElementById("txt_semana_5_5").disabled="disabled";
                        document.getElementById("txt_semana_5_6").disabled="disabled";
                        document.getElementById("txt_semana_5_7").disabled="disabled";
                        document.getElementById("txt_semana_5_8").disabled="disabled";
                        document.getElementById("txt_semana_5_9").disabled="disabled";
                        document.getElementById("txt_semana_5_10").disabled="disabled";
                        document.getElementById("txt_semana_5_11").disabled="disabled";
                        document.getElementById("txt_semana_5_12").disabled="disabled";
                        document.getElementById("txt_semana_5_13").disabled="disabled";
                        document.getElementById("txt_semana_5_14").disabled="disabled";
                        document.getElementById("txt_semana_5_15").disabled="disabled";
                    }
                    if (article.act_6.substring(2).replace(".", "").trim() == ""){//Si no tiene actividad lo bloqueo
                        document.getElementById("txt_semana_6_1").disabled="disabled";
                        document.getElementById("txt_semana_6_2").disabled="disabled";
                        document.getElementById("txt_semana_6_3").disabled="disabled";
                        document.getElementById("txt_semana_6_4").disabled="disabled";
                        document.getElementById("txt_semana_6_5").disabled="disabled";
                        document.getElementById("txt_semana_6_6").disabled="disabled";
                        document.getElementById("txt_semana_6_7").disabled="disabled";
                        document.getElementById("txt_semana_6_8").disabled="disabled";
                        document.getElementById("txt_semana_6_9").disabled="disabled";
                        document.getElementById("txt_semana_6_10").disabled="disabled";
                        document.getElementById("txt_semana_6_11").disabled="disabled";
                        document.getElementById("txt_semana_6_12").disabled="disabled";
                        document.getElementById("txt_semana_6_13").disabled="disabled";
                        document.getElementById("txt_semana_6_14").disabled="disabled";
                        document.getElementById("txt_semana_6_15").disabled="disabled";
                    }
                    
                    
                    
                    document.getElementById("txt_semana_1_1").value=article.act_1_sem1;
                    document.getElementById("txt_semana_1_2").value=article.act_1_sem2;
                    document.getElementById("txt_semana_1_3").value=article.act_1_sem3;
                    document.getElementById("txt_semana_1_4").value=article.act_1_sem4;
                    document.getElementById("txt_semana_1_5").value=article.act_1_sem5;
                    document.getElementById("txt_semana_1_6").value=article.act_1_sem6;
                    document.getElementById("txt_semana_1_7").value=article.act_1_sem7;
                    document.getElementById("txt_semana_1_8").value=article.act_1_sem8;
                    document.getElementById("txt_semana_1_9").value=article.act_1_sem9;
                    document.getElementById("txt_semana_1_10").value=article.act_1_sem10;
                    document.getElementById("txt_semana_1_11").value=article.act_1_sem11;
                    document.getElementById("txt_semana_1_12").value=article.act_1_sem12;
                    document.getElementById("txt_semana_1_13").value=article.act_1_sem13;
                    document.getElementById("txt_semana_1_14").value=article.act_1_sem14;
                    document.getElementById("txt_semana_1_15").value=article.act_1_sem15;
                    
                    document.getElementById("txt_semana_2_1").value=article.act_2_sem1;
                    document.getElementById("txt_semana_2_2").value=article.act_2_sem2;
                    document.getElementById("txt_semana_2_3").value=article.act_2_sem3;
                    document.getElementById("txt_semana_2_4").value=article.act_2_sem4;
                    document.getElementById("txt_semana_2_5").value=article.act_2_sem5;
                    document.getElementById("txt_semana_2_6").value=article.act_2_sem6;
                    document.getElementById("txt_semana_2_7").value=article.act_2_sem7;
                    document.getElementById("txt_semana_2_8").value=article.act_2_sem8;
                    document.getElementById("txt_semana_2_9").value=article.act_2_sem9;
                    document.getElementById("txt_semana_2_10").value=article.act_2_sem10;
                    document.getElementById("txt_semana_2_11").value=article.act_2_sem11;
                    document.getElementById("txt_semana_2_12").value=article.act_2_sem12;
                    document.getElementById("txt_semana_2_13").value=article.act_2_sem13;
                    document.getElementById("txt_semana_2_14").value=article.act_2_sem14;
                    document.getElementById("txt_semana_2_15").value=article.act_2_sem15;
                    
                    document.getElementById("txt_semana_3_1").value=article.act_3_sem1;
                    document.getElementById("txt_semana_3_2").value=article.act_3_sem2;
                    document.getElementById("txt_semana_3_3").value=article.act_3_sem3;
                    document.getElementById("txt_semana_3_4").value=article.act_3_sem4;
                    document.getElementById("txt_semana_3_5").value=article.act_3_sem5;
                    document.getElementById("txt_semana_3_6").value=article.act_3_sem6;
                    document.getElementById("txt_semana_3_7").value=article.act_3_sem7;
                    document.getElementById("txt_semana_3_8").value=article.act_3_sem8;
                    document.getElementById("txt_semana_3_9").value=article.act_3_sem9;
                    document.getElementById("txt_semana_3_10").value=article.act_3_sem10;
                    document.getElementById("txt_semana_3_11").value=article.act_3_sem11;
                    document.getElementById("txt_semana_3_12").value=article.act_3_sem12;
                    document.getElementById("txt_semana_3_13").value=article.act_3_sem13;
                    document.getElementById("txt_semana_3_14").value=article.act_3_sem14;
                    document.getElementById("txt_semana_3_15").value=article.act_3_sem15;
					
                    document.getElementById("txt_semana_4_1").value=article.act_4_sem1;
                    document.getElementById("txt_semana_4_2").value=article.act_4_sem2;
                    document.getElementById("txt_semana_4_3").value=article.act_4_sem3;
                    document.getElementById("txt_semana_4_4").value=article.act_4_sem4;
                    document.getElementById("txt_semana_4_5").value=article.act_4_sem5;
                    document.getElementById("txt_semana_4_6").value=article.act_4_sem6;
                    document.getElementById("txt_semana_4_7").value=article.act_4_sem7;
                    document.getElementById("txt_semana_4_8").value=article.act_4_sem8;
                    document.getElementById("txt_semana_4_9").value=article.act_4_sem9;
                    document.getElementById("txt_semana_4_10").value=article.act_4_sem10;
                    document.getElementById("txt_semana_4_11").value=article.act_4_sem11;
                    document.getElementById("txt_semana_4_12").value=article.act_4_sem12;
                    document.getElementById("txt_semana_4_13").value=article.act_4_sem13;
                    document.getElementById("txt_semana_4_14").value=article.act_4_sem14;
                    document.getElementById("txt_semana_4_15").value=article.act_4_sem15;
                    
                    document.getElementById("txt_semana_5_1").value=article.act_5_sem1;
                    document.getElementById("txt_semana_5_2").value=article.act_5_sem2;
                    document.getElementById("txt_semana_5_3").value=article.act_5_sem3;
                    document.getElementById("txt_semana_5_4").value=article.act_5_sem4;
                    document.getElementById("txt_semana_5_5").value=article.act_5_sem5;
                    document.getElementById("txt_semana_5_6").value=article.act_5_sem6;
                    document.getElementById("txt_semana_5_7").value=article.act_5_sem7;
                    document.getElementById("txt_semana_5_8").value=article.act_5_sem8;
                    document.getElementById("txt_semana_5_9").value=article.act_5_sem9;
                    document.getElementById("txt_semana_5_10").value=article.act_5_sem10;
                    document.getElementById("txt_semana_5_11").value=article.act_5_sem11;
                    document.getElementById("txt_semana_5_12").value=article.act_5_sem12;
                    document.getElementById("txt_semana_5_13").value=article.act_5_sem13;
                    document.getElementById("txt_semana_5_14").value=article.act_5_sem14;
                    document.getElementById("txt_semana_5_15").value=article.act_5_sem15;
                    
                    document.getElementById("txt_semana_6_1").value=article.act_6_sem1;
                    document.getElementById("txt_semana_6_2").value=article.act_6_sem2;
                    document.getElementById("txt_semana_6_3").value=article.act_6_sem3;
                    document.getElementById("txt_semana_6_4").value=article.act_6_sem4;
                    document.getElementById("txt_semana_6_5").value=article.act_6_sem5;
                    document.getElementById("txt_semana_6_6").value=article.act_6_sem6;
                    document.getElementById("txt_semana_6_7").value=article.act_6_sem7;
		    document.getElementById("txt_semana_6_8").value=article.act_6_sem8;
                    document.getElementById("txt_semana_6_9").value=article.act_6_sem9;
                    document.getElementById("txt_semana_6_10").value=article.act_6_sem10;
                    document.getElementById("txt_semana_6_11").value=article.act_6_sem11;
                    document.getElementById("txt_semana_6_12").value=article.act_6_sem12;
                    document.getElementById("txt_semana_6_13").value=article.act_6_sem13;
                    document.getElementById("txt_semana_6_14").value=article.act_6_sem14;
                    document.getElementById("txt_semana_6_15").value=article.act_6_sem15;
                        
                    document.getElementById("txt_tot_actividad_1").value=article.act_1_sum;
                    document.getElementById("txt_tot_actividad_2").value=article.act_2_sum;
                    document.getElementById("txt_tot_actividad_3").value=article.act_3_sum;
                    document.getElementById("txt_tot_actividad_4").value=article.act_4_sum;
                    document.getElementById("txt_tot_actividad_5").value=article.act_5_sum;
                    document.getElementById("txt_tot_actividad_6").value=article.act_6_sum;
                    
                    document.getElementById("txt_sum_total").value=article.total_gnral;
                    
                    
                    
                    
                });
            }
        });
}
function devuelve_cc(){
    var cont = document.getElementById("contador").value;
    var id_cc = document.getElementById("cc_id_" + cont).value;
    return id_cc;
}

function imprime(cont) {
    var ruta = document.getElementById("ruta_principal").value;
    var id_cc = document.getElementById("cc_id_" + cont).value;
    document.getElementById("txt_id_carta_comp").value = id_cc;
    //alert(id_cc);
    document.getElementById("frm_ficha").action = ruta + "/Entidad_Externa/Cronograma/imprime_cronograma.jsp";
    document.frm_ficha.target = "_new";
    document.frm_ficha.submit();
}//FIN imprime
function suma_tot_gral(){
    var valor_actividad1=document.getElementById("txt_tot_actividad_1").value;
    var valor_actividad2=document.getElementById("txt_tot_actividad_2").value;
    var valor_actividad3=document.getElementById("txt_tot_actividad_3").value;
    var valor_actividad4=document.getElementById("txt_tot_actividad_4").value;
    var valor_actividad5=document.getElementById("txt_tot_actividad_5").value;
    var valor_actividad6=document.getElementById("txt_tot_actividad_6").value;
    var total_gral_new=0;
    
    total_gral_new = parseInt(valor_actividad1) + 
                            parseInt(valor_actividad2)+ 
                            parseInt(valor_actividad3)+ 
                            parseInt(valor_actividad4)+ 
                            parseInt(valor_actividad5)+ 
                            parseInt(valor_actividad6);
    document.getElementById("txt_sum_total").value=total_gral_new;
    
}
function suma_act_parcial(actividad_num,semana_num,e){
    var total_general = document.getElementById("txt_sum_total").value;
    var total_actividad = document.getElementById("txt_tot_actividad_"+actividad_num).value;
    var actividad = document.getElementById("txt_actividad_"+actividad_num).value;
    var valor_actividad_semana = document.getElementById("txt_semana_"+actividad_num+"_"+semana_num).value;
    var valor_actividad_sem1 = document.getElementById("txt_semana_"+actividad_num+"_1").value;
    var valor_actividad_sem2 = document.getElementById("txt_semana_"+actividad_num+"_2").value;
    var valor_actividad_sem3 = document.getElementById("txt_semana_"+actividad_num+"_3").value;
    var valor_actividad_sem4 = document.getElementById("txt_semana_"+actividad_num+"_4").value;
    var valor_actividad_sem5 = document.getElementById("txt_semana_"+actividad_num+"_5").value;
    var valor_actividad_sem6 = document.getElementById("txt_semana_"+actividad_num+"_6").value;
    var valor_actividad_sem7 = document.getElementById("txt_semana_"+actividad_num+"_7").value;
    var valor_actividad_sem8 = document.getElementById("txt_semana_"+actividad_num+"_8").value;
    var valor_actividad_sem9 = document.getElementById("txt_semana_"+actividad_num+"_9").value;
    var valor_actividad_sem10 = document.getElementById("txt_semana_"+actividad_num+"_10").value;
    var valor_actividad_sem11 = document.getElementById("txt_semana_"+actividad_num+"_11").value;
    var valor_actividad_sem12 = document.getElementById("txt_semana_"+actividad_num+"_12").value;
    var valor_actividad_sem13 = document.getElementById("txt_semana_"+actividad_num+"_13").value;
    var valor_actividad_sem14 = document.getElementById("txt_semana_"+actividad_num+"_14").value;
    var valor_actividad_sem15 = document.getElementById("txt_semana_"+actividad_num+"_15").value;
    
    
    
    var total_act_new = 0;
    var total_gral_new=0;
    
    
    tecla = (document.all) ? e.keyCode : e.which;
    
    if (tecla >=48 && tecla <=57){
        
        if (actividad.substring(2).replace(".", "").trim() != ""){//Siempre y cuando haya una actividad 

            if (total_actividad == ""){
                total_actividad = 0;
            }
            if (total_general == ""){
                total_general = 0;
            }
            
            
            total_act_new = parseInt(valor_actividad_sem1) + 
                            parseInt(valor_actividad_sem2)+ 
                            parseInt(valor_actividad_sem3)+ 
                            parseInt(valor_actividad_sem4)+ 
                            parseInt(valor_actividad_sem5)+ 
                            parseInt(valor_actividad_sem6)+ 
                            parseInt(valor_actividad_sem7) + 
                            parseInt(valor_actividad_sem8)+ 
                            parseInt(valor_actividad_sem9)+ 
                            parseInt(valor_actividad_sem10)+ 
                            parseInt(valor_actividad_sem11)+ 
                            parseInt(valor_actividad_sem12)+ 
                            parseInt(valor_actividad_sem13)+ 
                            parseInt(valor_actividad_sem14)+ 
                            parseInt(valor_actividad_sem15);
                    
             
            //total_act_new = parseInt(total_actividad) + parseInt(valor_actividad_semana);
            //total_gral_new = parseInt(total_general) + parseInt(valor_actividad_semana);
            
            //total_gral_new = parseInt(total_general) + parseInt(valor_actividad_semana);
            
            
            document.getElementById("txt_tot_actividad_"+actividad_num).value=total_act_new;
        }
    }else if (tecla == 8){
        
        if (valor_actividad_semana ==""){
            document.getElementById("txt_semana_"+actividad_num+"_"+semana_num).value=0;
        }
        
        if (valor_actividad_sem1.trim() == ""){
           valor_actividad_sem1 = 0;
        }
        if (valor_actividad_sem2 == ""){
           valor_actividad_sem2 = 0;
        }
        if (valor_actividad_sem3 == ""){
           valor_actividad_sem3 = 0;
        }
        if (valor_actividad_sem4 == ""){
           valor_actividad_sem4 = 0;
        }
        if (valor_actividad_sem5 == ""){
           valor_actividad_sem5 = 0;
        }
        if (valor_actividad_sem6 == ""){
           valor_actividad_sem6 = 0;
        }
        if (valor_actividad_sem7 == ""){
           valor_actividad_sem7 = 0;
        }
        if (valor_actividad_sem8 == ""){
           valor_actividad_sem8 = 0;
        }
        if (valor_actividad_sem9 == ""){
           valor_actividad_sem9 = 0;
        }
        if (valor_actividad_sem10 == ""){
           valor_actividad_sem10 = 0;
        }
        if (valor_actividad_sem11 == ""){
           valor_actividad_sem11 = 0;
        }
        if (valor_actividad_sem12 == ""){
           valor_actividad_sem12 = 0;
        }
        if (valor_actividad_sem13 == ""){
           valor_actividad_sem13 = 0;
        }
        if (valor_actividad_sem14 == ""){
           valor_actividad_sem14 = 0;
        }
        if (valor_actividad_sem15 == ""){
           valor_actividad_sem15 = 0;
        }
        total_act_new = parseInt(valor_actividad_sem1) + 
                            parseInt(valor_actividad_sem2)+ 
                            parseInt(valor_actividad_sem3)+ 
                            parseInt(valor_actividad_sem4)+ 
                            parseInt(valor_actividad_sem5)+ 
                            parseInt(valor_actividad_sem6)+ 
                            parseInt(valor_actividad_sem7) + 
                            parseInt(valor_actividad_sem8)+ 
                            parseInt(valor_actividad_sem9)+ 
                            parseInt(valor_actividad_sem10)+ 
                            parseInt(valor_actividad_sem11)+ 
                            parseInt(valor_actividad_sem12)+ 
                            parseInt(valor_actividad_sem13)+ 
                            parseInt(valor_actividad_sem14)+ 
                            parseInt(valor_actividad_sem15);

        document.getElementById("txt_tot_actividad_"+actividad_num).value=total_act_new;
        
    }
}
function controltag(e) {
            tecla = (document.all) ? e.keyCode : e.which; 
            
            if (tecla==8) return true; // para la tecla de retroseso
            if (tecla==0||tecla==9)  return true; //<-- PARA EL TABULADOR-> su keyCode es 9 pero en tecla se esta transformando a 0 asi que porsiacaso los dos
            else 
            if (tecla==32)  return false;//Bloqueamos la barra espaciadora
            
            patron =/[0-9\s]/;// -> solo letras
           // patron =/[0-9\s]/;// -> solo numeros
            te = String.fromCharCode(tecla);
            return patron.test(te); 
}
