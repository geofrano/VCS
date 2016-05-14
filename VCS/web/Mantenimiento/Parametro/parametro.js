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
    
    $scope.consulta_parametro = function() {
        var ruta = document.getElementById("ruta_principal").value;
        var descripcion = document.getElementById("txt_nombre_para").value;
        var tipo = document.getElementById("cmb_tipo").value;
        var cont = 0;
        var $tabla = $("#tbl_parametro");
        $tabla.find("tr:gt(0)").remove();
        document.getElementById("existe_data").value = "0";
        $("#div_consulta").css("display", "none");
        $("#div_consulta2").css("display", "block");
        $.ajax({
            type: 'POST',
            dataType: 'json',
            data: {descripcion: descripcion, tipo: tipo, dato: "parametro"},
            url: ruta + '/F_Consulta_Parametro',
            success: function (result) {
                $("#div_datos").html("");
                $.each(result.items, function (index, article) {
                    cont = cont + 1;
                    $tabla.append("<tr>\n" +
                            "<td><input type=\"hidden\" name=\"par_id_" + cont + "\" id=\"par_id_" + cont + "\" value=\"" + article.id_parametro + "\"></td>\n" +
                            "<td>" + article.id_parametro + "</td>\n" +
                            "<td><input type=\"hidden\" name=\"par_des_" + cont + "\" id=\"par_des_" + cont + "\" value=\"" + article.descripcion + "\"></td>" +
                            "<td>" + article.descripcion + "</td>\n" +
                            "<td><input type=\"hidden\" name=\"par_valor_" + cont + "\" id=\"par_valor_" + cont + "\" value=\"" + article.valor + "\"></td>" +
                            "<td>" + article.valor + "</td>\n" +
                            "<td><input type=\"hidden\" name=\"par_tipo_" + cont + "\" id=\"par_tipo_" + cont + "\" value=\"" + article.tipo + "\"></td>" +
                            "<td>" + article.tipo_desc + "</td>\n" +
                            "<td class=\"alineado3\">" +
                            "<div name=\"div_modificar_" + cont + "\" id=\"div_modificar_" + cont + "\"><img width=\"30px\" height=\"30px\" src=\"../../images/modificar.png\" title=\"Modificar\" data-toggle=\"modal\" data-target=\"#campos_parametro\" onclick=\"carga_cont(" + cont + ")\"/></div>" +
                            "</td>\n" +
                            "<td class=\"alineado3\">" +
                            "<div name=\"div_eliminar_" + cont + "\" id=\"div_eliminar_" + cont + "\"><img width=\"30px\" height=\"30px\" src=\"../../images/eliminar.jpg\" title=\"Eliminar\" onclick=\"carga_cont(" + cont + "), asigna_accion_elimina(), modificar_parametro();\"/></div>" +
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
    
    $scope.carga_cmb_tipo_parametro = function () {
        var ruta = document.getElementById("ruta_principal").value;
        var $cmb = $("#cmb_tipo_para");
        $.ajax({
            type: 'POST',
            dataType: 'json',
            data: {id_cmb: 'tipo_actividad'},
            url: ruta + '/F_Mantenimiento_parametro',
            success: function (result) {
                $cmb.find('option').remove();
                $.each(result.items, function (index, article) {
                    $cmb.append("<option value=\"" + article.valor + "\">\n" + article.descripcion + "</option>");
                });
                console.log("Se cargo exitosamente el combo tipo de actividad");
            }
        });
    };
});

function carga_combo_tipo_parametro() {
    var ruta = document.getElementById("ruta_principal").value;
    var $cmb = $("#cmb_tipo");
    $.ajax({
        type: 'POST',
        dataType: 'json',
        data: {id_cmb: 'tipo_actividad'},
        url: ruta + '/F_Mantenimiento_parametro',
        success: function (result) {
            $cmb.find('option').remove();
            $cmb.append("<option value=\"TD\">Todo</option>");
            $.each(result.items, function (index, article) {
                $cmb.append("<option value=\"" + article.valor + "\">\n" + article.descripcion + "</option>");
            });
            console.log("Se cargo exitosamente el combo tipo de actividad");
        }
    });
}

function carga_cont(seleccionado) {
    var id_parametro = document.getElementById("par_id_"+seleccionado).value;
    var descripcion = document.getElementById("par_des_"+seleccionado).value;
    var valor = document.getElementById("par_valor_"+seleccionado).value;
    var tipo = document.getElementById("par_tipo_"+seleccionado).value;
    document.getElementById("tipo_accion").value = "M";
    document.getElementById("cont").value = seleccionado;
    document.getElementById("txt_id_parametro").value = id_parametro;
    document.getElementById("txt_descripcion").value = descripcion;
    document.getElementById("txt_valor").value = valor;
    document.forms["frm_datos"]["cmb_tipo_para"].value = tipo;
}

function modificar_parametro(){
    var ruta = document.getElementById("ruta_principal").value;
    var id_parametro = document.getElementById("txt_id_parametro").value;
    var descripcion = document.getElementById("txt_descripcion").value;
    var valor = document.getElementById("txt_valor").value;
    
    if (id_parametro == "") {
        swal("Error!", "Favor ingrese ID del Parametro", "info");
        document.getElementById("txt_id_parametro").focus();
    }else if (descripcion == "") {
        swal("Error!", "Favor ingrese la Descripción del Parametro", "info");
        document.getElementById("txt_descripcion").focus();
    } else if (valor == "") {
        swal("Error!", "Favor ingrese el Valor del Parametro", "info");
        document.getElementById("txt_valor").focus();
    } else {
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
                url: ruta + '/F_grabar_parametro',
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
}

function asigna_accion_ingreso(){
    document.getElementById("tipo_accion").value = "I";
    document.getElementById("txt_id_parametro").readOnly = false;
    document.getElementById("txt_id_parametro").value = "";
    document.getElementById("txt_descripcion").value = "";
    document.getElementById("txt_valor").value = "";
}

function asigna_accion_elimina(){
    document.getElementById("tipo_accion").value = "E";
}