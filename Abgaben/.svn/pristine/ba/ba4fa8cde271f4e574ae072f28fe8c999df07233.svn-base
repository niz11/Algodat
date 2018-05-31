import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;


/**
 * 
 * @author AlgoDat Team
 *
 */
public class KnapsackSolver {
	
	
	/**
	 * Tries all possible item combination to solve the knapsack problem. Returns the optimal solution.
	 * @param k Empty knapsack with a maximum capacity to fill
	 * @param items a list of items each with a weight and a value
	 * @return the filled knapsack
	 */
	public Knapsack solveKnapsackOptimal(Knapsack k, LinkedList<Item> items){
		int maxWeight = k.maxWeight;
		
		/*
		 * building the CostTable to get the best combi of items
		 */
		int [][] CostTable;
		CostTable  = new int  [items.size()+1][maxWeight+1] ; 
	    /*
	     * Set each column in first row to zero
	     */
	    for(int j = 0 ; j < maxWeight; j++)
	        CostTable[0][j] = 0;
	 
	    /*
	     * Set each row in first column to zero
	     */
	    for(int s = 0; s < items.size(); ++s)
	        CostTable[s][0] = 0;
	    for(int i = 1; i < items.size()+1; ++i){
	        
	        /*
	         * calculate till required weight
	         */
	        for(int w = 1; w <= maxWeight; ++w){
	            /*
	             * Get value from row above
	             * or,
	             * the value from a left column (w - Weight[i]) in the row above with added benefit
	             */
	        	
	            if(items.get(i-1).getWeight() <= w)
	                CostTable[i][w] = max(items.get(i-1).getValue() + CostTable[i-1][w - items.get(i-1).getWeight()], CostTable[i-1][w]);
	            else
	                CostTable[i][w] = CostTable[i-1][w];
	        }
	    }
	    
	    /*
	     *  A loop to abstract the Answer from my CostTable
	     */
	    int SpalteIndex = maxWeight;
	    int zeileIndex = items.size();
	    
	    while (zeileIndex > 0 ){
	    	if (CostTable[zeileIndex][SpalteIndex] == CostTable[zeileIndex-1][SpalteIndex]){
	    		zeileIndex = zeileIndex-1;
	    	}
	    	else{
	    		k.addItem(items.get(zeileIndex-1));
	    		SpalteIndex = SpalteIndex - items.get(zeileIndex-1).getWeight();
	    		zeileIndex = zeileIndex-1;
	    	}
	    		
	    }
	    
		/*
		 * Printing the Costable to see if it is right
		 */
	    for(int m = 0; m <= items.size(); ++m){
	        for(int w = 0; w <= maxWeight; ++w)
	            System.out.print(" "+ CostTable[m][w]);
	        System.out.println();
	    }
		return k;
	}

	/**
	 * Uses the trivial greedy algorithm to solve the Knapsack problem. 
	 * @param k Empty knapsack with a maximum capacity to fill
	 * @param items a list of items each with a weight and a value
	 * @return the filled knapsack
	 */
	public Knapsack solveKnapsackGreedyStupid(Knapsack k, LinkedList<Item> items){
		/*
		 * Now sorting the new List by The Values , My sorting need twice to work perfectly ;) 
		 */
		if (!items.isEmpty()) { // goes until the end of the method
			
			if (items.size()>1){
		quickS(0 , items.size()-1,items);
		quickS(0 , items.size()-1,items);
			}
		/*
		 * Starting from the item with the highest Value until can,t fit anymore
		 */
		int i=(items.size()-1);
		//while (k.addItem(items.get(i))){
		while (i>-1){
			k.addItem(items.get(i));
			i--;
			if (i==-1) break;
		}
		}
		return k;
	}
	
	
	/**
	 * Uses a smarter greedy algorithm to solve the Knapsack problem. 
	 * @param k Empty knapsack with a maximum capacity to fill
	 * @param items a list of items each with a weight and a value
	 * @return the filled knapsack
	 */
	public Knapsack solveKnapsackGreedySmart(Knapsack k, LinkedList<Item> items){
		LinkedList<Item> Sorteditems = new LinkedList<Item>();
		double newValue = 0;
		int newIntValue = 0;
		/*
		 * Build a new List where all the Items have a new Value , which is the Relativ value between Value and Weight
		 */
		if (!items.isEmpty()) {
		for (int i=0 ; i<items.size(); i++) {
			int Value = items.get(i).getValue();
			int Weight = items.get(i).getWeight();
			newValue = Value/Weight;
			newValue = newValue *100;
			newIntValue = (int) newValue;
			Item e = new Item(items.get(i).getIndex(), Weight ,newIntValue );
			Sorteditems.add(e);
		}
		/*
		 * Now sorting the new List by The new Values , My sorting need twice to work perfectly ;) 
		 */
		if (items.size()>1){
		quickS(0 , items.size()-1, Sorteditems);
		quickS(0 , items.size()-1, Sorteditems);
		}
		 /*
		  * Now add to k untill full
		  */
		int i=Sorteditems.size()-1;
		//while (k.addItem(items.get(Sorteditems.get(i).getIndex()-1)))
		while (i>-1) {
			if(items.get(0).getIndex()==1){
			k.addItem(items.get(Sorteditems.get(i).getIndex()-1));
			i--;
		    if (i==-1) break;
			}
			else {
				k.addItem(items.get(Sorteditems.get(i).getIndex()));
				i--;
			    if (i==-1) break;
				
			}
		}
		}
		return k;
	}
	
	//END


public void quickS(int low , int high ,LinkedList<Item> items) {
	System.out.println(items.size());
	int mid = (high + low )/ 2;
	int left = low;
	int right = high;
	int pivot = items.get(mid).getValue(); // select middle element as pivot
	while (left <= right) {
		while (items.get(left).getValue() < pivot)
			left++;// find element which is greater than pivot
		while (items.get(right).getValue() > pivot)
			right--;// //find element which is smaller than pivot
		// if we found the element on the left side which is greater than
		// pivot
		// and element on the right side which is smaller than pivot
		// Swap them, and increase the left and right
		if (left <= right) {
			Item temp = items.get(left);
			items.remove(left);
			if (right==0){
				items.add(left, items.get(right));
				items.remove(right);
				items.add(right, temp);
				left++;
				right--;	
			}
			else {
			items.add(left, items.get(right-1));
			items.remove(right);
			items.add(right, temp);
			left++;
			right--;
			}
		}
	}
	// Recursion on left and right of the pivot
	if (low < right)
		quickS(low, right ,items);
	if (left < high)
		quickS(left, high, items);
	
}

public int max(int a, int b){
    		if (a > b)
    			return a;
    			else
    				return  b;
}
}




