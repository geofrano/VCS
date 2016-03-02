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
        var cc_act = 'PA';*/
        /*$.ajax({
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
        //var fullname = $('#fullname').val();
        /*$.ajax({
         type: 'POST',
         //data: {id_cmb:'carrera'},
         url: ruta + '/F_carta_compromiso_busca.jsp',
         success: function(result) {
         $('#icono').html(result);
         }
         });*/
    };

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
                            /*"<td><div style=\"display:none\" name=\"div_inserta_" + cont + "\" id=\"div_inserta_" + cont + "\"><input type = \"radio\" name = \"group1\" id = \"group1\" value = \"" + article.id_cc + "\" ></div></td>\n" +
                            "<td class=\"alineado3\">" +
                            "<div style=\"display:none\" name=\"div_modificar_" + cont + "\" id=\"div_modificar_" + cont + "\"><img width=\"30px\" height=\"30px\" src=\"../../images/modificar.png\" title=\"Modificar\" onclick=\"carga_ingreso(" + cont + ")\"/></div>" +
                            "</td>\n" +
                            "<td class=\"alineado3\">" +
                            "<div style=\"display:none\" name=\"div_eliminar_" + cont + "\" id=\"div_eliminar_" + cont + "\"><img width=\"20px\" height=\"10px\" src=\"../../images/eliminar.jpg\" title=\"Eliminar\" onclick=\"carga_ingreso(" + cont + ")\"/>" +
                            "</td>\n" +*/
                            "<td class=\"alineado3\"><img width=\"20px\" height=\"20px\" title=\"Modificar\" src=\"../../images/icono_modifica.png\"/></td>\n"+
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

    $scope.carreras_grado = [
        {id: 1, name: 'Ingenieria de Sistemas'},
        {id: 2, name: 'Ingenieria de Administracion'},
        {id: 3, name: 'Ingenieria de Contabilidad'}
    ];
    $scope.prueba = function () {
        $scope.carrera = $scope.carrera_grado.carreras_grado;
        var prueba = document.getElementById("carrera_selected").value;
        $scope.muestra_carrera = true;
        alert(prueba);
    };
    $scope.carga_combo_carrera = function () {
        var ruta = document.getElementById("ruta_principal").value;
        //var fullname = $('#fullname').val();
        $.ajax({
            type: 'POST',
            //data: {id_cmb:'carrera'},
            url: ruta + '/F_Muestra_carreras',
            success: function (result) {
                $('#div_carrera').html(result);
            }
        });
    };

    $scope.carga_combo_programas = function () {
        var ruta = document.getElementById("ruta_principal").value;
        //var fullname = $('#fullname').val();
        $.ajax({
            type: 'POST',
            data: {id_cmb: 'programas'},
            url: ruta + '/F_Muestra_programas',
            success: function (result) {
                $('#div_programas').html(result);
            }
        });
    };

    $scope.carga_combo_horas = function () {
        var ruta = document.getElementById("ruta_principal").value;
        //var fullname = $('#fullname').val();
        $.ajax({
            type: 'POST',
            data: {id_cmb: 'horas'},
            url: ruta + '/F_Muestra_programas',
            success: function (result) {
                $('#div_horas').html(result);
            }
        });
    };
    $scope.carga_combo_ciclo = function () {
        var ruta = document.getElementById("ruta_principal").value;
        //var fullname = $('#fullname').val();
        $.ajax({
            type: 'POST',
            data: {id_cmb: 'ciclos'},
            url: ruta + '/F_Muestra_programas',
            success: function (result) {
                $('#div_ciclos').html(result);
            }
        });
    };
    $scope.carga_combo_tipo_actividad = function () {
        var ruta = document.getElementById("ruta_principal").value;
        //var fullname = $('#fullname').val();
        $.ajax({
            type: 'POST',
            data: {id_cmb: 'tipo_actividad'},
            url: ruta + '/F_Muestra_programas',
            success: function (result) {
                $('#div_tipo_actividad').html(result);
            }
        });
    };

    $(function() {
        $('#datetimepicker6').datetimepicker();
        $('#datetimepicker7').datetimepicker({
            useCurrent: false
        });
        $("#datetimepicker6").on("dp.change", function(e) {
            $('#datetimepicker7').data("DateTimePicker").minDate(e.date);
        });
        $("#datetimepicker7").on("dp.change", function(e) {
            $('#datetimepicker6').data("DateTimePicker").maxDate(e.date);
        });
    });
    /*$scope.insertaprueba=function() {
     $http.post("vistas/blank.jsp",{'txt_nombre_empresa':$scope.txt_nombre_empresa})
     .success(function(data,status,headers,config){
     console.log("data inserted successfull"); 
     });
     };*/

});

function al_cambiar(){
    alert("QUE ES QUE LE PASA A MARIA");
}


