package repository;

import model.StudentEnrolment;

import java.util.List;

public interface StudentEnrolmentManager {
    boolean add(StudentEnrolment studentEnrolment);

    boolean update(String studentId);

    boolean delete(String studentId);

    StudentEnrolment getOne(StudentEnrolment studentEnrolment);

    List<StudentEnrolment> getAll();
}
