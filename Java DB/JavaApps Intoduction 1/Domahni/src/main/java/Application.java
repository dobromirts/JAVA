import java.sql.*;
import java.util.Properties;

public class Application {
    public static void main(String[] args) throws SQLException {
            Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "12345");

        final String connectionUrl = "jdbc:mysql://localhost:3306/minions_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        Connection connection = DriverManager.getConnection(connectionUrl, props);

        Engine engine = new Engine(connection);
        engine.run();
    }
}
