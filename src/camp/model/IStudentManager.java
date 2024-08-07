package camp.model;

import java.util.List;

public interface IStudentManager {
    void addStudent(String studentID, String name, List<String> subjects);
    void updateStudentName(String studentID, String newName);
    void updateStudentStatus(String studentID, String newStatus);
    IStudent removeStudent(String studentID);
    List<IStudent> getStudentsByStatus(String status);
    List<IStudent> getAllStudents();
    IStudent getStudentById(String studentID);

}
