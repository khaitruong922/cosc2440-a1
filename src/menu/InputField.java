package menu;

import validator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputField {
    private final String label;
    private boolean required;
    private final List<Validator> validators = new ArrayList<>();

    public InputField(String label) {
        this.label = label;
        required = false;
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
        for (Validator validator : validators) {
            if (!validator.validate(input)) {
                System.out.println(validator.getErrorMessage());
                return getInput();
            }
        }
        return input;
    }

    public InputField required() {
        required = true;
        return this;
    }

    public InputField addValidator(Validator validator) {
        validators.add(validator);
        return this;
    }
}
