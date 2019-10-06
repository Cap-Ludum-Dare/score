package se.capgemini.score.score.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import se.capgemini.score.score.helper.GetScores;
import se.capgemini.score.score.helper.PostScore;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class Controller {

    private GetScores getScores;
    private PostScore postScore;

    @Autowired
    public Controller(GetScores getScores, PostScore postScore) {
        this.getScores = getScores;
        this.postScore = postScore;
    }

    @GetMapping(value = "/scores", produces = APPLICATION_JSON_VALUE)
    public Map<String, String> getScore() {

        return getScores.getScores();
    }

    @GetMapping("/highscore")
    public String getHighScore() {

        postScore.postScore("Alfredo", "10");
        return "HIGH SCORE!!";
    }

    @PostMapping("/savescore")
    public String postScore() {
        return "saved";
    }
}
