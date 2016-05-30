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

    $scope.consultar_estudiante_cc = function() {
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
                        $("#" + "div_imprimir_" + cont).css("display", "block");
                        $("#" + "div_eliminar_" + cont).css("display", "block");
                        $("#" + "div_modificar_" + cont).css("display", "block");
                        
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

    $scope.carga_ingreso = function () {
        var ruta = document.getElementById("ruta_principal").value;
        document.getElementById("id_cc_consulta").value="NADA";
        document.getElementById("frm_datos").action = ruta + "/Entidad_Externa/Carta_Compromiso/ingresar_carta_compromiso.jsp";
        document.getElementById("frm_datos").target = "_self";
        document.frm_datos.submit();
        //window.open(ruta + "/Entidad_Externa/Carta_Compromiso/ingresar_carta_compromiso.jsp", target = "_self");
    };

    $scope.carga_busca_cc = function () {
        var ruta = document.getElementById("ruta_principal").value;
        window.open(ruta + "/Entidad_Externa/Carta_Compromiso/consultar_carta_compromiso.jsp", target = "_self");
    };

    $scope.guarda_carta_comp = function () {
        var ruta = document.getElementById("ruta_principal").value;
        $scope.user = {};
        document.getElementById("frm_carta_comp").action = ruta + "/F_carta_compromiso.jsp";
        
        var cod_cc           = document.getElementById("txt_codigo").value;
        var empresa_nomb     = document.getElementById("txt_nombre_empresa").value;
        var est_nomb         = document.getElementById("txt_nombre_estudiante").value;
        var objetivo_act     = document.getElementById("txt_obj_act_academica").value;
        var fecha_inicio     = document.getElementById("txt_fecha_ini").value;
        var fecha_fin        = document.getElementById("txt_fecha_fin").value;
        var horario_act      = document.getElementById("txt_horario").value;
        var area_academica   = document.getElementById("txt_area_academica").value;
        var responsable_area = document.getElementById("txt_respon_area").value;
        var actividad_1      = document.getElementById("txt_actividad_1").value;
        var resultado_1      = document.getElementById("txt_resultado_1").value;
        var producto_1       = document.getElementById("txt_producto_1").value;
        var actividad_2      = document.getElementById("txt_actividad_2").value;
        var resultado_2      = document.getElementById("txt_resultado_2").value;
        var producto_2       = document.getElementById("txt_producto_2").value;
        var actividad_3      = document.getElementById("txt_actividad_3").value;
        var resultado_3      = document.getElementById("txt_resultado_3").value;
        var producto_3       = document.getElementById("txt_producto_3").value;
        var actividad_4      = document.getElementById("txt_actividad_1").value;
        var resultado_4      = document.getElementById("txt_resultado_1").value;
        var producto_4       = document.getElementById("txt_producto_1").value;
        var actividad_5      = document.getElementById("txt_actividad_2").value;
        var resultado_5      = document.getElementById("txt_resultado_2").value;
        var producto_5       = document.getElementById("txt_producto_2").value;
        var actividad_6      = document.getElementById("txt_actividad_3").value;
        var resultado_6      = document.getElementById("txt_resultado_3").value;
        var producto_6       = document.getElementById("txt_producto_3").value;
        var represent_legal  = document.getElementById("txt_nombre_repr_legal").value;
        var delegado_ups     = document.getElementById("txt_nombre_deleg_ups").value;
        var tutor            = document.getElementById("cmb_tutor").value;
        var accion_realiza   = document.getElementById("accion_form").value;
        
        if (cod_cc == "") {
            swal("Error!", "El codigo no ha podido ser generado. Favor comuníquese con el administrador o el Dpto. de sistemas", "info");
        }else if (empresa_nomb == "") {
            document.getElementById("txt_nombre_empresa").focus();
            swal("Error!", "Favor verifique no ha seleccionado ninguna empresa. Debe dar clic sobre el campo empresa para acceder a una ventana de búsqueda", "info");
        }else if (est_nomb == "") {
            document.getElementById("txt_nombre_estudiante").focus();
            swal("Error!", "Favor verifique no ha seleccionado ningun estudiante. Debe dar clic sobre el campo estudiante para acceder a una ventana de búsqueda", "info");
        }else if (objetivo_act == "") {
            document.getElementById("txt_obj_act_academica").focus();
            swal("Error!", "Favor verifique no ha ingresado el objetivo de la actividad académica", "info");
        }else if (fecha_inicio == "") {
            document.getElementById("txt_fecha_ini").focus();
            swal("Error!", "Favor ingrese la fecha de inicio de la actividad académica", "info");
        }else if (fecha_fin == "") {
            document.getElementById("txt_fecha_fin").focus();
            swal("Error!", "Favor ingrese la fecha de finalización de la actividad académica", "info");
        }else if (fecha_fin == fecha_inicio) {
            document.getElementById("txt_fecha_fin").focus();
            swal("Error!", "Favor verifique la fecha de inicio no puede ser igual que la fecha de finalización", "info");
        }else if (horario_act == "") {
            document.getElementById("txt_horario").focus();
            swal("Error!", "Favor ingrese el horario en el que se desarrollará la actividad académica", "info");
        }else if (area_academica == "") {
            document.getElementById("txt_area_academica").focus();
            swal("Error!", "Favor ingrese el área donde desarrollará la actividad académica", "info");
        }else if (responsable_area == "") {
            document.getElementById("txt_respon_area").focus();
            swal("Error!", "Favor ingrese el responsable del área donde desarrollará la actividad académica", "info");
        }else if (represent_legal == "") {
            document.getElementById("txt_nombre_empresa").focus();
            swal("Error!", "Favor verifique que la empresa seleccionada tiene un representante legal asignado", "info");
        }else if (tutor == "") {
            document.getElementById("cmb_tutor").focus();
            swal("Error!", "Los tutores no pudieron ser cargados. Favor comunicarse con el administrador o con el Dpto. de sistemas", "info");
        }else if (delegado_ups == "") {
            document.getElementById("txt_nombre_deleg_ups").focus();
            swal("Error!", "El delegado de la UPS no pudo ser cargado. Favor comuníquese con el administrador o el Dpto. de sistemas", "info");
        }else if (actividad_1 == "") {
            document.getElementById("txt_actividad_1").focus();
            swal("Error!", "Favor ingresar por lo menos la primera actividad", "info");
        }else if (resultado_1 == "") {
            document.getElementById("txt_resultado_1").focus();
            swal("Error!", "Favor ingresar por lo menos el resultado de la primera actividad", "info");
        }else if (producto_1 == "") {
            document.getElementById("txt_producto_1").focus();
            swal("Error!", "Favor ingresar por lo menos el producto de la primera actividad", "info");
        }else if ( (actividad_2 == "" && producto_2 == "" && resultado_2 != "")
                || (actividad_2 == "" && producto_2 != "" && resultado_2 == "")
                || (actividad_2 != "" && producto_2 == "" && resultado_2 == "")
                || (actividad_2 != "" && producto_2 != "" && resultado_2 == "")
                || (actividad_2 != "" && producto_2 == "" && resultado_2 != "")
                || (actividad_2 == "" && producto_2 != "" && resultado_2 != "")
                 ) {
            document.getElementById("txt_actividad_2").focus();
            swal("Error!", "Ha ingresado la actividad 2 incompleta. Favor verifique que se encuentren llenos los campos actividad 2, producto 2, resultado 2", "info");
        }else if ( (actividad_3 == "" && producto_3 == "" && resultado_3 != "")
                || (actividad_3 == "" && producto_3 != "" && resultado_3 == "")
                || (actividad_3 != "" && producto_3 == "" && resultado_3 == "")
                || (actividad_3 != "" && producto_3 != "" && resultado_3 == "")
                || (actividad_3 != "" && producto_3 == "" && resultado_3 != "")
                || (actividad_3 == "" && producto_3 != "" && resultado_3 != "")
                 ) {
            document.getElementById("txt_actividad_3").focus();
            swal("Error!", "Ha ingresado la actividad 3 incompleta. Favor verifique que se encuentren llenos los campos actividad 3, producto 3, resultado 3", "info");
        }else if ( (actividad_4 == "" && producto_4 == "" && resultado_4 != "")
                || (actividad_4 == "" && producto_4 != "" && resultado_4 == "")
                || (actividad_4 != "" && producto_4 == "" && resultado_4 == "")
                || (actividad_4 != "" && producto_4 != "" && resultado_4 == "")
                || (actividad_4 != "" && producto_4 == "" && resultado_4 != "")
                || (actividad_4 == "" && producto_4 != "" && resultado_4 != "")
                 ) {
            document.getElementById("txt_actividad_4").focus();
            swal("Error!", "Ha ingresado la actividad 4 incompleta. Favor verifique que se encuentren llenos los campos actividad 4, producto 4, resultado 4", "info");
        }else if ( (actividad_5 == "" && producto_5 == "" && resultado_5 != "")
                || (actividad_5 == "" && producto_5 != "" && resultado_5 == "")
                || (actividad_5 != "" && producto_5 == "" && resultado_5 == "")
                || (actividad_5 != "" && producto_5 != "" && resultado_5 == "")
                || (actividad_5 != "" && producto_5 == "" && resultado_5 != "")
                || (actividad_5 == "" && producto_5 != "" && resultado_5 != "")
                 ) {
            document.getElementById("txt_actividad_5").focus();
            swal("Error!", "Ha ingresado la actividad 5 incompleta. Favor verifique que se encuentren llenos los campos actividad 5, producto 5, resultado 5", "info");
        }else if ( (actividad_6 == "" && producto_6 == "" && resultado_6 != "")
                || (actividad_6 == "" && producto_6 != "" && resultado_6 == "")
                || (actividad_6 != "" && producto_6 == "" && resultado_6 == "")
                || (actividad_6 != "" && producto_6 != "" && resultado_6 == "")
                || (actividad_6 != "" && producto_6 == "" && resultado_6 != "")
                || (actividad_6 == "" && producto_6 != "" && resultado_6 != "")
                 ) {
            document.getElementById("txt_actividad_6").focus();
            swal("Error!", "Ha ingresado la actividad 6 incompleta. Favor verifique que se encuentren llenos los campos actividad 6, producto 6, resultado 6", "info");
        }else {
            
            if (accion_realiza == "I"){
                $.ajax({
                    type: 'POST',
                    //dataType: 'json',
                    //data: {id_cc: id_cc},
                    //data: {id_cmb:'carrera'},
                    data: $('#frm_carta_comp').serialize(),
                    url: ruta + '/F_valida_cc',
                    success: function(data) {
                        if (data.trim() == "NO") {//NO HAY INGRESADO duplicados
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
                                    data: $('#frm_carta_comp').serialize(),
                                    url: ruta + '/F_carta_compromiso.jsp',
                                    success: function(data) {
                                        if (data.trim().substring(0,2) == "SI") {
                                            //swal("Exito!", "La ficha del estudiante ha sido ingresada", "success");
                                            swal({
                                                title: "Éxito!",
                                                text: "La carta compromiso ha sido ingresada",
                                                type: "success",
                                                showCancelButton: false,
                                                confirmButtonColor: "#337ab7",
                                                confirmButtonText: "Ok",
                                                closeOnConfirm: true
                                                },
                                                function() {
                                                    document.getElementById("txt_codigo").value=data.trim().substring(3);
                                                    document.getElementById("frm_carta_comp").action = ruta + "/Entidad_Externa/Carta_Compromiso/imprime_carta_compromiso.jsp";
                                                    document.frm_carta_comp.target="_new";
                                                    //alert(document.getElementById("frm_ficha").action);
                                                    $("#frm_carta_comp").submit();
                                                    //location.reload();
                                                    //window.open(ruta + "/Administracion_de_Carrera/Ficha_del_Estudiante/ficha_estudiante.jsp", "_self");
                                                });

                                            } else {
                                                swal("Error", "La carta compromiso no pudo ser ingresada", "error");
                                            }
                                        }
                                    });

                                });

                        } else {
                            swal("Error", "El estudiante ya posee dicha actividad en el sistema. Favor verifique", "error");
                        }
                    }
                });
            }else if (accion_realiza == "M"){
            //document.getElementById("accion_form").value="I";
            //document.frm_carta_comp.submit();
            //$scope.submitted = true;
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
                        data: $('#frm_carta_comp').serialize(),
                        url: ruta + '/F_carta_compromiso.jsp',
                        success: function(data) {
                            if (data.trim().substring(0,2) == "SI") {
                                //swal("Exito!", "La ficha del estudiante ha sido ingresada", "success");
                                swal({
                                    title: "Éxito!",
                                    text: "La carta compromiso ha sido ingresada",
                                    type: "success",
                                    showCancelButton: false,
                                    confirmButtonColor: "#337ab7",
                                    confirmButtonText: "Ok",
                                    closeOnConfirm: true
                                },
                                function() {
                                    document.getElementById("txt_codigo").value=data.trim().substring(3);
                                    document.getElementById("frm_carta_comp").action = ruta + "/Entidad_Externa/Carta_Compromiso/imprime_carta_compromiso.jsp";
                                    document.frm_carta_comp.target="_new";
                                    //alert(document.getElementById("frm_ficha").action);
                                    $("#frm_carta_comp").submit();
                                    //location.reload();
                                    //window.open(ruta + "/Administracion_de_Carrera/Ficha_del_Estudiante/ficha_estudiante.jsp", "_self");
                                });

                            } else {
                                swal("Error", "La carta compromiso no pudo ser ingresada", "error");
                            }
                        }
                    });

                });
            }
        }
    };

    $scope.carga_combo_carreras = function (id_carrera) {
        var ruta = document.getElementById("ruta_principal").value;
        var nombre_est_form=document.getElementById("txt_nombre_estudiante").value ;
        //var fullname = $('#fullname').val();
        var $cmb = $("#cmb_carrera");
        $.ajax({
            type: 'POST',
            dataType: 'json',
            //data: {id_cmb:'carrera'},
            url: ruta + '/F_Muestra_carreras',
            success: function (result) {
                $cmb.find('option').remove();
                //$('#div_carrera').html(result);
                
                $.each(result.items, function (index, article) {
                    if(id_carrera == article.valor){
                        $cmb.append("<option selected value=\"" + article.valor + "\">\n" + article.descripcion +
                                    "</option>");
                    }else{
                        $cmb.append("<option  value=\"" + article.valor + "\">\n" + article.descripcion +
                                    "</option>");
                    }
                });
                if (nombre_est_form == ""){
                    $scope.carga_combo_tipo_actividad();
                }else{
                    
                    var cod_cc=document.getElementById("txt_codigo").value ;
                    var cc_car = document.getElementById("cmb_carrera").value;
                    var num_cc = document.getElementById("txt_numero").value;
                    var id_carrera_ant=cod_cc.substring(9,12);
                    var cod_cc_new="";
                    
                    if (id_carrera_ant == id_carrera){//Si el estudiante seleccionado es de la misma carrera no tengo que cambiar la secuencia
                        cod_cc=cod_cc.substring(0,9);
                        cod_cc_new=cod_cc+cc_car+"-"+num_cc;
                        document.getElementById("txt_codigo").value=cod_cc_new;
                    }else{
                        carga_codigo2();//Carga el codigo de la carta compromiso
                    }
                    
                    
                }
                
                console.log("Se cargo exitosamente el combo carreras");
            }
        });
    };

    $scope.carga_combo_programas = function () {
        var ruta = document.getElementById("ruta_principal").value;
        var $cmb = $("#cmb_programa");
        $.ajax({
            type: 'POST',
            dataType: 'json',
            data: {id_cmb: 'programas'},
            url: ruta + '/F_Muestra_programas',
            success: function (result) {
                $cmb.find('option').remove();
                $.each(result.items, function (index, article) {
                    $cmb.append("<option value=\"" + article.valor + "\">\n" + article.descripcion +
                            "</option>");
                });
                console.log("Se cargo exitosamente el combo programas");
            },
            error: function (result) {
                alert("Ocurrio un error al realizar la carga de programas " + result);
            }
        });
    };

    $scope.carga_combo_horas = function () {
        var ruta = document.getElementById("ruta_principal").value;
        //var fullname = $('#fullname').val();
        var $cmb = $("#cmb_horas");
        //$tabla.find("tr:gt(0)").remove();
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
    $scope.carga_combo_ciclo = function (id_ciclo) {
        var ruta = document.getElementById("ruta_principal").value;
        var $cmb = $("#cmb_ciclos");
        $.ajax({
            type: 'POST',
            dataType: 'json',
            data: {id_cmb: 'ciclos'},
            url: ruta + '/F_Muestra_programas',
            success: function (result) {
                $cmb.find('option').remove();
                $.each(result.items, function (index, article) {
                    if (id_ciclo == article.valor){
                      $cmb.append("<option selected value=\"" + article.valor + "\">\n" + article.descripcion +
                                  "</option>");  
                    }else{
                      $cmb.append("<option  value=\"" + article.valor + "\">\n" + article.descripcion +
                                  "</option>");
                    }
                    
                });
                console.log("Se cargo exitosamente el combo ciclo");
            }
        });
    };
    $scope.carga_combo_tipo_actividad = function () {
        var ruta = document.getElementById("ruta_principal").value;
        var $cmb = $("#cmb_tipo_actividad");
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
                carga_codigo2();//Carga el codigo de la carta compromiso
                console.log("Se cargo exitosamente el combo tipo de actividad");
            }
        });
    };
    $scope.carga_combo_tipo_empr = function () {
        var ruta = document.getElementById("ruta_principal").value;
        var $cmb = $("#cmb_tipo_emp");
        var tipo_accion = window.parent.opener.document.getElementById("tipo_accion").value;
        if(tipo_accion == "I"){
            
            $.ajax({
                type: 'POST',
                dataType: 'json',
                data: {id_cmb: 'tipo_empresa'},
                url: ruta + '/F_Muestra_tipo_empresa',
                success: function (result) {
                    $cmb.find('option').remove();
                    $.each(result.items, function (index, article) {
                        $cmb.append("<option  value=\"" + article.valor + "\">\n" + article.descripcion +
                                "</option>");
                    });
                    console.log("Se cargo exitosamente el combo tipo de actividad");
                }
            });
        }
    };
    
    $(function () {
        $('#datetimepicker6').datetimepicker({
            format: 'L'
        });
        $('#datetimepicker7').datetimepicker({
            useCurrent: false,
            format: 'L'
        });
        $("#datetimepicker6").on("dp.change", function (e) {
            $('#datetimepicker7').data("DateTimePicker").minDate(e.date);
        });
        $("#datetimepicker7").on("dp.change", function (e) {
            $('#datetimepicker6').data("DateTimePicker").maxDate(e.date);
        });
        
    });
    
    $scope.consultar_estudiante = function () {
        var estudiante = document.getElementById("txt_nombre_est_mod").value;
        var cedula = document.getElementById("txt_ced_est_mod").value;
        var ruta = document.getElementById("ruta_principal").value;
        var cont = 0;
        
        $("#btn_aceptar_est").attr('disabled','disabled');
        var $tabla = $("#tbl_estudiante");
        if (estudiante != "" || cedula != ""){
            $tabla.find("tr:gt(0)").remove();
            document.getElementById("existe_estudiante").value = "0";
            $("#div_consulta_est").css("display", "none");
            $("#div_consulta2_est").css("display", "block");
            $.ajax({
                type: 'POST',
                dataType: 'json',
                data: {estudiante: estudiante, cedula_est: cedula},
                url: ruta + '/F_Consulta_EstudianteCC',
                success: function (data) {
                    $.each(data.items, function (index, article) {
                        cont = cont + 1;
                        $tabla.append("<tr>\n" +
                                "<td>" + article.nomb_est + "\n" +
                                "<input type=\"hidden\" name=\"id_est_" + cont + "\" id=\"id_est_" + cont + "\" value=\"" + article.id_est + "\">\n" +
                                "<input type=\"hidden\" name=\"id_ciclo_" + cont + "\" id=\"id_ciclo_" + cont + "\" value=\"" + article.id_ciclo + "\">\n" +
                                "<input type=\"hidden\" name=\"id_carrera_" + cont + "\" id=\"id_carrera_" + cont + "\" value=\"" + article.id_carrera + "\">\n" +
                                "<input type=\"hidden\" name=\"nombre_estudiante_" + cont + "\" id=\"nombre_estudiante_" + cont + "\" value=\"" + article.nomb_est + "\"></td>\n" +
                                "<td>" + article.cedula + "\n" +
                                "<input type=\"hidden\" name=\"cedula_" + cont + "\" id=\"cedula_" + cont + "\" value=\"" + article.cedula + "\"></td>\n" +
                                "<td>" + article.carrera + "\n" +
                                "<input type=\"hidden\" name=\"carrera_" + cont + "\" id=\"carrera_" + cont + "\" value=\"" + article.carrera + "\"></td>\n" +
                                "<td>" + article.ciclo + "\n" +
                                "<input type=\"hidden\" name=\"ciclo_" + cont + "\" id=\"ciclo_" + cont + "\" value=\"" + article.ciclo + "\"></td>\n" +
                                "<td><div name=\"div_inserta_" + cont + "\" id=\"div_inserta_" + cont + "\"><input type = \"radio\" name = \"grupo_est\" id = \"grupo_est\" value = \"" + cont + "\" onclick=\"habilita_btn()\"></div></td>\n" +
                                "</tr>\n");
                        document.getElementById("existe_estudiante").value = "1";
                        //$("#btn_aceptar_est").removeAttr('disabled');
                    });
                    var v = document.getElementById("existe_estudiante").value;

                    if (v == "0") {
                        $("#btn_aceptar_est").attr('disabled','disabled');
                        $tabla.append("<tr><td colspan=\"9\" align=\"center\">No hay datos a mostrar</td></tr>");
                    }
                    $("#div_consulta_est").css("display", "block");
                    $("#div_consulta2_est").css("display", "none");
                }
            });
        }else{
            alert("Favor ingrese el nombre del estudiante o su cédula");
        }
    };
    
    $scope.consultar_empresa = function () {
        var empresa = document.getElementById("txt_nombre_emp").value;
        var ruta = document.getElementById("ruta_principal").value;
        var cont = 0;
        $("#btn_aceptar_emp").attr('disabled','disabled');
        var $tabla = $("#tbl_empresa");
        if (empresa != ""){
            
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
                                "<td><div name=\"div_inserta_" + cont + "\" id=\"div_inserta_" + cont + "\"><input type = \"radio\" name = \"grupo\" id = \"grupo\" value = \"" + cont + "\" onclick=\"habilita_btn()\"></div></td>\n" +
                                "<td><div name=\"div_modificar_" + cont + "\" id=\"div_modificar_" + cont + "\"><img width=\"30px\" height=\"30px\" src=\"../../images/modificar.png\" title=\"Modificar\" onclick=\"carga_datos_empresa(" + cont + ",'M')\"/></div></td> \n" +
                                "</tr>\n");
                        document.getElementById("existe_empresa").value = "1";
                        //$("#btn_aceptar_emp").removeAttr('disabled');
                    });
                    var v = document.getElementById("existe_empresa").value;

                    if (v == "0") {
                        $("#btn_aceptar_emp").attr('disabled','disabled');
                        $tabla.append("<tr><td colspan=\"9\" align=\"center\">No hay datos a mostrar</td></tr>");
                    }
                    $("#div_consulta").css("display", "block");
                    $("#div_consulta2").css("display", "none");
                }
            });
        }else{
            alert("Favor ingrese el nombre de la empresa");
        }   
    };

    $scope.datos_empresa = function () {
        var seleccionado = $("input[name='grupo']:checked").val();
        if (seleccionado) {
            llena_dato_empresa(seleccionado);
        } else {
            alert("No ha seleccionado una Empresa. Favor verifique");
        }
    };
    
    $scope.datos_estudiantes = function () {
        var seleccionado = $("input[name='grupo_est']:checked").val();
        if (seleccionado) {
            $scope.llena_dato_estudiantes(seleccionado);
        } else {
            alert("No ha seleccionado ningun estudiante. Favor verifique");
        }
    };
    $scope.llena_dato_estudiantes= function (seleccionado) {
        var nombre_estudiante = document.getElementById("nombre_estudiante_" + seleccionado).value;
        var id_est = document.getElementById("id_est_" + seleccionado).value;
        var id_ciclo = document.getElementById("id_ciclo_" + seleccionado).value;
        var id_carrera = document.getElementById("id_carrera_" + seleccionado).value;
        var nombre_est_form=document.getElementById("txt_nombre_estudiante").value ;
        
        $scope.carga_combo_ciclo(id_ciclo);
        $scope.carga_combo_carreras(id_carrera);
        if (nombre_est_form == ""){
            $scope.carga_combo_horas();
            $scope.carga_combo_programas();
            $("#div_campos_bloq").css("display", "block");
        }
        
        document.getElementById("txt_nombre_estudiante").value = nombre_estudiante;
        document.getElementById("txt_id_est").value = id_est;
        //$( "div.first" ).slideUp( 300 ).delay( 8000 ).fadeIn( 400 );
        //$( "div.second" ).slideUp( 300 ).fadeIn( 400 );
        
        
    };
    $scope.ventana_ing_empresa = function () {
        var ruta = document.getElementById("ruta_principal").value;
        document.getElementById("tipo_accion").value = "I";
        window.open(ruta + "/Entidad_Externa/Carta_Compromiso/ingresar_empresa.jsp", target = "name", 'top=65, left=450, width=700, height=775,scrollbars=1');
    };
});
function recarga() {
    //location.reload();
    var ruta = document.getElementById("ruta_principal").value;
    window.open(ruta + "/Entidad_Externa/Carta_Compromiso/carta_compromiso.jsp", target="_self");
}
    function controltag(e,valida) {
            tecla = (document.all) ? e.keyCode : e.which; 
            if (tecla==8) return true; // para la tecla de retroseso
            if (tecla==0||tecla==9)  return true; //<-- PARA EL TABULADOR-> su keyCode es 9 pero en tecla se esta transformando a 0 asi que porsiacaso los dos
            if (valida != 1) {
                if (tecla>=1) return false; // para todo lo que se ingrese
                else if (tecla==8) return false; // para la tecla de retroseso
            }
            //else 
            if (tecla==0||tecla==9)  return true;//Habilitamos el tab
            patron =/[0-9\s]/;// -> solo letras
           // patron =/[0-9\s]/;// -> solo numeros
            te = String.fromCharCode(tecla);
            return patron.test(te); 
        }
        
function habilita_btn() {
    $("#btn_aceptar_emp").removeAttr('disabled');
    $("#btn_aceptar_est").removeAttr('disabled');
}

function carga_codigo() {
    var cod_cc=document.getElementById("txt_codigo").value ;
    var cod_cc2=document.getElementById("txt_codigo").value ;
    var ruta = document.getElementById("ruta_principal").value;
    var cc_car = document.getElementById("cmb_carrera").value;
    var cc_act = document.getElementById("cmb_tipo_actividad").value;
    var fecha_suscrip=document.getElementById("txt_lugar_fecha_suscrip").value;

    //alert("cc_car "+cc_car);
    //alert("cc_act "+cc_act);
    if (cod_cc == ""){
        $.ajax({
            type: 'POST',
            dataType: 'json',
            data: {cc_carrera: cc_car, cc_actividad: cc_act},
            url: ruta + '/F_consulta_codigo_cc',
            success: function (result) {
                $("#llenaDato").html("");
                $.each(result.items, function (index, article) {
                    document.getElementById("txt_codigo").value = article.codigo;
                    document.getElementById("txt_numero").value = article.numero;
                    document.getElementById("txt_nombre_deleg_ups").value = article.nombre_delegado;
                    document.getElementById("txt_cargo_deleg_ups").value = article.cargo_delegado;
                    document.getElementById("txt_fono_deleg_ups").value = article.telefono_delegado;
                    document.getElementById("txt_lugar_fecha_suscrip").value = fecha_suscrip+", "+article.fecha;
                });
               carga_combo_tutores();

            }
        });
    }else{
        cod_cc2=cod_cc.substring(9);
        cod_cc=cod_cc.substring(0, 8);
        var cod_cc_new = "CC001."+cc_act+"-"+cod_cc2;
        cod_cc_new=cod_cc_new.replace("--","-");
        document.getElementById("txt_codigo").value=cod_cc_new;
    }
}
//Siempre cargara el codigo desde la base si cambia de estudiante de diferente carrera
function carga_codigo2() {
    //var cod_cc=document.getElementById("txt_codigo").value ;
    //var cod_cc2=document.getElementById("txt_codigo").value ;
    var ruta = document.getElementById("ruta_principal").value;
    var cc_car = document.getElementById("cmb_carrera").value;
    var cc_act = document.getElementById("cmb_tipo_actividad").value;
    var fecha_suscrip=document.getElementById("txt_lugar_fecha_suscrip").value;

    //alert("cc_car "+cc_car);
    //alert("cc_act "+cc_act);
        $.ajax({
            type: 'POST',
            dataType: 'json',
            data: {cc_carrera: cc_car, cc_actividad: cc_act},
            url: ruta + '/F_consulta_codigo_cc',
            success: function (result) {
                $("#llenaDato").html("");
                $.each(result.items, function (index, article) {
                    document.getElementById("txt_codigo").value = article.codigo;
                    document.getElementById("txt_numero").value = article.numero;
                    document.getElementById("txt_nombre_deleg_ups").value = article.nombre_delegado;
                    document.getElementById("txt_cargo_deleg_ups").value = article.cargo_delegado;
                    document.getElementById("txt_fono_deleg_ups").value = article.telefono_delegado;
                    document.getElementById("txt_lugar_fecha_suscrip").value = fecha_suscrip+", "+article.fecha;
                });
               carga_combo_tutores();

            }
        });

}
function llena_dato_empresa(seleccionado) {
    var nombre_empresa = document.getElementById("nombre_empresa_" + seleccionado).value;
    var direccion = document.getElementById("direccion_" + seleccionado).value;
    var telefono = document.getElementById("telefono_" + seleccionado).value;
    var actividad = document.getElementById("actividad_" + seleccionado).value;
    var representante = document.getElementById("representante_" + seleccionado).value;
    var cargo = document.getElementById("cargo_" + seleccionado).value;
    var tele_repre = document.getElementById("tele_repre_" + seleccionado).value;
    var unidad_ext = document.getElementById("ue_id_" + seleccionado).value;
    
    document.getElementById("txt_nombre_empresa").value = nombre_empresa;
    document.getElementById("txt_direccion").value = direccion;
    document.getElementById("txt_telefono").value = telefono;
    document.getElementById("txt_actividad_empresa").value = actividad;
    document.getElementById("txt_nombre_repr_legal").value = representante;
    document.getElementById("txt_cargo_repr_legal").value = cargo;
    document.getElementById("txt_fono_repr_legal").value = tele_repre;
    document.getElementById("id_empresa").value = unidad_ext;

}

function carga_combo_tutores() {
    var ruta = document.getElementById("ruta_principal").value;
    var carrera = document.getElementById("cmb_carrera").value;
    //var carrera = "GIS";
    var $cmb = $("#cmb_tutor");
    $.ajax({
        type: 'POST',
        dataType: 'json',
        data: {carrera: carrera},
        url: ruta + '/F_muestra_tutor',
        success: function (result) {
            $cmb.find('option').remove();
            $.each(result.items, function (index, article) {
                $cmb.append("<option  value=\"" + article.descripcion + "\">\n" + article.valor +
                        "</option>");
            });
            console.log("Se cargo exitosamente el combo carreras");
        }
    });
}

function carga_ingreso_empr(cont) {
    
    var ruta = document.getElementById("ruta_principal").value;
    var nombre_empresa = document.getElementById("txt_nom_empresa_ing").value;
    var direccion = document.getElementById("txt_direccion_ing").value;
    var telefono = document.getElementById("txt_telefono_ing").value;
    var actividad = document.getElementById("txt_actividad_empresa_ing").value;
    var nomb_representante = document.getElementById("txt_nombre_repr_legal_ing").value;
    var apell_representante = document.getElementById("txt_apellido_repr_legal_ing").value;
    var cargo = document.getElementById("txt_cargo_repr_legal_ing").value;
    var tele_repre = document.getElementById("txt_fono_repr_legal_ing").value;
    document.getElementById("accion").value = window.parent.opener.document.getElementById("tipo_accion").value;
    
    if (document.getElementById("accion").value == "M") {
        document.getElementById("id_ue").value =window.parent.opener.document.getElementById("ue_id_" + cont).value;
        document.getElementById("id_ar").value =window.parent.opener.document.getElementById("ar_id_" + cont).value;
    }
    
    if (nombre_empresa == "") {
        swal("Error!", "Favor ingrese el Nombre de la Empresa", "info");
        document.getElementById("txt_nombre_empresa_ing").focus();
    } else if (direccion == "") {
        swal("Error!", "Favor ingrese la Direccion de la Empresa", "info");
        document.getElementById("txt_direccion_ing").focus();
    } else if (telefono == "") {
        swal("Error!", "Favor ingrese el Tel�fono de la Empresa", "info");
        document.getElementById("txt_telefono_ing").focus();
    } else if (actividad == "") {
        swal("Error!", "Favor ingrese la Actividad de la Empresa", "info");
        document.getElementById("txt_actividad_empresa_ing").focus();
    } else if (nomb_representante == "") {
        swal("Error!", "Favor ingrese el Nombre del Representante Legal", "info");
        document.getElementById("txt_nombre_repr_legal_ing").focus();
    } else if (apell_representante == "") {
        swal("Error!", "Favor ingrese el Apellido del Representante Legal", "info");
        document.getElementById("txt_nombre_repr_legal_ing").focus();
    } else if (cargo == "") {
        swal("Error!", "Favor ingrese el Cargo del Representante Legal", "info");
        document.getElementById("txt_cargo_repr_legal_ing").focus();
    } else if (tele_repre == "") {
        swal("Error!", "Favor ingrese el Tel�fono del Representante Legal", "info");
        document.getElementById("txt_fono_repr_legal_ing").focus();
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
        }, function () {
            $.ajax({
                type: 'POST',
                data: $('#frm_empresa_ingreso').serialize(),
                url: ruta + '/F_grabar_empresa',
                success: function (data) {
                    if (data.trim() == "SI") {
                        //swal("Exito!", "La ficha del estudiante ha sido ingresada", "success");
                        swal({
                            title: "Éxito!",
                            text: "La Empresa ha sido ingresada",
                            type: "success",
                            showCancelButton: false,
                            confirmButtonColor: "#337ab7",
                            confirmButtonText: "Ok",
                            closeOnConfirm: false
                        });
                        window.parent.opener.document.getElementById("img_consulta").click();
                        //img_consulta
                        window.close();
                    } else {
                        swal("Error!", "La Empresa no ha sido ingresada", "error");
                    }
                }});
        });
    }
}
function verifica_accion(){
    var id_cc_consul = document.getElementById("id_cc_consulta").value;
    
    if (id_cc_consul != "NADA" && id_cc_consul !=""){
        document.getElementById("accion_form").value = "M";
        carga_datos(id_cc_consul);
        $("#div_campos_bloq").css("display", "block");
    }
    
}

function modif_empr() {
    var tipo_accion = window.parent.opener.document.getElementById("tipo_accion").value;
    var cont = window.parent.opener.document.getElementById("cont").value;
    //alert(tipo_accion);
    
    if (tipo_accion == "M") {
        carga_modificacion(cont);
    }
    //window.parent.opener.document.getElementById("txt_nombre_empresa").value = "si funco";
}
function carga_modifica_empr2() {
    //var tipo_accion = window.parent.opener.document.getElementById("tipo_accion").value;
    var cont = window.parent.opener.document.getElementById("cont").value;
    //alert(tipo_accion);
    
    //if (tipo_accion == "I") {
        //alert("ENTRO ");
        carga_ingreso_empr(cont);
    //}
    //window.parent.opener.document.getElementById("txt_nombre_empresa").value = "si funco";
}
function carga_datos_empresa(cont, accion) {
    var ruta = document.getElementById("ruta_principal").value;
    document.getElementById("tipo_accion").value = accion;
    document.getElementById("cont").value = cont;
    window.open(ruta + "/Entidad_Externa/Carta_Compromiso/ingresar_empresa.jsp", target = "name", 'top=65, left=450, width=700, height=775,scrollbars=1');
}

function carga_modificacion(cont) {
    var ruta = document.getElementById("ruta_principal").value;
    var id_ue = window.parent.opener.document.getElementById("ue_id_" + cont).value;
    var id_ar = window.parent.opener.document.getElementById("ar_id_" + cont).value;
    //alert(cont);
    $.ajax({
        type: 'POST',
        dataType: 'json',
        data: {id_ue: id_ue, id_ar: id_ar},
        url: ruta + '/F_Consulta_Empresa_mod',
        success: function (data) {
            $.each(data.items, function (index, article) {
                //alert(article.nombre_empresa);
                document.getElementById("txt_nom_empresa_ing").value = article.nombre_empresa;
                document.getElementById("txt_direccion_ing").value = article.direccion;
                document.getElementById("txt_telefono_ing").value = article.telefono;
                document.getElementById("txt_actividad_empresa_ing").value = article.actividad;
                //document.getElementById("cmb_tipo_emp").value = article.tipo;
                carga_combo_tipo_empr_sel(article.tipo)
                //falta ingresar el tipo
                document.getElementById("txt_apellido_repr_legal_ing").value = article.apellido;
                document.getElementById("txt_nombre_repr_legal_ing").value = article.nombre;
                document.getElementById("txt_cargo_repr_legal_ing").value = article.cargo;
                document.getElementById("txt_fono_repr_legal_ing").value = article.tele_repre;
                
            });

        }
    });
}
function elimina(cont) {
    var id_cc = document.getElementById("cc_id_" + cont).value;
    var ruta = document.getElementById("ruta_principal").value;
    swal({
        title: "Está segur@?",
        text: "Realmente desea eliminar la Carta del estudiante",
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
            url: ruta + '/F_carta_compromiso.jsp',
            success: function(data) {
                if (data.trim() == "SI") {
                    swal("Éxito", "La carta compromiso ha sido eliminada exitosamente", "success");
                    window.open(ruta + "/Entidad_Externa/Carta_Compromiso/carta_compromiso.jsp", "_self");
                } else {
                    swal("Error", "La carta compromiso no pudo ser eliminada", "error");
                }
            }
        });
    });

}

function imprime(cont) {
    var ruta = document.getElementById("ruta_principal").value;
    var id_cc = document.getElementById("cc_id_" + cont).value;
    document.getElementById("txt_codigo").value = id_cc;
    document.getElementById("frm_cc").action = ruta + "/Entidad_Externa/Carta_Compromiso/imprime_carta_compromiso.jsp";
    document.frm_cc.target = "_new";
    document.frm_cc.submit();
}//FIN imprime
function carga_datos(id_cart_comp) {
    var ruta = document.getElementById("ruta_principal").value;
    //alert(id_cart_comp);
    var id_cc = id_cart_comp.trim();
    var accion = document.getElementById("accion_form").value;
    $.ajax({
        type: 'POST',
        dataType: 'json',
        data: {id_cc: id_cc, accion_form: accion},
        //data: {id_cmb:'carrera'},
        //data: $('#formid').serialize(),
        url: ruta + '/F_muestra_carta_compromiso',
        success: function(data) {

            $.each(data.items, function(index, article) {
                document.getElementById("txt_codigo").value = article.id_cc;
                document.getElementById("txt_numero").value = article.num_cc;
                document.getElementById("txt_nombre_empresa").value = article.empresa;
                document.getElementById("txt_direccion").value = article.emp_dir;
                document.getElementById("txt_telefono").value = article.empresa_fono;
                document.getElementById("txt_actividad_empresa").value = article.act_emp;
                document.getElementById("txt_nombre_estudiante").value = article.est_nombre;
                //document.getElementById("cmb_ciclos").value = article.est_ciclo;
                carga_combo_ciclo_modif(article.est_ciclo);
                //document.getElementById("cmb_tipo_actividad").value = article.tipo_act;//------
                carga_combo_tipo_actividad_modif(article.tipo_act);
                //document.getElementById("cmb_carrera").value = article.est_carrera;
                carga_combo_carreras_modif(article.est_carrera,article.tutor);
                //document.getElementById("cmb_horas").value = article.duracion;//------
                carga_combo_horas_modif(article.duracion);
                document.getElementById("txt_obj_act_academica").value = article.objetivo_act;
                document.getElementById("txt_fecha_ini").value = article.dia_ini + '/' + article.mes_ini + '/' + article.anio_ini;
                document.getElementById("txt_fecha_fin").value = article.dia_fin + '/' + article.mes_fin + '/' + article.anio_fin;
                document.getElementById("txt_horario").value = article.horario;
                //document.getElementById("cmb_programa").value = article.programa;//------------
                carga_combo_programas_modif(article.programa);
                document.getElementById("txt_area_academica").value = article.area_act;
                document.getElementById("txt_respon_area").value = article.resp_area;
                document.getElementById("txt_actividad_1").value = article.act_1;
                document.getElementById("txt_actividad_2").value = article.act_2;
                document.getElementById("txt_actividad_3").value = article.act_3;
                document.getElementById("txt_actividad_4").value = article.act_4;
                document.getElementById("txt_actividad_5").value = article.act_5;
                document.getElementById("txt_actividad_6").value = article.act_6;
                document.getElementById("txt_resultado_1").value = article.res_1;
                document.getElementById("txt_resultado_2").value = article.res_2;
                document.getElementById("txt_resultado_3").value = article.res_3;
                document.getElementById("txt_resultado_4").value = article.res_4;
                document.getElementById("txt_resultado_5").value = article.res_5;
                document.getElementById("txt_resultado_6").value = article.res_6;
                document.getElementById("txt_producto_1").value = article.rec_1;
                document.getElementById("txt_producto_2").value = article.rec_2;
                document.getElementById("txt_producto_3").value = article.rec_3;
                document.getElementById("txt_producto_4").value = article.rec_4;
                document.getElementById("txt_producto_5").value = article.rec_5;
                document.getElementById("txt_producto_6").value = article.rec_6;
                //document.getElementById("cmb_tutor").value = article.tutor;//-----------------
                //carga_combo_tutores_modif(article.tutor);
                document.getElementById("txt_nombre_repr_legal").value = article.emp_rep;
                document.getElementById("txt_cargo_repr_legal").value = article.cargo_rep;
                document.getElementById("txt_fono_repr_legal").value = article.fono_rep;
                document.getElementById("txt_nombre_deleg_ups").value = article.dir_tec;
                document.getElementById("txt_cargo_deleg_ups").value = article.cargo_dir_tec;
                document.getElementById("txt_fono_deleg_ups").value = article.fono_dir_tec;
                document.getElementById("txt_lugar_fecha_suscrip").value = article.suscripcion;
                document.getElementById("id_empresa").value = article.id_empr;
                document.getElementById("txt_id_est").value = article.id_est;
            });
        }
    });
}
function carga_ingreso(cont) {
    var id_cc = document.getElementById("cc_id_" + cont).value;
    document.getElementById("id_cc_consulta").value=id_cc;
    //alert(id_cc);
    var ruta = document.getElementById("ruta_principal").value;
    document.getElementById("frm_datos").action = ruta + "/Entidad_Externa/Carta_Compromiso/ingresar_carta_compromiso.jsp";
    document.getElementById("frm_datos").target = "_self";
    document.frm_datos.submit();
}
function carga_combo_tipo_empr_sel(tipo) {
        var ruta = document.getElementById("ruta_principal").value;
        var $cmb = $("#cmb_tipo_emp");
        $.ajax({
            type: 'POST',
            dataType: 'json',
            data: {id_cmb: 'tipo_empresa'},
            url: ruta + '/F_Muestra_tipo_empresa',
            success: function (result) {
                $cmb.html('');
                $cmb.find('option').remove();
                $.each(result.items, function (index, article) {
                    if (tipo == article.valor){
                      $cmb.append("<option selected value=\"" + article.valor + "\">\n" + article.descripcion +
                            "</option>");  
                    }else{
                      $cmb.append("<option  value=\"" + article.valor + "\">\n" + article.descripcion +
                            "</option>");  
                    }
                    
                });
                console.log("Se cargo exitosamente el combo tipo de actividad");
            }
        });
    };

//Funcion que se cargan cuando es modificacion
function carga_combo_horas_modif(variable){
    var ruta = document.getElementById("ruta_principal").value;
        //var fullname = $('#fullname').val();
        var $cmb = $("#cmb_horas");
        //$tabla.find("tr:gt(0)").remove();
        $.ajax({
            type: 'POST',
            dataType: 'json',
            data: {id_cmb: 'horas'},
            url: ruta + '/F_Muestra_programas',
            success: function (result) {
                $cmb.find('option').remove();
                $.each(result.items, function (index, article) {
                    if (variable == article.descripcion){
                        $cmb.append("<option selected value=\"" + article.valor + "\">\n" + article.descripcion +
                            "</option>");
                    }else{
                        $cmb.append("<option  value=\"" + article.valor + "\">\n" + article.descripcion +
                                "</option>");
                    }
                });
                console.log("Se cargo exitosamente el combo hora");
            }
        });
}
function carga_combo_ciclo_modif(ciclo){
    var ruta = document.getElementById("ruta_principal").value;
        var $cmb = $("#cmb_ciclos");
        $.ajax({
            type: 'POST',
            dataType: 'json',
            data: {id_cmb: 'ciclos'},
            url: ruta + '/F_Muestra_programas',
            success: function (result) {
                $cmb.find('option').remove();
                $.each(result.items, function (index, article) {
                    if (ciclo == article.descripcion){
                      $cmb.append("<option selected value=\"" + article.valor + "\">\n" + article.descripcion +
                                  "</option>");  
                    }else{
                      $cmb.append("<option  value=\"" + article.valor + "\">\n" + article.descripcion +
                                  "</option>");
                    }
                    
                });
                console.log("Se cargo exitosamente el combo ciclo");
            }
        });
}

function carga_combo_tipo_actividad_modif(variable){
    var ruta = document.getElementById("ruta_principal").value;
        var $cmb = $("#cmb_tipo_actividad");
        $.ajax({
            type: 'POST',
            dataType: 'json',
            data: {id_cmb: 'tipo_actividad'},
            url: ruta + '/F_Muestra_programas',
            success: function (result) {
                $cmb.find('option').remove();
                $.each(result.items, function (index, article) {
                    if (variable == article.descripcion){
                        $cmb.append("<option selected value=\"" + article.valor + "\">\n" + article.descripcion +
                                "</option>");
                    }else{
                        $cmb.append("<option value=\"" + article.valor + "\">\n" + article.descripcion +
                                "</option>");
                    }
                });
                //carga_codigo2();//Carga el codigo de la carta compromiso
                console.log("Se cargo exitosamente el combo tipo de actividad");
            }
        });
}
function carga_combo_programas_modif(variable){
    var ruta = document.getElementById("ruta_principal").value;
        var $cmb = $("#cmb_programa");
        $.ajax({
            type: 'POST',
            dataType: 'json',
            data: {id_cmb: 'programas'},
            url: ruta + '/F_Muestra_programas',
            success: function (result) {
                $cmb.find('option').remove();
                $.each(result.items, function (index, article) {
                    if (variable == article.descripcion){
                        $cmb.append("<option selected value=\"" + article.valor + "\">\n" + article.descripcion +
                                "</option>");
                    }else{
                        $cmb.append("<option value=\"" + article.valor + "\">\n" + article.descripcion +
                                "</option>");
                    }
                });
                console.log("Se cargo exitosamente el combo programas");
            },
            error: function (result) {
                alert("Ocurrio un error al realizar la carga de programas " + result);
            }
        });
}
function carga_combo_carreras_modif(variable,tutor){
    var ruta = document.getElementById("ruta_principal").value;
        var nombre_est_form=document.getElementById("txt_nombre_estudiante").value ;
        //var fullname = $('#fullname').val();
        var $cmb = $("#cmb_carrera");
        $.ajax({
            type: 'POST',
            dataType: 'json',
            //data: {id_cmb:'carrera'},
            url: ruta + '/F_Muestra_carreras',
            success: function (result) {
                $cmb.find('option').remove();
                //$('#div_carrera').html(result);
                $.each(result.items, function (index, article) {
                    if(variable == article.descripcion){
                        $cmb.append("<option selected value=\"" + article.valor + "\">\n" + article.descripcion +
                                    "</option>");
                        carga_combo_tutores_modif(tutor);
                    }else{
                        $cmb.append("<option  value=\"" + article.valor + "\">\n" + article.descripcion +
                                    "</option>");
                    }
                });
                
                console.log("Se cargo exitosamente el combo carreras");
            }
        });
}

function carga_combo_tutores_modif(variable) {
    var ruta = document.getElementById("ruta_principal").value;
    var carrera = document.getElementById("cmb_carrera").value;
    //var carrera = "GIS";
    var $cmb = $("#cmb_tutor");
    $.ajax({
        type: 'POST',
        dataType: 'json',
        data: {carrera: carrera},
        url: ruta + '/F_muestra_tutor',
        success: function (result) {
            $cmb.find('option').remove();
            $.each(result.items, function (index, article) {
                if(variable == article.valor){
                   $cmb.append("<option selected value=\"" + article.descripcion + "\">\n" + article.valor +
                        "</option>"); 
                }else{
                    $cmb.append("<option  value=\"" + article.descripcion + "\">\n" + article.valor +
                            "</option>");
                }
            });
            console.log("Se cargo exitosamente el combo carreras");
        }
    });
}



