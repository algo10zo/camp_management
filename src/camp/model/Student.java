package camp.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student implements IStudent{

    private final String studentID; // 변경된 필드명
    private String name;
    private String status;
    private Map<String, ISubject> subjects;

    public Student(String sequence, String name, List<String> subjects) {
        this.studentID = sequence;
        this.name = name;
        this.status = "Green";
        this.subjects = new HashMap<>();
    }

    public Student(String sequence, String studentName) {
        this.studentID = sequence;
        this.name = studentName;
        this.status = "Green";
        this.subjects = new HashMap<>();
    }

    @Override
    public String getStudentID () {
        return studentID;
    }

    @Override
    public String getName () {
        return name;
    }

    @Override

    public void setName (String name){
        this.name = name;
    }

    @Override

    public String getStatus () {
        return status;
    }

    @Override

    public void setStatus (String status){
        this.status = status;
    }

    @Override

    public Map<String, ISubject> getSubjects () {
        return subjects;
    
    }
}
