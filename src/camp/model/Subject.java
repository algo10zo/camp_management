package camp.model;

import java.util.HashMap;
import java.util.Map;

public class Subject implements ISubject {
    private String name;
    private String subjectType;
    private Map<Integer, Integer> scores;

    public Subject(String name, String subjectType) {
        this.name = name;
        this.subjectType = subjectType;
        this.scores = new HashMap<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addScore(int round, int score) {
        if(scores.containsKey(round)) {
            throw new IllegalArgumentException("해당 회차에 이미 점수가 존재합니다.");
        }
        scores.put(round, score);
    }

    @Override
    public void updateScore(int round, int score) {
        if (!scores.containsKey(round)) {
            throw new IllegalArgumentException("해당 회차에 점수가 입력되지 않았습니다.");
        }
        scores.put(round, score);
    }

    @Override
    public String getGrade(int round) {
        Integer score = scores.get(round);
        if (score == null) {
            return "해당 회차에 점수가 입력되지 않았습니다.";
        }
        // calculateGrade 구현 후 입력
        return "";
    }

    @Override
    public double getAverageGrade() {
        if (scores.isEmpty()) {
            return 0.0;
        }
        double total = 0;
        for (int score : scores.values()) {
            total += score;
        }
        return total / scores.size();
    }

    private void validateRound(int round) {
        if (round < 1 || round > 10) {
            throw new IllegalArgumentException("회ㅏㅊ는 1에서 10 사이여야 합니다.");
        }
    }

    private void validateScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("점수는 0에서 100 사이여야 합니다.");
        }
    }
}
