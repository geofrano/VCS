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
                            "<td><div style=\"display:none\" name=\"div_inserta_" + cont + "\" id=\"div_inserta_" + cont + "\"><input type = \"radio\" name = \"group1\" id = \"group1\" value = \"" + article.id_cc + "\" ></div></td>\n" +
                            "<td class=\"alineado3\">" +
                            "<div style=\"display:none\" name=\"div_modificar_" + cont + "\" id=\"div_modificar_" + cont + "\"><img width=\"30px\" height=\"30px\" src=\"../../images/modificar.png\" title=\"Modificar\" onclick=\"carga_ingreso(" + cont + ")\"/></div>" +
                            "</td>\n" +
                            "<td class=\"alineado3\">" +
                            "<div style=\"display:none\" name=\"div_eliminar_" + cont + "\" id=\"div_eliminar_" + cont + "\"><img width=\"20px\" height=\"10px\" src=\"../../images/eliminar.jpg\" title=\"Eliminar\" onclick=\"carga_ingreso(" + cont + ")\"/>" +
                            "</td></tr>\n");

                    if (article.cc_estado.trim() == "A") {
                        $("#" + "div_eliminar_" + cont).css("display", "none");
                        $("#" + "div_modificar_" + cont).css("display", "none");
                        $("#" + "div_inserta_" + cont).css("display", "block");
                    }
                    if (article.cc_estado.trim() == "5") {//La ficha del estudiante ya fue ingresada
                        $("#" + "div_eliminar_" + cont).css("display", "block");
                        $("#" + "div_modificar_" + cont).css("display", "block");
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
                url: ruta + '/Administracion_de_Carrera/Ficha_del_Estudiante/cont_ficha_estudiante.jsp',
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
        document.getElementById("accion_form").value = "I";

        var id_cc = id_cart_comp;
        $.ajax({
            type: 'POST',
            dataType: 'json',
            data: {id_cc: id_cc, accion_form: 'I'},
            //data: {id_cmb:'carrera'},
            //data: $('#formid').serialize(),
            url: ruta + '/F_muestra_ficha_estudiante',
            success: function(data) {

                $.each(data.items, function(index, article) {
                    document.getElementById("txt_id_carta_comp").value = article.id_carta_comp;
                    document.getElementById("txt_actividad").value = article.tipo_act;
                    document.getElementById("txt_fecha_ini").value = article.dia_ini + '/' + article.mes_ini + '/' + article.anio_ini;
                    document.getElementById("txt_fecha_fin").value = article.dia_fin + '/' + article.mes_fin + '/' + article.anio_fin;
                    if (article.est_ced.length > 10) {
                        document.getElementById("txt_tipo_doc").value = "PASAPORTE";
                    } else {
                        document.getElementById("txt_tipo_doc").value = "CÉDULA DE CIUDADANÍA";
                    }
                    document.getElementById("txt_cedula").value = article.est_ced;
                    document.getElementById("txt_nombre_completo").value = article.est_nombre;
                    document.getElementById("txt_fono_est").value = article.est_fono;
                    document.getElementById("txt_email_est").value = article.est_mail;
                    document.getElementById("txt_carrera").value = article.est_carrera;
                    document.getElementById("txt_semestre").value = article.est_ciclo;
                    document.getElementById("txt_empresa").value = article.empresa;
                    document.getElementById("txt_responsable_empresa").value = article.emp_rep;
                    document.getElementById("txt_departamento").value = article.area_act;
                    document.getElementById("txt_responsable_area").value = article.resp_area;
                    document.getElementById("txt_horario_previsto").value = article.horario;
                    document.getElementById("txt_cargo_resp_cia").value = article.cargo_rep;
                    document.getElementById("txt_telefono_cia").value = article.fono_rep;
                    document.getElementById("txt_dir_cia").value = article.emp_dir;
                    document.getElementById("txt_nomb_progama").value = article.programa;
                    document.getElementById("txt_nomb_proy").value = article.proyecto;
                    document.getElementById("txt_tutor").value = article.tutor;
                    document.getElementById("txt_act_realizar").value = article.actividades;
                    document.getElementById("txt_cod_proy").value = article.txt_cod_proy;
                });
            }
        });
    };



    $(function() {
        $('#datetimepicker6').datetimepicker();
        $('#datetimepicker7').datetimepicker({
            useCurrent: false //Important! See issue #1075
        });
        $("#datetimepicker6").on("dp.change", function(e) {
            $('#datetimepicker7').data("DateTimePicker").minDate(e.date);
        });
        $("#datetimepicker7").on("dp.change", function(e) {
            $('#datetimepicker6').data("DateTimePicker").maxDate(e.date);
        });
    });

});
function graba() {
    var ruta = document.getElementById("ruta_principal").value;
    var direccion = document.getElementById("txt_direccion_est").value;
    var cod_proy = document.getElementById("cod_proy").value;
   
    if (direccion == "") {
        swal("Error!", "Favor ingrese la direccion del estudiante", "info");
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
                url: ruta + '/F_graba_Ficha_estudiante',
                success: function(data) {
                    if (data.trim() == "SI") {
                        //swal("Exito!", "La ficha del estudiante ha sido ingresada", "success");
                        swal({
                            title: "Exito!",
                            text: "La ficha del estudiante ha sido ingresada",
                            type: "success",
                            showCancelButton: false,
                            confirmButtonColor: "#337ab7",
                            confirmButtonText: "Ok",
                            closeOnConfirm: false
                        },
                        function() {
                            window.open(ruta + "/Administracion_de_Carrera/Ficha_del_Estudiante/ficha_estudiante.jsp", "_self");
                        });
                    } else {
                        swal("Error!", "La ficha del estudiante no ha sido ingresada", "error");
                    }
                }
            });

        });

    }
}//FIN GRABA
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
        url: ruta + '/Administracion_de_Carrera/Ficha_del_Estudiante/cont_ficha_estudiante.jsp',
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
    alert(id_cart_comp);
    var id_cc = id_cart_comp.trim();
    var accion = document.getElementById("accion_form").value;
    $.ajax({
        type: 'POST',
        dataType: 'json',
        data: {id_cc: id_cc, accion_form: accion},
        //data: {id_cmb:'carrera'},
        //data: $('#formid').serialize(),
        url: ruta + '/F_muestra_ficha_estudiante',
        success: function(data) {

            $.each(data.items, function(index, article) {
                document.getElementById("txt_direccion_est").value = article.dir_est;
                document.getElementById("txt_facebook").value = article.facebook;
                document.getElementById("txt_linkedin").value = article.linked_in;
                document.getElementById("txt_nomb_proy").value = article.nom_proy;
                document.getElementById("txt_twitter").value = article.twitter;
                document.getElementById("txt_id_carta_comp").value = article.id_carta_comp;
                document.getElementById("txt_actividad").value = article.tipo_act;
                document.getElementById("txt_fecha_ini").value = article.dia_ini + '/' + article.mes_ini + '/' + article.anio_ini;
                document.getElementById("txt_fecha_fin").value = article.dia_fin + '/' + article.mes_fin + '/' + article.anio_fin;
                if (article.est_ced.length > 10) {
                    document.getElementById("txt_tipo_doc").value = "PASAPORTE";
                } else {
                    document.getElementById("txt_tipo_doc").value = "CÉDULA DE CIUDADANÍA";
                }
                document.getElementById("txt_cedula").value = article.est_ced;
                document.getElementById("txt_nombre_completo").value = article.est_nombre;
                document.getElementById("txt_fono_est").value = article.est_fono;
                document.getElementById("txt_email_est").value = article.est_mail;
                document.getElementById("txt_carrera").value = article.est_carrera;
                document.getElementById("txt_semestre").value = article.est_ciclo;
                document.getElementById("txt_empresa").value = article.empresa;
                document.getElementById("txt_responsable_empresa").value = article.emp_rep;
                document.getElementById("txt_departamento").value = article.area_act;
                document.getElementById("txt_responsable_area").value = article.resp_area;
                document.getElementById("txt_horario_previsto").value = article.horario;
                document.getElementById("txt_cargo_resp_cia").value = article.cargo_rep;
                document.getElementById("txt_telefono_cia").value = article.fono_rep;
                document.getElementById("txt_dir_cia").value = article.emp_dir;
                document.getElementById("txt_nomb_progama").value = article.programa;
                document.getElementById("txt_nomb_proy").value = article.proyecto;
                document.getElementById("txt_tutor").value = article.tutor;
                document.getElementById("txt_act_realizar").value = article.actividades;
                document.getElementById("txt_cod_proy").value = article.txt_cod_proy;
            });
        }
    });
}