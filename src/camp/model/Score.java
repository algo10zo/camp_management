package camp.model;

public class Score implements IScore {
    private int round;
    private int score;
    private String grade;

    public Score(int round, int score) {
        this.round = round;
        this.score = score;
    }

    @Override
    public int getRound() {
        return round;
    }

    @Override
    public void setRound(int round) {
        this.round = round;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;

    }

    @Override
    public String getGrade() {
        return grade;
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

