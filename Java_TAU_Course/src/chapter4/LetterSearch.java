package chapter4;

import java.util.Scanner;

/*
LOOP BREAK
Search a string to determine if it contains the lette 'A'
 */
public class LetterSearch {
    public static void main(String args[])
    {
        //Get text
        System.out.println("Enter some text: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        scanner.close();
        boolean letterFound = false;
        //Search for letter 'A'
        for(int i =0; !letterFound && i<text.length(); i++){
            char currentLetter = text.charAt(i);
            if(currentLetter == 'A' || currentLetter == 'a'){
                letterFound = true;
                //break;
            }
        }
        if(letterFound){
            System.out.println("This text contains the letter 'A'");
        }
        else{
            System.out.println("This text does not contains the letter 'A'");
        }
    }
}
