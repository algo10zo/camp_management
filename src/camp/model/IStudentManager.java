package camp.model;

import java.util.List;

public interface IStudentManager {
    void addStudent(int id, String name, List<String> subjects);
    IStudent getStudent(String id);
    void updateStudentName(String id, String newName);
    void updateStudentStatus(int id, String newStatus);
    void removeStudent(int id);
    List<IStudent> getStudentsByStatus(String status);
    double getAverageGradeForSubject(String subjectName);
    double getAverageGradeForMandatorySubjects(String status, List<String> mandatorySubjects);
}
