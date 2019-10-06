package se.capgemini.score.score.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.capgemini.score.score.helper.GetScores;
import se.capgemini.score.score.helper.PostScore;
import se.capgemini.score.score.model.Score;

import java.util.List;

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
    public List<Score> getScore() {

        return getScores.getScores();
    }

    @GetMapping(value = "/highscore", produces = APPLICATION_JSON_VALUE)
    public List<Score> getHighScore() {

        return getScores.getHighScore();
    }

    @GetMapping(value = "/top3", produces = APPLICATION_JSON_VALUE)
    public List<Score> getTop3() {

        return getScores.getTop();
    }

    @PostMapping(value = "/savescore")
    public String postScore(@RequestParam(required = true) String username, @RequestParam(required = true) String score) {
        postScore.postScore(username, score);
        return "saved";
    }
}
