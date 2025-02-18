package chapter3;

import java.util.Scanner;

/*
NESTED IF:
to qualify for a loan, a person must make at least $30,000
and have been working at their current job for at least 2 years.
 */
public class LoanQualifier {
    public static void main(String args[])
    {
        //initialize what we know
        int requiredSalery = 30000;
        int requiredYearsEmployed = 2;

        //get what we do not know
        System.out.println("Enter your salary:");
        Scanner scanner = new Scanner(System.in);
        double salary = scanner.nextDouble();
        System.out.println("Enter the number of years with your current employer: ");
        double years = scanner.nextDouble();

        scanner.close();
        //Make decision -output
        if(salary >= requiredSalery)
        {
            if(years >= requiredYearsEmployed){
                System.out.println("Congrats!, you qualified for the loan");
            }
            else{
                System.out.println("Sorry, you must have worked at your current job for at least " + requiredYearsEmployed +  " years");
            }
        } else{
            System.out.println("Sorry, you must earn at least $ " + requiredSalery + " to qualify the loan");
        }


    }
}
