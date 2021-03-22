import menu.MainMenu;
import repository.InMemoryStudentEnrolmentManager;
import repository.StudentEnrolmentManager;

public class Main {
    public static void main(String[] args) {
        StudentEnrolmentManager sem = new InMemoryStudentEnrolmentManager();
        MainMenu mainMenu = new MainMenu(sem);
        mainMenu.run();
    }

}
