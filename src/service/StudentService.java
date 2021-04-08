package service;

import helper.Table;
import model.Enrolment;
import model.Student;
import repository.StudentEnrolmentManager;

import java.util.List;
import java.util.stream.Collectors;

public class StudentService {
    private final StudentEnrolmentManager sem;

    public StudentService(StudentEnrolmentManager sem) {
        this.sem = sem;

    }

    public static void displayFromList(List<Student> students) {
        Table table = new Table(Student.getFields());
        students.forEach(s -> {
            table.addRow(s.toRecord());
        });
        table.display();
    }

    public List<Student> getStudents() {
        return sem.getStudents();
    }

    public List<Student> getStudentsInCourse(String cid, String semester) {
        return sem.getEnrolments().stream()
                .filter(e -> e.getCourse().getId().equals(cid) && e.getSemester().equals(semester))
                .map(Enrolment::getStudent).distinct().collect(Collectors.toList());
    }
}
