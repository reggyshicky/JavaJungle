public class IfElse {

    public static void main(String[] args) {

        int chemistryGrade = 95;
        int biologyGrade = 75;
        System.out.println("Me: Hi Java, did I score better in biology?");
        if (biologyGrade > chemistryGrade) {
            System.out.println("Yes you did");
        } else {
            System.out.println("No, you did not");
        }

        double sales = 37.55;
        double costs = 5.55;
        System.out.println("Me: Hi Java, did we make money?");
        if (sales > costs) {
            System.out.println("Congrats! You are rich");
        } else {
            System.out.println("Not this time");
        }

        double temperature = 15.5;
        double targetTemperature = 20.0;
        System.out.println("Me: Hi Java, is the temperature colder than our target?");
        if (temperature < targetTemperature) {
            System.out.println("Yes it is");
        } else {
            System.out.println("No it is not");
        }

        int currentSpeed = 60;
        int speedLimit = 70;
        System.out.println("Me: Hi Java, am I driving slower than the speed limit?");
        if (currentSpeed < speedLimit) {
            System.out.println("You are driving lower than the speed limit");
        } else {
            System.out.println("Please slow down");
        }

        int age = 45;
        int retirementAge = 65;
        System.out.println("Me: Hi Java, am I old enough to retire?");
        if (age >= retirementAge) {
            System.out.println("Enjoy your pension");
        } else {
            System.out.println("You still have to work for " + (retirementAge - age) + " years");
        }

        char myGrade = 'A';
        char bestGrade = 'A';
        System.out.println("Me: Hi Java, did I get the best possible grade?");
        if (myGrade == bestGrade) {
            System.out.println("Congrats! You got the highest score");
        } else {
            System.out.println("No, but you will next time");
        }
        String word = "hello";
        String secondWord = "hello";
        System.out.println("Me: Are the two words the same?");
        if (word.equals(secondWord)) {
            System.out.println("They are the same");
        } else {
            System.out.println("They are not");
        }

        String thirdWord = "hello";
        String fourthWord = "goodbye";
        System.out.println("Me: Are the two words different");
        if (!thirdWord.equals(fourthWord)) {
            System.out.println("They are indeed different");
        } else {
            System.out.println("No they are not");
        }
    }
}
