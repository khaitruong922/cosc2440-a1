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

    public boolean addStudent(Student student) {
        if (getStudentById(student.getId()) != null) return false;
        students.add(student);
        return true;
    }

    public boolean addCourse(Course course) {
        if (getCourseById(course.getId()) != null) return false;
        courses.add(course);
        return true;
    }


    @Override
    public boolean addEnrolment(String studentId, String courseId, String semester) {
        Student student = getStudentById(studentId);
        Course course = getCourseById(courseId);
        enrolments.add(new StudentEnrolment(student, course, semester));
        return true;
    }

    @Override
    public boolean updateEnrolment(String studentId) {
        return false;
    }

    @Override
    public boolean deleteEnrolment(String studentId) {
        return false;
    }

    @Override
    public List<StudentEnrolment> getEnrolments() {
        return enrolments;
    }

    public Student getStudentById(String studentId) {
        return students.stream().filter(s -> s.getId().equals(studentId)).findFirst().orElse(null);
    }

    public Course getCourseById(String courseId) {
        return courses.stream().filter(c -> c.getId().equals(courseId)).findFirst().orElse(null);
    }

    public List<Course> getCoursesInSemester(String semester) {
        return enrolments.stream().filter(e -> e.getSemester().equals(semester)).distinct().map(StudentEnrolment::getCourse).distinct().collect(Collectors.toList());
    }

    public List<Course> getCoursesOfStudentInSemseter(String studentId, String semester) {
        return enrolments.stream().filter(e -> e.getSemester().equals(semester) && e.getStudent().getId().equals(studentId)).map(StudentEnrolment::getCourse).distinct().collect(Collectors.toList());
    }

    public List<Student> getStudentsInCourseInSemester(String courseId, String semester) {
        return enrolments.stream().filter(e -> e.getSemester().equals(semester) && e.getCourse().getId().equals(courseId)).map(StudentEnrolment::getStudent).distinct().collect(Collectors.toList());
    }

    public List<StudentEnrolment> getEnrolmentsByCourseId(String courseId) {
        return enrolments.stream().filter(e -> e.getCourse().getId().equals(courseId)).collect(Collectors.toList());
    }

    @Override
    public List<StudentEnrolment> getEnrolmentsByStudentId(String studentId) {
        return enrolments.stream().filter(e -> e.getStudent().getId().equals(studentId)).collect(Collectors.toList());
    }
}
