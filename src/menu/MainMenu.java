package menu;

import repository.InMemoryStudentEnrolmentManager;
import repository.StudentEnrolmentManager;
import validator.Validator;

public class MainMenu {

    private final StudentEnrolmentManager sem = new InMemoryStudentEnrolmentManager();
    private final SemesterMenu semesterMenu = new SemesterMenu();
    private final OptionMenu optionMenu;

    public MainMenu() {
        optionMenu = new OptionMenu();
        optionMenu.add(new Option("Students", "1", () -> {
            run();
        }));
        optionMenu.add(new Option("Courses", "2", () -> {
            run();
        }));
        optionMenu.add(new Option("Quit", "3", () -> {
            System.out.println("Program exits.");
        }));
    }

    public void run() {
        optionMenu.run();
    }
}
