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
        addStudent(new Student("s3818074", "Khai Truong", null));
        addStudent(new Student("s3818075", "Khai Truong", null));
        addCourse(new Course("COSC2092", "Machine Learning", 24));
        addCourse(new Course("COSC2440", "SADI", 12));
        addEnrolment("s3818074", "COSC2092", "2021A");
        addEnrolment("s3818075", "COSC2092", "2021A");
        addEnrolment("s3818075", "COSC2092", "2021B");
        addEnrolment("s3818074", "COSC2440", "2021A");
        courses.forEach(System.out::println);
        enrolments.forEach(System.out::println);
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
    public Enrolment addEnrolment(String sid, String cid, String semester) {
        Student student = getStudentById(sid);
        if (student == null) return null;
        Course course = getCourseById(cid);
        if (course == null) return null;
        Enrolment enrolment = new Enrolment(student, course, semester);
        if (getEnrolment(sid, cid, semester) != null) return null;
        enrolments.add(enrolment);
        return enrolment;
    }

    @Override
    public boolean deleteEnrolment(String sid, String cid, String semester) {
        Enrolment enrolment = getEnrolment(sid, cid, semester);
        if (enrolment == null) return false;
        enrolments.remove(enrolment);
        return true;
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

    @Override
    public Enrolment getEnrolment(String sid, String cid, String semester) {
        return enrolments.stream()
                .filter(e -> e.getStudent().getId().equals(sid)
                        && e.getCourse().getId().equals(cid)
                        && e.getSemester().equals(semester))
                .findFirst().orElse(null);
    }

    public Student getStudentById(String sid) {
        return students.stream().filter(s -> s.getId().equals(sid)).findFirst().orElse(null);
    }

    public Course getCourseById(String cid) {
        return courses.stream().filter(c -> c.getId().equals(cid)).findFirst().orElse(null);
    }
}
