public class AreaCalculator {
    public static void main(String[] args) {
        System.out.println(areaSquare(2));
        System.out.println(areaRectangle(1, 2));
        System.out.println(areaTriangle(1, 2));
        System.out.println(areaCircle(2));

    }

    /**
     * Name: areaSquare
     * @param side (double)
     * @return the area (double)
     * 
     * Inside the function:
     *  1. If side is negative
     *        - prints "Impossible"
     *        - shuts the app down
     *  2. Calculatrs the area of the square. A = side^2
     */
    public static double areaSquare(double side) {
        double area = 0;
        if (side < 0) {
            System.out.println("Impossible");
            System.exit(0);
        } else {
            area = Math.pow(side, 2);
        }
        return area;
    }

    /**
     * Name: areaRectangle
     * @param length (double)
     * @param width (double)
     * @return the area (double)
     * Inside the function:
     *  1. If side is negative
     *        - prints "Impossible"
     *        - shuts the app down
     *  2. Calculatrs the area of the rectangle. 
     */
    public static double areaRectangle (double length, double width) {
        if (length < 0 || width < 0) {
            System.out.println("Error: impossible");
            System.exit(0);
        }
        return length * width;
    }

    /**
     * Name: areaTriangle
     * @param base: (double)
     * @param height: (double)
     * @return the area (double)
     */
    public static double areaTriangle(double base, double height) {
        if (base < 0 || height < 0) {
            System.out.println("Error: Impossible");
            System.exit(0);
        }
        return base * height / 2;
    }
    /**
     * Name" areaCircle
     * @param radius
     * @return
     */
    public static double areaCircle(double radius) {
        if (radius < 0) {
            System.out.println("Impossible");
        }
        return Math.PI * Math.pow(radius, 2); 
    }

}
