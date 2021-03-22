package menu;

import menu.model.InputField;
import menu.model.Menu;
import menu.model.Option;
import menu.model.Table;
import model.Course;
import model.Enrolment;
import model.Student;
import repository.InMemoryStudentEnrolmentManager;
import repository.StudentEnrolmentManager;

import java.util.List;

public class EnrolmentMenu extends Menu {
    private final StudentEnrolmentManager sem;
    private final InputField sidInput;
    private final InputField cidInput;
    private final InputField semesterInput;

    public EnrolmentMenu(StudentEnrolmentManager sem) {
        this.sem = sem;
        addOption(new Option("View enrolments", "1", () -> {
            viewEnrolments();
            waitForEnter();
            run();
        }));
        addOption(new Option("Enroll", "2", () -> {
            enroll();
            waitForEnter();
            run();
        }));
        addOption(new Option("Back", "4", () -> {

        }));
        sidInput = new InputField("Student ID: ").required().setValidator(input -> {
            Student s = sem.getStudentById(input);
            if (s != null) return true;
            System.out.println("Student ID " + input + " does not exist.");
            return false;
        });
        cidInput = new InputField("Course ID: ").required().setValidator(input -> {
            Course c = sem.getCourseById(input);
            if (c != null) return true;
            System.out.println("Course ID " + input + " does not exist.");
            return false;
        });
        semesterInput = new InputField("Semester: ").required();

    }

    private void viewEnrolments() {
        List<Enrolment> enrolments = sem.getEnrolments();
        Table table = new Table(Enrolment.getFields());
        enrolments.forEach(e -> {
            table.addRow(e.toRecord());
        });
        table.display();
    }

    public void enroll() {
        String sid = sidInput.getInput();
        String cid = cidInput.getInput();
        String semester = semesterInput.getInput();
        Enrolment enrolment = sem.addEnrolment(sid, cid, semester);
        System.out.println("Enroll student successfully!");
        Table table = new Table(Student.getFields());
        table.addRow(enrolment.toRecord());
        table.display();
    }
}
