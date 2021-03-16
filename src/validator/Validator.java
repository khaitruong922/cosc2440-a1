package validator;

public interface Validator {
    boolean validate(String input);

    default String getErrorMessage() {
        return "Invalid input.";
    }
}
