package connectionDataBase;

import java.sql.Connection;

public class InciarDB {
    public static void main(String[] args) {
        try {
            Connection conexao = ConexaoSQL.obterConexao();
            if (conexao != null) {
                System.out.println("Conexão realizada com sucesso!");
                conexao.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
