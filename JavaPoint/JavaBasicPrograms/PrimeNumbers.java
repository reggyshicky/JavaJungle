import java.util.Scanner;
public class PrimeNumbers {
    //Prime number is a number that is greater than 1 and  divided
    //by 1 or itself only. Note 0 and 1 are not prime numbers, 2 is the only even prime number because
    //all the other even numbers can be divided by 2
    //https://www.youtube.com/watch?v=-edAgWN1mQk

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter a number:");
        int num = s.nextInt();
        int count = 0;

        //The logic is if a number is 7, you check numbers all the way from 1 to 7, if they any of them is a divisor of 7, if you get a divisor you increase your count
        //since prime number is only 1 and itself, we check whether the count is 2 , if it is not then it is not a prime number

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            System.out.println("Num " + num + " is a prime number");
        } else {
            System.out.println("Num " + num + " is not a prime number");
        }
        s.close();
    }
}
