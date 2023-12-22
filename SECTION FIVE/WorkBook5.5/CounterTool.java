import java.util.Scanner;
public class CounterTool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("I hear you like to count by threes");
        scan.nextLine();

        System.out.println("\nOh, Ok...");
        System.out.println("\tPick a number to count by: ");
        int interval = scan.nextInt();
        System.out.println("\tPick a number to start counting from: ");
        int start = scan.nextInt();
        System.out.println("\tPick a number to count to: ");
        int end = scan.nextInt();

        for (int i = start; i <= end; i += interval) {
            System.out.print(i + " ");
        }

        scan.close();
    }
}
