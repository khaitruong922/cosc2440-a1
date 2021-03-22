package menu;

import menu.model.InputField;
import menu.model.Menu;
import menu.model.Option;
import model.Course;
import model.Student;
import repository.StudentEnrolmentManager;
import service.CourseService;
import service.InputService;
import service.StudentService;

import java.util.List;

public class StudentMenu extends Menu {
    private final StudentService studentService;
    private final InputService inputService;

    public StudentMenu(StudentEnrolmentManager sem) {
        this.studentService = new StudentService(sem);
        this.inputService = new InputService(sem);
        addOption(new Option("View students", "1", () -> {
            viewStudents();
            waitForEnter();
            run();
        }));
        addOption(new Option("View students in course", "2", () -> {
            viewStudentsInCourse();
            waitForEnter();
            run();
        }));
        addOption(new Option("Back", "4", () -> {

        }));
    }

    private void viewStudentsInCourse() {
        String cid = inputService.getCidInput();
        String semester = inputService.getSemesterInput();
        List<Student> students = studentService.getStudentsInCourse(cid, semester);
        StudentService.displayFromList(students);
    }

    private void viewStudents() {
        List<Student> students = studentService.getStudents();
        StudentService.displayFromList(students);
    }
}
