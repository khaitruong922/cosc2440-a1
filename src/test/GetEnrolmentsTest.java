package test;

import model.Course;
import model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.InMemoryStudentEnrolmentManager;
import repository.StudentEnrolmentManager;

import static org.junit.jupiter.api.Assertions.*;

public class GetEnrolmentsTest {
    private StudentEnrolmentManager sem = new InMemoryStudentEnrolmentManager();

    @BeforeEach
    public void setupTest() {
        sem = new InMemoryStudentEnrolmentManager();
        sem.addCourse(new Course("COSC2000", "Intro to Programming", 12));
        sem.addStudent(new Student("s1234567", "Khai Truong", null));

    }

    @Test
    public void emptyOnCreation() {
        assertEquals(sem.getEnrolments().size(), 0);
    }

    @Test
    public void increaseSizeOnAdded() {
        sem.addEnrolment("s1234567", "COSC2000", "2020A");
        assertEquals(sem.getEnrolments().size(), 1);
    }

    @Test
    public void decreaseSizeOnDeleted() {
        sem.addEnrolment("s1234567", "COSC2000", "2020A");
        sem.deleteEnrolment("s1234567", "COSC2000", "2020A");
        assertEquals(sem.getEnrolments().size(), 0);
    }
}
