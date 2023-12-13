//package SECTION TWO.Challenge2;
import java.util.Scanner;
public class Chatbot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Hello. What is your name?");
        String name = scan.nextLine();
        
        System.out.println("\nHi " + name + " i'm Javabot.Where are you from?");
        String location = scan.nextLine();
        System.out.println(location + " is a very beautiful place");

        System.out.println("\nHow old are you?");
        int age = scan.nextInt();
        System.out.println("So you are " + age + ", cool! I'm 400 years old,");
        System.out.println("This means I'm " + (400 / age) + " times older than you.");

        System.out.println("\nEnough about me.What's your favourite language? (just don't say Ruby)");
        scan.nextLine(); //throwaway nextLine
        String language = scan.nextLine();
        System.out.println(language + ", that's great! Nice chatting with you " + name + "  I have to log off now. See ya");










        scan.close();






    }
}
