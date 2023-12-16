public class Weather {
    public static void main(String[] args) {
        double noon = 77;
        double evening = 61;
        double midnight = 55;
        printTemperatures(midnight);
        printTemperatures(evening);
        printTemperatures(noon);

    }
    /**
     * Function name: fahrenheitToCelsius - converts fahrenheit to celcius.
     * @param fahrenheit (double)
     * @return celcius (double).
     */
    public static double fahrenheitToCelsius (double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    /**
     * Name: printTemperatures - prints a temperature in fahrenheit and celcius.
     * @param fahrenheit (double)
     */
    public static void printTemperatures(double fahrenheit) {
        System.out.println("F: " + fahrenheit);
        System.out.println("C: " + fahrenheitToCelsius(fahrenheit) + "\n");
        
    }
}
