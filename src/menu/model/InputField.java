package menu.model;

import validator.Validator;

import java.util.Scanner;

public class InputField {
    private final String label;
    private boolean required = false;
    private Validator validator = null;

    public InputField(String label) {
        this.label = label;
    }

    public String getInput() {
        System.out.print(label);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (!required && input.isEmpty()) return input;
        if (required && input.isEmpty()) {
            System.out.println("Field is missing.");
            return getInput();
        }
        // Check if the input is valid
        if (validator != null && !validator.validate(input)) {
            return getInput();
        }
        return input;
    }

    public InputField required() {
        required = true;
        return this;
    }

    public InputField setValidator(Validator validator) {
        this.validator = validator;
        return this;
    }

    private static final InputField enterInputField = new InputField("Press Enter to continue...");

    public static void waitForEnter() {
        enterInputField.getInput();
    }
}
