public class Car {
    private String make;
    private double price;
    private int year;
    private String color;

    public Car(String make, double price, int year, String color) {
        this.make = make;
        this.price = price;
        this.year = year;
        this.color = color;
    }

    // return type of the getter depends on a particular field
    public String getMake() {
        return make;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    /*
     * So notice here we do need the this keyword to distinguish between the field
     * and the parameter that gets passed in.
     * Whereas in the getter there are no parameters.
     * So make will automatically refer to the object as field.
     */
    public void setMake(String make) {
        this.make = make;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
