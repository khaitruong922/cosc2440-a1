package model;

import java.util.Date;

public class Student implements Model {
    private String id;
    private String name;
    private Date birthDate;
    private final static String[] fields = {"ID", "Name", "Birth Date"};

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

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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
