public class IntroToArrays {
    public static void main(String[] args) {
        String[] kingdoms = {"Mercia", "Wessex", "Northumbria", "East Anglia"};
        System.out.println(kingdoms); //prints hashcode representation of the reference/ address
        System.out.println(kingdoms[0]);
        System.out.println(kingdoms[1]);
        System.out.println(kingdoms[2]);
        System.out.println(kingdoms[3]);
        System.out.println(kingdoms[4]); //out of range error is raised
    }
}