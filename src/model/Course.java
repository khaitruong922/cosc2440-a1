package model;

public class Course implements Model {
    private final String id;
    private final String name;
    private final int numberOfCredits;

    private final static String[] fields = {"Course ID", "Name", "Number of Credits"};

    public static String[] getFields() {
        return fields;
    }

    public Course(String id, String name, int numberOfCredits) {
        this.id = id;
        this.name = name;
        this.numberOfCredits = numberOfCredits;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }


    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", numberOfCredits=" + numberOfCredits +
                '}';
    }

    @Override
    public String[] toRecord() {
        return new String[]{id, name, String.valueOf(numberOfCredits)};
    }
}
