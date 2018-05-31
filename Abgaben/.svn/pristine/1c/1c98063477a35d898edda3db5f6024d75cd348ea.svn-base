/**
 * Represents a Cuboid
 * http://en.wikipedia.org/wiki/Cuboid
 * 
 * @author AlgoDat
 *
 */
public class Cuboid extends Body{

	double height, length, width;
	
	/*
	 * Constructor for a Cuboid object
	 */
	public Cuboid() {
		this.height = 0.0;
		this.length = 0.0;
		this.width = 0.0;
		
	}
	/*
	 * Constructor for a Cuboid object
	 * 
	 * @param h height
	 * @param l length
	 * @param w width
	 */
	public Cuboid(double h, double l, double w) {
		if ((h <0) || (l<0) || (w<0) ){
			System.out.println("The Cuboid vlaues aren't correct , The Coubid will inhalt 0 vlaues");
			this.height = 0.0;
			this.length = 0.0;
			this.width = 0.0;
		}
			
		this.height = h;
		this.length = l;
		this.width =w;
		
	}

	public double getHeight(){
		return this.height;
	}
	public double getLength(){
		return this.length;
	}
	public double getWidth(){
		return this.width;
	}
	//TODO: ggf. weitere Methoden und member implementieren
	
	// Calculate Volume
	// @see Body#calculateVolume()
	@Override
	double calculateVolume() {
		
		return (this.length * this.height * this.width);
	}
	
	// Culculate The surface
	// {@Link Body#calculateSurface()}
	
	@Override
	double calculateSurface() {
		// TODO Auto-generated method stub
		return 2 * (this.width * this.length + this.height * this.width + this.height * this.length);
	}
	
	// Print method // 
	public String Tostring(Cuboid c){
		return ("The height of the Cuboid is - " + this.height + "/n" + "The width of the Cuboid is - " + this.width +"/n"+ "The length of the Cuboid is -" + this.width );
		
	}


}

