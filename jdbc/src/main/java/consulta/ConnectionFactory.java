package consulta;

import javax.management.RuntimeErrorException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private ConnectionFactory () { throw new UnsupportedOperationException()}

    public static Connection getConnection(){

        // 1 declarar o objeto conexão
        Connection connection = null;

        // 2 carregar arquivo de propriedades para se conectar com o banco de dados
        try (InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream("connection.properties")){

            // 3 definir parâmetros para a conexão
            Properties prop = new Properties();
            prop.load(input);

            String driver = prop.getProperty("jdbc.driver");
            String dataBaseAddress = prop.getProperty("db.address");
            String dataBaseName = prop.getProperty("db.name");
            String user = prop.getProperty("db.user.login");
            String password = prop.getProperty("db.user.password");

            // 4 construção da string de conexão
            StringBuilder sb = new StringBuilder("jdbc:")
                    .append(driver).append("://")
                    .append(dataBaseAddress).append("/")
                    .append(dataBaseName);

            String connectionUrl = sb.toString();

            // 5 criar a conexão usando o DriverManager
            try {
                connection = DriverManager.getConnection(connectionUrl, user, password);
            } catch (SQLException e){
                System.out.println("FALHA NA CONEXÃO COM O BANCO DE DADOS");
                throw new RuntimeErrorException(e);
            }

        } catch (IOException e){
            System.out.println("FALHA AO CARREGAR OS ARQUIVOS DE PROPRIEDADES");
            e.printStackTrace();
        }

        return  connection;
    }
}
