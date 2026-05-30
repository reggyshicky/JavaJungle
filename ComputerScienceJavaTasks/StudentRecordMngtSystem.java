import java.util.Scanner;
import java.util.InputMismatchException;


public class StudentRecordMngtSystem {
 
    private static Scanner scan = new Scanner(System.in);
 
    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("   Student Record Management System");
        System.out.println("============================================");
 
        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ");
 
            switch (choice) {
                case 1 -> addStudentFlow();
                case 2 -> updateStudentFlow();
                case 3 -> viewStudentFlow();
                case 4 -> StudentManagement.viewAllStudents();
                case 5 -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("[ERROR] Invalid choice. Please enter 1-5.");
            }
        }
        scan.close();
    }
 
    //Menu 
 
    private static void printMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Add Student");
        System.out.println("2. Update Student");
        System.out.println("3. View Student by ID");
        System.out.println("4. View All Students");
        System.out.println("5. Exit");
    }
 
    //Flows 
 
    /** Collects inputs then calls StudentManagement.addStudent() */
    private static void addStudentFlow() {
        System.out.println("\n-- Add New Student --");
        String name  = readString("Enter name  : ");
        int    id    = readInt   ("Enter ID    : ");
        int    age   = readInt   ("Enter age   : ");
        String grade = readString("Enter grade : ");
 
        if (StudentManagement.addStudent(name, id, age, grade)) {
            System.out.println("[SUCCESS] Student added. Total students: "
                + StudentManagement.getTotalStudents());
        }
    }
 
    /** Collects inputs then calls StudentManagement.updateStudent() */
    private static void updateStudentFlow() {
        System.out.println("\n-- Update Student --");
        int id = readInt("Enter student ID to update: ");
 
        System.out.println("(Leave blank or enter 0 to keep existing value)");
        String newName  = readOptionalString("New name  (or blank): ");
        int    newAge   = readOptionalInt   ("New age   (or 0)    : ");
        String newGrade = readOptionalString("New grade (or blank): ");
 
        if (StudentManagement.updateStudent(id, newName, newAge, newGrade)) {
            System.out.println("[SUCCESS] Student ID " + id + " updated.");
        }
    }
 
    /** Collects an ID then calls StudentManagement.viewStudent() */
    private static void viewStudentFlow() {
        System.out.println("\n-- View Student --");
        int id = readInt("Enter student ID: ");
        StudentManagement.viewStudent(id);
    }
 
    //  Input Helpers 
 
    /**
     * Reads a non-blank string. Re-prompts if empty.
     */
    private static String readString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scan.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("[ERROR] Input cannot be empty.");
        }
    }
 
    /**
     * Reads a string that is allowed to be blank (used for optional update fields).
     * Returns null if blank so the caller can skip that field.
     */
    private static String readOptionalString(String prompt) {
        System.out.print(prompt);
        String input = scan.nextLine().trim();
        return input.isEmpty() ? null : input;
    }
 
    /**
     * Reads a valid integer. Handles InputMismatchException and re-prompts.
     */
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = scan.nextInt();
                scan.nextLine();                       // consumes leftover newline
                return value;
            } catch (InputMismatchException e) {
                scan.nextLine();                        // flushes bad input
                System.out.println("[ERROR] Please enter a valid number.");
            }
        }
    }
 
    /**
     * Reads an integer that is allowed to be 0 (used for optional update fields).
     */
    private static int readOptionalInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = scan.nextInt();
                scan.nextLine();
                return value; // 0 is valid here — caller treats 0 as "no change"
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("[ERROR] Please enter a valid number.");
            }
        }
    }
}

class Student {
    private String name;
    private int id;
    private int age;
    private String grade;

    public Student() {

    }

    public Student(String name, int id, int age, String grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {return name;}
    public int getId(){return id;}
    public int getAge(){return age;}
    public String getGrade(){return grade;}

    public void setName(String name){ this.name = name;}
    public void setAge(int age) {this.age=age;}
    public void setGrade(String grade){this.grade=grade;}

    @Override
    public String toString() {
         return String.format(
            "+-----------------------------------------+%n" +
            "  ID    : %d%n" +
            "  Name  : %s%n" +
            "  Age   : %d%n" +
            "  Grade : %s%n" +
            "+-----------------------------------------+",
            id, name, age, grade
        );
    }
     
}
 
class StudentManagement {
    private static final int MAX_STUDENTS = 100;
    private static Student[] students = new Student[100];
    private static int totalStudents;

    public static boolean addStudent(String name, int id, int age, String grade) {
        if (totalStudents >= MAX_STUDENTS) {
            System.out.println("[ERROR] Student capacity reached. Cannot add more students.");
            return false;
        }
        if (findById(id) != null) {
            System.out.println("[ERROR] A student with ID " + id + " already exists.");
            return false;

        }

        students[totalStudents++] = new Student(name, id, age, grade);
        return true;
    }


     /**
     * Updates an existing student's name, age, or grade by ID.
     * Pass null / -1 for any field you do not want to change.
     *
     * @param id       ID of the student to update
     * @param newName  New name  (null or blank = keep existing)
     * @param newAge   New age   (-1 or 0   = keep existing)
     * @param newGrade New grade (null or blank = keep existing)
     * @return true if updated, false if student not found
     */
    public static boolean updateStudent(int id, String newName, int newAge, String newGrade) {
        Student s = findById(id);
        if (s == null) {
            System.out.println("[ERROR] No student found with ID " + id + ".");
            return false;
        }
        if (newName != null && !newName.isBlank()) s.setName(newName);
        if (newAge > 0) s.setAge(newAge);
        if (newGrade != null && !newGrade.isBlank()) s.setGrade(newGrade);
        return true;
    }



    /**
     * Prints details for a single student by ID.
     *
     * @param id Student ID to look up
     * @return true if found, false otherwise
     */
    public static boolean viewStudent(int id) {
        Student s = findById(id);
        if (s == null) {
            System.out.println("[ERROR] No student found with ID " + id + ".");
            return false;
        }
        System.out.println(s);
        return true;
    }



    /**
     * Linear search through the students array by ID.
     *
     * @param id Student ID to search for
     * @return the matching Student, or null if not found
     */
    private static Student findById(int id) {
        for (int i = 0; i < totalStudents; i++) {
            if ((students[i]).getId() == id) return students[i];
        }
        return null;
    }



     /**
     * Prints all students currently stored in the system.
     */
    public static void viewAllStudents() {
        if (totalStudents == 0) {
            System.out.println("[INFO] No students have been added yet.");
            return;
        }
        System.out.println("\n========= All Students (" + totalStudents + ") =========");
        for (int i = 0; i < totalStudents; i++) {
            System.out.println(students[i]);
        }
    }



    /** @return total number of students currently stored */
    public static int getTotalStudents() { return totalStudents; }


    
}


 