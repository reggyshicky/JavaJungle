public class Tip {
    public static void main(String[] args) {
        tipTheWiater(100);
    }  

    public static void tipTheWiater(double bill) {
        double tip = (0.15 * bill);
        System.out.println("Your Service was wonderfu! Please, accept this tip: $" + tip);
    }
}
