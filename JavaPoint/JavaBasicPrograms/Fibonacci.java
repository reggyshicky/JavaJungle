public class Fibonacci {
    //In Fibonacci series, next number is the sum of previous two numbers i.e 0,1,1,2,3,5,8,13,21,32,55 etc
    //The first two numbers of fibonacci series are 0 and 1
    //There are two ways to write fibonacci i)Fibonacci series in without using  recursion
    //ii) Fibonacci series using recursion

    //Without using recursion
    public static void main(String[] args) {
        int n1=0, n2=1, n3, i, count=10;
        System.out.print(n1+" "+n2); //printing 0 and 1

        for (i = 2; i < count; ++i) { //loops starts from 2 becuase 0 and 1 are already printed
             n3=n1+n2;
             System.out.print(" "+n3);
             n1 = n2;
             n2 = n3;
        }
    
    }
}