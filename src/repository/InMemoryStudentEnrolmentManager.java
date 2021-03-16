package repository;

import model.Student;
import model.StudentEnrolment;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStudentEnrolmentManager implements StudentEnrolmentManager {
    private final List<StudentEnrolment> studentEnrolments = new ArrayList<>();


    @Override
    public boolean add(StudentEnrolment studentEnrolment) {
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
    public StudentEnrolment getOne(StudentEnrolment studentEnrolment) {
        return studentEnrolments.get(studentEnrolments.indexOf(studentEnrolment));
    }

    @Override
    public List<StudentEnrolment> getAll() {
        return studentEnrolments;
    }
}
