package menu;

import menu.model.Menu;
import menu.model.Option;
import model.Course;
import repository.StudentEnrolmentManager;
import service.CourseService;
import service.InputService;
import writer.CSVWriter;

import java.util.List;

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
        addOption(new Option("View courses of student in semester", "3", () -> {
            viewCoursesOfStudentInSemester();
            waitForEnter();
            run();
        }));
        addOption(new Option("Back", "4", () -> {

        }));
    }

    private void viewCoursesOfStudentInSemester() {
        String sid = inputService.getSidInput();
        if (sid.isEmpty()) return;
        String semester = inputService.getSemesterInput();
        if (semester.isEmpty()) return;
        List<Course> courses = courseService.getCoursesOfStudentInSemester(sid, semester);
        CourseService.displayFromList(courses);
        String saveReport = inputService.getSaveReportInput();
        if (saveReport.equals("y")) {
            CSVWriter csvWriter = new CSVWriter("courses", sid, semester);
            csvWriter.write(courses);
        }
    }

    private void viewCoursesInSemester() {
        String semester = inputService.getSemesterInput();
        if (semester.isEmpty()) return;
        List<Course> courses = courseService.getCoursesInSemester(semester);
        CourseService.displayFromList(courses);
        String saveReport = inputService.getSaveReportInput();
        if (saveReport.equals("y")) {
            CSVWriter csvWriter = new CSVWriter("courses", semester);
            csvWriter.write(courses);
        }
    }

    private void viewCourses() {
        List<Course> courses = courseService.getCourses();
        CourseService.displayFromList(courses);
    }


}
