public class Receipt {
    public static void main(String[] args) {
        String[] apples = {"Gala", "Granny Smith", "Macintosh"};
        double[] price = {1.99, 1.49, 1.29};
        System.out.println("Here's is your receipt");

        for (int i = 0; i < 3; i++) {
                System.out.println(apples[i] + ": $" + price[i]);
        }

    }
}