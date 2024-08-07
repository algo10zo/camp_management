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
    public Subject(String name) {
        this.name = name;
        scores = new HashMap<>();
    }

    public String getSubjectType() {
        return subjectType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addScore(int round, int score) {
        validateRound(round);
        validateScore(score);
        scores.put(round, score);
    }

    @Override
    public void updateScore(int round, int score) {
        validateScore(score);
        if (scores.containsKey(round)) {
            scores.put(round, score);
        } else {
            System.out.println("회차를 찾을수 없습니다.");
        }

    }

    @Override
    public String getGrade(int round) {
        if(scores.get(round) == null){
            throw new NullPointerException("점수를 먼저 등록해주세요");
        }
        if (subjectType.equals("MANDATORY")) {
            if (scores.get(round) >= 95) {
                return "A";
            } else if (scores.get(round)  >= 90) {
                return "B";
            } else if (scores.get(round)  >= 80) {
                return "C";
            } else if (scores.get(round)  >= 70) {
                return "D";
            } else if (scores.get(round)  >= 60) {
                return "F";
            } else {
                return "N";
            }
        } else if (subjectType.equals("CHOICE")) {
            if (scores.get(round)  >= 90) {
                return "A";
            } else if (scores.get(round)  >= 80) {
                return "B";
            } else if (scores.get(round)  >= 70) {
                return "C";
            } else if (scores.get(round)  >= 60) {
                return "D";
            } else if (scores.get(round)  >= 50) {
                return "F";
            } else {
                return "N";
            }
        }
        throw new IllegalArgumentException("올바르지 않은 과목 타입입니다.");
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
        return total/ scores.size();
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

