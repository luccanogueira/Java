package br.academico.DAO;

import br.academico.pojo.Aluno;
import br.academico.pojo.Curso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlunoDAO {

    private Statement stm;

    public ArrayList<Aluno> getTodos() throws SQLException {
        ArrayList<Aluno> alunos = new ArrayList<>();

        stm = ConnectionFactory.createConnection().
                createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        String select = "SELECT alunos.\"idAluno\",\n"
                + "       alunos.\"ra\",\n"
                + "       alunos.\"nome\",\n"
                + "       cursos.\"idCurso\",\n"
                + "       cursos.\"nome_curso\",\n"
                + "       cursos.\"tipo_curso\"\n"
                + "FROM \"tb_Alunos\" as alunos,\n"
                + "     \"tb_Cursos\" as cursos\n"
                + "WHERE alunos.\"idCurso\" = cursos.\"idCurso\"";

        ResultSet resultados = stm.executeQuery(select);

        while (resultados.next()) {
            Aluno a = new Aluno();
            Curso c = new Curso();

            a.setIdAluno(resultados.getInt("idAluno"));
            a.setRa(resultados.getInt("ra"));
            a.setNome(resultados.getString("nome"));

            c.setIdCurso(resultados.getInt("idCurso"));
            c.setNomeCurso(resultados.getString("nome_curso"));
            c.setTipoCurso(resultados.getString("tipo_curso"));

            a.setCurso(c);

            alunos.add(a);
        }
        stm.getConnection().close();
        return alunos;
    }

    
    public boolean insereAluno(Aluno aluno) {
        try {
            String query = "INSERT INTO \"tb_Alunos\" (\"ra\", \"nome\", \"idCurso\") VALUES(?, ?, ?)";

            PreparedStatement pstm = ConnectionFactory.createConnection().prepareStatement(query);

            pstm.setInt(1, aluno.getRa());
            pstm.setString(2, aluno.getNome());
            pstm.setInt(3, aluno.getCurso().getIdCurso());

            pstm.execute();
            pstm.getConnection().close();

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

}
