package service;

import csv.CsvReader;
import helper.DateParser;
import model.Course;
import model.Enrolment;
import model.Student;
import repository.StudentEnrolmentManager;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsvService {
    private final StudentEnrolmentManager sem;

    public CsvService(StudentEnrolmentManager sem) {
        this.sem = sem;
    }

    private Student csvToStudent(String csv) {
        String[] fields = csv.split(",");
        trimStringArray(fields);
        String id = fields[0];
        String name = fields[1];
        Date birthDate = null;
        try {
            birthDate = DateParser.parse(fields[2]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Student(id, name, birthDate);
    }

    private Course csvToCourse(String csv) {
        String[] fields = csv.split(",");
        trimStringArray(fields);
        String id = fields[0].trim();
        String name = fields[1].trim();
        int numberOfCredits = Integer.parseInt(fields[2]);
        return new Course(id, name, numberOfCredits);
    }

    private Enrolment csvToEnrolment(String csv) {
        String[] fields = csv.split(",");
        trimStringArray(fields);
        String sid = fields[0];
        String cid = fields[1];
        String semester = fields[2];
        return new Enrolment(sem.getStudentById(sid), sem.getCourseById(cid), semester);
    }

    public List<Student> getStudentsFromCsvFile(String fileName) {
        CsvReader csvReader = new CsvReader(fileName);
        List<Student> students = new ArrayList<>();
        csvReader.getAll().forEach(csv -> {
            students.add(csvToStudent(csv));
        });
        return students;
    }

    public List<Course> getCoursesFromCsvFile(String fileName) {
        CsvReader csvReader = new CsvReader(fileName);
        List<Course> courses = new ArrayList<>();
        csvReader.getAll().forEach(csv -> {
            courses.add(csvToCourse(csv));
        });
        return courses;
    }

    public List<Enrolment> getEnrolmentsFromCsvFile(String fileName) {
        CsvReader csvReader = new CsvReader(fileName);
        List<Enrolment> enrolments = new ArrayList<>();
        csvReader.getAll().forEach(csv -> {
            enrolments.add(csvToEnrolment(csv));
        });
        return enrolments;
    }

    private static void trimStringArray(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].trim();
        }
    }
}
