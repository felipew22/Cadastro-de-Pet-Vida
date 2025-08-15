package connectionDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class IniciarDB {
    public static Connection obterConexao(){
        String url = "jdbc:mysql://localhost:3306/db_petvida?serverTimezone=America/Sao_Paulo";
        String porta = "root";
        String senha = "senha";
        try{
            return DriverManager.getConnection(url,porta,senha);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o Banco de Dados!");
        }
    }

    public static void main(String[] args) {
        try{
            Connection connection = obterConexao();
            if(connection != null){
                System.out.println("----- Banco Conectado Com Sucesso -----");
                connection.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("----- Fim Do Teste -----");
        }
    }
}
