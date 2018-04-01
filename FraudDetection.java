import java.util.*;
import java.io.*;

public class FraudDetection {

    public static void main(String[] args) throws Exception {
        if ( args.length != 1 ) {
            System.out.println("Incorrect input. To run: java FraudDetection [filename]");
        }
        else {
            String filename = args[0];
            System.out.println(filename);
            File input = new File("transactions.txt"); // just gotta make this come from cmdline
            ArrayList<String[]> inputList = new ArrayList<String[]>();
            Scanner scanner = new Scanner(input);
            
            while (scanner.hasNextLine() ) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                inputList.add(tokens);
            }
            
            for( int i = 0; i < inputList.size(); i++ ) {
                String[] temp = inputList.get(i);
                for( int j = 0; j < temp.length; j++ ) {
                    System.out.println( temp[j] );
                }
            }
        }
    }
}
