package unmute_your_code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
	
    public static void main(String[] args) {
    	
        BufferedReader in;
        String a, b;
        int p = 0;
        
        try {
            //in = new BufferedReader(new FileReader(new File(args[0])));
            in = new BufferedReader(new FileReader(new File("strings.txt")));
            a = in.readLine();
            b = in.readLine();

            System.out.println("String A = " + a + "\nString B = " + b);
            p = ifStringsCanBeRearrangedReturnMovesCount(a,b);             
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(p);
    }
    
    // this method checks if String A can be arrange to String B and if it can be done it returns moves count
 	private static int ifStringsCanBeRearrangedReturnMovesCount(String a, String b){		
 		
 		// check if strings are null or their length isn't equal - it means that they can't be rearranged
 		if (a == null || b == null || a.length() != b.length()) {	
 			System.out.println(">> String A can\'t be rearrange to B");
 			return -1;
 		}
 		// check if string A and B are equals - if yes, they don't have to be rearrange, because they are equals
 		else if (a.equals(b)){
 			System.out.println(">> String A is equal to B");
 			return 0;
 		}
 		// check if there are the same letters in both Strings (if not rearrange is not possible)
 		else if (!areLettersTheSameInBothStrings(a,b)){
 			System.out.println(">> String A can\'t be rearrange to B (different letters)");
 			return -1;
 		}
 		// else means the strings can be rearrange, return in how many moves it can be done
 		else {			
 			return howManyMovesToRearrange(a,b);		
 		}
 	}
 	
 	// this method checks if there are the same letters in both Strings and returns true or false
 	private static boolean areLettersTheSameInBothStrings(String a, String b) {
 		char[] aChar = a.toCharArray();
 		char[] bChar = b.toCharArray();
 		boolean isOk = false;
 		
 		for (int i = 0; i < a.length(); i ++){			
 			for (int j = 0; j < b.length(); j++){
 				isOk = false;
 				if (aChar[i] == bChar[j]){
 					bChar[j] = 0;
 					isOk = true;
 					break;
 				}
 			}
 			if (!isOk) break;
 		}
 		return isOk;
 	}
 	
 	
 	// this method checks how many moves should be done to rearrange String A to String B and returns that value
 	private static int howManyMovesToRearrange(String a, String b) {
 		int p = 0;
 		char[] aChar = a.toCharArray();
 		char[] bChar = b.toCharArray();
 		int length = a.length();
 		int j = length-1;
 		
 		for (int i = length-1; i >= 0; i--){
 			if (aChar[i] == bChar[j]) {
 				if(i != j){
 					for (int k = 0; k < j-i; k++){
 						char tempChar = aChar[i+k+1];
 						aChar[i+k+1] = aChar[i+k];
 						aChar[i+k] = tempChar;
 						p++;
 					}
 					i = j;
 				}
 				j--;				
 			}		
 		}	
 		System.out.println(">> String A can be rearrange to B");
 		return p;
 	}
}