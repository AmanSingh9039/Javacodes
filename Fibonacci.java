import java.util.Scanner;
public class Fibonacci {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int sum=0,n;
        int a=0;
        int b=1;

        System.out.print("Enter the nth number:");
        n=input.nextInt();
        System.out.println("Fibonacci Series:");

        while(sum<=n){
            System.out.println(sum+" ");
            a=b;
            b=sum;
            sum=a+b;
        }
    }
}
