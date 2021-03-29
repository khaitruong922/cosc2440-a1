package test;

import model.Course;
import model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.InMemoryStudentEnrolmentManager;
import repository.StudentEnrolmentManager;

import static org.junit.jupiter.api.Assertions.*;

public class GetStudentsTest {
    private StudentEnrolmentManager sem = new InMemoryStudentEnrolmentManager();

    @BeforeEach
    public void setupTest() {
        sem = new InMemoryStudentEnrolmentManager();
    }

    @Test
    public void emptyOnCreation() {
        assertEquals(sem.getStudents().size(), 0);
    }

    @Test
    public void increaseSizeOnAdded() {
        sem.addStudent(new Student("s1234567", "Khai Truong", null));
        assertEquals(sem.getStudents().size(), 1);
    }
}
