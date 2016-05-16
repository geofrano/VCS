<%-- 
    Document   : Imprime la Carta Compromiso
    Created on : 07-feb-2016, 11:25:10
    Author     : lpita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <% String ruta=request.getContextPath(); %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ficha del Estudiante - Impresion</title>
        <% String id_cc = request.getParameter("txt_codigo").toString();%>
        <script>
            function imprime()
            {
                window.opener.recarga();
                var ruta=document.getElementById("ruta_principal").value; 
                document.getElementById("frm_imprime").action=ruta+"/F_genera_pdf_carta_compromiso";
                document.frm_imprime.submit();
            }
        </script>
    </head>
    <body onload="imprime()">
        <form action="" method="POST" id="frm_imprime" name="frm_imprime">
            <input type="text" value="<%=ruta%>" id="ruta_principal" name="ruta_principal" />
            <input type="text" value="CC001.PA-GIS-10" id="txt_id_carta_comp" name="txt_id_carta_comp" />
        </form>
    </body>
</html>
