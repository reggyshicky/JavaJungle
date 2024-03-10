public class Fibonacci {
    //In Fibonacci series, next number is the sum of previous two numbers i.e 0,1,1,2,3,5,8,13,21,32,55 etc
    //The first two numbers of fibonacci series are 0 and 1
    //There are two ways to write fibonacci i)Fibonacci series in without using  recursion
    //ii) Fibonacci series using recursion

    
    public static void main(String[] args) {
        //Fibonacci series Without using recursion
        int n1=0, n2=1, n3, i, count=10;
        System.out.print(n1+" "+n2); //printing 0 and 1

        for (i = 2; i < count; ++i) { //loops starts from 2 becuase 0 and 1 are already printed
             n3=n1+n2;
             System.out.print(" "+n3);
             n1 = n2;
             n2 = n3;
        }

        //ALTERNATIVE
        // int n = 10; // Number of Fibonacci numbers to generate
        // System.out.println("Fibonacci Series:");
        // int prev = 0;
        // int next = 1;
        // for (int i = 0; i < n; i++) {
        //     System.out.print(prev + " ");
        //     int sum = prev + next;
        //     prev = next;
        //     next = sum;
        // }

        System.out.println("\n\n");
        //Fibonacci series using recursion
        int n = 20; //Number of Fibonacci numbers to generate
        System.out.println("Fibonacci Series:");
        for (int j = 0; j < n; j ++) {
            System.out.print(fibonacci(j) + " ");
        }
    
    }

    //Fibonacci series using recursion
    public static int fibonacci(int n) {
        if (n <= 1) { //n in the fibonacci func represent the pos in the fibonacci sequence for which we want to calculate the value. ie if n is 0, we calculate the value of fibonacci number at pos 0 in the sequence
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n -2);
        }
    }
}