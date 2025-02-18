package chapter2;
import java.util.Scanner;
public class GrossPayCalculator {
    public static void main(String arg[]){
        // 1. get the number of hours worked
        System.out.println("Enter the number of hours the employee worked.");
        Scanner scanner = new Scanner(System.in);
        int hours = scanner.nextInt();

        //2. Get the hourly pay rate
        System.out.println("Enter the employee's pay rate");
        double rate = scanner.nextDouble();
        scanner.close();

        //3. multiply hours and pay rate
        double grossPay = hours*rate;

        //4. display result
        System.out.println("the employe's gross pay is $" + grossPay);


    }
}
