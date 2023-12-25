import java.util.Arrays;
import java.util.Scanner;
public class PizzaDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("How many pizza toppings do you want?");
        int numToppings = scan.nextInt();
        scan.nextLine(); //Throwaway nextline to avoid nextLine() trap 

        System.out.println("Great, enter each topping!");
        
        String[] Toppings = new String[numToppings];

        for (int i = 0; i < Toppings.length; i++) {
            System.out.print(i + ". ");
            Toppings[i] = scan.nextLine();
        }
        System.out.println("\nThank you! Here are the toppings you ordered");
        for (int i = 0; i < Toppings.length; i++) {
            System.out.println(i + ". " + Toppings[i]);
        }
        scan.close();
    }
}
