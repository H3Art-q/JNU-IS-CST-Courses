package lab6.chapter10;
// 10.9

public class Course {
    private int capacity = 100;
    private String courseName;
    private String[] students = new String[capacity];
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        if (numberOfStudents + 1 > capacity) {
            capacity *= 2;
            String[] increasedStudents = new String[capacity];
            System.arraycopy(students, 0, increasedStudents, 0, numberOfStudents);
            students = increasedStudents;
        }
        students[numberOfStudents] = student;
        numberOfStudents++;

    }

    public String[] getStudents() {
        String[] exactStudents = new String[numberOfStudents];
        System.arraycopy(students, 0, exactStudents, 0, numberOfStudents);
        return exactStudents;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {
        // Left as an exercise in Programming Exercise 10.9
        // Search
        int index = -1;
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].equals(student)) {
                index = i;
                break;
            }
        }

        // Drop
        if (index == -1) {
            System.out.println("Student: " + student + " doesn't exist");
        } else {
            for (int i = index; i < numberOfStudents; i++) {
                students[i] = students[i + 1];
            }
            numberOfStudents--;
        }

        // Capacity adjustment
        if(numberOfStudents <= capacity / 2){
            capacity /= 2;
            String[] increasedStudents = new String[capacity];
            System.arraycopy(students, 0, increasedStudents, 0, numberOfStudents);
            students = increasedStudents;
        }
    }

    public void clear() {
        numberOfStudents = 0;
        capacity = 100;
        students = new String[capacity];
    }
}
