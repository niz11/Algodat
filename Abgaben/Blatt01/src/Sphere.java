
public class Sphere {
	public Point center = new Point();
	double radius;
	double four;
	
	Sphere(int x, int y, int z, double r){
	center = new Point(x,y,z);	
	this.radius = r;
		
	}
	
	Sphere(Point c, double r){
		this.radius = r;
		this.center = c;
		
	}
	
	int getX(){
		return this.center.getX(); // TODO
	}

	int getY(){
		return this.center.getY(); // TODO
	}

	int getZ(){
		return this.center.getZ(); // TODO
	}


	double getRadius(){
		return this.radius; // TODO
	}
	
	

	double calculateDiameter(){
		return (2*this.getRadius()); // TODO
	}	
	
	double calculateSurfaceArea(){
		return (4*(Math.PI)*(Math.pow(this.getRadius(), 2))); // TODO
	}
	
	double calculateVolume(){
		return ( (Math.PI)*(Math.pow(this.getRadius(), 3)) * 4/3); // TODO
	}

}