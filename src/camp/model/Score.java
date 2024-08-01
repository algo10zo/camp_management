package camp.model;

import java.util.Map;

public class Score {
    private int id;
    private Map<Integer, String> scores; // <점수 , 등급> 으로 저장

    public void setScores(Map<Integer, String> scores) {
        this.scores = scores;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
