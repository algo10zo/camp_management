package camp.model;

import java.util.HashMap;
import java.util.Map;

public class Subject implements ISubject {
    private String number;
    private String name;
    private String subjectType;
    private Map<Integer, Integer> scores; // key : round, values : Score
    public Subject(String number,String subject,String subjectType){
        scores = new HashMap<>();
        this.number = number;
        this.name = subject;
        this.subjectType = subjectType;
    }
    @Override
    public String getName() {
        return null;
    }

    @Override
    public void addScore(int round, int score) {

    }

    @Override
    public void updateScore(int round, int score) {

    }

    @Override
    public String getGrade(int round) {
        return null;
    }

    @Override
    public double getAverageGrade() {
        return 0;
    }
}
