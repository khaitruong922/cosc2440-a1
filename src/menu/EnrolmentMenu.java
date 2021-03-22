package menu;

import menu.model.InputField;
import menu.model.Menu;
import menu.model.Option;
import menu.model.Table;
import model.Course;
import model.Enrolment;
import model.Student;
import repository.StudentEnrolmentManager;
import service.EnrolmentService;
import service.InputService;

import java.util.List;

public class EnrolmentMenu extends Menu {
    private final EnrolmentService enrolmentService;
    private final InputService inputService;

    public EnrolmentMenu(StudentEnrolmentManager sem) {
        this.enrolmentService = new EnrolmentService(sem);
        this.inputService = new InputService(sem);
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


    }

    private void viewEnrolments() {
        List<Enrolment> enrolments = enrolmentService.getEnrolments();
        EnrolmentService.displayFromList(enrolments);
    }

    public void enroll() {
        String sid = inputService.getSidInput();
        String cid = inputService.getCidInput();
        String semester = inputService.getSemesterInput();
        Enrolment enrolment = enrolmentService.addEnrolment(sid, cid, semester);
        System.out.println("Enroll student successfully!");
        Table table = new Table(Student.getFields());
        table.addRow(enrolment.toRecord());
        table.display();
    }
}
