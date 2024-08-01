package camp.model;

public class Subject implements ISubject {
    private String subjectId;
    private String subjectName;
    private String subjectType;

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

    public String getSubjectType() {
        return subjectType;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void addScore(int round, int score) {

    }

    @Override
    public void updateScore(int round, int score) {

    }

    @Override
    public String getGrade(int round) {
        return "";
    }

    @Override
    public double getAverageGrade() {
        return 0;
    }
}
