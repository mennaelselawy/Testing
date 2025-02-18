package chapter3;
import java.util.Scanner;
/*
IF ELSE
all salespeople are expected to make at least 10 sales each week
for those who do, they receive a congratulatory message
for those who don't , they are informed of how many sales they were short
*/

import java.util.Scanner;

public class QuotaCalculator {
    public static void main(String args[]){
        //initialize values we know
         int quota = 10;
        // get unknown values
        System.out.println("Enter the number of sales you made this week:");
        Scanner scanner = new Scanner(System.in);
        int sales = scanner.nextInt();
        scanner.close();
        //make a decision on the path to take -output
        if(sales >= quota)
        {
            System.out.println("Congrats! you've met your quota");
        }
        else{
            int salesShort = quota - sales;
            System.out.println("You did not make your quota, you were " + salesShort + " Sales short");
        }
    }
}
