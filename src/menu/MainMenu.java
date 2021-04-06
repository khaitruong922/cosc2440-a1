package menu;

import helper.Option;
import repository.StudentEnrolmentManager;

public class MainMenu extends Menu {

    private final StudentEnrolmentManager sem;
    private final Menu studentMenu;
    private final Menu courseMenu;
    private final Menu enrolmentMenu;


    public MainMenu(StudentEnrolmentManager sem) {
        this.sem = sem;
        studentMenu = new StudentMenu(sem);
        courseMenu = new CourseMenu(sem);
        enrolmentMenu = new EnrolmentMenu(sem);
        addOption(new Option("Manage students", "1", () -> {
            studentMenu.run();
            run();
        }));
        addOption(new Option("Manage courses", "2", () -> {
            courseMenu.run();
            run();
        }));
        addOption(new Option("Manage enrolments", "3", () -> {
            enrolmentMenu.run();
            run();
        }));
        addOption(new Option("Quit", "4", () -> {
            quit();
        }));

    }

    private void quit() {
        System.out.println("See you again!");
    }
}
