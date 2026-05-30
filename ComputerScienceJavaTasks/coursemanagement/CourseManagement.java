package coursemanagement;
import java.util.*;

public class CourseManagement {
    private static ArrayList<Course> courses = new ArrayList<>();
    private static HashMap<String, HashMap<String, Double>> overallGrades = new HashMap<>();

    public static void addCourse(String courseCode, String courseName, int maxCapacity) {
        Course newCourse = new Course(courseCode, courseName, maxCapacity);
        courses.add(newCourse);
        System.out.println("Course added successfully: " + newCourse);
    }

    public static boolean enrollStudent(Student student, Course course) {
        if (!course.hasCapacity()) {
            System.out.println("Error: Course " + course.getCourseCode() +
                    " has reached maximum capacity!");
            return false;
        }

        if (student.enrollInCourse(course)) {
            course.incrementEnrollment();
            System.out.println("Student " + student.getName() +
                    " enrolled in " + course.getCourseCode());
            return true;
        } else {
            System.out.println("Student is already enrolled in this course.");
            return false;
        }
    }

    public static void assignGrade(Student student, Course course, double grade) {
        if (grade < 0 || grade > 100) {
            System.out.println("Error: Grade must be between 0 and 100!");
            return;
        }

        student.assignGrade(course, grade);

        overallGrades.putIfAbsent(student.getStudentId(), new HashMap<>());
        overallGrades.get(student.getStudentId()).put(course.getCourseCode(), grade);

        System.out.println("Grade " + grade + " assigned to " + student.getName() +
                " for course " + course.getCourseCode());
    }

    public static double calculateOverallGrade(Student student) {
        HashMap<String, Double> grades = student.getCourseGrades();

        if (grades.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        int count = 0;

        for (Double grade : grades.values()) {
            total += grade;
            count++;
        }

        return count > 0 ? total / count : 0.0;
    }

    public static Course getCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                return course;
            }
        }
        return null;
    }

    public static void displayAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        System.out.println("\n=== Available Courses ===");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public static ArrayList<Course> getCourses() {
        return courses;
    }
}

