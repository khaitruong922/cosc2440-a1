package repository;

import model.Course;
import model.Student;
import model.StudentEnrolment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InternalStudentEnrolmentManager implements StudentEnrolmentManager {
    private final List<StudentEnrolment> enrolments = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();


    @Override
    public boolean add(String studentId, String courseId, String semester) {
        Student student = getStudentById(studentId);
        Course course = getCourseById(courseId);
        enrolments.add(new StudentEnrolment(student, course, semester));
        return true;
    }

    @Override
    public boolean update(String studentId) {
        return false;
    }

    @Override
    public boolean delete(String studentId) {
        return false;
    }

    @Override
    public List<StudentEnrolment> getAll() {
        return enrolments;
    }

    public Student getStudentById(String studentId) {
        return students.stream().filter(s -> s.getId().equals(studentId)).findFirst().orElse(null);
    }

    public Course getCourseById(String courseId) {
        return courses.stream().filter(c -> c.getId().equals(courseId)).findFirst().orElse(null);
    }

    @Override
    public List<StudentEnrolment> getByCourseId(String courseId) {
        return enrolments.stream().filter(e -> e.getCourse().getId().equals(courseId)).collect(Collectors.toList());
    }

    @Override
    public List<StudentEnrolment> getByStudentId(String studentId) {
        return enrolments.stream().filter(e -> e.getStudent().getId().equals(studentId)).collect(Collectors.toList());
    }
}
