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
import writer.CSVWriter;

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
        addOption(new Option("Back", "3", () -> {

        }));
    }

    private void viewStudentsInCourse() {
        String cid = inputService.getCidInput();
        if (cid.isEmpty()) return;
        String semester = inputService.getSemesterInput();
        if (semester.isEmpty()) return;
        List<Student> students = studentService.getStudentsInCourse(cid, semester);
        StudentService.displayFromList(students);
        String saveReport = inputService.getSaveReportInput();
        if (saveReport.equals("y")) {
            CSVWriter csvWriter = new CSVWriter("students", cid);
            csvWriter.write(students);
        }
    }

    private void viewStudents() {
        List<Student> students = studentService.getStudents();
        StudentService.displayFromList(students);
    }
}
