
package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao{
    private Connection conn;
    public Conexao() throws Exception{
        String url = "jdbc:postgresql://localhost:5432/teste11";//dbprojetousuario
        String driver = "org.postgresql.Driver";
        Class.forName(driver);
        conn = DriverManager.getConnection(url, "postgres", "");
    }
    
    public Connection getConexao(){
        return conn;
    }
}
