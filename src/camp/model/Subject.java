package camp.model;

import java.util.HashMap;
import java.util.Map;

public class Subject implements ISubject {

    private String number;
    private String name;
    private String subjectType;
    private Map<Integer, Score> scores; // key : round, values : Score

    public Subject(String number, String name, String subjectType) {
        this.number = number;
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
        if (scores.containsKey(round)) {
            throw new IllegalArgumentException("해당 회차에 이미 점수가 존재합니다.");
        }
        Score temp = new Score();
        temp.setScore(score, this.subjectType);
        scores.put(round, temp);
    }

    @Override
    public void updateScore(int round, int score) {
        if (!scores.containsKey(round)) {
            throw new IllegalArgumentException("해당 회차에 점수가 입력되지 않았습니다.");
        }
        Score temp = new Score();
        temp.setScore(score,this.subjectType);
        scores.put(round, temp);
    }

    @Override
    public String getGrade(int round) {
        return scores.get(round).getGrade();
    }

    @Override
    public double getAverageGrade() {
        double sum = 0;
        for(Score score : scores.values()){
            sum += score.getScore();
        }
        return sum / scores.size();
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
