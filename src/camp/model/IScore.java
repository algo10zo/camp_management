package camp.model;

public interface IScore {
    int getScore();
    void setScore(int score,String type);
    String getGrade();
    void calculateGrade(String type);
}
}