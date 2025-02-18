package chapter4;
/*
NESTED LOOPS
find thw average of each student's test scores
 */

import java.util.Scanner;

public class AverageTestScores {
    public static void main(String args[]){
        // initialize what we know
        int numberOfStudents = 24;
        int numberOfTests = 4;
        Scanner scanner = new Scanner(System.in);
        //process all students
        for(int i =0; i < numberOfStudents ; i++){
            double total = 0;
            for(int j =0; j < numberOfTests; j++){
                System.out.println("Enter the Score of the test #" + (j+1) );
                Double score = scanner.nextDouble();
                total = total + score ;
            }
            double average = total/numberOfTests;
            System.out.println("The test average for student #" + (i+1)  + " is  " + average);
        }

        scanner.close();
    }
}
