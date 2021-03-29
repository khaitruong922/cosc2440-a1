package test;

import model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.InMemoryStudentEnrolmentManager;
import repository.StudentEnrolmentManager;

import static org.junit.jupiter.api.Assertions.*;

public class GetCoursesTest {
    private StudentEnrolmentManager sem = new InMemoryStudentEnrolmentManager();

    @BeforeEach
    public void setupTest() {
        sem = new InMemoryStudentEnrolmentManager();
    }

    @Test
    public void emptyOnCreation() {
        assertEquals(sem.getCourses().size(), 0);
    }

    @Test
    public void increaseSizeOnAdded() {
        sem.addCourse(new Course("COSC2000", "Intro to Programming", 12));
        assertEquals(sem.getCourses().size(), 1);
    }
}
