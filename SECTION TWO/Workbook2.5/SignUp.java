//package Workbook2.5;
import java.util.Scanner;
public class SignUp {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("What is your first name?");
        String firstName = scan.nextLine();

        System.out.println("What is your last Name");
        String lastName = scan.nextLine();

        System.out.println("How old are you?");
        int age = scan.nextInt();

        System.out.println("Make a username");
        scan.nextLine(); //throaway nextLine() to take up wast;ed spaces
        String userName = scan.nextLine();
        System.out.println("What city do you live in?");
        String city = scan.nextLine();
        System.out.println("What country is that?");
        String country = scan.nextLine();

        System.out.println("Thank yuo for joing Javagram");
        System.out.println("\nHere is the information you entered");
        System.out.println("\tFirst Name: " + firstName);
        System.out.println("\tLast Name: " + lastName);
        System.out.println("\tAge: " + age);
        System.out.println("\tUserName: " + userName);
        System.out.println("\tCity: " + city);
        System.out.println("\tCountry: " + country);

        scan.close();
    }
}
