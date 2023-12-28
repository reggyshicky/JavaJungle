public class DealerShip {
    private Car[] cars;

    public DealerShip (Car[] cars) {
        this.cars = new Car[cars.length];
        for (int i = 0; i < this.cars.length; i++) {
            this.cars[i] = new Car(cars[i]);
        } //a deep copy
    }

    public Car getCar(int index) {
        //Deep copying is creating duplicates of your object to make sure you are protecting the internal state of your class
        Car copy = new Car(this.cars[index]);
        return copy;
    }

    public void setCar(int index, Car newCar) {
        Car copy = new Car(newCar);
        this.cars[index] = copy;
    }




    public String toString() {
        String temp = "";
        for (int i = 0; i < this.cars.length; i++) {
            temp += "Parking Spot: " + i + "\n";
            String carDescription = this.cars[i].toString();
            temp += carDescription + "\n";
        }
        return temp;
    }

    public void sell(int index) {
        this.cars[index].drive();
    }
}
