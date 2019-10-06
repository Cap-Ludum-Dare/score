package se.capgemini.score.score.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
public class GetScores {

    @Autowired
    private MySqlClient client;

    public Map<String, String> getScores() {
        Connection con = client.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM scoredb ORDER BY score DESC LIMIT 10");
            ResultSet resultSet = preparedStatement.executeQuery();

            Map list = new HashMap();
            while (resultSet.next()) {
                list.put(resultSet.getString("username"), resultSet.getString("score"));
            }
            System.out.println("Result: " + list.toString());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
