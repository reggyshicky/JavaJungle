package coursemanagement;

import java.util.*;

public class Student {
    private String name;
    private String studentId;
    private ArrayList<Course> enrolledCourses;
    private HashMap<String, Double> courseGrades;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.enrolledCourses = new ArrayList<>();
        this.courseGrades = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public HashMap<String, Double> getCourseGrades() {
        return courseGrades;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public boolean enrollInCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            courseGrades.put(course.getCourseCode(), 0.0);
            return true;
        }
        return false;
    }

    public void assignGrade(Course course, double grade) {
        if (enrolledCourses.contains(course)) {
            courseGrades.put(course.getCourseCode(), grade);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentId='" + studentId + '\'' +
                ", enrolledCourses=" + enrolledCourses.size() +
                '}';
    }
}

