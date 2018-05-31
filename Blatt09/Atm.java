import java.util.LinkedList;
import java.util.List;
import java.lang.RuntimeException;

/**
 * The class <code>Node</code> implements a node in a network.
 * 
 * @author AlgoDat team
 */
public class Atm {

	public LinkedList<Integer> denominations;

    /**
	 * Initializes the banknote denominations available to the ATM
	 *
	 * @param name
	 *            the drawn value in visualization
	 **/
	public Atm() {
		// initialize list of available denominations
		denominations = new LinkedList<Integer>();
		//Add denominations in a sorted order, highest value first:
		denominations.add(200);
		denominations.add(100);
		denominations.add(50);
		denominations.add(20);
		denominations.add(10);
		denominations.add(5);
	}

	/**
	 * Computes the the number of banknotes for each denomination
	 * 
	 * @param total
	 *            Amount of money requested
	 *            End point of this edge.
	 * @return List<int> 
	 *            Amount of banknotes for each denomination, 
	 *            as a list in the same order as the list denominations
	 *            Example: [0,1,0,0,0,0]: one 100EUR banknote
	 */
	public LinkedList<Integer> getDivision(int total) {
		LinkedList<Integer> division = new LinkedList<Integer>();
		int fiveH = total / 200;
		division.add(fiveH);
		if (fiveH % 200 ==0){
			for (int i=1 ; i< 6 ; i++)
				division.add(0);
			return division;
		}
			else {
				if (fiveH>0)
					total = total - 200 * fiveH ; 
					int Hundert = total / 100;
					division.add(Hundert);
						if (fiveH % 100 ==0){
							for (int i=2 ; i< 6 ; i++)
								division.add(0);
								return division;
						}
									else {
										if (Hundert>0)
											total = total - 100 * Hundert ; 
											int Funfzig = total / 50;
											division.add(Funfzig);
											if (fiveH % 50 ==0){
												for (int i=3 ; i< 6 ; i++)
												division.add(0);
												return division;
											}
												else {
													if (Funfzig>0)
														total = total - 50 * Funfzig ; 
													int Zwanzig = total / 20;
													division.add(Zwanzig);
													if (Zwanzig % 20 ==0){
														for (int i=4 ; i< 6 ; i++)
															division.add(0);
															return division;
													}
															else {
																if (Zwanzig>0)
																	total = total - 20 * Zwanzig ; 
																int Zehner = total / 10;
																division.add(Zehner);
																if (Zehner % 10 ==0){
																	for (int i=5 ; i< 6 ; i++)
																		division.add(0);
																		return division;
																}
																	else {
																		if (Zehner>0)
																			total = total - 10 * Zehner ; 
																			int Funfer = total / 5;
																			division.add(Funfer);
									
										
										
																	}
								
								
															}
						
						
												}
				
				
									}
			}
		return division;
		}

}
