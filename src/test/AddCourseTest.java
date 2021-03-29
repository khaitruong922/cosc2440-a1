package test;

import model.Course;
import model.Student;
import repository.InMemoryStudentEnrolmentManager;
import repository.StudentEnrolmentManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddCourseTest {
    private StudentEnrolmentManager sem = new InMemoryStudentEnrolmentManager();

    @BeforeEach
    public void setupTest() {
        sem = new InMemoryStudentEnrolmentManager();
    }

    @Test
    public void shouldAddToListWithNonExistingId() {
        boolean success = sem.addCourse(new Course("COSC2000", "Intro to Programming", 12));
        assertTrue(success);
    }

    @Test
    public void shouldNotAddToListWithExistingId() {
        sem.addCourse(new Course("COSC2000", "Intro to Programming", 12));
        boolean success = sem.addCourse(new Course("COSC2000", "Intro to Programming 2", 24));
        assertFalse(success);
    }

}