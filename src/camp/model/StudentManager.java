package camp.model;


import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class StudentManager implements IStudentManager {
    private Store store;
    private static Scanner sc = new Scanner(System.in);

    @Override
    public void addStudent(String id, String name, List<Subject> subjects) {
        Student student = new Student(id, name, subjects);
        store.getStudentStore().add(student);
    }

    @Override
    public List<String> selectSubject() {
        List<String> selectedSubjects = new ArrayList<>();
        int mandatoryCount = 0;
        int choiceCount = 0;
        System.out.println("1. Java");
        System.out.println("2. 객체지향");
        System.out.println("3. Spring");
        System.out.println("4. JPA");
        System.out.println("5. MySQL");
        System.out.println("6. 디자인 패턴");
        System.out.println("7. Spring Security");
        System.out.println("8. Redis");
        System.out.println("9. MongoDB");
        System.out.println("0. 종료");
        System.out.println("추가할 과목 번호를 입력하세요: ");
        do {
            try {
                int choice = sc.nextInt();

                if (choice == 0) {
                    if (mandatoryCount < 3) {
                        System.out.println("필수 과목을 3개 선택해야 합니다.");
                    }
                    if (choiceCount < 2) {
                        System.out.println("선택 과목을 2개 선택해야 합니다.");
                    }
                    continue;
                } else if (choice >= 1 && choice <= 5) {
                    if (mandatoryCount < 3) {
                        String subjectName = store.getSubjectStore().get(choice - 1).getName();
                        if (!selectedSubjects.contains(subjectName)) {
                            selectedSubjects.add(subjectName);
                            mandatoryCount++;
                        } else {
                            System.out.println("이미 선택된 과목입니다.");
                        }
                    } else {
                        System.out.println("필수과목은 3개까지 선택할 수 있습니다.");
                    }
                } else if (choice >= 6 && choice <= 9) {
                    if (choiceCount < 2) {
                        String subjectName = store.getSubjectStore().get(choice - 1).getName();
                        if (!selectedSubjects.contains(subjectName)) {
                            selectedSubjects.add(subjectName);
                            choiceCount++;
                        } else {
                            System.out.println("이미 선택된 과목입니다.");
                        }
                    } else {
                        System.out.println("선택 과목은 2개까지 선택할 수 있습니다.");
                    }
                } else {
                    System.out.println("올바른 번호를 입력하세요.");
                }
            } catch (Exception e) {
                System.out.println("유효하지 않은 입력입니다. 숫자를 입력하세요.");
                sc.next();
            }
        } while (mandatoryCount < 3 || choiceCount < 2);

        return selectedSubjects;
    }

    @Override
    public IStudent getStudent(int id) {
        return null;
    }

    @Override
    public void updateStudentName(int id, String newName) {

    }

    @Override
    public IStudent getStudent(String id) {
        return store.getStudentStore().stream()
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
    public void setStore(Store store){
        this.store = store;
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
