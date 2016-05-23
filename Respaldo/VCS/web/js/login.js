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