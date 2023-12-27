import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Reginah";
        person.dateOfBirth = "29/02/1788";
        person.nationality = "Kenyan";
        person.seatNumber = 5;
        person.passport = new String[] {
            person.name,
            person.nationality,
            person.dateOfBirth,
        };
        System.out.println(person.name);
        System.out.println(person.nationality);
        System.out.println(person.dateOfBirth);
        System.out.println(Arrays.toString(person.passport)); //string representation
        System.out.println(person.seatNumber);

    } 
}
