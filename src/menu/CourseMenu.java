package menu;

import menu.model.InputField;
import menu.model.Menu;
import menu.model.Option;
import menu.model.Table;
import model.Course;
import model.Enrolment;
import repository.InMemoryStudentEnrolmentManager;
import repository.StudentEnrolmentManager;

import java.util.List;
import java.util.stream.Collectors;

public class CourseMenu extends Menu {
    private final StudentEnrolmentManager sem = new InMemoryStudentEnrolmentManager();
    private final InputField semesterInput;

    public CourseMenu() {
        optionMenu.add(new Option("View courses", "1", () -> {
            viewCourses();
            waitForEnter();
            run();
        }));
        optionMenu.add(new Option("View courses in semester", "2", () -> {
            viewCoursesInSemester();
            waitForEnter();
            run();
        }));
        optionMenu.add(new Option("Back", "4", () -> {

        }));
        semesterInput = new InputField("Semester: ").required();
    }

    private void viewCoursesInSemester() {
        String semester = semesterInput.getInput();
        List<Enrolment> enrolments = sem.getEnrolments();
        List<Course> coursesInSemester = enrolments.stream().filter(e -> e.getSemester().equals(semester)).map(Enrolment::getCourse).collect(Collectors.toList());
        viewCoursesFromList(coursesInSemester);

    }

    private void viewCourses() {
        List<Course> courses = sem.getCourses();
        viewCoursesFromList(courses);
    }

    private void viewCoursesFromList(List<Course> courses) {
        Table table = new Table(Course.getFields());
        courses.forEach(c -> {
            table.addRow(c.toRecord());
        });
        table.display();
    }
}
