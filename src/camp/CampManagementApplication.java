package camp;

import camp.model.*;

import java.util.*;


/**
 * Notification
 * Java, 객체지향이 아직 익숙하지 않은 분들은 위한 소스코드 틀입니다.
 * main 메서드를 실행하면 프로그램이 실행됩니다.
 * model 의 클래스들과 아래 (// 기능 구현...) 주석 부분을 완성해주세요!
 * 프로젝트 구조를 변경하거나 기능을 추가해도 괜찮습니다!
 * 구현에 도움을 주기위한 Base 프로젝트입니다. 자유롭게 이용해주세요!
 */
public class CampManagementApplication {
    // 데이터 저장소

    private static List<Student> studentStore = new ArrayList<>();
    private static List<Subject> subjectStore = new ArrayList<>();
    private static List<Score> scoreStore = new ArrayList<>();
    private static StudentManager studentManager = new StudentManager();

    // 과목 타입
    private static String SUBJECT_TYPE_MANDATORY = "MANDATORY";
    private static String SUBJECT_TYPE_CHOICE = "CHOICE";

    // index 관리 필드
    private static int studentIndex;
    private static final String INDEX_TYPE_STUDENT = "ST";
    private static int subjectIndex;
    private static final String INDEX_TYPE_SUBJECT = "SU";
    private static int scoreIndex;
    private static final String INDEX_TYPE_SCORE = "SC";

    // 스캐너
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        setInitData();
        try {
            displayMainView();
        } catch (Exception e) {
            System.out.println("\n오류 발생!\n프로그램을 종료합니다.");
        }
    }

    // 초기 데이터 생성
    private static void setInitData() {
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

    // index 자동 증가 메서드 (String 타입)
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

    // index 자동 증가 메서드 (int 타입)
    private static String intSequence(int type) {
        switch (type) {
            case 1 -> {
                studentIndex++;
                return INDEX_TYPE_STUDENT + studentIndex;
            }
            case 2 -> {
                subjectIndex++;
                return INDEX_TYPE_SUBJECT + subjectIndex;
            }
            case 3 -> {
                scoreIndex++;
                return INDEX_TYPE_SCORE + scoreIndex;
            }
            default -> throw new IllegalArgumentException("Invalid type: " + type);
        }
    }

    private static void displayMainView() throws InterruptedException {
        boolean flag = true;
        while (flag) {
            System.out.println("\n==================================");
            System.out.println("내일배움캠프 수강생 관리 프로그램 실행 중...");
            System.out.println("1. 수강생 관리");
            System.out.println("2. 점수 관리");
            System.out.println("3. 프로그램 종료");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> {
                    Thread studentThread = new Thread(() -> displayStudentView());
                    studentThread.start();
                    studentThread.join(); // 메인 스레드가 studentThread의 종료를 기다림
                }
                case 2 -> {
                    Thread scoreThread = new Thread(() -> displayScoreView());
                    scoreThread.start();
                    scoreThread.join(); // 메인 스레드가 scoreThread의 종료를 기다림
                }
                case 3 -> flag = false; // 프로그램 종료
                default -> {
                    System.out.println("잘못된 입력입니다.\n되돌아갑니다!");
                    Thread.sleep(2000);
                }
            }
        }

        System.out.println("프로그램을 종료합니다.");
    }

    private static void displayStudentView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("수강생 관리 실행 중...");
            System.out.println("1. 수강생 등록");
            System.out.println("2. 수강생 목록 조회");
            System.out.println("3. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> createStudent(); // 수강생 등록
                case 2 -> inquireStudent(); // 수강생 목록 조회
                case 3 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    // 수강생 등록
    private static void createStudent() {
        System.out.println("\n수강생을 등록합니다...");
        System.out.print("수강생 이름 입력: ");
        String studentName = sc.next();
        System.out.println("\n 필수 과목 목록:");
        for(Subject subject : subjectStore){
            if(subject.getSubjectType().equals(SUBJECT_TYPE_MANDATORY)){
                System.out.println("-"+subject.getName());
            }

        }
        System.out.println("\n선택 과목 목록:");
        for(Subject subject : subjectStore){
            if (subject.getSubjectType().equals(SUBJECT_TYPE_CHOICE)) {
                System.out.println("- " + subject.getName());
            }
        }


        // 필수 과목과 선택 과목을 입력받기
        System.out.print("필수 과목 (콤마로 구분): ");
        String[] mandatorySubjects = sc.next().split(",");
        System.out.print("선택 과목 (콤마로 구분): ");
        String[] choiceSubjects = sc.next().split(",");

        if(mandatorySubjects.length <3 ){
            System.out.println("필수 과목은 최소 3개를 선택해야 합니다.");
            return;
        }
        if(choiceSubjects.length <2 ){
            System.out.println("선택 과목은 최소 2개를 선택해야 합니다.");
            return;
        }

        // Student 객체 생성
        IStudent student = new Student(sequence(INDEX_TYPE_STUDENT), studentName);

        // 필수 과목 추가
        for (String subjectName : mandatorySubjects) {
            ISubject subject = new Subject(sequence(INDEX_TYPE_SUBJECT),subjectName, SUBJECT_TYPE_MANDATORY);
            student.getSubjects().put(subjectName, subject);
        }

        // 선택 과목 추가
        for (String subjectName : choiceSubjects) {
            ISubject subject = new Subject(sequence(INDEX_TYPE_SUBJECT), subjectName, SUBJECT_TYPE_CHOICE);
            student.getSubjects().put(subjectName, subject);
        }

        // 학생을 studentManager에 추가
        studentManager.addStudent(student.getStudentID(), student.getName(), new ArrayList<>(student.getSubjects().keySet()));
        studentStore.add((Student) student);


        System.out.println("수강생 등록 성공!\n");
    }

// 수강생 목록 조회
private static void inquireStudent() {
    System.out.println("\n수강생 목록을 조회합니다...");

    List<IStudent> students = studentManager.getAllStudents();
    if (students.isEmpty()) {
        System.out.println("등록된 수강생이 없습니다.");
    } else {
        System.out.println("ID\t이름\t상태\t과목");
        for (IStudent student : students) {
            // 학생의 과목 목록을 출력
            StringBuilder subjects = new StringBuilder();
            for (ISubject subject : student.getSubjects().values()) {
                if (subjects.length() > 0) {
                    subjects.append(", ");
                }
                subjects.append(subject.getName());
            }

            // 학생 정보 출력
            System.out.printf("%s\t%s\t%s\t%s\n",
                    student.getStudentID(),
                    student.getName(),
                    student.getStatus(),
                    subjects.toString()
            );
        }
    }

    System.out.println("\n수강생 목록 조회 성공!");
}

    private static void displayScoreView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("점수 관리 실행 중...");
            System.out.println("1. 수강생의 과목별 시험 회차 및 점수 등록");
            System.out.println("2. 수강생의 과목별 회차 점수 수정");
            System.out.println("3. 수강생의 특정 과목 회차별 등급 조회");
            System.out.println("4. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> createScore(); // 수강생의 과목별 시험 회차 및 점수 등록
                case 2 -> updateRoundScoreBySubject(); // 수강생의 과목별 회차 점수 수정
                case 3 -> inquireRoundGradeBySubject(); // 수강생의 특정 과목 회차별 등급 조회
                case 4 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    private static String getStudentId() {
        System.out.print("\n관리할 수강생의 번호를 입력하시오...");
        return sc.next();
    }

    // 수강생의 과목별 시험 회차 및 점수 등록
    private static void createScore() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        System.out.println("시험 점수를 등록합니다...");
        // 기능 구현
        System.out.println("\n점수 등록 성공!");
    }

    // 수강생의 과목별 회차 점수 수정
    private static void updateRoundScoreBySubject() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        // 기능 구현 (수정할 과목 및 회차, 점수)
        System.out.println("과목을 입력하세요: ");
        String subject = sc.next();
        System.out.println("회차를 입력하세요: ");
        int round = sc.nextInt();
        System.out.println("시험 점수를 수정합니다...");
        // 기능 구현
        System.out.println("수정할 점수를 입력하세요: ");
        int updateScore = sc.nextInt();
//        .get(studentId).get(subject).put(round, updateScore);
        System.out.println("점수 수정 성공!");
    }

    // 수강생의 특정 과목 회차별 등급 조회
    private static void inquireRoundGradeBySubject() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        // 기능 구현 (조회할 특정 과목)
        System.out.println("회차별 등급을 조회합니다...");
        // 기능 구현
        System.out.println("\n등급 조회 성공!");
    }

}
