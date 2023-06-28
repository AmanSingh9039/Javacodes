import java.util.Scanner;

public class Calculator{
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        System.out.print("Enter 1st number:");
        float num1=input.nextInt();

        System.out.print("Enter 2nd number:");
        float num2= input.nextInt();

        System.out.print("Choose Your operands(+,-,*,/):");
        String operands=input.next();

        float sum=num1+num2;
        float substraction=num1-num2;
        float multiply=num1*num2;
        float divide=num1/num2;

        if (operands.equals("+")) {
            System.out.println("The sum is "+sum);
        }
        else if (operands.equals("-")) {
            System.out.println("The substraction is "+substraction);
        }
        else if (operands.equals("*")) {
            System.out.println("The multiplication is "+multiply);
        }
        else{
            System.out.println("The division is "+divide);
        }
    }
}