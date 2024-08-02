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
    public String getGrade(int round) {
        if (round < 1 || round > 10) {
            throw new IllegalArgumentException("회차는 1과 10 사이입니다.");
        }
        if (scoreMap.containsKey(round)) {
            return scoreMap.get(round).setScores();
        }
        return "test";
    }
}
