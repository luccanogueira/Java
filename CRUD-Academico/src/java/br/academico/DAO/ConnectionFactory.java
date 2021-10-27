
package br.academico.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
 
    public static Connection createConnection() throws SQLException{
      
        String dbURL = "jdbc:derby://localhost:1527/sisacademico";
        String usuario = "academico";
        String senha = "Senha123";
        
        Connection conexao = DriverManager.getConnection(dbURL, usuario, senha);
        
        return conexao; 
    }
}
