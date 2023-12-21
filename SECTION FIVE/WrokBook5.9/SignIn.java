import java.util.Scanner;

public class SignIn {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userName = "Samantha";
        String password = "Java <3";

        System.out.println("\nWelcome to Javagram! Sign in below");
        System.out.print("- UserName: ");
        String usernameEntry = scan.nextLine();
        System.out.print("- Password: ");
        String passwordEntry = scan.nextLine();

        while (!usernameEntry.equals(userName) || !passwordEntry.equals(password)) {
            System.out.println("\nIncorrect, please try again");
            System.out.print("- UserName: ");
            usernameEntry = scan.nextLine();
            System.out.print("- Password: ");
            passwordEntry = scan.nextLine();
        }
        System.out.println("\nLogin successful!");
        scan.close();

    }
}
