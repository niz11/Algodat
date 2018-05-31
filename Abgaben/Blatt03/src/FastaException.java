
public class FastaException extends Exception {

	public FastaException(String message)
	{	 
		super (message);
		
	}
	/*
	public FastaException(String message ,int Line){
	this.Line = Line;
	this.message = message;
	}
	public int getLine() {
		return Line;
	}
	public void setLine(int line) {
		Line = line;
	}
	public String getMessage() {
		if (this.Line != -1){
			return message + this.Line;
		}
		else
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
		
	*/
				 
}
	
	
	
