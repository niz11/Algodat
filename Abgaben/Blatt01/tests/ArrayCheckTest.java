import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class ArrayCheckTest {
	private ArrayList<Integer> Testarray1 = new ArrayList<Integer>();
	private ArrayList<Integer> Testarray2 = new ArrayList<Integer>();
	public int divisor;
	private ArrayList<Character> Testarray3 = new ArrayList<Character>();
	private ArrayList<Character> Testarray4 = new ArrayList<Character>();
	private ArrayList<Character> null1 = new ArrayList<Character>();
	private ArrayList<Character> null2 = new ArrayList<Character>();
	private ArrayList<Character> Tom = new ArrayList<Character>();
	private ArrayList<Character> Lord = new ArrayList<Character>();
	
	
	// NOTTODO DIESE ZEILE BITTE NICHT VERAENDERN!!
	// TODO Fuehrt eure Tests auf diesem ArrayCheck-Objekt aus!
	// Ansonsten werden unsere Tests fehlschlagen
	public ArrayCheck arrayCheckTestObject = new ArrayCheck();

	@Test(timeout = 1000)
	public void testAllDivisibleBy() {
		
		divisor = -2;
		Testarray1.add(2);
		Testarray1.add(4);
		Testarray1.add(5);
		Testarray1.add(8);
		Testarray1.add(10);
		
		assertEquals("Checks if brings the right answer -" , false ,arrayCheckTestObject.allDivisibleBy(Testarray1,divisor));
		assertEquals("Checks division by 0 -" , false ,arrayCheckTestObject.allDivisibleBy(Testarray1,0));
		assertEquals("Checks emptyArray -" , false ,arrayCheckTestObject.allDivisibleBy(Testarray2,2));
		
		Testarray2.add(null);
		Testarray2.add(3);
		assertEquals("Checks emptyArray -" , false ,arrayCheckTestObject.allDivisibleBy(Testarray2,2));
		Testarray2.remove(1);
		assertEquals("Checks emptyArray -" , false ,arrayCheckTestObject.allDivisibleBy(Testarray2,2));
		Testarray2.add(2);
		assertEquals("Checks emptyArray -" , true ,arrayCheckTestObject.allDivisibleBy(Testarray2,2));
		
		// TODO Schreibt verschiedene Testfaelle, die unterschiedliche Arrays
		// anlegen und an arrayCheck.testAllDivisibleBy uebergeben.
		// Benutzt nur diese Methode.
		// Testet auch randfaelle wie z.B. leere arrays.
		// Bsp: assertTrue("mein test 1", arrayCheckTestObject.allDivisibleBy(testArray, 7));
	}

	@Test(timeout = 1000)
	public void testIsAnagram() {
		Testarray3.add('l');
		Testarray4.add('l');
		
		assertTrue("Simple test both are one letter Angram", arrayCheckTestObject.isAnagram(Testarray3, Testarray4)); 
		
		Testarray3.add('k');
		Testarray4.add('l');
		null1.add(null);
		null2.add(null);
		
		assertFalse("Simple test , both Aren't Angram", arrayCheckTestObject.isAnagram(Testarray3, Testarray4));
		assertFalse("One of the Lists is empty", arrayCheckTestObject.isAnagram(Testarray3, null1)); // One of the Lists is empty
		assertFalse("One of the Lists is empty", arrayCheckTestObject.isAnagram(null2, Testarray4)); 
		assertFalse("Both of the Lists are empty", arrayCheckTestObject.isAnagram(null1, null2));
		
		Testarray3.add('l');
		Testarray4.add('k');
		assertTrue("Simple test both are one letter Angram", arrayCheckTestObject.isAnagram(Testarray3, Testarray4));
		
		Testarray3.add(' ');
		Testarray4.add('!');
		assertTrue("Checking other character types and a space", arrayCheckTestObject.isAnagram(Testarray3, Testarray4));
		
		Testarray3.add('G');
		Testarray4.add('g');
		assertTrue("Check Kapital letters", arrayCheckTestObject.isAnagram(Testarray3, Testarray4));
		
		
		// Check I am Lord Voldemort and Tom Marvolo Riddle
		Tom.add(null);
		Tom.add('T');
		Tom.add('o');
		Tom.add('m');
		Tom.add(' ');
		Tom.add('M');
		Tom.add('a');
		Tom.add(null);
		Tom.add('r');
		Tom.add('v');
		Tom.add('o');
		Tom.add('-');
		Tom.add('+');
		Tom.add('2');
		Tom.add('l');
		Tom.add('o');
		Tom.add(' ');
		Tom.add(null);
		Tom.add('R');
		Tom.add('i');
		Tom.add('d');
		Tom.add('d');
		Tom.add(null);
		Tom.add('l');
		Tom.add('e');
		Tom.add('!');
		
		Lord.add('!');
		Lord.add('I');
		Lord.add(null);
		Lord.add(null);
		Lord.add(null);
		Lord.add(' ');
		Lord.add(null);
		Lord.add('a');
		Lord.add('m');
		Lord.add(' ');
		Lord.add(null);
		Lord.add('L');
		Lord.add('o');
		Lord.add('r');
		Lord.add('d');
		Lord.add(' ');
		Lord.add('v');
		Lord.add('o');
		Lord.add('@');
		Lord.add('%');
		Lord.add('l');
		Lord.add('d');
		Lord.add('e');
		Lord.add(null);
		Lord.add('m');
		Lord.add('o');
		Lord.add('r');
		Lord.add('*');
		Lord.add('^');
		Lord.add('t');
		Lord.add(null);
		Lord.add(null);
		Lord.add(null);
		
		assertTrue("The dark Lord", arrayCheckTestObject.isAnagram(Lord, Tom));
		
		
		
		
		
		
		
		
		
		// TODO Schreibt verschiedene Testfaelle fuer isAnagram in diese Methode
		// Bsp: assertTrue("mein test 2", arrayCheckTestObject.isAnagram(testArray1, testArray2));

		// TODO Schreibt verschiedene Testfaelle fuer isAnagram
	}


}

