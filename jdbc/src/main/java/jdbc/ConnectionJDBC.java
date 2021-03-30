package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    public static void main(String[] args) throws SQLException {

//        // 1
//        String urlConnection = "jdbc:mysql://localhost/digital";
//
//        try (Connection conn = DriverManager.getConnection(urlConnection, "root", "root")){
//            System.out.println("SUCESSO AO SE CONECTAR COM O BANCO DE DADOS");
//        } catch (Exception e){
//            System.out.println("FALHA NA CONEXÃO COM O BANDO DE DADOS");
//        }


        // 2 Parâmetros para conectar ao banco de dados
        String driver = "mysql";
        String dataBaseAddress = "localhost";
        String dataBaseName = "digital";
        String user = "root";
        String password = "root";

        // 3 Construção de string de conexão
        StringBuilder sb = new StringBuilder("jdbc:")
                .append(driver).append("://")
                .append(dataBaseAddress).append("/")
                .append(dataBaseName);

        String connectionURL = sb.toString();

        // 4 Criar conexão usando o DriverManager, passando como parâmetros a string de conexão, usuário e senha
        try(Connection conn = DriverManager.getConnection(connectionURL, user, password)){
            System.out.println("SUCESSO AO CONECTAR AO BANCO DE DADOS");
        } catch (SQLException e){
            System.out.println("FALHA NA CONEXÃO COM O BANCO DE DADOS");
            e.printStackTrace();
        }
    }
}
