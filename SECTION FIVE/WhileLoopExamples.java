public class WhileLoopExamples {

    public static void main(String[] args) {
        // Example 1: Roll a dice until a 6 is rolled
        int diceroll = 0;
        while (diceroll != 6) {
            diceroll = rollDice();
        }

        // Example 2: Generate random numbers between 1 and 100 until a number greater than 90 is generated

        int number = 0;
        while (number <= 90) {
            number = generateRandomNumber();
        }
        // TODO: Write a while loop that keeps doubling the 'number' variable until it's greater than 1000

        int num = generateRandomNumber();
        while (num <= 1000) {
            num *= 2;
            System.out.println(num);
        }


    }

    // Function to simulate rolling a dice (returns a random integer between 1 and 6)
    public static int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }

    // Function to generate a random integer between 1 and 100
    public static int generateRandomNumber() {
        return (int) (Math.random() * 100) + 1;
    }
}
