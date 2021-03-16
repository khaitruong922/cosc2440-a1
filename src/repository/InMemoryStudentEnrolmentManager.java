package repository;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStudentEnrolmentManager implements StudentEnrolmentManager {
    private final List<Student> students = new ArrayList<>();

    @Override
    public boolean add(Student student) {
        boolean idExists = getOne(student.getId()) == null;
        if (idExists) return false;
        students.add(student);
        return true;
    }

    @Override
    public boolean update(String studentId, Student updatedStudent) {
        Student student = getOne(studentId);
        if (student == null) return false;
        students.set(students.indexOf(student), updatedStudent);
        return true;
    }

    @Override
    public boolean delete(String studentId) {
        Student student = getOne(studentId);
        if (student == null) return false;
        students.remove(student);
        return true;
    }

    @Override
    public Student getOne(String studentId) {
        return students.stream().filter(s -> s.getId().equals(studentId)).findFirst().orElse(null);
    }

    @Override
    public List<Student> getAll() {
        return students;
    }
}
