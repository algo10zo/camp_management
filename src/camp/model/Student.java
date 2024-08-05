package camp.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student implements IStudent{
    private String studentID; // 변경된 필드명
    private String name;
    private String status;
    private Map<String, ISubject> subjects;

    public Student(String studentID, String name, List<String> subjectsList) {
        this.studentID = studentID; // 변경된 필드명
        this.name = name;
        this.status = "Green"; // 기본 상태
        this.subjects = new HashMap<>();
        for (String subject : subjectsList) {
            // 예시: Subject 객체를 생성하고 추가
            this.subjects.put(subject, new Subject(subject));
        }
    }

    public Student(String sequence, String studentName) {
        this.studentID = sequence;
        this.name = studentName;
        this.status = "active";
        this.subjects = new HashMap<>();
    }

    @Override
    public String getStudentID() {
        return studentID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public Map<String, ISubject> getSubjects() {
        return subjects;
    }
}
