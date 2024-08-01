package camp.model;

import java.util.Map;

public class Subject implements ISubject {
    private String subjectId;
    private String subjectName;
    private String subjectType;
    private Map<Integer, Score> scoreMap;

    public Subject(String seq, String subjectName, String subjectType) {
        this.subjectId = seq;
        this.subjectName = subjectName;
        this.subjectType = subjectType;
    }

    // Getter
    public String getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectType() { return subjectType; }

    @Override
    public String getName() {
        return subjectName;
    }

    @Override
    public void addScore(int round, int score) {
        if (round < 1 || round > 10) {
            throw new IllegalArgumentException("회차는 1과 10 사이입니다.");
        }
        if (scoreMap.containsKey(round)) {
            throw new IllegalArgumentException(round + "회차는 이미 존재합니다.");
        }
        // scoreMap.put(round, new Score(score));
    }

    @Override
    public void updateScore(int round, int score) {
        if (round < 1 || round > 10) {
            throw new IllegalArgumentException("회차는 1과 10 사이입니다.");
        }
        if (!scoreMap.containsKey(round)) {
            throw new IllegalArgumentException(round + "회차는 이미 존재하지 않습니다. 추가를 먼저해야 합니다.");
        }
        // scoreMap.get(round).setScore(score);
    }

    @Override
    public String getGrade(int round) {
        if (round < 1 || round > 10) {
            throw new IllegalArgumentException("회차는 1과 10 사이입니다.");
        }
        if (scoreMap.containsKey(round)) {
            // return scoreMap.get(round).setScore(score);
        }
        return "test";
    }
}
