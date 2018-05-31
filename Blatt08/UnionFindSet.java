import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * A class implementing a Union-Find-data structure with representatives.
 * 
 * @author AlgoDat-Team
 */
public class UnionFindSet<T>{

	//You can use this map to store the representant for each element of the Union find structure
    private HashMap<T,T> element2representative;

	public UnionFindSet() {
		element2representative = new HashMap<>();
	}

	/**
	 * Takes a collection of n elements and adds 
	 * n disjoint partitions each with one element in it.
	 * 
	 * @param set
	 *            The set to be partitioned.
	 */
	public void add(List<T> elements) {
		for (int i= 0 ; i<elements.size(); i++){
			element2representative.put(elements.get(i), elements.get(i));
		}
	}

	/**
	 * Creates one disjoint partition with the element in it 
	 * and adds it to the Union-Find data structure
	 * 
	 * @param element
	 *            The element to put in the partition.
	 */
	public void add(T element) {
		element2representative.put(element, element);
	}

	/**
	 * Retrieves the partition which contains the wanted element.
	 * 
	 * A partition is identified by a single, representative element.
	 * This function returns the representative of the partition
	 * that contains x. 
	 * 
	 * @param x
	 *            The element whose partition we want to know
	 * @return 
	 *            The representative element of the partition
	 */
	public T getRepresentative(T x) {
		//System.out.println("I am the representativ from " + x + " - " +x.hashCode());
		return element2representative.get(x);
	}

	/**
	 * Joins two partitions. First it retrieves the partitions containing the
	 * given elements. Removes one of the joined partitions from
	 * <code>partitions</code>.
	 * 
	 * @param x
	 *            One element whose partition is to be joined.
	 * @param y
	 *            The other element whose partition is to be joined.
	 */
	public void union(T x, T y) {
		T placeholder = getRepresentative(y);
		T placeholder2 = getRepresentative(x);
		element2representative.remove(y);
		element2representative.put(y,placeholder2);
		/* Tutor meinte , dass die For loop im SimpleGraph sein Soll
		
		for (Entry<T, T> entry : element2representative.entrySet()) {
		    T key = entry.getKey();
		    T value = entry.getValue();
		    if (value==placeholder){
		    	element2representative.remove(key);
		    	element2representative.put(key,getRepresentative(x));
		}
		}
		*/

	
}}

