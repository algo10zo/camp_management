package camp.model;

public interface IScoreManager {
    void addScore(int round, int score);

    void updateScore(int round, int score);

    void inquiryRank(int round);

    void avgRank(ISubject subject);

    void avgMandatoryRank(ISubject subject);
}
