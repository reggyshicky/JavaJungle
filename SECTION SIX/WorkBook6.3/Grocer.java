public class Grocer {
    public static void main(String[] args) {
        String[] aisles = {"apples", "bananas", "candy", "chocolate", "coffee", "tea"};
        System.out.println("Do you sell coffee?");
        for (int i = 0; i < aisles.length; i++) {
            if (aisles[i] == "coffee") {
                System.out.println("\n\nWe have that in aisle: 4");
                break; //to terminate the rest of the execution
            }
        }

    }
}
