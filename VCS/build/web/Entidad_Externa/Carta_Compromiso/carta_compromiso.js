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

    $scope.carga_ingreso = function () {
        var ruta = document.getElementById("ruta_principal").value;
        window.open(ruta + "/Entidad_Externa/Carta_Compromiso/ingresar_carta_compromiso.jsp", target = "_self");
        //var fullname = $('#fullname').val();
        /*$.ajax({
         type: 'POST',
         //data: {id_cmb:'carrera'},
         url: ruta + '/F_carta_compromiso_ing.jsp',
         success: function(result) {
         $('#icono').html(result);
         }
         });*/
    };

    /*$scope.llena_datos = function () {
     var ruta = document.getElementById("ruta_principal").value;
     document.getElementById("txt_codigo").value = "";
     document.getElementById("txt_numero").value = "";
     var cc_car = document.getElementById("cmb_carrera").value;
     var cc_act = document.getElementById("cmb_tipo_actividad").value;
     alert("Carrera: "+cc_car);
     alert("Actividad: "+cc_act);
     /*var cc_car = 'GIS';
     var cc_act = 'PA';
     $.ajax({
     type: 'POST',
     dataType: 'json',
     data: {cc_carrera: cc_car,cc_actividad: cc_act},
     url: ruta + '/F_consulta_codigo_cc',
     success: function (result) {
     $("#llenaDato").html("");
     $.each(result.items, function(index, article) {
     document.getElementById("txt_codigo").value = article.codigo;
     document.getElementById("txt_numero").value = article.numero;
     });
     }
     });
     };*/

    $scope.carga_busca_cc = function () {
        var ruta = document.getElementById("ruta_principal").value;
        window.open(ruta + "/Entidad_Externa/Carta_Compromiso/consultar_carta_compromiso.jsp", target = "_self");
    };

    $scope.consultar_estudiante = function () {
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
            url: ruta + '/F_Consulta_Estudiante',
            success: function (data) {
                $("#div_datos").html("");

                $.each(data.items, function (index, article) {
                    cont = cont + 1;
                    $tabla.append("<tr><td><input type=\"hidden\" name=\"cc_id_" + cont + "\" id=\"cc_id_" + cont + "\" value=\"" + article.id_cc + "\">" + article.id_cc + "</td>\n" +
                            "<td>" + article.cc_tipo_act + "</td>\n" +
                            "<td colspan=\"2\">" + article.nomb_est + "</td>\n" +
                            //"<td>" + article.emp_nombre + "</td>\n" +
                            "<td>" + article.lugar_suscrip + "</td>\n" +
                            "<td>" + article.fecha_suscrip + "</td>\n" +
                            /*"<td><div style=\"display:none\" name=\"div_inserta_" + cont + "\" id=\"div_inserta_" + cont + "\"><input type = \"radio\" name = \"group1\" id = \"group1\" value = \"" + article.id_cc + "\" ></div></td>\n" +
                             "<td class=\"alineado3\">" +
                             "<div style=\"display:none\" name=\"div_modificar_" + cont + "\" id=\"div_modificar_" + cont + "\"><img width=\"30px\" height=\"30px\" src=\"../../images/modificar.png\" title=\"Modificar\" onclick=\"carga_ingreso(" + cont + ")\"/></div>" +
                             "</td>\n" +
                             "<td class=\"alineado3\">" +
                             "<div style=\"display:none\" name=\"div_eliminar_" + cont + "\" id=\"div_eliminar_" + cont + "\"><img width=\"20px\" height=\"10px\" src=\"../../images/eliminar.jpg\" title=\"Eliminar\" onclick=\"carga_ingreso(" + cont + ")\"/>" +
                             "</td>\n" +*/
                            "<td class=\"alineado3\"><img width=\"20px\" height=\"20px\" title=\"Modificar\" src=\"../../images/icono_modifica.png\"/></td>\n" +
                            "<td class=\"alineado3\"><img width=\"20px\" height=\"20px\" title=\"Eliminar\" src=\"../../images/eliminar.jpg\"/></td></tr>\n");

                    if (article.cc_estado.trim() == "A") {
                        $("#" + "div_eliminar_" + cont).css("display", "none");
                        $("#" + "div_modificar_" + cont).css("display", "none");
                        $("#" + "div_inserta_" + cont).css("display", "block");
                    }
                    if (article.cc_estado.trim() == "5") {
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

    $scope.guarda_carta_comp = function () {
        var ruta = document.getElementById("ruta_principal").value;
        $scope.user = {};
        document.getElementById("frm_carta_comp").action = ruta + "/F_carta_compromiso.jsp";
        document.frm_carta_comp.submit();
        $scope.submitted = true;
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
                    var cod_cc_new="";
                    
                    cod_cc=cod_cc.substring(0,9);
                    cod_cc_new=cod_cc+cc_car+"-"+num_cc;
                    
                    document.getElementById("txt_codigo").value=cod_cc_new;
                    
                }
                
                console.log("Se cargo exitosamente el combo carreras");
            }
        });
        carga_combo_tutor();
    };

    /*$scope.carga_combo_tutor = function () {
     var ruta = document.getElementById("ruta_principal").value;
     var carrera = document.getElementById("cmb_carrera").value;
     //var carrera = "GIS";
     var $cmb = $("#cmb_tutor");
     $.ajax({
     type: 'POST',
     dataType: 'json',
     data: {carrera:carrera},
     url: ruta + '/F_Muestra_tutores',
     success: function (result) {
     $cmb.find('option').remove();
     $.each(result.items, function (index, article) {
     $cmb.append("<option  value=\"" + article.valor + "\">\n" + article.descripcion +
     "</option>");
     });
     console.log("Se cargo exitosamente el combo carreras");
     }
     });
     };*/

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
                carga_codigo();//Carga el codigo de la carta compromiso
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
        $('#datetimepicker6').datetimepicker();
        $('#datetimepicker7').datetimepicker({
            useCurrent: false
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
        var ruta = document.getElementById("ruta_principal").value;
        var cont = 0;
        $("#btn_aceptar_est").attr('disabled','disabled');
        var $tabla = $("#tbl_estudiante");
        $tabla.find("tr:gt(0)").remove();
        document.getElementById("existe_estudiante").value = "0";
        $("#div_consulta_est").css("display", "none");
        $("#div_consulta2_est").css("display", "block");
        $.ajax({
            type: 'POST',
            dataType: 'json',
            data: {estudiante: estudiante},
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
    };
    
    $scope.consultar_empresa = function () {
        var empresa = document.getElementById("txt_nombre_emp").value;
        var ruta = document.getElementById("ruta_principal").value;
        var cont = 0;
        $("#btn_aceptar_emp").attr('disabled','disabled');
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
function habilita_btn() {
    $("#btn_aceptar_emp").removeAttr('disabled');
    $("#btn_aceptar_est").removeAttr('disabled');
}

function carga_codigo() {
    //alert("asda");
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
            }
        });
    }else{
        cod_cc2=cod_cc.substring(9);
        cod_cc=cod_cc.substring(0, 8);
        var cod_cc_new = "CC001."+cc_act+"-"+cod_cc2
        document.getElementById("txt_codigo").value=cod_cc_new;
    }
}

function llena_dato_empresa(seleccionado) {
    var nombre_empresa = document.getElementById("nombre_empresa_" + seleccionado).value;
    var direccion = document.getElementById("direccion_" + seleccionado).value;
    var telefono = document.getElementById("telefono_" + seleccionado).value;
    var actividad = document.getElementById("actividad_" + seleccionado).value;
    var representante = document.getElementById("representante_" + seleccionado).value;
    var cargo = document.getElementById("cargo_" + seleccionado).value;
    var tele_repre = document.getElementById("tele_repre_" + seleccionado).value;

    document.getElementById("txt_nombre_empresa").value = nombre_empresa;
    document.getElementById("txt_direccion").value = direccion;
    document.getElementById("txt_telefono").value = telefono;
    document.getElementById("txt_actividad_empresa").value = actividad;
    document.getElementById("txt_nombre_repr_legal").value = representante;
    document.getElementById("txt_cargo_repr_legal").value = cargo;
    document.getElementById("txt_fono_repr_legal").value = tele_repre;
}

function carga_combo_tutor() {
    var ruta = document.getElementById("ruta_principal").value;
    var carrera = document.getElementById("cmb_carrera").value;
    //var carrera = "GIS";
    var $cmb = $("#cmb_tutor");
    $.ajax({
        type: 'POST',
        dataType: 'json',
        data: {carrera: carrera},
        url: ruta + '/F_Muestra_tutores',
        success: function (result) {
            $cmb.find('option').remove();
            $.each(result.items, function (index, article) {
                $cmb.append("<option  value=\"" + article.valor + "\">\n" + article.descripcion +
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
            title: "Est� segur@?",
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
                    //alert(data);
                    if (data.trim() == "SI") {
                        //swal("Exito!", "La ficha del estudiante ha sido ingresada", "success");
                        swal({
                            title: "Exito!",
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
    var tipo_accion = window.parent.opener.document.getElementById("tipo_accion").value;
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