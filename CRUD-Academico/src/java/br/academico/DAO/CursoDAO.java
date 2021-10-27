package br.academico.DAO;

import br.academico.pojo.Curso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CursoDAO {

    private Statement stm;

    public ArrayList<Curso> getTodosCursos() throws SQLException {
        ArrayList<Curso> cursos = new ArrayList<>();

        String select = "SELECT \"idCurso\", \"nome_curso\", \"tipo_curso\" FROM \"tb_Cursos\"";
        try {

            stm = ConnectionFactory.createConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet resultados = stm.executeQuery(select);

            while (resultados.next()) {
                Curso c = new Curso();
                c.setIdCurso(resultados.getInt("idCurso"));
                c.setNomeCurso(resultados.getString("nome_curso"));
                c.setTipoCurso(resultados.getString("tipo_curso"));

                cursos.add(c);
            }

            stm.getConnection().close();
            return cursos;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean insereCurso(Curso curso) throws SQLException {
        try {
            String query = "INSERT INTO \"tb_Cursos\" (\"nome_curso\", \"tipo_curso\") VALUES(?, ?)";

            PreparedStatement pstm = ConnectionFactory.createConnection().prepareStatement(query);

            pstm.setString(1, curso.getNomeCurso());
            pstm.setString(2, curso.getTipoCurso());

            pstm.execute();
            pstm.getConnection().close();

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean atualizaCurso(int idCurso, String novoNome, String novoTipo) {
        try {
            String query = "UPDATE \"tb_Cursos\" SET \"nome_curso\" = ?, \"tipo_curso\" = ? WHERE \"idCurso\" = ?";
            
            PreparedStatement pstm = ConnectionFactory.createConnection().prepareStatement(query);
            
            pstm.setString(1, novoNome);
            pstm.setString(2, novoTipo);
            pstm.setInt(3, idCurso);
            
            pstm.execute();
            
            pstm.getConnection().close();
            
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    //opcional: Passando um objeto curso, ao invés de receber os parâmentros que são alrterados
    public boolean atualizaCurso(Curso curso) {
        try {
            String query = "UPDATE \"tb_Cursos\" SET \"nome_curso\" = ?, \"tipo_curso\" = ? WHERE \"idCurso\" = ?";
            
            PreparedStatement pstm = ConnectionFactory.createConnection().prepareStatement(query);
            
            pstm.setString(1, curso.getNomeCurso());
            pstm.setString(2, curso.getTipoCurso());
            pstm.setInt(3, curso.getIdCurso());
            
            pstm.execute();
            
            pstm.getConnection().close();
            
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Curso getCurso(int idCurso) throws SQLException {
       Curso c = new Curso();

        String select = "SELECT \"idCurso\", \"nome_curso\", \"tipo_curso\" FROM \"tb_Cursos\" WHERE \"idCurso\" =  " + idCurso;
        try {

            stm = ConnectionFactory.createConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet resultados = stm.executeQuery(select);

            while (resultados.next()) {
                c.setIdCurso(resultados.getInt("idCurso"));
                c.setNomeCurso(resultados.getString("nome_curso"));
                c.setTipoCurso(resultados.getString("tipo_curso"));
            }

            stm.getConnection().close();
            return c;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
