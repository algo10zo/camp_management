package camp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentManager implements IStudentManager {
    static List<Student> studentStore = new ArrayList<Student>();
    @Override
    public void addStudent(int id, String name, List<String> subjects) {

    }

    @Override
    public IStudent getStudent(String id) {
        return  studentStore.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NullPointerException("해당 ID의 학생이 존재하지 않습니다."));
    }

    @Override
    public void updateStudentName(String id, String newName) {
        getStudent(id).setName(newName);
    }

    @Override
    public void updateStudentStatus(int id, String newStatus) {

    }

    @Override
    public void removeStudent(int id) {

    }

    @Override
    public List<IStudent> getStudentsByStatus(String status) {
        return List.of();
    }

    @Override
    public double getAverageGradeForSubject(String subjectName) {
        return 0;
    }

    @Override
    public double getAverageGradeForMandatorySubjects(String status, List<String> mandatorySubjects) {
        return 0;
    }
}
