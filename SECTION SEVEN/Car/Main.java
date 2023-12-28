public class Main {
    public static void main(String[] args) {
        
        Car nissan = new Car("Nissan", 10000.0, 2020, "Green", new String[] {"Tires", "Keys"});
        Car dodge = new Car("dodge", 11000.0, 2019, "Blue", new String[] {"Tires", "Keys"});
        
        Car nissan2 = new Car(nissan);
        System.out.println(nissan);
        System.out.println(dodge);;
        System.out.println(nissan2);

    }
} 