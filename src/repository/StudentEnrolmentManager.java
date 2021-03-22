package repository;

import model.Course;
import model.Enrolment;
import model.Student;

import java.util.List;

public interface StudentEnrolmentManager {
    Enrolment addEnrolment(String sid, String cid, String semester);

    boolean deleteEnrolment(String sid, String cid, String semester);

    List<Enrolment> getEnrolments();

    List<Course> getCourses();

    List<Student> getStudents();

    Enrolment getEnrolment(String sid, String cid, String semester);

    Course getCourseById(String id);

    Student getStudentById(String id);
}
