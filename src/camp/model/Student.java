package camp.model;

import java.util.List;
import java.util.Map;

public class Student {
    private static String originalNumber;
    private String studentName;
    private List<String> subjectList;

    public Student(String sequence, String studentName, List<String> subjectList) {
        this.originalNumber = sequence;
        this.studentName = studentName;
        this.subjectList = subjectList;
    }
}
