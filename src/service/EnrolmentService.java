package service;

import helper.Table;
import model.Enrolment;
import repository.StudentEnrolmentManager;

import java.util.List;

public class EnrolmentService {
    private final StudentEnrolmentManager sem;

    public EnrolmentService(StudentEnrolmentManager sem) {
        this.sem = sem;
    }


    public static void displayFromList(List<Enrolment> enrolments) {
        Table table = new Table(Enrolment.getFields());
        enrolments.forEach(e -> {
            table.addRow(e.toRecord());
        });
        table.display();
    }

    public Enrolment addEnrolment(String sid, String cid, String semester) {
        return sem.addEnrolment(sid, cid, semester);
    }

    public List<Enrolment> getEnrolments() {
        return sem.getEnrolments();
    }


    public boolean deleteEnrolment(String sid, String cid, String semester) {
        return sem.deleteEnrolment(sid, cid, semester);
    }
}
