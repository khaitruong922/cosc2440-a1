package test;

import model.Course;
import model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.InMemoryStudentEnrolmentManager;
import repository.StudentEnrolmentManager;

import static org.junit.jupiter.api.Assertions.*;

public class GetStudentByIdTest {
    private StudentEnrolmentManager sem = new InMemoryStudentEnrolmentManager();

    @BeforeEach
    public void setupTest() {
        sem = new InMemoryStudentEnrolmentManager();
    }

    @Test
    public void shouldReturnStudentIfFound() {
        Student student = new Student("s1234567", "Khai Truong", null);
        sem.addStudent(student);
        Student foundStudent = sem.getStudentById("s1234567");
        assertNotNull(foundStudent);
        assertEquals(student.getId(), foundStudent.getId());
        assertEquals(student.getName(), foundStudent.getName());
        assertEquals(student.getBirthDate(), foundStudent.getBirthDate());
    }

    @Test
    public void shouldReturnNullIfNotFound() {
        Student foundStudent = sem.getStudentById("s1234567");
        assertNull(foundStudent);
    }
}