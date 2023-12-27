public class Main {
    public static void main(String[] args) {

        Person person = new Person("Rayan Slim", "Canadian", "0/01/111", 5);
        
        person.setSeatNumber(10);

        System.out.println("Name: " + person.getName() + "\n" + "Nationality: " 
        + person.getNationality() + "\n" + "Date of Birth: " + person.getDateOfBirth() + 
        "\n" + "Seat Number: " + person.getSeatNumber() + "\n");

    }
}