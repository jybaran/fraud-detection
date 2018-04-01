import java.util.*;
import java.io.*;

public class TopTransactions {

    public static void main(String[] args) throws Exception {
        File input = new File("transactions.txt"); // just gotta make this come from cmdline
        ArrayList<String[]> inputList = new ArrayList<String[]>();
        Scanner scanner = new Scanner(input);
        
        while (scanner.hasNextLine() ) {
            String s = scanner.nextLine();
            String[] temp = s.split(" +");
            inputList.add(temp);
        }
        
        for( int i = 0; i < inputList.size(); i++ ) {
            String[] temp = inputList.get(i);
            for( int j = 0; j < temp.length; j++ ) {
                System.out.println( temp[j] );
            }
        }
    }
}
