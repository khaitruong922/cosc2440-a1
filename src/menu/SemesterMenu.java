package menu;

public class SemesterMenu {
    private String semester = null;
    private final OptionMenu optionMenu;

    public SemesterMenu() {
        optionMenu = new OptionMenu();
        optionMenu.add(new Option("View courses", "1", () -> {

        }));
        optionMenu.add(new Option("View students", "2", () -> {

        }));
        optionMenu.add(new Option("Back", "3", () -> {

        }));
    }

    public void run() {
        optionMenu.run();
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
