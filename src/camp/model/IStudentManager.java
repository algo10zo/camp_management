package camp.model;

import java.util.List;

public interface IStudentManager {
    void addStudent(String id, String name, List<Subject> subjects);

    IStudent getStudent(String id);

    List<String> selectSubject();

    IStudent getStudent(int id);

    void updateStudentName(int id, String newName);

    void updateStudentName(String id, String newName);

    void updateStudentStatus(int id, String newStatus);

    void removeStudent(int id);

    List<IStudent> getStudentsByStatus(String status);

    double getAverageGradeForSubject(String subjectName);

    double getAverageGradeForMandatorySubjects(String status, List<String> mandatorySubjects);
}
