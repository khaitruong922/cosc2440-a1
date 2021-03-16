package repository;

import model.Course;
import model.StudentEnrolment;

import java.util.List;

public interface StudentEnrolmentManager {
    boolean addEnrolment(String studentId, String courseId, String semester);

    boolean updateEnrolment(String studentId);

    boolean deleteEnrolment(String studentId);

    List<StudentEnrolment> getEnrolments();

    List<StudentEnrolment> getEnrolmentsByCourseId(String courseId);

    List<StudentEnrolment> getEnrolmentsByStudentId(String studentId);
}
