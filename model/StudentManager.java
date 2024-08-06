package camp.model;

import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class StudentManager implements IStudentManager {
    private  Map<String, IStudent> students = new HashMap<>();
    private  Map<String, ISubject> subjects = new HashMap<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public StudentManager() {
        this.students = new HashMap<>();
        this.subjects = new HashMap<>();
    }


    @Override
    public List<IStudent> getAllStudents() {
        lock.readLock().lock();
        try {
            return new ArrayList<>(students.values());
        }
        finally {
            lock.readLock().unlock();
        }
    }
    @Override
    public IStudent getStudentById(String studentID) {
        lock.readLock().lock();
        try{
            return students.get(studentID);
        }
        finally {
            lock.readLock().unlock();
        }

    }
    @Override
    public void updateStudentStatus(String studentID, String newStatus) {
        lock.writeLock().lock();
        try{
            IStudent student = students.get(studentID);
            if(student != null) {
                student.setStatus(newStatus);
            }
            else {
                throw new NoSuchElementException("이 ID를 가진 학생은 존재하지 않습니다.");
            }
        }
        finally {
            lock.writeLock().unlock();
        }

    }
    @Override
    public void updateStudentName(String studentID, String newName) {
        lock.writeLock().lock();
        try {
            IStudent student = students.get(studentID);
            if(student != null) {
                student.setName(newName);
            }
            else {
                throw new NoSuchElementException("이 ID를 가진 학생은 존재하지 않습니다.");
            }
        }
        finally {
            lock.writeLock().unlock();
        }

    }

    @Override
    public void addStudent(String studentID, String name, List<String> subjects) {
        lock.writeLock().lock();
        try {
            if(!students.containsKey(studentID)) {
                IStudent student = new Student(studentID, name, subjects);
                for(String subject: subjects) {
                    student.getSubjects().put(subject,new Subject(subject));
                }
                students.put(studentID, student);
            }
            else{
                throw new IllegalArgumentException("이 ID를 가진 학생이 이미 있습니다");
            }
        }
        finally {
            lock.writeLock().unlock();
        }
    }


    @Override
    public IStudent removeStudent(String studentID) {
        if(students.containsKey(studentID)) {
            students.remove(studentID);
            System.out.println("삭제를 성공했습니다.");
        }
        else {
            System.out.println("해당 ID를 가진 수강생이 존재하지않습니다.");

        }
        return null;
    }

    @Override
    public List<IStudent> getStudentsByStatus(String status) {
        lock.readLock().lock();
        try {
            List<IStudent> result = new ArrayList<>();
            for(IStudent student: students.values()) {
                if(student.getStatus().equals(status)) {
                    result.add(student);
                }
            }
            return result;
        }
        finally {
            lock.readLock().unlock();
        }

    }




}
