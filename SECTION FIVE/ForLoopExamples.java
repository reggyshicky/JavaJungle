public class ForLoopExamples {

    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            System.out.println(i);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Hello, World!");
        }
 
        // TODO: Write a for loop that prints the multiplication table of 5 up to 10 (5 x 1, 5 x 2, ..., 5 x 10)
        for (int i = 1; i < 11; i++) {
            System.out.println(5 * i);
        }
        // TODO: Write a for loop that prints numbers from 10 to 1 in reverse order

        System.out.println("\n\n");
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }

        System.out.println("\n\n");
        // TODO: Write a for loop that prints the first 10 even numbers
        //even numbers are: 0, 2, 4, 6, 8, 10, 12, 14, 16, 18
        for (int i = 0; i < 19; i += 2) {
            System.out.println(i);
        }
    }
}
