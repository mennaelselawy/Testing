package chapter7;
import java.util.Arrays;
import java.util.Random;
/*

 */
public class LotteryTicket {
    private static final int LENGTH = 6;
    private static final int MAX_TICKET_NUMBER = 69;
    public static void main(String args[]){
        int ticket[]= generateNumbers();
        Arrays.sort(ticket);
        printTicket(ticket);
    }
    public static int[] generateNumbers(){
        int ticket[] = new int[LENGTH];
        Random random = new Random();
        for(int i =0; i < LENGTH; i++){
            int randomNumber;
            /*generate random number then search to make sure it does not already exists in the array
            if it does regenerate and search again
             */
            do{
                randomNumber = random.nextInt(MAX_TICKET_NUMBER) + 1;
            }while(search(ticket, randomNumber));
            //number is unique if we get here. add it to the array
            ticket[i] = randomNumber;
        }
        return ticket;
    }

    /**
     * Does a Sequential search on the array to find a value
     * @param array Array to search through
     * @param numberToSearchFor Value to search for
     * @return true if found , false if not
     */
    public static boolean search(int[] array, int numberToSearchFor){
        //this is called an enhanced loop. it iterates through array and each time assigns the current element to value
        //RANGED LOOP
        for(int value: array){
            if(value ==numberToSearchFor){
                return true;
            }
        }
        //if we reached this point then the entire array was searched amd the value was not found
        return false;
    }

    public static boolean binarySearch(int array[], int numberToSearchFor){
        //array must be sorted first
        Arrays.sort(array);
        int index = Arrays.binarySearch(array, numberToSearchFor);
        if(index >= 0){
            return true;
        }
        else return false;
    }
    public static void printTicket(int ticket[])
    {
        for(int i =0; i < LENGTH; i++){
            System.out.print(ticket[i] + " | ");
        }
    }
}
