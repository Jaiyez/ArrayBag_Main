
import java.io.*;
import java.util.*;

/**
 * LongestCommonSubsequence is a program that will determine the longest string that is 
 * a subsequence of two input strings. This program applies a brute force solution technique.
 * 
 * @author Charles Hoot
 * @version 5.0
 */
public class LongestCommonSubsequence {

    public static void main(String args[]) {
        BagInterface<String> toCheckContainer = null;

        Scanner input;
        input = new Scanner(System.in);

        System.out.println("This program determines the longest string that is a subsequence of two input string.");
        System.out.println("Please enter the first string:");
        String first = input.next();

        System.out.println("Please enter the second string:");
        String second = input.next();



        // ADD CODE HERE TO CREATE THE BAG WITH THE INITIAL STRING
///vvvvvvvvv ADDED CODE vvvvvvvvvvvvvvvvvvvvvvvv       
        BagInterface<String> containBag = new ArrayBag <>();
        containBag.add(first);
        toCheckContainer = new ArrayBag<String>();
        toCheckContainer.add(first);

        System.out.println("The strings to check are: " + toCheckContainer);
        String bestSubsequence = new String("");


        // ADD CODE HERE TO CHECK THE STRINGS IN THE BAG
        boolean isSubsequence = isSubsequence(bestSubsequence, second);
        if (isSubsequence) {
        System.out.println("Found " + bestSubsequence + " for the longest common subsequence" + second);
        
        }
        else {
        	System.out.println("Didn't find any subsequence");
        }
    }

    /**
     * Determine if one string is a subsequence of the other.
     *
     * @param check See if this is a subsequence of the other argument.
     * @param against The string to check against. 
     * @return     A boolean if check is a subsequence of other. 
     */
    public static boolean isSubsequence(String check, String against) {
        boolean result = false;

        // ADD CODE HERE TO CHECK IF WE HAVE A SUBSEQUENCE
        int indexInCheck = 0;
        for (int indexlnAgainst = 0; indexlnAgainst < against.length();indexlnAgainst++) {
        	if (check.charAt(indexInCheck) == against.charAt(indexlnAgainst)) {
        		++indexInCheck;
        	}
        	if (indexInCheck == check.length()) {
        		result =true;
        		return result;
        	}
        }
        return result;
    }
}
