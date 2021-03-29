package test;

import model.Course;
import model.Enrolment;
import model.Student;
import repository.InMemoryStudentEnrolmentManager;
import repository.StudentEnrolmentManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddEnrolmentTest {
    private StudentEnrolmentManager sem = new InMemoryStudentEnrolmentManager();

    @BeforeEach
    public void setupTest() {
        sem = new InMemoryStudentEnrolmentManager();
        sem.addCourse(new Course("COSC2000", "Intro to Programming", 12));
        sem.addStudent(new Student("s1234567", "Khai Truong", null));
        sem.addEnrolment("s1234567", "COSC2000", "2020A");
    }

    @Test
    public void shouldNotAddWithNonExistingStudentId() {
        Enrolment enrolment = sem.addEnrolment("s0000000", "COSC2000", "2020B");
        assertNull(enrolment);
    }

    @Test
    public void shouldNotAddWithNonExistingCourseId() {
        Enrolment enrolment = sem.addEnrolment("s1234567", "COSC0000", "2020B");
        assertNull(enrolment);
    }

    @Test
    public void shouldNotAddDuplicateEnrolment() {
        Enrolment enrolment = sem.addEnrolment("s1234567", "COSC2000", "2020A");
        assertNull(enrolment);
    }

    @Test
    public void shouldAddValidEnrolment() {
        Enrolment enrolment = sem.addEnrolment("s1234567", "COSC2000", "2020B");
        assertNotNull(enrolment);
    }

}