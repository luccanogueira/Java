<%@page import="br.academico.DAO.CursoDAO"%>
<%@page import="br.academico.pojo.Curso"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório de cursos</title>
    </head>
    <body>
        <jsp:include page="../menu.jsp"/>
        <%
            CursoDAO cDAO = new CursoDAO();
            ArrayList<Curso> cursos = cDAO.getTodosCursos();
        %>
        <br/><br/>
        <div class="table-responsive-md" style="width: 90%; margin: 0 auto !important;">
            <table class="table justify-content-center">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Curso</th>
                        <th scope="col">Tipo de Curso</th>
                        <th scope="col">Editar</th>
                        <th scope="col">Excluir</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for(Curso c: cursos){
                    %>
                    <tr>
                        <td><%=c.getNomeCurso()%></td>
                        <td><%=c.getTipoCurso()%></td>
                        <td><a href="../cadastros/cadCurso.jsp?idCurso=<%=c.getIdCurso()%>" type="button" class="btn btn-primary">Editar</a></td>
                        <td><a href="#" type="button" class="btn btn-danger">Excluir</a></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
