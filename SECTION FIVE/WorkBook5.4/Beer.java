public class Beer {
    public static void main(String[] args) {
        sing(99);
    }

    /**
     * Fuction name --sing.
     * @param  i (int)
     * Inside the function:
     *  1. print:
     *       <i> bottles of beer on the wall, <i> bottles of beer!
     *       take one down, pass it around <i-1>, bottles of beer on the wall!
     */

     public static void sing(int i) {
        for (int j = i; j >= 1; j--) {
            System.out.println(j + " bottles of beer on the wall, " + j + " bottles of beer!");
            System.out.println("take one down, pass it around, " + (j - 1) + " bottles of beer on the wall!");
        }
      
     }
}   
