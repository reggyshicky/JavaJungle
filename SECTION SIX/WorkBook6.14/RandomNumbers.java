public class RandomNumbers {
    public static void main(String[] args) {
        int[][] array = new int[100][10];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = randomNumber();
            }
        }
        print2DArray(array);
    }
    
    //function returns a random numbers  btn 0 and 99
    public static int randomNumber () {
        int randomNumber = (int) (Math.random() * 100);
        return randomNumber;
    }

    public static void print2DArray (int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println(); //prints newline
        }
    }
}
