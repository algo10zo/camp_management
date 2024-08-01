package camp.model;

public interface IStudent {
    int getId();
    String getName();
    void setName(String name);
    String getStatus();
    void setStatus(String status);
    Map<String, ISubject> getSubjects();
}
