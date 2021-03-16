package menu;

import validator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputField {
    private String label;
    private boolean required;
    private List<Validator> validators = new ArrayList<>();

    public InputField(String label) {
        this.label = label;
        required = false;
    }

    public InputField required() {
        required = true;
        return this;
    }

    public String getInput(Validator validator, String errorMessage) {
        System.out.print(label);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (!required && input.isEmpty()) return input;
        if (required && input.isEmpty()) {
            System.out.println("Field is missing.");
            return getInput(validator, errorMessage);
        }
        // Check if the input is valid
        if (validator.validate(input)) return input;
        // Print error message and ask the user to type again if it is not valid
        if (!errorMessage.isEmpty()) System.out.println(errorMessage);
        return getInput(validator, errorMessage);
    }

    public InputField addValidator(Validator validator) {
        validators.add(validator);
        return this;
    }
}
