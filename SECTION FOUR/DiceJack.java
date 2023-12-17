import java.util.Scanner;
public class DiceJack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int roll1 = rollDice();
        int roll2 = rollDice();
        int roll3 = rollDice();

        System.out.print("Enter three numbers between 1 and 6: ");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();

        if (isLessThan1(num1, num2, num3) || isHigherThan6(num1, num2, num3)) {
            System.out.println("You entered numbers outside the valid range");
            System.exit(0); //terminates the application, it stops the jvm
        }
        int sumOfNumbers = num1 + num2 + num3;
        int sumOfDiceRolls = roll1 + roll2 + roll3;
        System.out.println("Your Sum: " + sumOfNumbers + " DiceSum: " + sumOfDiceRolls );
        if (userWon(sumOfNumbers, sumOfDiceRolls)) {
            System.out.println("\nCongratulations you won!");
        } else {
            System.out.println("\nBetter Luck next time");
        }
        scan.close();
    }



    public static boolean isLessThan1(int num1, int num2, int num3) {
        return (num1 < 1|| num2 < 1 || num3 < 1);
    }

    public static boolean isHigherThan6(int num1, int num2, int num3) {
        return (num1 > 6 || num2 > 6 || num3 > 6);
    }

    public static int rollDice() {
        //Math.random() returns a no btn 0 - 0.999999999999
        //when we multiply by 6 the returned no will be btn 0-5.999999999999
        double randomNumber = Math.random() * 6; // 0 - 5.99999999999
        randomNumber += 1; //1 - 6.999999999999;
        return (int)randomNumber;

    }

    public static boolean userWon(int sumNumbers, int sumDiceRolls) {
        return (sumNumbers < sumDiceRolls && (sumNumbers - sumDiceRolls) < 3);
    }

    
}
