package connectionDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InciarDB {

    public static Connection obterConexao() throws RuntimeException {
        String url = "jdbc:mysql://localhost:3306/db_petvida?serverTimezone = America/Sao_Paulo";
        String porta = "root";
        String senha = "senha";
        try{
            return DriverManager.getConnection(url,porta,senha);
        } catch (SQLException e) {
            throw new RuntimeException("Erro de conectar ao Banco de Dados!! ");
        }
    }

    public static void main(String[] args) {
        try{
            Connection conexao = obterConexao();
            if(conexao != null){
                System.out.println("**** Conexão Realizado com sucesso ****");
                conexao.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("** Bem Vindo ao SQL **");
        }

    }
}
