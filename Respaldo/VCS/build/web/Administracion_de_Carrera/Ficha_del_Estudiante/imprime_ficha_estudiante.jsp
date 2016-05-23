<%-- 
    Document   : Imprime el pdf de la ficha del estudiante
    Created on : 07-ene-2016, 9:25:10
    Author     : gbarrera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <% String ruta=request.getContextPath(); %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ficha del Estudiante - Impresion</title>
        <% String id_cc = request.getParameter("txt_id_carta_comp").toString();%>
        <script>
            function imprime()
            {
                window.opener.recarga();
                var ruta=document.getElementById("ruta_principal").value; 
                document.getElementById("frm_imprime").action=ruta+"/F_genera_pdf_ficha_estudiante";
                document.frm_imprime.submit();
            }
        </script>
    </head>
    <body onload="imprime()">
        <form action="" method="POST" id="frm_imprime" name="frm_imprime">
            <input type="hidden" value="<%=ruta%>" id="ruta_principal" name="ruta_principal" />
            <input type="hidden" value="<%=id_cc%>" id="txt_id_carta_comp" name="txt_id_carta_comp" />
        </form>
    </body>
</html>
