import java.util.*;
import java.io.*;

public class TopTransactions {

    public static void main(String[] args) throws Exception {
        File input = new File("transactions.txt"); // just gotta make this come from cmdline
        ArrayList<String> inputList = new ArrayList<String>();
        Scanner scanner = new Scanner(input);
        
        while (scanner.hasNextLine() ) {
            inputList.add(scanner.nextLine() + "\n");            
        }
        System.out.println(inputList);
    
    }
}
