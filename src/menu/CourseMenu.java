package menu;

import menu.model.Menu;
import menu.model.Option;
import menu.model.Table;
import model.Course;
import model.Enrolment;
import repository.InMemoryStudentEnrolmentManager;
import repository.StudentEnrolmentManager;

import java.util.List;

public class CourseMenu extends Menu {
    private final StudentEnrolmentManager sem = new InMemoryStudentEnrolmentManager();

    public CourseMenu() {
        optionMenu.add(new Option("View courses", "1", () -> {
            viewCourses();
            waitForEnter();
            run();
        }));
        optionMenu.add(new Option("Back", "4", () -> {

        }));
    }

    private void viewCourses() {
        List<Course> courses = sem.getCourses();
        Table table = new Table(Course.getFields());
        courses.forEach(c -> {
            table.addRow(c.toRecord());
        });
        table.display();
    }
}
