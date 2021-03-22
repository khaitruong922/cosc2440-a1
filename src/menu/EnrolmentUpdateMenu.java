package menu;

import menu.model.Menu;
import menu.model.Option;
import model.Course;
import repository.StudentEnrolmentManager;
import service.CourseService;
import service.EnrolmentService;
import service.InputService;

import java.util.List;

public class EnrolmentUpdateMenu extends Menu {
    private final EnrolmentService enrolmentService;
    private final CourseService courseService;
    private final InputService inputService;

    private String sid;
    private String semester;

    public EnrolmentUpdateMenu(StudentEnrolmentManager sem) {
        this.enrolmentService = new EnrolmentService(sem);
        this.courseService = new CourseService(sem);
        this.inputService = new InputService(sem);
        addOption(new Option("View enrolled courses", "1", () -> {
            viewEnrolledCourses();
            waitForEnter();
            run();
        }));
        addOption(new Option("Enroll course", "2", () -> {
            enrollCourse();
            waitForEnter();
            run();
        }));
        addOption(new Option("Drop course", "3", () -> {
            dropCourse();
            waitForEnter();
            run();
        }));
        addOption(new Option("Back", "4", () -> {

        }));


    }

    private void dropCourse() {
        viewEnrolledCourses();
        String cid = inputService.getCidInput();
        if (cid.isEmpty()) return;
        List<Course> courses = courseService.getCoursesOfStudent(sid, semester);
        Course course = courses.stream().filter(c -> c.getId().equals(cid)).findFirst().orElse(null);
        if (course == null) {
            System.out.println("Student " + sid + " does not enrolled in " + cid + " in " + semester);
            return;
        }
        enrolmentService.deleteEnrolment(sid, cid, semester);
    }

    private void enrollCourse() {
    }

    private void viewEnrolledCourses() {
        List<Course> courses = courseService.getCoursesOfStudent(sid, semester);
        CourseService.displayFromList(courses);
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
