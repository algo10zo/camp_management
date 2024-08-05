package camp.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subject implements ISubject {
    private String name;
    private String subjectType;
    private Map<Integer, Integer> scores;

    public Subject(String name) {
        this.name = name;
        scores = new HashMap<>();
    }

    public Subject(String sequence, String name, String subjectType) {
        this.name = name;
        this.subjectType = subjectType;
        scores = new HashMap<>();
    }

    public Subject(String name, String subjectType) {
        this.name = name;
        this.subjectType = subjectType;
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
    public String getGrade(int score, String subjectType) {
        if (subjectType.equals("필수")) {
            if (score >= 95) return "A";
            if (score >= 90) return "B";
            if (score >= 80) return "C";
            if (score >= 70) return "D";
            if (score >= 60) return "F";
            return "N";
        } else if (subjectType.equals("선택")) {
            if (score >= 90) return "A";
            if (score >= 80) return "B";
            if (score >= 70) return "C";
            if (score >= 60) return "D";
            if (score >= 50) return "F";
            return "N";
        }
        return "N";

    }


    @Override
    public double getAverageGrade() {
        if(scores.isEmpty()) return 0;

        int total = 0;
        for(int score : scores.values()){
            total += score;
        }
        return total/(double)scores.size();
    }
    }