<%-- 
    Document   : cabecera_pagina
    Created on : 10/01/2016, 04:15:31 PM
    Author     : Geovanny Barrera
--%>
<%  HttpSession sesion = request.getSession(true);
    String nombres = (String) session.getAttribute("nombre_usuario");
    String apellidos = (String) session.getAttribute("apellido_usuario");
%>
<div class="col-md-12">
    <div class="row">
    <div class="col-md-4"><image src="/VCS/images/Logo_UPS.png" width="70%"  /></div>
    <div class="col-md-8"><div class="titulos">Sistema para la Gestion VCS</div></div>
    </div>
    <fieldset style="border:1px solid #2e6da4;background:#337ab7;">
        
        <ul class="nav nav-pills nav-stacked alineado" >
            <li class="dropdown alineado active">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"> <%= nombres + " " + apellidos%>&nbsp;&nbsp;<b class="caret"></b>
                </a>
                <ul class="dropdown-menu alineado1 btn-warning">
                    <li class="btn-warning"><a href="/VCS/Login/cambia_clave.jsp" class="glyphicon glyphicon-play">&nbsp;&nbsp;Cambiar clave&nbsp;</a>
                    </li>
                    <li class="btn-warning"><a href="/VCS/Login/logout.jsp" class="glyphicon glyphicon-off">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Salir&nbsp;</a></li>
                </ul>
            </li>
        </ul>
    </fieldset>
                
</div>