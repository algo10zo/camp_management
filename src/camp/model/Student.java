package camp.model;

import java.util.List;
import java.util.Map;

public class Student {
    private static String originalNumber;
    private String studentName;
    private List<Subject> subjectList; // subjectList이니까 자료형의 타입을 subject로 수정

    public Student(String sequence, String studentName, List<Subject> subjectList) { // 자료형 subject로 수정
        this.originalNumber = sequence;
        this.studentName = studentName;
        this.subjectList = subjectList;
    }
}
