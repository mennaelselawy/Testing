package chapter4;

import java.util.Scanner;

/*
* WHILE LOOP
* each store employee makes $15 as hour, write a program that allows the employee
* to enter the number of hours worked for the week. do not allow overtime.
*/
public class GrossPayInputValidation {
    public static void main(String args[]){
        //initialize known variables
        int rate = 15;
        int maxHours = 40;

        //get unknown variables
        System.out.println("How many hours did you work this week? ");
        Scanner scanner = new Scanner(System.in);
        double hoursWorked = scanner.nextDouble();
        //validate input
        while(hoursWorked > maxHours || hoursWorked < 1){
            System.out.println("Invalid entry. your hours must be between 1 and 40. try againg.");
            hoursWorked = scanner.nextDouble();
        }
        scanner.close();
        //calculate gross
         double gross = rate * hoursWorked;
        System.out.println("Gross Pay:$" + gross);

    }
}
