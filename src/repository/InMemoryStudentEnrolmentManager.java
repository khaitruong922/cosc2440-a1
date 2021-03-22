package repository;

import model.Course;
import model.Student;
import model.Enrolment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryStudentEnrolmentManager implements StudentEnrolmentManager {
    private final List<Enrolment> enrolments = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();

    public InMemoryStudentEnrolmentManager() {
        students.add(new Student("s3818074", "Khai Truong", null));
        students.add(new Student("s3818075", "Khai Truong 2", null));
        courses.add(new Course("COSC2092", "Machine Learning", 24));
        courses.add(new Course("COSC2440", "SADI", 12));
        addEnrolment("s3818074", "COSC2092", "2021A");
        addEnrolment("s3818075", "COSC2092", "2021A");
        addEnrolment("s3818074", "COSC2440", "2021A");
    }

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
    public Enrolment addEnrolment(String studentId, String courseId, String semester) {
        Student student = getStudentById(studentId);
        Course course = getCourseById(courseId);
        Enrolment enrolment = new Enrolment(student, course, semester);
        enrolments.add(enrolment);
        return enrolment;
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
    public List<Enrolment> getEnrolments() {
        return enrolments;
    }

    @Override
    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public List<Student> getStudents() {
        return students;
    }

    public Student getStudentById(String studentId) {
        return students.stream().filter(s -> s.getId().equals(studentId)).findFirst().orElse(null);
    }

    public Course getCourseById(String courseId) {
        return courses.stream().filter(c -> c.getId().equals(courseId)).findFirst().orElse(null);
    }
}
