package menu;

import menu.model.InputField;
import menu.model.Menu;
import menu.model.Option;
import model.Course;
import model.Enrolment;
import repository.StudentEnrolmentManager;
import service.CourseService;
import service.InputService;
import service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

public class CourseMenu extends Menu {
    private final CourseService courseService;
    private final InputService inputService;

    public CourseMenu(StudentEnrolmentManager sem) {
        this.courseService = new CourseService(sem);
        this.inputService = new InputService(sem);
        addOption(new Option("View courses", "1", () -> {
            viewCourses();
            waitForEnter();
            run();
        }));
        addOption(new Option("View courses in semester", "2", () -> {
            viewCoursesInSemester();
            waitForEnter();
            run();
        }));
        addOption(new Option("Back", "3", () -> {

        }));
    }

    private void viewCoursesInSemester() {
        String semester = inputService.getSemesterInput();
        if (semester.isEmpty()) return;
        List<Course> coursesInSemester = courseService.getCoursesInSemester(semester);
        CourseService.displayFromList(coursesInSemester);

    }

    private void viewCourses() {
        List<Course> courses = courseService.getCourses();
        CourseService.displayFromList(courses);
    }


}
