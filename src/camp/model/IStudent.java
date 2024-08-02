package camp.model;

import java.util.Map;

public interface IStudent {
    String getId();
    String getName();
    void setName(String name);
//    String getStatus();
//    void setStatus(String status);
    Map<String, ISubject> getSubjects();
}
