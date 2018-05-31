import java.io.IOException;


import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import org.junit.Test;

public class FastaParser {
	/**
	 * Parse Fasta File and return list of sequences
	 * @param file to read
	 * @return ArrayList of String Objects containing the sequences
	 */
	public ArrayList<String> readSequences(File file) throws FastaException, IOException {
	    RandomAccessFile input = null;
	    ArrayList<String> SequencesList = new ArrayList < String>();
	    input = new RandomAccessFile(file, "r"); // r = file can be read ,but not written
	    String line;
	    String sequence = "";
	    int lineIndex=1;
	    boolean secondIndentifier = false;
	    try{
	    while ((line = input.readLine()) != null) { // read file line by line, if line == null, end is reached
	    	// check if First line is empty
	    	if((line.isEmpty()) && (SequencesList.isEmpty()))
	    		throw new FastaException("Expected identifier");
	    	// Check if line is Empty
	    	if(line.isEmpty()) 
	    		throw new FastaException("Expected sequence on line " + (lineIndex) );
	    	// check if First line has no identifier
	    	line.trim();
	    	if((line.charAt(0) != '>') && (SequencesList.isEmpty()))
	    		throw new FastaException("Expected identifier");
	    	 
	    	if (line.charAt(0) == '>') {
	    		SequencesList.add(sequence);
	    		sequence = "";
	    		if((secondIndentifier)) 
	    			throw new FastaException("Expected sequence on line " + (lineIndex) );
	    		lineIndex++;
	    		secondIndentifier = true;
	    		
	    	}
	    	else {
	    		for (int k=0 ; k < line.length()-1; k++)
						if (!Character.isLetter(line.charAt(k)))
							throw new FastaException("Expected sequence on line " + (lineIndex) );
	    		sequence = sequence + line;
	    		lineIndex++;
	    		secondIndentifier = false;
	    	}
	    }
	    // If sequence has a value , and there are no more identifiers
	    if(sequence != "")
	    	SequencesList.add(sequence);
	    input.close();
	    SequencesList.removeAll(Arrays.asList("", null));
		if (SequencesList.isEmpty())
			throw new FastaException("Expected identifier");
	    return SequencesList;}
	    finally{
	    	
	    }
	}

	/**
	 * Runs readSequence on the input and returns either a string presentation of the resulting ArrayList or, 
         * in case of an Exception, the corresponding message (hint: Exceptions are normal objects with fields/ methods) 
	 * @param file to read
	 * @return String representation of result list or exception message
	 */
	public String handleException(File f) {
		String finalAntwotrt = "";
		ArrayList<String> ArrayAntwort = new ArrayList < String>();
		try {
		//	if ((!f.exists()) || (f.length()==0) || (!f.canRead())) {
			//	throw new FastaException("Expected identifier");
			//}
			ArrayAntwort = readSequences(f);
			// If the first Cell isn't null , It means that there was no identifier
			if (ArrayAntwort.isEmpty())
				throw new FastaException("Expected identifier");
			//if (ArrayAntwort.get(0) != ""){
				//throw new FastaException("Expected identifier");
			//}
			// Checking if the Array contains only legal charakters
		//	if (!ArrayAntwort.isEmpty()){
			//for (int i=0; i <ArrayAntwort.size(); i++ ){
				//String check = ArrayAntwort.get(i);
				//for (int k=0 ; k < check.length(); k++){
					//if (!Character.isLetter(check.charAt(k))){
						//throw new FastaException("Expected sequence on line " +k );
					//}			
				//}
			//} 
			//}
			// Stringing the Final represatation of the Array 
			for (int i=0; i <ArrayAntwort.size(); i++ ){
				finalAntwotrt =  finalAntwotrt +ArrayAntwort.get(i);
			}
			return "[" +finalAntwotrt + "]";
			
			
		} catch (FastaException e) {
			//System.out.println(e.getMessage());
			return e.getMessage();
			
		} catch (IOException e) {
			//System.out.println("File is desn't exist / readeable or is empty");
			e.printStackTrace();
		}
		return finalAntwotrt;

	}


}

