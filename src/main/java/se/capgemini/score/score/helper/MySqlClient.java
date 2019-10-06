package se.capgemini.score.score.helper;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class MySqlClient {

    public Connection getConnection() {

        String url = "jdbc:mysql://ld45score.mysql.database.azure.com:3306/scores?serverTimezone=UTC";
        String username = "alfredim88@ld45score";
        String password = "ludumDare45";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected!!!");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
