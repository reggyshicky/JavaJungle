public class controlflow {
    public static void main(String args[]) {
        int x = 10;
        int y = 12;
        if ((x + y) > 20) {
            System.out.println("x + y is greater than 20");
        }

        String[] names = {"reginah", "shikanda", "Melvine", "Book"};
        for(String name: names) {
            System.out.println(name);
        }

        int i = 0;
        while(i < 10) {
            System.out.println(i);
            i++;
        }

        int j = 0;
        do {
            System.out.println("I love programming");
            j++;
        } while (j < 5);
        System.out.println("\n");
        System.out.println("I am testing break");
        for (int k = 0; k < 5; k++) {
            System.out.println(k);
            if (k == 3) {
                break;
            }
            
        }
        System.out.println("am done");

        //note, break, breaks/exits the loop out of the loop and goes to the next code to be executed
    }
}