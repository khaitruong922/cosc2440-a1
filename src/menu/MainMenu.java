package menu;

import model.Course;
import model.Enrolment;
import model.Student;
import repository.InMemoryStudentEnrolmentManager;
import repository.StudentEnrolmentManager;

import java.util.List;

public class MainMenu {

    private final StudentEnrolmentManager sem = new InMemoryStudentEnrolmentManager();
    private final OptionMenu optionMenu = new OptionMenu();
    private final InputField sidInput;
    private final InputField cidInput;
    private final InputField semesterInput;


    public MainMenu() {
        optionMenu.add(new Option("Students", "1", () -> {
            run();
        }));
        optionMenu.add(new Option("Courses", "2", () -> {
            run();
        }));
        optionMenu.add(new Option("Enroll", "3", () -> {
            enroll();
            InputField.waitForEnter();
            run();
        }));
        optionMenu.add(new Option("All enrolments", "5", () -> {
            displayAllEnrolments();
            InputField.waitForEnter();
            run();
        }));
        optionMenu.add(new Option("Quit", "4", () -> {
            quit();
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

    private void displayAllEnrolments() {
        List<Enrolment> enrolments = sem.getEnrolments();
        Table table = new Table(Enrolment.getFields());
        enrolments.forEach(e -> {
            table.addRow(e.toRecord());
        });
        table.display();
    }

    private void quit() {
        System.out.println("Program exits.");
    }

    public void run() {
        optionMenu.run();
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
