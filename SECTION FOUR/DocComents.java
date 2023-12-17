public class DocComents {
    public static void main(String[] args) {

    }

    /**
     * Function name: pgreet
     * 
     * Inside the function:
     *  1. prints: 'Hello'
     */
    public static void greet() {
        System.out.println("Hello");
    }

    /**
     * Function name: printText
     * @param name (String)
     * @param age (String)
     * 
     * Inside the function:
     *  1. printText: prints the name and age
     */
    public static void printText(String name, String age) {
        System.out.println("Hi, I'm  " + name + " and I'm " + age + " years old.");
    }

    /**
     * Function name: CslculateArea
     * @param length (double)
     * @param width (double)
     * @return      (double)
     * 
     * Inside the Function:
     *  1. calculates the area and returns
     */
    public static double CalculateArea(double length, double width) {
        double area = length + width;
        return area;
    }
}