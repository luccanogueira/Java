<%-- 
    Document   : sucesso
    Created on : 04/06/2020, 09:34:26
    Author     : thiagograzianitraue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sucesso</title>
    </head>
    <body>
        <jsp:include page="../menu.jsp"/>
        <br/><br/><br/>
        <%
            String itemCadastrado = "";
            if(request.getParameter("itemCadastrado") != null)
                itemCadastrado = request.getParameter("itemCadastrado");
                
        %>
        <div style="width: 90%; margin: 0 auto !important; text-align: center;">
            <p><%=itemCadastrado%> foi cadastrado com sucesso! =)</p>
        </div>
    </body>
</html>
