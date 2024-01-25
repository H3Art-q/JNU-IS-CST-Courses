package lab7.chapter11;
// 11.5

import java.util.ArrayList;

public class Course {
    private final String courseName;
    private final ArrayList<String> students = new ArrayList<>();
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        students.add(student);
        numberOfStudents++;
    }

    public ArrayList<String> getStudents() {
        return new ArrayList<>(students);
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void clear() {
        students.clear();
        numberOfStudents = 0;
    }

    public void dropStudent(String student) {
        students.remove(student);
        numberOfStudents--;
    }
}
