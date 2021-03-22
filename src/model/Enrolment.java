package model;

public class Enrolment implements Model {
    private final Student student;
    private final Course course;
    private final String semester;

    private final static String[] fields = {"Student ID", "Course ID", "Semester"};

    public static String[] getFields() {
        return fields;
    }

    public String[] toRecord() {
        return new String[]{student.getId(), course.getId(), semester};
    }

    public Enrolment(Student student, Course course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getSemester() {
        return semester;
    }

    @Override
    public String toString() {
        return "Enrolment{" +
                "student=" + student +
                ", course=" + course +
                ", semester='" + semester + '\'' +
                '}';
    }
}

