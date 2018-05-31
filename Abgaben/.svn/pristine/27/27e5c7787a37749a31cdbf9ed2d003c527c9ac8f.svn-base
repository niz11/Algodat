import java.util.ArrayList;

import java.util.Collections;

/**
 * This class implements two methods. These check an array on a few
 * characteristics.
 * 
 * @author AlgoDat-Tutoren
 * 
 */
public class ArrayCheck {

	/**
	 * Tests all elements of the given array, if they are divisible by the given
	 * divisor.
	 * 
	 * @param arr
	 *            array to be tested
	 * @param divisor
	 *            number by which all elements of the given array should be
	 *            divisible
	 * @return true if all elements are divisible by divisor
	 */
	public boolean allDivisibleBy(ArrayList<Integer> arr, int divisor) {
		int checknullArray = 0; // Counts the null values in the list
		if ((arr.isEmpty()) || (divisor == 0) || (arr == null) ) return false; // If ArrayList is empty or divisor ist zero , then it is false
        for (Integer answer : arr){ // goes through the Arraylist
        	if (answer != null ) {
        		if (answer % divisor != 0 )  // If it doesn't divided perfectly on divisor then it's false
        		return false;
        }
        else {
        	checknullArray += 1;
        }}
        if (checknullArray == arr.size())
        	return false;
        else
        return true;
    }
	/**
	 * Tests if the given two arrays are anagrams of each other
	 * 
	 * @param arr1
	 *            first array to be compared
	 * @param arr2
	 *            second array to be compared
	 * @return true if the two arrays are an anagram
	 */
    public boolean isAnagram(ArrayList<Character> arr1, ArrayList<Character> arr2) {
    	if ((arr1.isEmpty() || arr2.isEmpty())) return false; // Make sure both ArrayList aren't empty
    	if ((arr1.get(0)== null) && (arr1.size()==1)) return false; // Make sure both ArrayList aren't null
    	if ((arr2.get(0)== null) && (arr2.size()==1)) return false; // Make sure both ArrayList aren't null
    	
    	// First sorting and arraging both Arrays //

    	for (int j = 0 ; j < arr1.size(); j++){   // Deleltes every char that isn't a letter
      		if ((arr1.get(j) == null) && (j==0)){
    			arr1.remove(j);
    		}
      		else if ((arr1.get(j) == null)){
      			  arr1.remove(j);
      			  j = j-1;
      		}
    		else
    		if ((Character.isLetter(arr1.get(j)) == false) && (j==0)) {
    			arr1.remove(j);
    		}	
    		else if (Character.isLetter(arr1.get(j)) == false){
    			arr1.remove(j);
    			j=j-1;
    		}
    			arr1.set(j, Character.toLowerCase(arr1.get(j)));  // Changes all the List to lower case
    		}
    	for (int k = 0 ; k < arr2.size(); k++){   // Deleltes every char that isn't a letter
      		if ((arr2.get(k) == null) && (k==0)){
    			arr2.remove(k);
    		}
      		else if (arr2.get(k) == null) {
      			arr2.remove(k);
      			k=k-1;
      		}
    		else
    		if ((Character.isLetter(arr2.get(k)) == false) && (k==0)) {
    			arr2.remove(k);
    		}	
    		else if(Character.isLetter(arr2.get(k)) == false) {
    			arr2.remove(k);
    			k =k-1;
    		}
    			arr2.set(k, Character.toLowerCase(arr2.get(k)));  // Changes all the List to lower case
    		}
    	
    	if ((arr1.isEmpty() || arr2.isEmpty())) return false; // Make sure both ArrayList aren't empty
    	Collections.sort(arr1); // Sorting each List
    	Collections.sort(arr2);
    	
    	// After sorting and arraging each List , now actually Comparing them
    	
    	int sum = 0; // An Indikator to check if both ArrayList are exactly the same
        if ( (arr1.containsAll(arr2)) && (arr2.containsAll(arr1))) {  // First make sure that both Arrays contains each other
        	for (int i = 0; i < arr1.size(); i++){ // Compare both ArraysList
        		if (arr1.get(i)== arr2.get(i)) 
        			sum = sum+1; // Sums all the words coples
        	}
        	if (sum == arr1.size()) return true;
        	else
        		return false;        	
        }
        
        else
        	return false;
    }

}

