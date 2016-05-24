/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
 
 function valida(){
 
 var ruta=document.getElementById("ruta_principal").value; 
 var usuario=document.getElementById("txt_usuario").value;
 var clave=document.getElementById("txt_clave").value;
 
 
 if (usuario == ""){
 alert("El campo usuario no puede estar vacío");
 return;
 }
 if (clave == ""){
 alert("El campo contraseña no puede estar vacío");
 return;
 }
 document.getElementById("frm_login").action=ruta+"/F_autenticar_usuario.jsp";
 
 } */
/*USANDO EL FRAMEWORK ANGULARJS*/
var app = angular.module("VCS", []);
app.controller("ControladorLogin", function($scope) {
    $scope.institucion = "Universidad Politecnica Salesiana";
    $scope.submitted = false;
    $scope.valida = function() {
        var ruta = document.getElementById("ruta_principal").value;
        $scope.user = {};
        document.getElementById("frm_login").action = ruta + "/F_autenticar_usuario.jsp";
        $scope.submitted = true;
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
    
});
function logout() {
        var ruta = "/VCS";
        window.open(ruta + "/FLogout","_self");
}
window.onload=function(){
   var ruta = "/VCS";
   var usuario_sesion = document.getElementById("usuario_sesion").value;
   
   if (usuario_sesion != ""){
       window.open(ruta+"/Home.jsp");
   }
   
//   window.location.hash="no-back-button";
//
//   window.location.hash="Again-No-back-button"; //chrome
//
//   window.onhashchange=function(){window.location.hash="no-back-button";};
};

function cambia_clave() {
    var ruta = document.getElementById("ruta_principal").value;
    var clave = document.getElementById("txt_new_clave").value;
    var clave2 = document.getElementById("txt_new_clave2").value;

    if (clave == "") {
        swal("Error!", "Favor ingrese su nueva clave.", "info");
        document.getElementById("txt_new_clave").focus();
    } else if (clave2 == "") {
        swal("Error!", "Favor ingrese su ingrese nuevamente clave.", "info");
        document.getElementById("txt_new_clave2").focus();
    } else if (clave != clave2) {
        swal("Error!", "La clave ingresada no coincide con lo reingresado. Favor verifique", "info");
        document.getElementById("txt_new_clave").focus();
    }else {
        swal({
            title: "Está segur@?",
            text: "Favor confirme que la clave ingresada es la correcta.",
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
                data: {clave: clave},
                url: ruta + '/F_cambia_clave',
                success: function(data) {
                    if (data.trim() == "SI") {
                        //swal("Exito!", "La ficha del estudiante ha sido ingresada", "success");
                        swal({
                            title: "Éxito!",
                            text: "Se cambió la contraseña exitosamente.",
                            type: "success",
                            showCancelButton: false,
                            confirmButtonColor: "#337ab7",
                            confirmButtonText: "Ok",
                            closeOnConfirm: false
                        });
                        document.getElementById("txt_new_clave").value="";
                        document.getElementById("txt_new_clave2").value="";
                    } else {
                        swal("Error", "Hubo un problema y su clave no pudo ser actualizada", "error");
                    }
                }
            });

        });

    }
}//FIN GRABA