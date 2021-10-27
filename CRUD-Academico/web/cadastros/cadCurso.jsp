<%@page import="br.academico.DAO.CursoDAO"%>
<%@page import="br.academico.pojo.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de curso</title>
    </head>
    <body>
        <jsp:include page="../menu.jsp"/>
        <%
            String operacao = "cadastro";
            String labelBotao = "Cadastrar";
            
            Curso c = new Curso();
            c.setNomeCurso("");
            c.setTipoCurso("");
            
            if(request.getParameter("idCurso") != null){
                operacao = "edicao";
                labelBotao = "Atualizar curso...";
                
                int idCurso = Integer.parseInt(request.getParameter("idCurso"));
                CursoDAO cDAO = new CursoDAO();
                c = cDAO.getCurso(idCurso);
            }
        %>
        <br/><br/>
        <div style="width: 40%; margin: 0 auto !important;">
            <form method="post" action="../cursoController">
                <div class="form-group">
                    <label>Nome do curso:</label>
                    <input type="text" value="<%=c.getNomeCurso()%>" class="form-control" name="nomeCurso" placeholder="Insira o nome do curso"/>
                </div>
                <div class="form-group" style="padding-top: 20px">
                    <label>Tipo de curso:</label>
                    <input type="text" value="<%=c.getTipoCurso()%>" class="form-control" name="tipoCurso" placeholder="Insira o tipo de curso"/>
                </div>
                <div class="form-group" style="padding-top: 20px">
                    <input type="hidden" name="tipoAcao" value="<%=operacao%>"/>
                    <input type="hidden" name="idCurso" value="<%=c.getIdCurso()%>"/>
                    <input type="submit" class="btn btn-success col-12" value="<%=labelBotao%>"/>
                </div>
            </form>
        </div>
    </body>
</html>
