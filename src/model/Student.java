package model;

import java.util.Date;

public class Student implements Model {
    private final String id;
    private final String name;
    private final Date birthDate;

    private final static String[] fields = {"Student ID", "Name", "Birth Date"};

    public static String[] getFields() {
        return fields;
    }

    public Student(String id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public String[] toRecord() {
        return new String[]{id, name, birthDate == null ? "" : birthDate.toString()};
    }
}
