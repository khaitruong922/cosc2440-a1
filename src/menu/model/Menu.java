package menu.model;

public abstract class Menu {
    protected OptionMenu optionMenu = new OptionMenu();

    public void run() {
        optionMenu.run();
    }

    protected static void waitForEnter() {
        InputField.waitForEnter();
    }
}
