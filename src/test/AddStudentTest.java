package test;

import model.Student;
import repository.InMemoryStudentEnrolmentManager;
import repository.StudentEnrolmentManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddStudentTest {

    private StudentEnrolmentManager sem = new InMemoryStudentEnrolmentManager();

    @BeforeEach
    public void setupTest() {
        sem = new InMemoryStudentEnrolmentManager();
    }

    @Test
    public void shouldAddToListWithNonExistingId() {
        boolean success = sem.addStudent(new Student("s1234567", "Khai Truong", null));
        assertTrue(success);
    }

    @Test
    public void shouldNotAddToListWithExistingId() {
        sem.addStudent(new Student("s1234567", "Khai Truong", null));
        boolean success = sem.addStudent(new Student("s1234567", "Tsuu", null));
        assertFalse(success);
    }

}