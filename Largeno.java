import java.util.Scanner;
public class Largeno {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter first no:");
        float num1=input.nextFloat();

        System.out.print("Enter second no:");
        float num2=input.nextFloat();

        if(num1>num2){
            System.out.println(num1+" is grater no");
        }
        else{
            System.out.println(num2+" is greater no");
        }
    }
}
