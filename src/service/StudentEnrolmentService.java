package service;

import repository.InMemoryStudentEnrolmentManager;
import repository.StudentEnrolmentManager;

public class StudentEnrolmentService {
    private final StudentEnrolmentManager sem = new InMemoryStudentEnrolmentManager();

    public void printCoursesInSemester(String semester) {
        sem.getCoursesInSemester(semester).forEach(c -> {
            System.out.println(c.toString());
        });
    }

    public void printCoursesOfStudentInSemseter(String studentId, String semester) {
        sem.getCoursesOfStudentInSemseter(studentId, semester).forEach(c -> {
            System.out.println(c.toString());
        });
    }

    public void printStudentsInCourseInSemester(String courseId, String semester) {
        sem.getStudentsInCourseInSemester(courseId, semester).forEach(s -> {
            System.out.println(s.toString());
        });
    }


}
