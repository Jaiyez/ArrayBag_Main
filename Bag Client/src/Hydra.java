
import java.io.*;
import java.util.*;

/**
 * Hydra is a program that will simulate the work done for a
 * computational task that can be broken down into smaller subtasks.
 * 
 * @author Charles Hoot
 * @version 5.0
 */
public class Hydra {

    public static void main(String args[]) {
        BagInterface<Integer> headBag = null;
        BagInterface<String> workBag = null;

        int startingSize;

        System.out.println("Please enter the size of the initial head.");
        startingSize = getInt("   It should be an integer value greater than or equal to 1.");


        // ADD CODE HERE TO CREATE AND INITIALIZE THE TWO BAGS
        
        headBag = new ArrayBag<Integer>(startingSize);
        
        headBag.add(startingSize);
        
        workBag = new ArrayBag<String>();
        
        System.out.println("The head bag is " + headBag);

        boolean noOverflow = true;

        // ADD CODE HERE TO DO THE SIMULATION
        noOverflow = simulationStep(headBag, workBag);
        if (noOverflow) {
            System.out.println("The number of chops required is " + workBag.getCurrentSize());
        } else {
            System.out.println("Computation ended early with a bag overflow");
        }

    }

    /**
     * Take one head from the headBag bag.  If it is a final head, we are done with it.
     * Otherwise put in two heads that are one smaller.
     * Always put a chop into the work bag.
     *
     * @param  heads   A bag holding the heads yet to be considered.
     * @param  work   A bag of chops.
     * @return true if adding to the bags did not cause an overflow
     * 
     */
    public static boolean simulationStep(BagInterface<Integer> heads, BagInterface<String> work) {

        // COMPLETE THIS METHOD
        boolean result = true;
        while(heads.getCurrentSize() !=0)
        {
        	int n = heads.remove();
        	if(n!=1 && heads.getFrequencyOf(1)<=0)
        	{
        		if(!heads.add(n-1))
        			result=false;
        		if(!heads.add(n-1))
        			result=false;
        	}
        	
        	if(!work.add("Chop"))
        	{
        		result=false;
        		break;
        	}
        	if(result==false)
        	{
        		break;
        	}
        	
        	System.out.println(heads.toString());
        }

        return result;
    }

    /**
     * Get an integer value.
     *
     * @return     An integer. 
     */
    private static int getInt(String rangePrompt) {
        Scanner input;
        int result = 10;        //default value is 10
        try {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();

        } catch (NumberFormatException e) {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        } catch (Exception e) {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        return result;

    }
}
