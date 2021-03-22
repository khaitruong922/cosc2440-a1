package repository;

import model.Course;
import model.Enrolment;
import model.Student;

import java.util.List;

public interface StudentEnrolmentManager {
    Enrolment addEnrolment(String studentId, String courseId, String semester);

    boolean updateEnrolment(String studentId);

    boolean deleteEnrolment(String studentId);

    List<Enrolment> getEnrolments();

    List<Course> getCourses();

    List<Student> getStudents();

    Course getCourseById(String id);

    Student getStudentById(String id);
}
