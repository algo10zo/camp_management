package camp.model;

import java.util.List;
import java.util.Map;

public class Student implements IStudent {
    private String studentID; // 변경된 필드명
    private String name;
    private String status;
    private Map<String, ISubject> subjects;

    Student(String studentID, String name, List<Subject> subject){
        this.studentID = studentID;
        this.name = name;
    }

    @Override
    public String getStudentID() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getStatus() {
        return null;
    }

    @Override
    public void setStatus(String status) {

    }

    @Override
    public Map<String, ISubject> getSubjects() {
        return null;
    }
}
