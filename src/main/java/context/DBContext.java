package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

    private static DBContext instance = new DBContext();

    private final String serverName = "localhost";
    private final String dbName = "ShoppingDB";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "PRJ321xASM4";
    private final String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    private DBContext() {
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DBContext getInstance() {
        return instance;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        return DriverManager.getConnection(url, userID, password);
    }

}
