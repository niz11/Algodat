
/**
* this class <code> Picture </code> describes a RGB picture with dimensions width x height.
* Each pixels coulour is represented by an RGBColour
* 
* @author AlgoDat
*
*/

import javax.imageio.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;

public class Picture {

    /**
    * A 2d array containing the colours of the individual pixels
    */
    private RGBColor imageMatrix[][];

    /**
    * The width of the image in pixels
    */
    private int width;

    /**
    * height of the image in pixels
    */
    private int height;
    
    /**
     * intitialize a picture by creating a white picture
     */
    public Picture(int width, int height){
        this.height = height;
        this.width = width;
        createWhitePicture();
    }
    /**
     * initialize a picture by opening given file
     * @param picUrl path of *.bmp picture
     */
    public Picture(String picUrl){      
        openAndSetPicture(picUrl);      
    }

    /**
    * intialize a picture by giving an image matrix
    * @param imageMatrix two dimansionar RGBColor array
    */
    public Picture(RGBColor imageMatrix[][]){
        this.width = imageMatrix.length;
        this.height = imageMatrix[0].length;
        this.imageMatrix = imageMatrix;
    }

    /**
     * turns this picture 90 degrees to the right
     *
     */
    public void rot90DegRight(){
    	RGBColor[][] rotatedMatrix = new RGBColor[this.height][this.width];  // New Matrix to hold the new rotated values
        for (int w=0; w < this.height ; w++){
            for(int h=0; h< this.width; h++){
                //set this colors in picture
                rotatedMatrix[w][h] = new RGBColor(255, 255, 255);    // 255 = white . Without "new" it would be a mistake. because it will give values to null      
            }}
        
            for (int w=0; w< this.width; w++){  // A for loop to rotate the Matrix to a new Matrix
            for(int h=0; h< this.height; h++){
            	rotatedMatrix[(this.height-h-1)][w]=this.imageMatrix[w][h];
            }}
            
        
        this.imageMatrix = new RGBColor[this.height][this.width];
        for (int w=0; w < this.height ; w++){
            for(int h=0; h< this.width; h++){
            	this.imageMatrix[w][h]= rotatedMatrix[w][h];
            }}
        
        int a = 0;
        a = this.height;
        this.height = this.width;
        this.width = a;
    	    
    }
    
    /**
     * turns this picture 180 degrees
     *
     */
    public void rot180Deg(){ // Rotate 90 Grade two times
    	rot90DegRight();
    	rot90DegRight();

    }
    
    /**
     * finds white pixels and approximates their new color by using the average of neighbour colors
     *
     */
    public void repairPicture(){    
    	int Avred1 = 0; // Avarage for the red Nachbarn Red pixels
		int Avgreen1 = 0; //"" green pixels
		int Avblue1 = 0; // "" blue pixels
        for (int w=0; w< this.width; w++){  // A for loop to go trough the Matrix and find the damaged fixels 
            for(int h=0; h< this.height; h++){
            	if (this.imageMatrix[w][h].isWhite()){ // Is it whie? = Damaged
            		if((w==0) && (h==0)){ // If it's the first cell from the upper left corner , and % 255 to ignore the white/damaged pixels
            			 Avred1 = ((this.imageMatrix[w][h+1].getRed()%255) + (this.imageMatrix[w+1][h].getRed()%255) + (this.imageMatrix[w+1][h+1].getRed()%255))/3;
            			 Avgreen1 = ((this.imageMatrix[w][h+1].getGreen()%255) + (this.imageMatrix[w+1][h].getGreen()%255) + (this.imageMatrix[w+1][h+1].getGreen()%255))/3;
            			 Avblue1 = ((this.imageMatrix[w][h+1].getBlue()%255) + (this.imageMatrix[w+1][h].getBlue()%255) + (this.imageMatrix[w+1][h+1].getBlue()%255))/3;
            			this.imageMatrix[w][h] = new RGBColor(Avred1,Avgreen1,Avblue1);
            		}
            		else if ((w==0) && (h < this.height - 1)){ // Fixels on the Rand
                   			 Avred1 = ((this.imageMatrix[w][h+1].getRed()%255) + (this.imageMatrix[w+1][h].getRed()%255) + (this.imageMatrix[w+1][h+1].getRed()%255)+(this.imageMatrix[w][h-1].getRed()%255)+(this.imageMatrix[w+1][h-1].getRed()%255))/5;
                			 Avgreen1 = ((this.imageMatrix[w][h+1].getGreen()%255) + (this.imageMatrix[w+1][h].getGreen()%255) + (this.imageMatrix[w+1][h+1].getGreen()%255)+(this.imageMatrix[w][h-1].getGreen()%255)+(this.imageMatrix[w+1][h-1].getGreen()%255))/5;
                			 Avblue1 = ((this.imageMatrix[w][h+1].getBlue()%255) + (this.imageMatrix[w+1][h].getBlue()%255) + (this.imageMatrix[w+1][h+1].getBlue()%255)+(this.imageMatrix[w][h-1].getBlue()%255)+(this.imageMatrix[w+1][h-1].getBlue()%255))/5;
                			 this.imageMatrix[w][h] = new RGBColor(Avred1,Avgreen1,Avblue1);	
            				}
            				else if ((w==0) && (h== this.height-1)){ // Corner
                   			 Avred1 = ((this.imageMatrix[w][h-1].getRed()%255) + (this.imageMatrix[w+1][h].getRed()%255) + (this.imageMatrix[w-1][h-1].getRed()%255))/3;
                			 Avgreen1 = ((this.imageMatrix[w][h-1].getGreen()%255) + (this.imageMatrix[w+1][h].getGreen()%255) + (this.imageMatrix[w-1][h-1].getGreen()%255))/3;
                			 Avblue1 = ((this.imageMatrix[w][h-1].getBlue()%255) + (this.imageMatrix[w+1][h].getBlue()%255) + (this.imageMatrix[w-1][h-1].getBlue()%255))/3;
                			this.imageMatrix[w][h] = new RGBColor(Avred1,Avgreen1,Avblue1);		
            				}
            				else if((h==0) && (w < this.width -1 )){ // Rand
                      			 Avred1 = ((this.imageMatrix[w][h+1].getRed()%255) + (this.imageMatrix[w+1][h].getRed()%255) + (this.imageMatrix[w+1][h+1].getRed()%255)+(this.imageMatrix[w-1][h].getRed()%255)+(this.imageMatrix[w-1][h+1].getRed()%255))/5;
                    			 Avgreen1 = ((this.imageMatrix[w][h+1].getGreen()%255) + (this.imageMatrix[w+1][h].getGreen()%255) + (this.imageMatrix[w+1][h+1].getGreen()%255)+(this.imageMatrix[w-1][h].getGreen()%255)+(this.imageMatrix[w-1][h+1].getGreen()%255))/5;
                    			 Avblue1 = ((this.imageMatrix[w][h+1].getBlue()%255) + (this.imageMatrix[w+1][h].getBlue()%255) + (this.imageMatrix[w+1][h+1].getBlue()%255)+(this.imageMatrix[w-1][h].getBlue()%255)+(this.imageMatrix[w-1][h+1].getBlue()%255))/5;
                    			 this.imageMatrix[w][h] = new RGBColor(Avred1,Avgreen1,Avblue1);
            				}
            				else if((h==0) && (w == this.width -1 )){ //Corner
                      			 Avred1 = ((this.imageMatrix[w][h+1].getRed()%255) + (this.imageMatrix[w-1][h+1].getRed()%255) + (this.imageMatrix[w-1][h].getRed()%255))/3;
                    			 Avgreen1 = ((this.imageMatrix[w][h+1].getGreen()%255) + (this.imageMatrix[w-1][h+1].getGreen()%255) + (this.imageMatrix[w-1][h].getGreen()%255))/3;
                    			 Avblue1 = ((this.imageMatrix[w][h+1].getBlue()%255) + (this.imageMatrix[w-1][h+1].getBlue()%255) + (this.imageMatrix[w-1][h].getBlue()%255))/3;
                    			 this.imageMatrix[w][h] = new RGBColor(Avred1,Avgreen1,Avblue1);
            				}
            				else if ((w==this.width-1) && (h <this.height -1)) { //Rand
                     		 Avred1 = ((this.imageMatrix[w][h+1].getRed()%255) + (this.imageMatrix[w-1][h].getRed()%255) + (this.imageMatrix[w-1][h+1].getRed()%255)+(this.imageMatrix[w-1][h-1].getRed()%255)+(this.imageMatrix[w-1][h-1].getRed()%255))/5;
                   			 Avgreen1 = ((this.imageMatrix[w][h+1].getGreen()%255) + (this.imageMatrix[w-1][h].getGreen()%255) + (this.imageMatrix[w-1][h+1].getGreen()%255)+(this.imageMatrix[w-1][h-1].getGreen()%255)+(this.imageMatrix[w-1][h-1].getGreen()%255))/5;
                   			 Avblue1 = ((this.imageMatrix[w][h+1].getBlue()%255) + (this.imageMatrix[w-1][h].getBlue()%255) + (this.imageMatrix[w-1][h+1].getBlue()%255)+(this.imageMatrix[w-1][h-1].getBlue()%255)+(this.imageMatrix[w-1][h-1].getBlue()%255))/5;
                   			 this.imageMatrix[w][h] = new RGBColor(Avred1,Avgreen1,Avblue1);
            				}
            				else if((w==this.width-1) && (h ==this.height -1)) { // Last corner
                     		 Avred1 = ((this.imageMatrix[w][h-1].getRed()%255) + (this.imageMatrix[w-1][h-1].getRed()%255) + (this.imageMatrix[w-1][h].getRed()%255))/3;
                   			 Avgreen1 = ((this.imageMatrix[w][h-1].getGreen()%255) + (this.imageMatrix[w-1][h-1].getGreen()%255) + (this.imageMatrix[w-1][h].getGreen()%255))/3;
                   			 Avblue1 = ((this.imageMatrix[w][h-1].getBlue()%255) + (this.imageMatrix[w-1][h-1].getBlue()%255) + (this.imageMatrix[w-1][h].getBlue()%255))/3;
                   			 this.imageMatrix[w][h] = new RGBColor(Avred1,Avgreen1,Avblue1);
            				}
            				else if((h==this.height -1) && (w< this.width-1)) { // Rand
                        		 Avred1 = ((this.imageMatrix[w][h-1].getRed()%255) + (this.imageMatrix[w-1][h].getRed()%255) + (this.imageMatrix[w-1][h-1].getRed()%255)+(this.imageMatrix[w+1][h-1].getRed()%255)+(this.imageMatrix[w+1][h].getRed()%255))/5;
                       			 Avgreen1 = ((this.imageMatrix[w][h-1].getGreen()%255) + (this.imageMatrix[w-1][h].getGreen()%255) + (this.imageMatrix[w-1][h-1].getGreen()%255)+(this.imageMatrix[w+1][h-1].getGreen()%255)+(this.imageMatrix[w+1][h].getGreen()%255))/5;
                       			 Avblue1 = ((this.imageMatrix[w][h-1].getBlue()%255) + (this.imageMatrix[w-1][h].getBlue()%255) + (this.imageMatrix[w-1][h-1].getBlue()%255)+(this.imageMatrix[w+1][h-1].getBlue()%255)+(this.imageMatrix[w+1][h].getBlue()%255))/5;
                       			 this.imageMatrix[w][h] = new RGBColor(Avred1,Avgreen1,Avblue1);
            				}
            		// Will correct normally every pixel that isn't in the Rand , ignoring damaged pixels
            				else { for (int k=0 ; k<3 ; k++){
            						for(int l=0 ; l<3 ; l++) {
            							if (this.imageMatrix[w+k][h+l].isWhite()==false){
                                   		 Avred1 = this.imageMatrix[w+k][h+l].getRed() + Avred1; 
                               			 Avgreen1 = this.imageMatrix[w+k][h+l].getGreen() + Avgreen1;
                               			 Avblue1 = this.imageMatrix[w+k][h+l].getBlue() + Avblue1; 	
            								
            						}}}
            						this.imageMatrix[w][h] = new RGBColor(Avred1,Avgreen1,Avblue1);}
            						
            						
            		
            					
            					
            					
                 		}
            	}
            }
        }
    	

    
        
    /**
     * Creates a completely white picture
     *
     */
    public void createWhitePicture(){
        this.imageMatrix = new RGBColor[this.width][this.height]; // Create an Object , but points at nothing. Svaes space
        for (int w=0; w< this.width; w++){
            for(int h=0; h< this.height; h++){
                //set this colors in picture
                this.imageMatrix[w][h] = new RGBColor(255, 255, 255);    // 255 = white . Without "new" it would be a mistake. because it will give values to null      
            }
        }
    }

    /**
    * DO NOT CHANGE ANYTHING BELOW THIS LINE!
    **/

    // Getters
    
    /**
     * 
     * @return the width of the picture
     */
    public int getWidth(){
        return this.width;
    }

    /**
     * 
     * @return the height of the picture
     */
    public int getHeight(){
        return this.height;
    }

    /**
     * 
     * @return the the picture matrix
     */
    public RGBColor[][] getImageMatrix(){
        return this.imageMatrix;
    }
    
    /**
     * reads an 24-bit(8,8,8) Bitmap and store it into picture-array
     * @param picUrl The url to the pic
     * @return true, if successful else false
     */
    private boolean openAndSetPicture(String picUrl){
         
         BufferedImage pic;
         
         
         try {
             InputStream iS= new FileInputStream(picUrl);
             // get buffer of the picture
             pic = ImageIO.read(iS);    
             
             // get additional picture informations
             this.height = pic.getHeight();
             this.width = pic.getWidth();            
             
             // store rgb colors in picture
             this.imageMatrix = new RGBColor[this.width][this.height];
             ColorModel cm= ColorModel.getRGBdefault();
             for (int w=0; w< this.width; w++){
                 for(int h=0; h< this.height; h++){
                     
                     // read out every RGBcolor
                     int pixel = pic.getRGB(w, h);
                     int rVal= cm.getRed(pixel);
                     int gVal= cm.getGreen(pixel);
                     int bVal= cm.getBlue(pixel);
                     
                     //set this colors in picture
                     this.imageMatrix[w][h] = new RGBColor(rVal, gVal, bVal);                
                 }
             }
             return true;
             
             
         }catch (IOException e) {
             e.printStackTrace();       
         }
         return false;
         
    }
    
    public BufferedImage getImage(){
        BufferedImage buf = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
        for(int w=0; w<this.width; w++){
            for(int h=0; h<this.height; h++){
                int red= this.imageMatrix[w][h].getRed();
                int blue= this.imageMatrix[w][h].getBlue();
                int green= this.imageMatrix[w][h].getGreen();
                int rgbVal= new Color(red, green, blue).getRGB();
                buf.setRGB(w, h, rgbVal);
            }
    }
    
        return buf;
    }


    
    
}

