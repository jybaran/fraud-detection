# fraud-detection

Jenny Baran, Cathy Lee, Zoe Riell

To run:
$ javac FraudDetector.java
$ java FraudDetector [filename]

We decided to take the input file from the command line, instead of with redirection.

We searched the vendor and MCC fields for indications that a transaction involves a resort, pawn shop, or casino, because these were the fields that seemed most likely when we skimmed through the dataset. We do this by searching for "resort," "casino," or "pawn shop." We intentionally did not search for just occurances of "pawn" because that returned many false positives in transactions involving "Pawnee."