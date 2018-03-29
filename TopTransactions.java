
package toptransactions;
import java.util.*;
import java.io.*;
public class TopTransactions {

    public static void main(String[] args) throws Exception {
        File input = new File("C:/Users/Zoë/Documents/17-18/Spring '18/CS 220/Sprints/TopTransactions/src/toptransactions/transactions.txt");
        ArrayList<String> inputList = new ArrayList<String>();
        Scanner scanner = new Scanner(input);
        
        while (scanner.hasNextLine() ) {
            inputList.add(scanner.nextLine() + "\n");            
        }
        System.out.println(inputList);
    
    }
}