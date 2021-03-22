package menu;

import menu.model.Menu;
import menu.model.Option;
import menu.model.Table;
import model.Student;
import repository.InMemoryStudentEnrolmentManager;
import repository.StudentEnrolmentManager;

import java.util.List;

public class StudentMenu extends Menu {
    private final StudentEnrolmentManager sem = new InMemoryStudentEnrolmentManager();

    public StudentMenu() {
        optionMenu.add(new Option("View students", "1", () -> {
            viewStudents();
            waitForEnter();
            run();
        }));
        optionMenu.add(new Option("Back", "4", () -> {

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
