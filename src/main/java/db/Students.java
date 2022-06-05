package db;

public class Students {

    private final int id;
    private final String last_name;
    private final String first_name;
    private final int course;

    public Students(int id, String last_name, String first_name, int course) {
        this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", id, last_name, first_name, course);
    }
}
