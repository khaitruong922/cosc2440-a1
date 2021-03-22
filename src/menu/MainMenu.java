package menu;

import menu.model.Menu;
import menu.model.Option;
import repository.InMemoryStudentEnrolmentManager;
import repository.StudentEnrolmentManager;

public class MainMenu extends Menu {

    private final StudentEnrolmentManager sem = new InMemoryStudentEnrolmentManager();
    private final Menu studentMenu = new StudentMenu();
    private final Menu courseMenu = new CourseMenu();
    private final Menu enrolmentMenu = new EnrolmentMenu();


    public MainMenu() {
        optionMenu.add(new Option("Manage students", "1", () -> {
            studentMenu.run();
            run();
        }));
        optionMenu.add(new Option("Manage courses", "2", () -> {
            courseMenu.run();
            run();
        }));
        optionMenu.add(new Option("Manage enrolments", "3", () -> {
            enrolmentMenu.run();
            run();
        }));
        optionMenu.add(new Option("Quit", "4", () -> {
            quit();
        }));

    }

    private void quit() {
        System.out.println("Program exits.");
    }
}
