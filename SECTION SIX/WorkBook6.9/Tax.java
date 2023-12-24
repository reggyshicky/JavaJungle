import java.util.Arrays;
public class Tax {
    public static void main(String[] args) {
        double[] price = {1.99, 2.99, 3.99, 4.99};
        System.out.println("The original prices are: " + Arrays.toString(price));
        double[] aftertax = new double[4];
        for (int i = 0; i < 4; i++) {
            aftertax[i] = (price[i] + (0.13 * price[i]));
        }
        System.out.println("The after tax prices are: " + Arrays.toString(aftertax));
    }
}
