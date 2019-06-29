/**
 *  @author Yunxiang He
 *  @date   06/23/2019
 */

package dataAccess.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {

    private static final String USER = "root";
    private static final String PASSWORD = "Jacob880826@";
    private static final String URL = "jdbc:mysql://localhost:3306/POPG";

    public static Connection getConnection() {
        Connection connection = null;
        Properties info = new Properties();
        info.put("user", USER);
        info.put("password", PASSWORD);
        try {
            connection = DriverManager.getConnection(URL, info);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
