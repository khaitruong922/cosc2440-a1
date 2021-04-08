package menu;

import helper.Option;
import model.Enrolment;
import repository.StudentEnrolmentManager;
import service.EnrolmentService;
import service.InputService;

import java.util.Collections;
import java.util.List;

public class EnrolmentMenu extends Menu {
    private final EnrolmentService enrolmentService;
    private final InputService inputService;
    private final EnrolmentUpdateMenu enrolmentUpdateMenu;


    public EnrolmentMenu(StudentEnrolmentManager sem) {
        this.enrolmentService = new EnrolmentService(sem);
        this.inputService = new InputService(sem);
        this.enrolmentUpdateMenu = new EnrolmentUpdateMenu(sem);

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
        addOption(new Option("Update enrolments", "3", () -> {
            updateEnrolments();
            run();
        }));
        addOption(new Option("Back", "4", () -> {

        }));


    }

    private void updateEnrolments() {
        String sid = inputService.getSidInput();
        if (sid.isEmpty()) return;
        String semester = inputService.getSemesterInput();
        if (semester.isEmpty()) return;
        System.out.println("You are now updating enrolment info of " + sid + " in semester " + semester);
        enrolmentUpdateMenu.setSid(sid);
        enrolmentUpdateMenu.setSemester(semester);
        enrolmentUpdateMenu.run();
    }

    private void viewEnrolments() {
        List<Enrolment> enrolments = enrolmentService.getEnrolments();
        EnrolmentService.displayFromList(enrolments);
    }

    private void enroll() {
        String sid = inputService.getSidInput();
        if (sid.isEmpty()) return;
        String cid = inputService.getCidInput();
        if (cid.isEmpty()) return;
        String semester = inputService.getSemesterInput();
        if (semester.isEmpty()) return;
        Enrolment enrolment = enrolmentService.addEnrolment(sid, cid, semester);
        if (enrolment == null) {
            System.out.println("Enrolment of student " + sid + " in course " + cid + " in semester " + semester + " already exists!");
            return;
        }
        System.out.println("Enroll student successfully!");
        EnrolmentService.displayFromList(Collections.singletonList(enrolment));
    }
}
