package camp.model;


import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class StudentManager implements IStudentManager{
    private static List<Student> studentStore = new ArrayList<>();
    //{학생1,학생2,학생3,학생4}
    private static List<Subject> subjectStore = new ArrayList<>();
    private static List<Score> scoreStore = new ArrayList<>();
    private static int studentIndex = 0;
    private static int subjectIndex = 0;
    private static int scoreIndex = 0;

    private static Scanner sc = new Scanner(System.in);

    private static final String INDEX_TYPE_STUDENT = "S";
    private static final String INDEX_TYPE_SUBJECT = "SB";
    private static final String INDEX_TYPE_SCORE = "SC";
    private static final int SUBJECT_TYPE_MANDATORY = 0;
    private static final int SUBJECT_TYPE_CHOICE = 1;

    public static void setInitData() {
        studentStore = new ArrayList<>();
        subjectStore = List.of(
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Java",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "객체지향",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Spring",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "JPA",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "MySQL",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "디자인 패턴",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Spring Security",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Redis",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "MongoDB",
                        SUBJECT_TYPE_CHOICE
                )
        );
        scoreStore = new ArrayList<>();
    }

    private static String sequence(String type) {
        switch (type) {
            case INDEX_TYPE_STUDENT -> {
                studentIndex++;
                return INDEX_TYPE_STUDENT + studentIndex;
            }
            case INDEX_TYPE_SUBJECT -> {
                subjectIndex++;
                return INDEX_TYPE_SUBJECT + subjectIndex;
            }
            default -> {
                scoreIndex++;
                return INDEX_TYPE_SCORE + scoreIndex;
            }
        }
    }

    @Override
    public void addStudent(int id, String name, List<String> subjects) {
        String studentId = generateStudentId();
        Student student = new Student(studentId, name, subjects);
        studentStore.add(student);
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
                        String subjectName = subjectStore.get(choice - 1).getName();
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
                        String subjectName = subjectStore.get(choice - 1).getName();
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

    // 학생 ID 생성 메서드
    private static String generateStudentId() {
        studentIndex++;
        return INDEX_TYPE_STUDENT + studentIndex;
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
