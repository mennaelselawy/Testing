package chapter3;

import java.util.Scanner;

public class GradeMessage {
    public static void main(String args[]){
        System.out.println("Enter your letter grade: ");
        Scanner scanner = new Scanner(System.in);
        String grade = scanner.next();
        String message;
        switch(grade){
            case "A":
                message = "Excellent Job!";
                break;
            case "B":
                message = "Great Job!";
                break;
            case "C":
                message = "Good Job";
                break;
            case "D":
                message = "you need to work a bit harder";
                break;
            case "F":
                message = "UH oh!";
                break;
            default:
                message = "Error, invalid grade";
                break;
        }
        System.out.println(message);

    }
}
