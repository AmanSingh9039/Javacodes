import java.util.Scanner;
public class Currency {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter Currency (in inr):");
        float currency1=input.nextFloat();

        float dollar= (float) (currency1/81.99);
        System.out.println("INR to Dollar :"+dollar);

    }
}
