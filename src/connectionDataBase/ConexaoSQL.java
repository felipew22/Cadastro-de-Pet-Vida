package connectionDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQL {
    public static Connection obterConexao() {
        String url = "jdbc:mysql://localhost:3306/db_petvida?serverTimezone = America/Sao_Paulo";
        String usuario = "root";
        String senha = "senha";
        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão com o banco de dados: " + e.getMessage(), e);
        }
    }
}
