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

    /*$scope.insertaprueba=function() {
     $http.post("vistas/blank.jsp",{'txt_nombre_empresa':$scope.txt_nombre_empresa})
     .success(function(data,status,headers,config){
     console.log("data inserted successfull"); 
     });
     };*/

});

function carga_iconos(){
var ruta = document.getElementById("ruta_principal").value;
        var id_modulo_padre = document.getElementById("id_modulo_padre").value;
        var contador=0;
        var pag_modulo_ant="";
        var ruta_icono_ant="";
        var nombre_modulo_ant="";
        var total_menus=0;
        var recorre_menus=0;
        var recorre_menu2=0;
        var $tabla = $("#tbl_iconos");
        $tabla.find("tr:gt(0)").remove();
        
        $.ajax({
            type: 'POST',
            data: {txt_id_modulo_padre: id_modulo_padre},
            //data: {id_cmb:'carrera'},
            //data: $('#formid').serialize(),
            url: ruta + '/F_devuelve_total_menus',
            success: function(data) {
                total_menus=parseInt(data);
                
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
                                contador=contador+1;
                                recorre_menu2=recorre_menu2+1;
                                
                                if (contador == 1){
                                  pag_modulo_ant=article.pagina_modulo;
                                  ruta_icono_ant=article.icono_modulo;
                                  nombre_modulo_ant=article.nombre_modulo;  
                                }

                                if (contador > 1){
                                    recorre_menus=recorre_menus+2;
                                    contador=0;
                                    $tabla.append("<tr>\n"+
                                            "<td>" + "<a  href=\"" + pag_modulo_ant + "\">" +
                                            " <img width=\"150px\" height=\"150px\" class=\"img-circle\" src=\"" + ruta_icono_ant + "\"/> </a>"+ "</td>\n" +
                                            "<td>" + " <br><br><br><a  href=\"" + pag_modulo_ant + "\">" +nombre_modulo_ant+ "</td>\n" +
                                            "<td>" + "<a  href=\"" + article.pagina_modulo + "\">" +
                                            " <img width=\"150px\" height=\"150px\" class=\"img-circle\" src=\"" + article.icono_modulo + "\"/> </a>"+ "</td>\n" +
                                            "<td>" + " <br><br><br><a  href=\"" + article.pagina_modulo + "\">" +article.nombre_modulo+ "</td>\n" +
                                           "</tr>");
                                /*$("#ajaxIconos").append("<a  href=\"" + article.pagina_modulo + "\">" +
                                        " <img width=\"150px\" height=\"150px\" class=\"img-circle\" src=\"" + article.icono_modulo + "\"/> " +
                                        article.nombre_modulo + "</a>");*/
                                }
                                
                                if ((total_menus - 1) == recorre_menus && recorre_menu2 == total_menus ){
                                    $tabla.append("<tr>\n"+
                                            "<td>" + "<a  href=\"" + article.pagina_modulo + "\">" +
                                            " <img width=\"150px\" height=\"150px\" class=\"img-circle\" src=\"" + article.icono_modulo + "\"/> </a>"+ "</td>\n" +
                                            "<td>" + "<br><br><br> <a  href=\"" + article.pagina_modulo + "\">" +article.nombre_modulo+ "</td>\n" +
                                            "<td>" + "</td>\n" +
                                            "<td>" + "</td>\n" +
                                           "</tr>");
                                }


                            }
                        });
                    }
                });
            }
        });
        
        //alert(total_menus);
        
        //var fullname = $('#fullname').val();
        
}