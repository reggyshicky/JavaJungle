public class Doubles {
    public static void main(String[] args) {

    }

    /**
     * Function name: rollDice -- rolls a dice btn 1 and 6
     * @return randomNumber (int)
     */
    public static int rollDice() {
        int randomNumber = (int) Math.random() * 6;
        return randomNumber;
    }
}