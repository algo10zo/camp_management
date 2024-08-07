package camp.model;

import java.util.List;

/**
 * 과목을 나타내는 인터페이스입니다.
 * 각 과목 객체는 고유의 ID, 이름, 유형, 점수를 관리합니다.
 */
public interface ISubject {
    String getName();
    void addScore(int round, int score);
    void updateScore(int round, int score);
    String getGrade(int round);
    double getAverageGrade();
    String getSubjectType();
}

