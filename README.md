# fraud-detection

Jenny Baran, Cathy Lee, Zoe Riell

To run:
$ javac FraudDetector.java
$ java FraudDetector [filename]

We decided to take the input file from the command line, instead of with redirection.

We used an ArrayList to store all the data in Transaction objects, because this allowed us to iterate over all the transactions (and the Transaction object allowed easy access to the different fields of data).

We searched the vendor and MCC fields for indications that a transaction involves a resort, pawn shop, or casino, because these were the fields that seemed most likely when we skimmed through the dataset. We do this by searching for "resort," "casino," or "pawn shop." We intentionally did not search for just occurances of "pawn" because that returned many false positives in transactions involving "Pawnee."

In order to identify and flag transactions involving infrequently used airlines, we generated a dictionary of all airlines (identified by "air travel" in the description) and the number of times they occured in the dataset. We used the HasMap data structure to allow easy access by way of airline name (the key) and storage of the count (the value). Then we created an arraylist of all the airlines with a count of less than 10. Using an ArrayList for this meant that we could use the contains method to check if a transaction's MCC appeared in this set and then flag that transaction as potentially fraudulent. Also, we manually removed two elements from the HashMap; " " and "BOOK STORES." While normally best to avoid hardcoding like this, these invalid airline names (probably a result of a mistake in the dataset) were causing us to get false positives when checking for bad airline, and our output was flooded with Amazon transactions, which made it very difficult to check for correctness.