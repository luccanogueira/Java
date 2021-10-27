<%@page import="java.util.ArrayList"%>
<%@page import="br.academico.pojo.Curso"%>
<%@page import="br.academico.DAO.CursoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de aluno</title>
    </head>
    <body>
        <jsp:include page="../menu.jsp"/>
        <br/><br/>

        <%
            CursoDAO cDAO = new CursoDAO();
            ArrayList<Curso> cursos = cDAO.getTodosCursos();
        %>


        <div style="width: 40%; margin: 0 auto !important;">
            <form method="post" action="../alunoController">
                <div class="form-group">
                    <label>RA:</label>
                    <input class="form-control" type="text" name="raAluno" placeholder="Insira o RA do aluno"/>
                </div>
                <div class="form-group" style="padding-top: 20px">
                    <label>Nome completo do aluno:</label>
                    <input class="form-control" type="text" name="nomeAluno" placeholder="Insira o nome completo do aluno"/>
                </div>
                <div class="form-group" style="padding-top: 20px">
                    <label>Selecione o curso para este aluno:</label>
                    <select name="idCurso" class="form-control">
                        <% for (Curso c : cursos) {%>
                        <option value="<%=c.getIdCurso()%>"><%=c.getNomeCurso()%></option>
                        <% }%>
                    </select>
                </div>
                <div class="form-group" style="padding-top: 20px">
                    <input type="hidden" name="tipoAcao" value="cadastro"/>
                    <input type="submit" class="btn btn-success col-12" value="Cadastrar"/>
                </div>
            </form>
        </div>
    </body>
</html>
