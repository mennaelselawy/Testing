package chapter3;
import java.util.Scanner;
/*
IF STATEMENT
all salespeople get a payment of $1000 a week.
salespeople who exceed 10 sales get an additional bonus of $250
 */
public class SalaryCalculator {
    public static void main(String args[])
    {
        //initialize known values
        int salary = 1000;
        int bonus = 250;
        int quota = 10;
        //get values for the unknown
        System.out.println("How many sales did the employee make this week?");
        Scanner scanner = new Scanner(System.in);
        int sales = scanner.nextInt();
        scanner.close();

        //quick detour for the bonus earners
        if(sales > quota){
            salary = salary + bonus;
        }

        //output
        System.out.println("the employee's pay is $" + salary);
    }
}
