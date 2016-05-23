/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var app = angular.module("VCS", []);
app.controller("ControladorVCS", function ($scope, $http) {
    $scope.institucion = "Universidad Politecnica Salesiana";
    $scope.sede = "Guayaquil";
    $scope.submitted = false;
    $scope.muestra_carrera = false;


    $scope.carga2 = function () {
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
            success: function (data) {
                $("#ajaxResponse").html("");
                $.each(data.items, function (index, article) {
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

    $scope.carga_iconos = function () {
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
            success: function (data) {
                $("#ajaxIconos").html("");
                $.each(data.items, function (index, article) {
                    $("#ajaxIconos").append("");
                    if (article.id_modulo_padre == id_modulo_padre) {
                        $("#ajaxIconos").append("<a  href=\"" + article.pagina_modulo + "\">" +
                                " <img width=\"150px\" height=\"150px\" class=\"img-circle\" src=\"" + article.icono_modulo + "\"/> " +
                                "<p>" + article.nombre_modulo + "</p>" + "</a>");
                    }
                });
            }
        });
    };
    
    $scope.consulta_mapeo = function() {
        var ruta = document.getElementById("ruta_principal").value;
        var horas = document.getElementById("cmb_horas").value;
        var actividad = document.getElementById("cmb_actividad").value;
        var cont = 0;
        var $tabla = $("#tbl_mapeo");
        $tabla.find("tr:gt(0)").remove();
        document.getElementById("existe_data").value = "0";
        $("#div_consulta").css("display", "none");
        $("#div_consulta2").css("display", "block");
        $.ajax({
            type: 'POST',
            dataType: 'json',
            data: {horas: horas, actividad: actividad},
            url: ruta + '/F_Consulta_Mapeo',
            success: function (result) {
                $("#div_datos").html("");
                $.each(result.items, function (index, article) {
                    cont = cont + 1;
                    $tabla.append("<tr>\n" +
                            "<td><input type=\"hidden\" name=\"mapeo_id_" + cont + "\" id=\"mapeo_id_" + cont + "\" value=\"" + article.id_parametro + "\"></td>\n" +
                            "<td>" + article.id_parametro + "</td>\n" +
                            "<td><input type=\"hidden\" name=\"mapeo_id_act_" + cont + "\" id=\"mapeo_id_act_" + cont + "\" value=\"" + article.id_actividad + "\"></td>" +
                            "<td>" + article.id_actividad + "</td>\n" +
                            "<td><input type=\"hidden\" name=\"mapeo_desc_act_" + cont + "\" id=\"mapeo_desc_act_" + cont + "\" value=\"" + article.desc_actividad + "\"></td>" +
                            "<td>" + article.desc_actividad + "</td>\n" +
                            "<td><input type=\"hidden\" name=\"mapeo_id_ho_" + cont + "\" id=\"mapeo_id_ho_" + cont + "\" value=\"" + article.id_horas + "\"></td>" +
                            "<td>" + article.id_horas + "</td>\n" +
                            "<td><input type=\"hidden\" name=\"mapeo_desc_ho_" + cont + "\" id=\"mapeo_desc_ho_" + cont + "\" value=\"" + article.desc_horas + "\"></td>" +
                            "<td>" + article.desc_horas + "</td>\n" +
                            "<td class=\"alineado3\">" +
                            "<div name=\"div_modificar_" + cont + "\" id=\"div_modificar_" + cont + "\"><img width=\"30px\" height=\"30px\" src=\"../../images/modificar.png\" title=\"Modificar\" data-toggle=\"modal\" data-target=\"#campos_parametro\" onclick=\"carga_cont(" + cont + ")\"/></div>" +
                            "</td>\n" +
                            "<td class=\"alineado3\">" +
                            "<div name=\"div_eliminar_" + cont + "\" id=\"div_eliminar_" + cont + "\"><img width=\"30px\" height=\"30px\" src=\"../../images/eliminar.jpg\" title=\"Eliminar\" onclick=\"carga_cont(" + cont + "), asigna_accion_elimina(), modificar_mapeo();\"/></div>" +
                            "</td>\n" +
                            "</tr>\n");
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
    
    $scope.carga_combo_horas = function () {
        var ruta = document.getElementById("ruta_principal").value;
        var $cmb = $("#cmb_horas");
        $.ajax({
            type: 'POST',
            dataType: 'json',
            data: {id_cmb: 'horas'},
            url: ruta + '/F_Muestra_programas',
            success: function (result) {
                $cmb.find('option').remove();
                $cmb.append("<option value=\"TD\">Todas</option>");
                $.each(result.items, function (index, article) {
                    $cmb.append("<option  value=\"" + article.valor + "\">\n" + article.descripcion +
                            "</option>");
                });
                console.log("Se cargo exitosamente el combo hora");
            }
        });
    };
    
    $scope.carga_combo_tipo_actividad = function () {
        var ruta = document.getElementById("ruta_principal").value;
        var $cmb = $("#cmb_actividad");
        $.ajax({
            type: 'POST',
            dataType: 'json',
            data: {id_cmb: 'tipo_actividad'},
            url: ruta + '/F_Muestra_programas',
            success: function (result) {
                $cmb.find('option').remove();
                $cmb.append("<option value=\"TD\">Todas</option>");
                $.each(result.items, function (index, article) {
                    $cmb.append("<option value=\"" + article.valor + "\">\n" + article.descripcion +
                            "</option>");
                });
                console.log("Se cargo exitosamente el combo tipo de actividad");
            }
        });
    };
    
    $scope.carga_combo_horas_in = function () {
        var ruta = document.getElementById("ruta_principal").value;
        var $cmb = $("#cmb_horas_in");
        $.ajax({
            type: 'POST',
            dataType: 'json',
            data: {id_cmb: 'horas'},
            url: ruta + '/F_Muestra_programas',
            success: function (result) {
                $cmb.find('option').remove();
                $.each(result.items, function (index, article) {
                    $cmb.append("<option  value=\"" + article.valor + "\">\n" + article.descripcion +
                            "</option>");
                });
                console.log("Se cargo exitosamente el combo hora");
            }
        });
    };
    
    $scope.carga_combo_tipo_actividad_in = function () {
        var ruta = document.getElementById("ruta_principal").value;
        var $cmb = $("#cmb_actividad_in");
        $.ajax({
            type: 'POST',
            dataType: 'json',
            data: {id_cmb: 'tipo_actividad'},
            url: ruta + '/F_Muestra_programas',
            success: function (result) {
                $cmb.find('option').remove();
                $.each(result.items, function (index, article) {
                    $cmb.append("<option value=\"" + article.valor + "\">\n" + article.descripcion +
                            "</option>");
                });
                console.log("Se cargo exitosamente el combo tipo de actividad");
            }
        });
    };
    
    $scope.carga_codigo = function () {
        var ruta = document.getElementById("ruta_principal").value;
        $.ajax({
            type: 'POST',
            dataType: 'json',
            //data: {carga: 'horas'},
            url: ruta + '/F_consulta_codigo_mapeo',
            success: function (result) {
                $("#div_consul").html("");
                $.each(result.items, function (index, article) {
                    document.getElementById("txt_id_parametro").value = article.id_parametro;
                });
                console.log("Se cargo exitosamente el combo hora");
            }
        });
    };
});

function carga_combo_carrera_parametro() {
    var ruta = document.getElementById("ruta_principal").value;
    var $cmb = $("#cmb_carrera");
    $.ajax({
        type: 'POST',
        dataType: 'json',
        data: {id_cmb: 'carrera'},
        url: ruta + '/F_Mantenimiento_parametro',
        success: function (result) {
            $cmb.find('option').remove();
            $cmb.append("<option value=\"TD\">Todas</option>");
            $.each(result.items, function (index, article) {
                $cmb.append("<option value=\"" + article.valor + "\">\n" + article.descripcion + "</option>");
            });
            console.log("Se cargo exitosamente el combo tipo de actividad");
        }
    });
}

function carga_cont(seleccionado) {
    var id_parametro = document.getElementById("mapeo_id_"+seleccionado).value;
    var id_actividad = document.getElementById("mapeo_id_act_"+seleccionado).value;
    var id_hora = document.getElementById("mapeo_id_ho_"+seleccionado).value;
    document.getElementById("tipo_accion").value = "M";
    document.getElementById("cont").value = seleccionado;
    document.getElementById("txt_id_parametro").value = id_parametro;
    document.forms["frm_datos"]["cmb_actividad_in"].value = id_actividad
    document.forms["frm_datos"]["cmb_horas_in"].value = id_hora;
}

function modificar_mapeo() {
    var ruta = document.getElementById("ruta_principal").value;

    swal({
        title: "Está segur@?",
        text: "Favor confirme que los datos son los correctos",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#337ab7",
        confirmButtonText: "Si",
        closeOnConfirm: false,
        showLoaderOnConfirm: true
    }, function () {
        $.ajax({
            type: 'POST',
            data: $('#frm_datos').serialize(),
            url: ruta + '/F_grabar_mapeo',
            success: function (data) {
                if (data.trim() == "SI") {
                    swal({
                        title: "Exito!",
                        text: "Proceso ejecutado correctamente",
                        type: "success",
                        showCancelButton: false,
                        confirmButtonColor: "#337ab7",
                        confirmButtonText: "Ok",
                        closeOnConfirm: false
                    });
                } else {
                    swal("Error!", "El proceso no ha sido ejecutado", "error");
                }
            }
        });
    });
}

function asigna_accion_ingreso(){
    document.getElementById("tipo_accion").value = "I";
}

function asigna_accion_elimina(){
    document.getElementById("tipo_accion").value = "E";
}