/**
 * This class demonstrates usage of JavaDoc Comments
 * 
 * @author Reginah
 */
public class JavaDoc {

    public static void main(String[] args) {
        JavaDoc s = new JavaDoc();
        System.out.println(s.sum(5, 10));
           //the below comment will be executed
           // \u000d System.out.println("Java comment is executed!!"); 
    }
    /**
     * @param num1 first int value
     * @param num2 second int value
     * @return num1 + num2
     */
    public int sum(int num1, int num2) {
        return num1 + num2;
    }


}
