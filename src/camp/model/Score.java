package camp.model;

import javax.security.auth.Subject;

public class Score implements IScore {
    private String scoreID;
    private String studentID;
    private String subjectID;
    private int round;
    private int score;
    private String grade;
    public Score(String scoreID, String studentID, String subjectID,int round,int score){
        this.scoreID = scoreID;
        this.studentID = studentID;
        this.subjectID = subjectID;
        this.round = round;
        this.score = score;
    }

    @Override
    public String getScoreID() {
        return this.scoreID;
    }

    @Override
    public String getStudentID() {
        return this.getStudentID();
    }

    @Override
    public String getSubjectID() {
        return this.getSubjectID();
    }

    @Override
    public int getRound() {
        return this.getRound();
    }

    @Override
    public void setRound(int round) {
        this.round = round;
    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public void setScore(int score,String type) {
        this.score = score;
        calculateGrade(type);
    }

    @Override
    public String getGrade() {
        return this.grade;
    }

    @Override
    public void calculateGrade(String type) {
        if (type.equals("MANDATORY")) {
            if (score >= 95) {
                this.grade = "A";
            } else if (score >= 90) {
                this.grade = "B";
            } else if (score >= 80) {
                this.grade = "C";
            } else if (score >= 70) {
                this.grade = "D";
            } else if (score >= 60) {
                this.grade = "F";
            } else {
                this.grade = "N";
            }
        } else if (type.equals("CHOICE")) {
            if (score >= 90) {
                this.grade = "A";
            } else if (score >= 80) {
                this.grade = "B";
            } else if (score >= 70) {
                this.grade = "C";
            } else if (score >= 60) {
                this.grade = "D";
            } else if (score >= 50) {
                this.grade = "F";
            } else {
                this.grade = "N";
            }
        }
        throw new IllegalArgumentException("올바르지 않은 과목 타입입니다.");
    }
}

