package service;

import menu.model.InputField;
import menu.model.Table;
import model.Course;
import model.Enrolment;
import repository.StudentEnrolmentManager;

import java.util.List;
import java.util.stream.Collectors;

public class CourseService {
    private final StudentEnrolmentManager sem;


    public CourseService(StudentEnrolmentManager sem) {
        this.sem = sem;
    }

    public static void displayFromList(List<Course> courses) {
        Table table = new Table(Course.getFields());
        courses.forEach(c -> {
            table.addRow(c.toRecord());
        });
        table.display();
    }

    public List<Course> getCoursesInSemester(String semester) {
        return sem.getEnrolments().stream()
                .filter(e -> e.getSemester().equals(semester))
                .map(Enrolment::getCourse).distinct().collect(Collectors.toList());
    }

    public List<Course> getCourses() {
        return sem.getCourses();
    }

    public List<Course> getCoursesOfStudentInSemester(String sid, String semester) {
        return sem.getEnrolments().stream()
                .filter(e -> e.getStudent().getId().equals(sid) && e.getSemester().equals(semester))
                .map(Enrolment::getCourse).distinct().collect(Collectors.toList());
    }
}
