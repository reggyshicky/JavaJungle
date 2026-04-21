import java.util.Scanner;

public class ProgrammingAssignment1 {
    public static void main(String[] args) {

        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);
        int numbers[] = new int[]{1,2,3,4,5};




        int score = 0; // Variable to store number of correct answers
        String answer; // Variable to store user's answer

        // ================= QUESTION 1 =================
        System.out.println("Q1: What is the capital of France?");
        System.out.println("A. Berlin");
        System.out.println("B. Madrid");
        System.out.println("C. Paris");
        System.out.println("D. Rome");
        System.out.print("Enter your answer (A/B/C/D): ");
        answer = input.nextLine().toUpperCase();

        // Validate input
        if (!(answer.equals("A") || answer.equals("B") || answer.equals("C") || answer.equals("D"))) {
            System.out.println("Invalid input! Moving to next question.\n");
        } else {
            // Check correct answer using switch
            switch (answer) {
                case "C":
                    score++; // increment score if correct
                    break;
            }
        }

        // ================= QUESTION 2 =================
        System.out.println("\nQ2: Which language is used for Android development?");
        System.out.println("A. Java");
        System.out.println("B. Python");
        System.out.println("C. C++");
        System.out.println("D. Swift");
        System.out.print("Enter your answer (A/B/C/D): ");
        answer = input.nextLine().toUpperCase();

        if (!(answer.equals("A") || answer.equals("B") || answer.equals("C") || answer.equals("D"))) {
            System.out.println("Invalid input! Moving to next question.\n");
        } else {
            switch (answer) {
                case "A":
                    score++;
                    break;
            }
        }

        // ================= QUESTION 3 =================
        System.out.println("\nQ3: What is 15 + 3?");
        System.out.println("A. 6");
        System.out.println("B. 18");
        System.out.println("C. 9");
        System.out.println("D. 7");
        System.out.print("Enter your answer (A/B/C/D): ");
        answer = input.nextLine().toUpperCase();

        if (!(answer.equals("A") || answer.equals("B") || answer.equals("C") || answer.equals("D"))) {
            System.out.println("Invalid input! Moving to next question.\n");
        } else {
            switch (answer) {
                case "B":
                    score++;
                    break;
            }
        }

        // ================= QUESTION 4 =================
        System.out.println("\nQ4: Which planet is known as the Red Planet?");
        System.out.println("A. Earth");
        System.out.println("B. Venus");
        System.out.println("C. Mars");
        System.out.println("D. Jupiter");
        System.out.print("Enter your answer (A/B/C/D): ");
        answer = input.nextLine().toUpperCase();

        if (!(answer.equals("A") || answer.equals("B") || answer.equals("C") || answer.equals("D"))) {
            System.out.println("Invalid input! Moving to next question.\n");
        } else {
            switch (answer) {
                case "C":
                    score++;
                    break;
            }
        }

        // ================= QUESTION 5 =================
        System.out.println("\nQ5: Which data type is used to store true/false?");
        System.out.println("A. int");
        System.out.println("B. boolean");
        System.out.println("C. char");
        System.out.println("D. double");
        System.out.print("Enter your answer (A/B/C/D): ");
        answer = input.nextLine().toUpperCase();

        if (!(answer.equals("A") || answer.equals("B") || answer.equals("C") || answer.equals("D"))) {
            System.out.println("Invalid input! Moving to next question.\n");
        } else {
            switch (answer) {
                case "B":
                    score++;
                    break;
            }
        }

        // ================= FINAL RESULT =================

        // Calculate percentage score
        double percentage = (score / 5.0) * 100;

        // Display results
        System.out.println("\n===== QUIZ RESULT =====");
        System.out.println("Correct Answers: " + score + "/5");
        System.out.println("Score: " + percentage + "%");

        // Close scanner
        input.close();
    }
}
