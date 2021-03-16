package service;

import menu.Table;
import model.Course;
import model.Student;
import repository.InMemoryStudentEnrolmentManager;
import repository.StudentEnrolmentManager;

public class StudentEnrolmentService {
    private final StudentEnrolmentManager sem = new InMemoryStudentEnrolmentManager();

    public void printCoursesInSemester(String semester) {
        Table table = new Table(Course.getFields());
        sem.getCoursesInSemester(semester).forEach(c -> {
            table.addRow(c.toRecord());
        });
        table.display();
    }

    public void printCoursesOfStudentInSemseter(String studentId, String semester) {
        Table table = new Table(Course.getFields());
        sem.getCoursesOfStudentInSemseter(studentId, semester).forEach(c -> {
            table.addRow(c.toRecord());
        });
        table.display();
    }

    public void printStudentsInCourseInSemester(String courseId, String semester) {
        Table table = new Table(Student.getFields());
        sem.getStudentsInCourseInSemester(courseId, semester).forEach(s -> {
            table.addRow(s.toRecord());
        });
        table.display();
    }


}
