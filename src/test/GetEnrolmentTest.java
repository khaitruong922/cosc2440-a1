package test;

import model.Course;
import model.Enrolment;
import model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.InMemoryStudentEnrolmentManager;
import repository.StudentEnrolmentManager;

import static org.junit.jupiter.api.Assertions.*;

public class GetEnrolmentTest {
    private StudentEnrolmentManager sem = new InMemoryStudentEnrolmentManager();

    @BeforeEach
    public void setupTest() {
        sem = new InMemoryStudentEnrolmentManager();
        sem.addCourse(new Course("COSC2000", "Intro to Programming", 12));
        sem.addStudent(new Student("s1234567", "Khai Truong", null));
    }

    @Test
    public void shouldReturnEnrolmentIfExists() {
        sem.addEnrolment("s1234567", "COSC2000", "2020A");
        Enrolment enrolment = sem.getEnrolment("s1234567", "COSC2000", "2020A");
        assertNotNull(enrolment);
    }

    @Test
    public void shouldReturnNullIfNotExists() {
        Enrolment enrolment = sem.getEnrolment("s1234567", "COSC2000", "2020A");
        assertNull(enrolment);
    }
}
