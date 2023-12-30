public class Contact {
    private String name;
    private String phoneNumber;
    private String birthDate;
    private int age;  

    //initializes the fields of a newly created object
    public Contact (String name, String phoneNumber, String birthDate, int age) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.age = age;
    }

    //copy constructor - initializes a new object using an existing object's field
    public Contact(Contact source) {
        this.name = source.name;
        this.phoneNumber = source.phoneNumber;
        this.birthDate = source.birthDate;
        this.age = source.age;
    }
}