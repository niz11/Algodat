/**
 * Represents a Cube
 * @author AlgoDat
 */
public class Cube extends Cuboid{
 
	/*
	 * Constructor without parameter
	 */
	public Cube() {
		//TODO
	}
	/*
	 * Constructor with one parameter
	 * 
	 * @param length the side length of the cube
	 */
	public Cube(double length) {
		super(length,length,length);
	}

	public double getLength(){
		return this.length;
	}
	//TODO: ggf. weitere Methoden und member implementieren
	// Calculate Volume
	// @see Body#calculateVolume()
	@Override
	double calculateVolume() {
		
		return Math.pow(this.length ,3);
	}
	
	// Culculate The surface
	// {@Link Body#calculateSurface()}
	
	@Override
	double calculateSurface() {
		// TODO Auto-generated method stub
		return 6 * Math.pow(this.length , 2);
	}
	
	// Print method // 
	public String Tostring(Cuboid c){
		return ("The height/width/length of the Cube is - " + this.length );
		
	}
}

