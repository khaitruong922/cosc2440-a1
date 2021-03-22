package service;

import menu.model.InputField;
import model.Course;
import model.Student;
import repository.StudentEnrolmentManager;

public class InputService {
    private final InputField cidInputField;
    private final InputField sidInputField;
    private final InputField semesterInputField;
    private final StudentEnrolmentManager sem;

    public InputService(StudentEnrolmentManager sem) {
        this.sem = sem;
        sidInputField = new InputField("Student ID: ").setValidator(input -> {
            Student s = this.sem.getStudentById(input);
            if (s != null) return true;
            System.out.println("Student ID " + input + " does not exist.");
            return false;
        });
        cidInputField = new InputField("Course ID: ").setValidator(input -> {
            Course c = this.sem.getCourseById(input);
            if (c != null) return true;
            System.out.println("Course ID " + input + " does not exist.");
            return false;
        });
        semesterInputField = new InputField("Semester: ");
    }

    public String getSidInput() {
        return sidInputField.getInput();
    }

    public String getCidInput() {
        return cidInputField.getInput();
    }

    public String getSemesterInput() {
        return semesterInputField.getInput();
    }
}
