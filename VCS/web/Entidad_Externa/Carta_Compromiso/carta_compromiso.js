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
                    $("#ajaxIconos").append("");
                    if (article.id_modulo_padre == id_modulo_padre) {
                        $("#ajaxIconos").append("<a  href=\"" + article.pagina_modulo + "\">" +
                                " <img width=\"150px\" height=\"150px\" class=\"img-circle\" src=\"" + article.icono_modulo + "\"/> " +
                                "<p>"+article.nombre_modulo +"</p>"+ "</a>");
                    }
                });
            }
        });
    };
    
    $scope.carga_ingreso = function() {
        var ruta = document.getElementById("ruta_principal").value;
        window.open(ruta + "/Administracion_de_Carrera/Carta_Compromiso/ingresar_carta_compromiso.jsp", target="_self");
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
    
    $scope.llena_datos = function () {
        var ruta = document.getElementById("ruta_principal").value;
        $.ajax({
            type: 'POST',
            url: ruta + '/F_consulta_codigo_cc',
            success: function(result) {
                $("#llenaDato").html(result);
            }
        });
    };
    
    $scope.carga_busca_cc = function() {
        var ruta = document.getElementById("ruta_principal").value;
        window.open(ruta + "/Administracion_de_Carrera/Carta_Compromiso/consultar_carta_compromiso.jsp", target="_self");
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
        //alert(ruta);
        $.ajax({
            type: 'POST',
            data: {id_est: estudiante},
            url: ruta + '/F_Consulta_Estudiante',
            success: function(result) {
                $('#div_datos').html(result);
            }
        });
    };
    
    $scope.guarda_carta_comp = function() {
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
    $scope.prueba = function() {
        $scope.carrera = $scope.carrera_grado.carreras_grado;
        var prueba = document.getElementById("carrera_selected").value;
        $scope.muestra_carrera = true;
        alert(prueba);
    };
    $scope.carga_combo_carrera = function() {
        var ruta = document.getElementById("ruta_principal").value;
        //var fullname = $('#fullname').val();
        $.ajax({
            type: 'POST',
            //data: {id_cmb:'carrera'},
            url: ruta + '/F_Muestra_carreras',
            success: function(result) {
                $('#div_carrera').html(result);
            }
        });
    };

    $scope.carga_combo_programas = function() {
        var ruta = document.getElementById("ruta_principal").value;
        //var fullname = $('#fullname').val();
        $.ajax({
            type: 'POST',
            data: {id_cmb: 'programas'},
            url: ruta + '/F_Muestra_programas',
            success: function(result) {
                $('#div_programas').html(result);
            }
        });
    };

    $scope.carga_combo_horas = function() {
        var ruta = document.getElementById("ruta_principal").value;
        //var fullname = $('#fullname').val();
        $.ajax({
            type: 'POST',
            data: {id_cmb: 'horas'},
            url: ruta + '/F_Muestra_programas',
            success: function(result) {
                $('#div_horas').html(result);
            }
        });
    };
    $scope.carga_combo_ciclo = function() {
        var ruta = document.getElementById("ruta_principal").value;
        //var fullname = $('#fullname').val();
        $.ajax({
            type: 'POST',
            data: {id_cmb: 'ciclos'},
            url: ruta + '/F_Muestra_programas',
            success: function(result) {
                $('#div_ciclos').html(result);
            }
        });
    };
    $scope.carga_combo_tipo_actividad = function() {
        var ruta = document.getElementById("ruta_principal").value;
        //var fullname = $('#fullname').val();
        $.ajax({
            type: 'POST',
            data: {id_cmb: 'tipo_actividad'},
            url: ruta + '/F_Muestra_programas',
            success: function(result) {
                $('#div_tipo_actividad').html(result);
            }
        });
    };


    /*$scope.insertaprueba=function() {
     $http.post("vistas/blank.jsp",{'txt_nombre_empresa':$scope.txt_nombre_empresa})
     .success(function(data,status,headers,config){
     console.log("data inserted successfull"); 
     });
     };*/

});


