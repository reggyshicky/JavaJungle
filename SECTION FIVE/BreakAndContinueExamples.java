public class BreakAndContinueExamples {

    public static void main(String[] args) {
        // TODO: Write a loop that prints numbers from 1 to 10, but stops when the number 5 is reached using the 'break' statement
        for (int i = 1; i < 11; i++) {
            if (i == 5) {
                break;
            } else {
                System.out.println(i);
            }
        }
        System.out.println("\n\n");
        // TODO: Write a loop that prints numbers from 1 to 10, but skips the number 5 using the 'continue' statement
        for (int i = 1; i < 11; i++) {
            if (i == 5) {
                continue;
            }
            System.out.println(i);
        }
        System.out.println("\n");
        // TODO: Write a loop that finds the smallest number greater than 20 that is divisible by 3 using the 'break' statement
        //Initialize j to a value greater than 20
        int j = 21; //You can start with 21, as 21 is the samllest number reater than 20
        while (true) {
            if (j % 3 == 0) {
                System.out.println("The smallest number greater than 20 that is divisible by 3 is: " + j);
                break;
            }
            j++;
        }
        // TODO: Write a loop that prints all even numbers from 1 to 20, skipping odd numbers using the 'continue' statement
        System.out.println("\nEvenNumbers");
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            } else {
                continue;
            }
        }
    }
}
