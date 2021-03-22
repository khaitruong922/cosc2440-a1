package menu;

import menu.model.Menu;
import menu.model.Option;
import menu.model.Table;
import model.Student;
import repository.InMemoryStudentEnrolmentManager;
import repository.StudentEnrolmentManager;

import java.util.List;

public class StudentMenu extends Menu {
    private final StudentEnrolmentManager sem;

    public StudentMenu(StudentEnrolmentManager sem) {
        this.sem = sem;
        addOption(new Option("View students", "1", () -> {
            viewStudents();
            waitForEnter();
            run();
        }));
        addOption(new Option("Back", "4", () -> {

        }));
    }

    private void viewStudents() {
        List<Student> students = sem.getStudents();
        Table table = new Table(Student.getFields());
        students.forEach(s -> {
            table.addRow(s.toRecord());
        });
        table.display();
    }
}
