import java.util.Scanner;
public class Guess {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int secret = 4;
        System.out.println("I chose a number between 1 and 5. Try to guess it: ");
        int guess = scan.nextInt();
        while (guess != secret) {
            System.out.print("Guess again: ");
            guess = scan.nextInt();
        }
        scan.close();
    }
}
