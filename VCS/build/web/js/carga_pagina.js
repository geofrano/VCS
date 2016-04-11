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

                    /*<ul class="nav nav-pills">
                     <li class="active">
                     <a href="#">Home</a>
                     </li>
                     <li><a href="#">...</a></li>
                     <li><a href="#">...</a></li>
                     </ul>*/


                    if (article.id_modulo_padre == id_modulo_padre) {

                        $("#ajaxIconos").append("<a  href=\"" + article.pagina_modulo + "\">" +
                                " <img width=\"150px\" height=\"150px\" class=\"img-circle\" src=\"" + article.icono_modulo + "\"/> " +
                                article.nombre_modulo + "</a>");

                    }
                });
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

    
    $scope.llama_pagina_hija = function(tipo_accion) {
        alert(tipo_accion);
        if (tipo_accion == "ingresar") {
            
        } else if (tipo_accion == "modificar") {

        } else if (tipo_accion == "eliminar") {

        }

    };
    /*$scope.insertaprueba=function() {
     $http.post("vistas/blank.jsp",{'txt_nombre_empresa':$scope.txt_nombre_empresa})
     .success(function(data,status,headers,config){
     console.log("data inserted successfull"); 
     });
     };*/

});


