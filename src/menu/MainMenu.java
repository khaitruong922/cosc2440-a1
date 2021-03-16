package menu;

import service.StudentEnrolmentService;

public class MainMenu {
    private static final MainMenu instance = new MainMenu();

    private static MainMenu getInstance() {
        return instance;
    }

    private final StudentEnrolmentService ses = new StudentEnrolmentService();
    private final OptionMenu optionMenu;

    private MainMenu() {
        optionMenu = new OptionMenu();
        optionMenu.add(new Option("View courses in semester", "1", () -> {
            ses.printCoursesInSemester("2021A");
        }));
        optionMenu.add(new Option("View courses of student in semester", "2", () -> {
            ses.printStudentsInCourseInSemester("COSC2092", "2021A");
        }));
        optionMenu.add(new Option("View students in course in semester", "3", () -> {
            ses.printCoursesOfStudentInSemseter("s3818074", "2021A");

        }));
    }
}
