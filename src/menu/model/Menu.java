package menu.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private final ArrayList<Option> options = new ArrayList<>();

    protected void addOption(Option option) {
        options.add(option);
    }

    protected void displayOptions() {
        Table table = new Table(Option.getFields());
        for (Option option : options) {
            table.addRow(option.toStringArray());
        }
        table.display();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        displayOptions();
        while (true) {
            System.out.print("Enter an option: ");
            String input = sc.next();
            for (Option option : options) {
                if (option.getToggleKey().equals(input)) {
                    option.execute();
                    return;
                }
            }
            System.out.println("Invalid input.");
        }
    }

    protected void waitForEnter() {
        InputField.waitForEnter();
    }
}
