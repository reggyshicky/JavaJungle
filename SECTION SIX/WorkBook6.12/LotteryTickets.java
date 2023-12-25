import java.util.Arrays;
public class LotteryTickets {
    public static void main(String[] args) {
        int[] ticket = {34, 43, 45, 65, 21, 54};
        int[] ticket2 = Arrays.copyOf(ticket, ticket.length);
        ticket2[2] = 54;
        printTicketNumbers(ticket);
        printTicketNumbers(ticket2);
    }
    public static void printTicketNumbers(int[] temp) {
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.println("\n\n");
    }
}