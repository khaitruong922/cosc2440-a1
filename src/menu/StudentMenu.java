package menu;

import helper.Option;
import model.Student;
import repository.StudentEnrolmentManager;
import service.InputService;
import service.StudentService;
import csv.CsvWriter;

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
            CsvWriter csvWriter = new CsvWriter("students", cid);
            csvWriter.write(students);
        }
    }

    private void viewStudents() {
        List<Student> students = studentService.getStudents();
        StudentService.displayFromList(students);
    }
}
