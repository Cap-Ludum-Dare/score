package se.capgemini.score.score.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.capgemini.score.score.model.Score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GetScores {

    @Autowired
    private MySqlClient client;

    public List<Score> getScores() {
        List<Score> list = call("SELECT * FROM scoredb ORDER BY score DESC LIMIT 15");
        if (list != null) return list;
        return null;
    }

    public List<Score> getHighScore() {
        List<Score> list = call("SELECT * FROM scoredb ORDER BY score DESC LIMIT 1");
        if (list != null) return list;
        return null;
    }

    public List<Score> getTop() {
        List<Score> list = call("SELECT * FROM scoredb ORDER BY score DESC LIMIT 3");
        if (list != null) return list;
        return null;
    }

    private List<Score> call(String s) {
        Connection con = client.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(s);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Score> list = new ArrayList<>();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("idscoredb"));
                Score score = new Score();
                score.setUsername(resultSet.getString("username"));
                score.setScore(Integer.valueOf(resultSet.getString("score")));
                list.add(score);
            }

            System.out.println("Result: " + list.toString());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
