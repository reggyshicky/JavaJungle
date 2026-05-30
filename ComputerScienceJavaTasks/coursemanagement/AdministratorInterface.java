package coursemanagement;

import java.util.*;

public class AdministratorInterface {
    private static Scanner scanner = new Scanner(System.in);
    private static HashMap<String, Student> students = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("Course Enrollment & Grade Management System");
        System.out.println("======================================\n");
        
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = getValidIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addNewCourse();
                    break;
                case 2:
                    enrollStudentInCourse();
                    break;
                case 3:
                    assignGradeToStudent();
                    break;
                case 4:
                    calculateStudentOverallGrade();
                    break;
                case 5:
                    displayAllCourses();
                    break;
                case 6:
                    displayAllStudents();
                    break;
                case 7:
                    displayTotalEnrollments();
                    break;
                case 8:
                    System.out.println("Exiting system. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 8.");
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("========== Main Menu ==========");
        System.out.println("1. Add New Course");
        System.out.println("2. Enroll Student in Course");
        System.out.println("3. Assign Grade to Student");
        System.out.println("4. Calculate Overall Grade");
        System.out.println("5. Display All Courses");
        System.out.println("6. Display All Students");
        System.out.println("7. Display Total Enrollments");
        System.out.println("8. Exit");
        System.out.println("================================");
    }
    
    private static void addNewCourse() {
        System.out.println("\n--- Add New Course ---");
        
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine().trim();
        
        if (courseCode.isEmpty()) {
            System.out.println("Error: Course code cannot be empty!");
            return;
        }
        
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine().trim();
        
        if (courseName.isEmpty()) {
            System.out.println("Error: Course name cannot be empty!");
            return;
        }
        
        int maxCapacity = getValidIntInput("Enter maximum capacity: ");
        
        if (maxCapacity <= 0) {
            System.out.println("Error: Maximum capacity must be positive!");
            return;
        }
        
        CourseManagement.addCourse(courseCode, courseName, maxCapacity);
    }
    
    private static void enrollStudentInCourse() {
        System.out.println("\n--- Enroll Student ---");
        
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine().trim();
        
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine().trim();
        
        Student student = students.getOrDefault(studentId, new Student(studentName, studentId));
        students.put(studentId, student);
        
        CourseManagement.displayAllCourses();
        
        System.out.print("\nEnter course code to enroll: ");
        String courseCode = scanner.nextLine().trim();
        
        Course course = CourseManagement.getCourseByCode(courseCode);
        
        if (course == null) {
            System.out.println("Error: Course not found!");
            return;
        }
        
        CourseManagement.enrollStudent(student, course);
    }
    
    private static void assignGradeToStudent() {
        System.out.println("\n--- Assign Grade ---");
        
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine().trim();
        
        Student student = students.get(studentId);
        
        if (student == null) {
            System.out.println("Error: Student not found!");
            return;
        }
        
        if (student.getEnrolledCourses().isEmpty()) {
            System.out.println("Error: Student is not enrolled in any courses!");
            return;
        }
        
        System.out.println("\nStudent's enrolled courses:");
        for (Course course : student.getEnrolledCourses()) {
            System.out.println("  - " + course);
        }
        
        System.out.print("\nEnter course code: ");
        String courseCode = scanner.nextLine().trim();
        
        Course course = CourseManagement.getCourseByCode(courseCode);
        
        if (course == null) {
            System.out.println("Error: Course not found!");
            return;
        }
        
        if (!student.getEnrolledCourses().contains(course)) {
            System.out.println("Error: Student is not enrolled in this course!");
            return;
        }
        
        double grade = getValidDoubleInput("Enter grade (0-100): ");
        
        CourseManagement.assignGrade(student, course, grade);
    }
    
    private static void calculateStudentOverallGrade() {
        System.out.println("\n--- Calculate Overall Grade ---");
        
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine().trim();
        
        Student student = students.get(studentId);
        
        if (student == null) {
            System.out.println("Error: Student not found!");
            return;
        }
        
        double overallGrade = CourseManagement.calculateOverallGrade(student);
        
        System.out.println("\n=== Grade Report for " + student.getName() + " ===");
        System.out.println("Student ID: " + student.getStudentId());
        
        HashMap<String, Double> grades = student.getCourseGrades();
        
        if (grades.isEmpty()) {
            System.out.println("No grades assigned yet.");
        } else {
            System.out.println("\nCourse Grades:");
            for (Course course : student.getEnrolledCourses()) {
                Double grade = grades.get(course.getCourseCode());
                System.out.printf("  %s: %.2f\n", course.getCourseCode(), grade);
            }
            System.out.printf("\nOverall Grade Average: %.2f\n", overallGrade);
        }
    }
    
    private static void displayAllCourses() {
        CourseManagement.displayAllCourses();
    }
    
    private static void displayAllStudents() {
        System.out.println("\n=== All Students ===");
        
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }
        
        for (Student student : students.values()) {
            System.out.println(student);
        }
    }
    
    private static void displayTotalEnrollments() {
        System.out.println("\n=== Enrollment Statistics ===");
        System.out.println("Total enrolled students across all courses: " + 
                         Course.getTotalEnrolledStudents());
        System.out.println("Total number of students: " + students.size());
        System.out.println("Total number of courses: " + CourseManagement.getCourses().size());
    }
    
    private static int getValidIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer!");
            }
        }
    }
    
    private static double getValidDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number!");
            }
        }
    }
}

