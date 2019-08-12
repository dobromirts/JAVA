import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Application {
    private static final String CONNECTION_PATH="jdbc:mysql://localhost:3306/minions_db";
    public static void main(String[] args) throws SQLException {
        Properties properties=new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","12345");

        Connection connection= DriverManager.getConnection(CONNECTION_PATH,properties);

        Engine engine=new Engine(connection);
        engine.run();
    }
}
