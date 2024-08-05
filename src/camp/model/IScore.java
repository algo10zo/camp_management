package camp.model;

public interface IScore {

    String getScoreID();
    String getStudentID();
    String getSubjectID();
    int getRound();
    void setRound(int round);
    int getScore();
    void setScore(int score,String type);
    String getGrade();
    void calculateGrade(String type); //
}
