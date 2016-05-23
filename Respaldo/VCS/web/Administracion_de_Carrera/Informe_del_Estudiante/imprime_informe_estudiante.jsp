<%-- 
    Document   : imprime_peticion_aprobacion
    Created on : 07-ene-2016, 9:25:10
    Author     : lpita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <% String ruta = request.getContextPath(); %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script>
            function genera_pdf()
            {
                var ruta = document.getElementById("ruta_principal").value;
                document.getElementById("frm_imprime").action = ruta + "/F_genera_pdf_informe_estudiante";
                document.frm_imprime.submit();
            }

        </script>
        <title>Informe del Estudiante - Impresion</title>
        <% String id_cc = request.getParameter("txt_id_carta_comp").toString();
            String sede = request.getParameter("txt_sede").toString();
            String universidad = request.getParameter("txt_institucion").toString();%>
    </head>
    <body onload="genera_pdf()">
        <form action="" method="POST" id="frm_imprime" name="frm_imprime">
            <input type="hidden" value="<%=ruta%>" id="ruta_principal" name="ruta_principal" />
            <input type="hidden" value="<%=id_cc%>" id="txt_id_carta_comp" name="txt_id_carta_comp" />
            <input type="hidden" value="<%=universidad%>" id="txt_institucion" name="txt_institucion" />
            <input type="hidden" value="<%=sede%>" id="txt_sede" name="txt_sede" />
        </form>
    </body>
</html>
