import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Let's play Rock Paper Scissors.");
        System.out.println("When I say 'shoot', Choose: rock, paper, or scissors.\n");
        System.out.println("Are you ready? Write 'yes' if you are.");
        String response = scan.nextLine();

        if (response.equals("yes")) {
            System.out.println("Great");
            System.out.println("rock - paper - scissors, shoot!");
            String userChoice = scan.nextLine();
            String compChoice = computerChoice();

            String finalResult = result(userChoice, compChoice);
            printResult(userChoice, compChoice, finalResult);
        
        } else {
            System.out.println("Darn, some other time...!");
        }
        scan.close();
    }

    public static String computerChoice() {
        int randomNumber = (int)(Math.random() * 3); // 0 - 2.9999999
        if (randomNumber == 0) {
            return "rock";
        } else if (randomNumber == 1) {
            return "paper";
        } else if (randomNumber == 2) {
            return "scissors";
        } else {
            return "Error in the app. Please visit this bag";
        }

    }

    public static String result(String yourChoice, String computerChoice) {
        String result = "";
        if (yourChoice.equals("rock") && computerChoice.equals("scissors")) {
            return "You win!";
        } else if (yourChoice.equals("paper") && computerChoice.equals("rock")) {
            return "You win!";
        } else if (yourChoice.equals("scissors") && computerChoice.equals("paper")) {
            return "You win!";
        } else if (computerChoice.equals("rock") && yourChoice.equals("scissors")) {
            return "You Lose!";
        } else if (computerChoice.equals("paper") && yourChoice.equals("rock")) {
            return "You Lose!";
        } else if (computerChoice.equals("scissors") && yourChoice.equals("paper")) {
            return "You Lose!";
        } else if (yourChoice.equals(computerChoice)) {
            return "It is a tie";
        } else {
            System.out.println("Invalid choice");
            System.exit(0);
        }

        return result;
    }

     public static void printResult(String yourChoice, String computerChoice, String result) {
        System.out.println("\nYou chose: " + yourChoice);
        System.out.println("The computer chose: " + computerChoice);
        System.out.println(result);
     }
}