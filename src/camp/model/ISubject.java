package camp.model;

public interface ISubject {
    String getName();
    void addScore(int round, int score);
    void updateScore(int round, int score);
    String getGrade(int round);
    double getAverageGrade();

}
