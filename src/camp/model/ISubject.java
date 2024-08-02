package camp.model;

public interface ISubject {
    String getName();
    void addScore(int round, int score, String subjectType);
    void updateScore(int round, int score, String subjectType);
    String getGrade(int round);
    // double getAverageGrade();

}