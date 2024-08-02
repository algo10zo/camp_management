package camp.model;

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
            }
            if (score < 95 && score >= 90) {
                return "B";
            }
            if (score >= 80 && score < 90) {
                return "C";
            }
            if (score >= 70 && score < 80) {
                return "D";
            }
            if (score >= 60 && score < 70) {
                return "F";
            }
            if (score < 60) {
                return "N";
            }
        } else if (subjectType.equals("선택")) {
            if (score >= 90) {
                return "A";
            }
            if (score < 90 && score >= 80) {
                return "B";
            }
            if (score >= 70 && score < 80) {
                return "C";
            }
            if (score >= 60 && score < 70) {
                return "D";
            }
            if (score >= 50 && score < 60) {
                return "F";
            }
            if (score < 50) {
                return "N";
            }
        }
        throw new IllegalArgumentException("올바르지 않은 과목 타입입니다.")
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
