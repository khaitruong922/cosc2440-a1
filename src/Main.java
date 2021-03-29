import menu.MainMenu;
import repository.InMemoryStudentEnrolmentManager;
import repository.StudentEnrolmentManager;

public class Main {
    public static void main(String[] args) {
        InMemoryStudentEnrolmentManager sem = new InMemoryStudentEnrolmentManager();
        sem.populateData();
        MainMenu mainMenu = new MainMenu(sem);
        mainMenu.run();
    }

}
