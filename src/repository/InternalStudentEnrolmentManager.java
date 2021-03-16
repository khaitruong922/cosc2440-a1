package repository;

import model.Course;
import model.Student;
import model.StudentEnrolment;

import java.util.ArrayList;
import java.util.List;

public class InternalStudentEnrolmentManager implements StudentEnrolmentManager {
    private final List<StudentEnrolment> studentEnrolments = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();


    @Override
    public boolean add(String studentId, String courseId, String semester) {
        return false;
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
        return studentEnrolments;
    }
}
