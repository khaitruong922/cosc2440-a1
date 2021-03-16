package validator;

public interface Validator {
    boolean validate(String input);

    String getErrorMessage();
}
