package camp.model;

import java.util.List;

public class StudentManager implements IStudentManager{
    @Override
    public void addStudent(int id, String name, List<String> subjects) {

    }

    @Override
    public IStudent getStudent(int id) {
        return null;
    }

    @Override
    public void updateStudentName(int id, String newName) {

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
