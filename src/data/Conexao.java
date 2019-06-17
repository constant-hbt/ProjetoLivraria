
package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao{
    private Connection conn;
    public Conexao() throws Exception{
        String url = "jdbc:postgresql://localhost:5432/henrique";//dbprojetousuario
        String driver = "org.postgresql.Driver";
        Class.forName(driver);
        conn = DriverManager.getConnection(url, "postgres", "1234");
    }
    
    public Connection getConexao(){
        return conn;
    }
}
