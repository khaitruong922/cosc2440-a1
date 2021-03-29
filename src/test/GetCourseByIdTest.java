package test;

import model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.InMemoryStudentEnrolmentManager;
import repository.StudentEnrolmentManager;

import static org.junit.jupiter.api.Assertions.*;

public class GetCourseByIdTest {
    private StudentEnrolmentManager sem = new InMemoryStudentEnrolmentManager();

    @BeforeEach
    public void setupTest() {
        sem = new InMemoryStudentEnrolmentManager();
    }

    @Test
    public void shouldReturnCourseIfFound() {
        Course course = new Course("COSC2000", "Intro to Programming", 12);
        sem.addCourse(course);
        Course foundCourse = sem.getCourseById("COSC2000");
        assertNotNull(foundCourse);
        assertEquals(foundCourse.getId(), course.getId());
        assertEquals(foundCourse.getName(), course.getName());
        assertEquals(foundCourse.getNumberOfCredits(), course.getNumberOfCredits());
    }

    @Test
    public void shouldReturnNullIfNotFound() {
        Course foundCourse = sem.getCourseById("COSC2000");
        assertNull(foundCourse);
    }
}