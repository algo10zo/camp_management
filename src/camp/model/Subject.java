package camp.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subject implements ISubject {
    private String number;
    private String name;
    private String subjectType;
    private Map<Integer, Integer> scores; // key : round, values : Score

    public Subject(String number, String subject, String subjectType) {
        scores = new HashMap<>();
        this.number = number;
        this.name = subject;
        this.subjectType = subjectType;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void addScore(int round, int score) {
        scores.put(round, score);
    }

    @Override
    public void updateScore(int round, int score) {
        if (scores.containsKey(round)) {
            scores.put(round, score);
        } else {
            System.out.println("회차를 찾을수 없습니다.");
        }

    }

    @Override
    public String getGrade(int round, String subjectType) {
        Integer score = scores.get(round);
        if (score == null) {
            return "해당 회차에 점수가 입력되지 않았습니다.";
        }
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
            throw new IllegalArgumentException("회차는 1에서 10 사이여야 합니다.");
        }
    }

    private void validateScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("점수는 0에서 100 사이여야 합니다.");
        }
    }
}