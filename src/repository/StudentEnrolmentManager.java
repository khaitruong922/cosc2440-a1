package repository;

import model.Course;
import model.StudentEnrolment;

import java.util.List;

public interface StudentEnrolmentManager {
    boolean add(String studentId, String courseId, String semester);

    boolean update(String studentId);

    boolean delete(String studentId);

    List<StudentEnrolment> getAll();
}
