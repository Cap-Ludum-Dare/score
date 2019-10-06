package se.capgemini.score.score.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class PostScore {

    @Autowired
    private MySqlClient client;

    public void postScore(String username, String score) {
        Connection con = client.getConnection();
        try {
            String query = "INSERT INTO score(username,score) VALUES ('" + username + "','" + score + "')";
            PreparedStatement preparedStatement = con
                    .prepareStatement(query);
            preparedStatement.executeUpdate();

            System.out.println("Result saved!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
