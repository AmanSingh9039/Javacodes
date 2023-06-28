import java.util.Scanner;
public class Si{
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);

        System.out.print("Enter Principle Value:");
        int principle=input.nextInt();

        System.out.print("Enter the Time(in years):");
        int time=input.nextInt();

        System.out.print("Enter the Rate:");
        int rate=input.nextInt();

        int si= principle*time*rate/100;

        System.out.println("Your Simple interest is:"+si);


    }
}