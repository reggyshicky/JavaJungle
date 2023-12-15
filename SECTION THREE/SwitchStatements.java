public class SwitchStatements {
    public static void main(String[] args) {

        String weather = "rainy";
        switch (weather) {
            case "sunny":
            System.out.println("You can wear a shrit");
            break;
            case "cloudy":
            System.out.println("You should wear a sweater");
            break;
            case "rainy":
            System.out.println("You should wear a rain coat");
            break;
            case "snowy":
            System.out.println("You should wear a jacket");
            break;
            default:
            System.out.println("You should wear whatever you want");
        }
    
        int role = 2;
        switch (role) {
            case 1:
            System.out.println("You are aadmin");
            break;
            case 2:
            System.out.println("You are an editor");
            break;
            case 3:
            System.out.println("You are a user");
            break;
            default:
            System.out.println("Please contact hr");

        }

        int temperature = 75;
        int humidity = 65;
        if (temperature >= 80 && humidity >= 60) {
            System.out.println("It's too hot and humid\n");
        } else if (temperature >= 80) {
            System.out.println("it's too hot\n");
        } else if (temperature <= 60 && humidity >= 60) {
            System.out.println("It's too cold and humid\n");
        } else if(temperature <= 60) {
            System.out.println("it is too cold\n");
        }
        else {
            System.out.println("It is comfortable");
        }

        // Section 5: Age and income
        int age = 25;
        int income = 50000;
        if (age >= 25 && income >= 30000) {
            System.out.println("Eligible for a credit card");
        } else {
            System.out.println("Sorry you are not eligible for the credit card");
        }

        // Section 1: Traffic light colors
        String lightColor = "green";
        switch (lightColor) {
            case "green":
            System.out.println("Go");
            break;
            case "yellow":
            System.out.println("Stop");
            case "red":
            System.out.println("Slow down");
            default:
            System.out.println("Power Outage");

        }

        // Section 2: Exam grade
        int grade = 85;
        
        if (grade == 'B') {
            System.out.println("Good job!");
        } else if (grade == 'A') {
            System.out.println("Excellent work!");
        }  else if (grade == 'C') {
            System.out.println("You did okay.");
        } else if (grade == 'D') {
            System.out.println("Hey, you still passed!");
        } else {
            System.out.println("You failed :(");
        }
        
        // Section 3: Browser type
        String browser = "Chrome";
        switch (browser) {
            case "Chrome":
            System.out.println("Enjoy your chrome extension!");
            break;
            case "Firefox":
            System.out.println("The best nonprofit browser");
            break;
            case "Safari":
            System.out.println("I see you are a proud Apple user");
        }
        
        

    }
}
