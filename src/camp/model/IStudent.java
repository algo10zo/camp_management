package camp.model;

import java.util.List;
import java.util.Map;

public interface IStudent {
    String getStudentID();
    String getName();
    void setName(String name);
    String getStatus();
    void setStatus(String status);
    List<ISubject> getSubjects();
}
