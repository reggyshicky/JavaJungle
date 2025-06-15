public class PrimitiveDataTypes {
    /* Use Integer.MAX_VALUE and Integer.MIN_VALUE to get the maximum
       and miminum number you can assign to an int. (Wrapper class: Integer)
     */

    static int myMaxIntValue = Integer.MAX_VALUE;
    static int myMinValue = Integer.MIN_VALUE;


   public static void main(String[] args) {
       System.out.println("Minimum value is " + myMinValue);
       //-21,474,836,648
       System.out.println("Maximum value is " + myMaxIntValue);
       //21,474,836,647
   }

}
