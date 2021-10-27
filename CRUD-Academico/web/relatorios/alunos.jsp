<%@page import="br.academico.pojo.Aluno"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.academico.DAO.AlunoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório de alunos</title>
    </head>
    <body>
        <jsp:include page="../menu.jsp"/>
        <%
            AlunoDAO aDAO = new AlunoDAO();
            ArrayList<Aluno> alunos = aDAO.getTodos();
        %>
        <br/><br/>
        <div class="table-responsive-md" style="width: 90%; margin: 0 auto !important">
            <table class="table justify-content-center">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">RA</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Curso</th>
                        <th scope="col">Tipo de Curso</th>
                        <th scope="col">Editar</th>
                        <th scope="col">Excluir</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for(Aluno a: alunos){
                    %>
                    <tr>
                        <td><%=a.getRa()%></td>
                        <td><%=a.getNome()%></td>
                        <td><%=a.getCurso().getNomeCurso()%></td>
                        <td><%=a.getCurso().getTipoCurso()%></td>
                        <td><a href="#" class="btn btn-primary">Editar</a></td>
                        <td><a href="#" class="btn btn-danger">Excluir</a></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
