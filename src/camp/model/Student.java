package camp.model;

import java.util.List;
import java.util.Map;

public class Student implements IStudent{
    private static String originalNumber;
    private String studentName;
    private List<String> subjectList; // subjectList이니까 자료형의 타입을 subject로 수정
    //Student 김우진 = new Student()Student 김우진 = new Student()Student 김우진 = new Student()Student 김우진 = new Student()Student 김우진 = new Student()Student 김우진 = new Student()

    public Student(String sequence, String studentName, List<String> subjectList) { // 자료형 subject로 수정
        this.originalNumber = sequence;
        this.studentName = studentName;
        this.subjectList = subjectList;
    }
    @Override
    public String getId() {
        return originalNumber;
    }

    @Override
    public String getName() {
        return studentName;
    }

    @Override
    public void setName(String name) {
        this.studentName = name;
    }

    @Override
    public Map<String, ISubject> getSubjects() {
//        Map<String, ISubject> subjectsMap = Map.of();{
//            Map.Entry<Integer, String> java = Map.entry(1, "Java");
//            Map.Entry<Integer, String> OOP = Map.entry(2, "객체지향");
//            Map.Entry<Integer, String> Spring = Map.entry(3, "Spring");
//            Map.Entry<Integer, String> JPA = Map.entry(4, "JPA");
//            Map.Entry<Integer, String> MySQL = Map.entry(5, "MySQL");
//        }
        return Map.of();
    }
}
