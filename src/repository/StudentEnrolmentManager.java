package repository;

import model.Student;

import java.util.List;

public interface StudentEnrolmentManager {
    boolean add(Student student);

    boolean update(String studentId, Student updatedStudent);

    boolean delete(String studentId);

    Student getOne(String studentId);

    List<Student> getAll();
}
