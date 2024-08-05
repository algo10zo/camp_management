package camp.model;

public class Score implements IScore {
    private int score;
    private String grade;

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public void setScore(int score, String type) {
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

