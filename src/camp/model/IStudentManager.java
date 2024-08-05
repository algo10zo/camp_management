package camp.model;

import java.util.List;
import java.util.Map;

public interface IStudentManager {
    void addStudent(String studentID, String name, List<String> subjects);
    IStudent getStudent(String studentID);
    void updateStudentName(String studentID, String newName);
    void updateStudentStatus(String studentID, String newStatus);
    void removeStudent(String studentID);
    List<IStudent> getStudentsByStatus(String status);
    double getAverageGradeForSubject(String subjectName);
    double getAverageGradeForMandatorySubjects(String status, List<String> mandatorySubjects);
}
