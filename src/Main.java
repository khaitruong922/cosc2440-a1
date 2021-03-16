import service.StudentEnrolmentService;

public class Main {
    public static void main(String[] args) {

        StudentEnrolmentService ses = new StudentEnrolmentService();
        ses.printCoursesInSemester("2021A");
        ses.printCoursesOfStudentInSemseter("s3818075","2021A");
        ses.printStudentsInCourseInSemester("COSC2092","2021A");
    }

}
