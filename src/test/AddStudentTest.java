package test;

import model.Student;
import repository.InMemoryStudentEnrolmentManager;
import repository.StudentEnrolmentManager;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

class AddStudentTest {
    private StudentEnrolmentManager sem = new InMemoryStudentEnrolmentManager();

    @Before
    public void recreateInstance() {
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