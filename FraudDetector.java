import java.util.*;
import java.io.*;

public class FraudDetection {

    public static class Transaction {
        String yearmonth;
        int agencyNum;
        String agencyName;
        String cardName;
        String cardInitial;
        String description;
        float amount;
        String vendor;
        String transDate;
        String postDate;
        String MCC;

        public Transaction( String[] tokens ) {
            yearmonth = tokens[0];
            agencyNum = Integer.parseInt(tokens[1]);
            agencyName = tokens[2];
            cardName = tokens[3];
            cardInitial = tokens[4];
            description = tokens[5];
            amount = Float.parseFloat(tokens[6]);
            vendor = tokens[7];
            transDate = tokens[8];
            postDate = tokens[9];
            MCC = tokens[10];
        }
        
        public float getAmount() {
            return this.amount;
        }
        
        public boolean over50k() {
            if ( this.amount > 50000 ) {
                return true;
            } else {
                return false;
            }
        }
        
        public boolean tooRound() {
            if ( this.amount % 100 == 0 ) {
                return true;
            } else {
                return false;
            }
        }
        
        public boolean isSketchy() {
            String tempVendor = (this.vendor).toLowerCase();
            String tempMCC = (this.MCC).toLowerCase();
            if ( tempMCC.contains("pawn shop") ) {
                return true;
            }
            if ( tempVendor.contains("resort") || tempMCC.contains("resort") ) {
                return true;
            }
            if ( tempVendor.contains("casino") || tempMCC.contains("casino") ) {
                return true;
            }
            return false;
        }

        public String toString() {
            String retStr = this.cardInitial + ". " + this.cardName + ", ";
            retStr += (this.transDate).substring(0, 10) + ", ";
            retStr += this.vendor + ", ";
            retStr += String.format("%.2f", this.amount) + ", ";
            retStr += this.description;
            return retStr;
        }
        
        public String toString2() {
            String retStr = this.yearmonth + ", ";
            retStr += Integer.toString(this.agencyNum) + ", ";
            retStr += this.agencyName + ", ";
            retStr += this.cardName + ", ";
            retStr += this.cardInitial + ", ";
            retStr += this.description + ", ";
            retStr += String.format("%.2f", this.amount) + ", ";
            retStr += this.vendor + ", ";
            retStr += this.transDate + ", ";
            retStr += this.postDate + ", ";
            retStr += this.MCC;

            return retStr;
        }
    }

    public static void main(String[] args) throws Exception {
        if ( args.length != 1 ) {
            System.out.println("Incorrect input. To run: java FraudDetection [filename]");
        }
        else {
            String filename = args[0];
            //System.out.println(filename);
            File input = new File(filename);
            ArrayList<Transaction> inputList = new ArrayList<Transaction>();
            Scanner scanner = new Scanner(input);

            String line = scanner.nextLine(); //gets rid of headers
            while (scanner.hasNextLine() ) {
                line = scanner.nextLine();
                String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                Transaction tempTrans = new Transaction(tokens);
                inputList.add(tempTrans);
            }

            for( int i = 0; i < inputList.size(); i++ ) {
                Transaction temp = inputList.get(i);
                if ( temp.isSketchy() || temp.over50k() || temp.tooRound() ) {
                    System.out.println(temp);
                }
            }
            
        } // close else (valid input)
    } // close main
}