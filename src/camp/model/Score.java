package camp.model;

import java.util.HashMap;
import java.util.Map;

public class Score {
    private String id;
    private Map<Integer, String> scores; // <점수 , 등급> 으로 저장

    public Map<Integer, String> getScores() {
        return scores;
    }

    public void scoreRegister(int score, String type) {
        scores.put(score, setRank(score, type));
    }

    private String setRank(int score, String subjectType) {
        if (subjectType.equals("필수")) {
            if (score >= 95) {
                return "A";
            } else if (score >= 90) {
                return "B";
            } else if (score >= 80) {
                return "C";
            } else if (score >= 70) {
                return "D";
            } else if (score >= 60) {
                return "F";
            } else {
                return "N";
            }
        } else if (subjectType.equals("선택")) {
            if (score >= 90) {
                return "A";
            } else if (score >= 80) {
                return "B";
            } else if (score >= 70) {
                return "C";
            } else if (score >= 60) {
                return "D";
            } else if (score >= 50) {
                return "F";
            } else {
                return "N";
            }
        }
        throw new IllegalArgumentException("올바르지 않은 과목 타입입니다.");
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
