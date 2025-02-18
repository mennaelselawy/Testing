package chapter5;

import java.util.Scanner;

/*
VARIABLE SCOPE
write an instant credit check program that approves
anyone who makes more than $25,000 and has a credit score
of 700 or better. reject all others
 */
public class InstantCreditCheck {
    //initialize what we know
    static int requiredSalary = 25000;
    static int requiredCreditScore = 700;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]){
        //get what we do not know
        double salary = getSalary();
        int creditScore = getCreditScore();
        scanner.close();
        // check if the user is qualified
        boolean qualified = isUserQualified(creditScore , salary);
        // notify the user
        notifyUser(qualified);

    }
    public static double getSalary(){
        System.out.println("Enter you Salary: ");
        double salary = scanner.nextDouble();
        return salary;
    }
    public static int getCreditScore(){
        System.out.println("Enter you Credit Score: ");
        int creditScore = scanner.nextInt();
        return creditScore;
    }
    public static boolean isUserQualified(int creditScore, double salary){
        if(creditScore >= requiredCreditScore && salary>=requiredSalary){
            return true;
        }
        else{
            return false;
        }
    }
    public static void notifyUser(boolean isQualified){
        if(isQualified){
            System.out.println("Congrats! , you have been approved.");
        }
        else{
            System.out.println("Sorry! , you have been declined.");
        }
    }
}
