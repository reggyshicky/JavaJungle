public class HighScore {
    public static void main(String[] args) {
        int[] scores = {randomNumber(), randomNumber(), randomNumber(), randomNumber(), randomNumber(), randomNumber()};
        int highScore = 0;
        int seat = 0;
        System.out.println("Here are the scores!");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
            if (scores[i] > highScore) {
                highScore = scores[i];
                seat = i;
            }
        }
        System.out.println("\n\nThe highest score is: " + highScore + ". Impressive");
        System.out.println("It's the gentleman in seat: " + seat + ". Give that man a cookie");
         
    }

    //returns a random number between 0 to 49999
    public static int randomNumber() {
        int randomNo = (int) (Math.random() * 49999) + 1;
        return randomNo;
    }
}