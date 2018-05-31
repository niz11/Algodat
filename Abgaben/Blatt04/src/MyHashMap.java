/**
 * 
 * @author Algorithm and Datastructures Team SS2016

 * @version 1.0  
 * 
 */
import java.lang.RuntimeException;
public class MyHashMap {
	
	/**
	 * Use this array to store the values
	 * DO NOT MODIFY OR REMOVE THIS Attribute. Our tests rely on it.
	 */
	Student[] array;
	
	/**
	 * Tries inserting a Student into the hash map.
	 * Throws RunTimeException, if the student is already in the table or the table is full.
	 */
	public void add(Student s){
		//TODO: Your Code here.
		/*
		 *  Starts a loop from the hashfunktion value , looking for an empty cell , if not empty and not already there ,check the next cell
		 */
		int i =0;
		boolean full = true;
		while (i < (array.length - hashFunction(s))){
		if ((this.array[hashFunction(s) + i] == null)){
			this.array[hashFunction(s)+i] = s;
			full = false;
			i = array.length;
			
		}	
		else 
			if (this.array[hashFunction(s) + i].equals(s)){
				throw new RuntimeException();	
				
			}
		
		i++;
		}
		/*
		 * If the Array was Full until the end , starts checking again from the begining , in case the kulation pushed the student to the begining of the Array
		 */
		if (full){
			int k = 0;
			while ( k < hashFunction(s)){
				if ((this.array[k] == null)){
					this.array[k] = s;
					full = false;
					k = hashFunction(s) +1;
				}	
				else 
					if (this.array[k].equals(s)){
						throw new RuntimeException();	
						
					}
				k++;
			}
		}		
		if (full)
			throw new RuntimeException();			
		}
	
	/**
	 * Try removing a Student from the hash table.
	 * You should use the same implementation for remove discussed in the tutorial.
	 * You should NOT use the lazy deletion strategy (adding a special flag key indicating a deleted key)
	 * See https://en.wikipedia.org/wiki/Linear_probing#Deletion for more details about the algorithm!
	 * Throw RunTimeException if the hash table contained the Student
	 */
	public void remove(Student s) {
		if (contains(s)){
			boolean found = false;
			boolean loop = false;
			int index = -1;
			int hashValue = hashFunction(s);
			/*
			 * First find the right Student to Delete
			 */
			if (s.equals(array[hashValue])){
				index = hashValue;
				array[hashValue] = null;
			}
			else {
				int numberOfCellesEndArray = array.length - hashValue;
				for (int k = 1 ; k < numberOfCellesEndArray;k++ ){
					if (s.equals(array[hashValue+k])){
						array[hashValue+k] = null;
						found=true;
						index = hashValue+k;
						break;
				}	
			}
			if (found == false){
				for (int i=0 ; i<hashValue ;i++){
					if (s.equals(array[i])){
						array[i] = null;
						found=true;
						index = i;
						break;	
				 }
				}
			 }
			}
			if (index == -1)
				System.out.println("I did something wrong");
			//System.out.println(index);
			int i =1;
			if(index+i < array.length)
			// While the next cell is empty and it's noth the end of the Array do -
			while((array[index+i] != null) && (i< array.length - (index))){
				System.out.println(i);
				if(hashFunction(array[index+i]) < (index+i) ){ // Doesn't feet to his cell 
					array[index] = array[index+i];
					array[index+i]=null;
					i++;
					if (index + i == array.length){
						break;
					}
				}
				else{
				i++;
				if (index + i == array.length){
					break;}
			}}
			if /*(i == array.length- (index) && */(array[array.length-1]==null){
				int k=0;
				while((array[k] != null) && (k < hashValue)){
					if ((hashFunction(array[k]) > k)) {//&& (k==0))
						array[array.length-1] = array[k];
						array[k] = null;
						k++;
						loop = true;
						break;
					}
					k++;
			 }	
				if (loop){
					while ((k<hashValue) && (array[k+1] !=null)){
						if(hashFunction(array[k+1]) < k){
							array[k] = array[k+1];
							array[k]= null;
							k++;
						}
						k++;
					}
				}
			
			}
		}
		else{
			throw new RuntimeException();		
		}
			
	}
	
	
	/**
	 * Returns true, if the hash table contains the given Student
	 */
	public boolean contains(Student s){
		int i =0;
		int arrayEnd = array.length - hashFunction(s);
		if (this.array[hashFunction(s)]==null)
			return false;
		while ((i < arrayEnd) && (this.array[hashFunction(s) + i] != null)){
			Student s2 = array[hashFunction(s)+i];
		if ((s2.equals(s))){
			return true;
		}	
		else {
			i++;
		}}
		if (i==arrayEnd){
		int k = 0; 
		while ((k < hashFunction(s))){
			if ((this.array[k] == null))
				return false;
			Student s3 = this.array[k];
		if ((s3.equals(s))){
			return true;
		}	
		else {
			k++;
		}}}
		return false;
	}
	
	/**
	 * @param h Hashvalue to search for
	 * @return Number of Student in the hash table that have the hashvalue h
	 */
	public int getNumberStudentsWithHashvalue(int h){
		int n = 0;
		int counter=0;
		boolean EndArray=false;
		while(((this.array[h+n]) != null) && ((h+n) <= (array.length-1))){
			if(hashFunction(array[h+n]) == h)
				counter++;
				n++;
				if (h+n == array.length){
					EndArray=true;
					break;}
		}
		if (EndArray){
			int k=0;
			while(((this.array[k]) != null) && ((k) < h-1)){
				if(hashFunction(array[k]) == h){
					counter++;
					k++;
				}
				else
					k++;
			}	
		}
		
		return counter;
	}
	
	/**
	 * Doubles the size of the hash table. Recomputes the position of all elements using the
	 * new function.
	 */
	public void resize(){
		Student[] oldArray = array;
		int i=0;
		int oldLength = array.length;
		int newSize = 2*array.length;
		array = new Student[newSize] ;
		while(i < oldLength){
			if (oldArray[i] != null){
					add(oldArray[i]);
			}
			i++;
			
		}
	}

	/**
	 * This method return the array in which the strings are stored.
	 * DO NOT MODIFY OR REMOVE THIS METHOD. Our tests rely on it.
	 */
	public Student[] getArray(){
		return array;
	}
	
	/**
	 * DO NOT MODIFY OR REMOVE THIS METHOD. Our tests rely on it.
	 */
	public void setArray(Student[] array){
		this.array = array;
	}

	/**
	 * Runs the hash function for Student s (dependent on the size of the hash table)
	 * DO NOT MODIFY OR REMOVE THIS METHOD. Our tests rely on it.
	 * @param s Student
	 * @return the hash value for a student. (The position where it would be saved given no collisions)
	 */
	public int hashFunction(Student s){
		int hashvalue = Math.abs(s.hashCode()) % array.length;
		return hashvalue;
	}
	
	/**
	 * Constructor to initialize the hash with a given capacity
	 * DO NOT MODIFY OR REMOVE THIS METHOD. Our tests rely on it.
	 */
	public MyHashMap(int capacity){
		array = new Student[capacity];
	}

}
