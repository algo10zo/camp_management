package camp.model;

public interface IScore {

    int getRound();
    void setRound(int round);
    int getScore();
    void setScore(int score);
    String getGrade();
     //

    void calculateGrade(String type);


}
