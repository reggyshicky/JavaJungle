public class RingAnnouncer {
    public static void main(String[] args) {
        int win = 0;
        int losses = 0;
        String[] record = {"WIN", "WIN", "WIN", "LOSS", "WIN", "WIN", "LOSS"}; 
        for (int i = 0; i < record.length; i++) {
            if (record[i].equals("WIN")) {
                win++;
            } else {
                losses++;
            }
        }
    }
}
