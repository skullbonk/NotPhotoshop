package pixLab.classes;
import pixLab.classes.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
import java.util.Random;
import javax.swing.*;;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void zeroRed()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (int row = 0; row < pixels.length; row++)
	  {
		  for (int col = 0; col < pixels[0].length; col++)
		  {
			  pixels[row][col].setRed(0);
			  
			  Pixel tempPixel = pixels[row][col];
			  tempPixel.setRed(0); 
		  }  
	  }
  }
  
  
  
  public void zeroGreen()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (int row = 0; row < pixels.length; row++)
	  {
		  for (int col = 0; col < pixels[0].length; col++)
		  {
			  pixels[row][col].setGreen(0);
			  
			  Pixel tempPixel = pixels[row][col];
			  tempPixel.setGreen(0);  
		  }
	  }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  
  /*
  public void mirrorVerticallyTheOtherWay()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  int width = pixels[0].length;
	  for (int row = 0; row < pixels.length; row++)
	  {
		  for (int col = 0; col < width / 2; col++) 
		  {
			  leftPixel = pixels[row][col];
			  rightPixel = pixels[row][width - 1 - col];
			  rightPixel.setColor(leftPixel.getColor());
		  }
	  }  
  }
  */
  
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  
  public void mirrorGull()
  {
	  Random random = new Random();
	  int mirrorPoint = 300;
	  Pixel oldPixel = null;
	  Pixel newPixel = null;
	  int count = 0;
	  Pixel[][] pixels = this.getPixels2D();
	  for (count = 0; count < random.nextInt(30); count++)
	  {

			  for (int col = 230; col < 353; col++)
			  {
				  oldPixel = pixels[count][col];
			  
				  newPixel = pixels[count][col + 180];
			  
//				  newPixel = pixels[row][rando.nextInt(pixels[0].length)];
			  
				  newPixel.setColor(oldPixel.getColor());
			  }

	  }
  }
  
  
  
  public void chopItUp()
  {
	  Random random = new Random();
	  SimplePicture image = new SimplePicture();
	  Pixel originalPixel = null;
	  Pixel freshPixel = null;
	  Pixel[][] replaceBox = this.getPixels2D();
	  int reps = 0;
	  int rRow = 0;
	  int rCol = 0;
	  for (reps = 0; reps < random.nextInt(7); reps++)
	  {
		  
	  }
	  
	  
  }
  
  public void glitchGang()
  {
//	  SimplePicture picture = new SimplePicture();
	  Pixel[][] pixelRef = this.getPixels2D();
	  Random random = new Random();
	  Pixel startPixel = null;
	  Pixel endPixel = null;
//	  boolean rowIsEven = false;
//	  boolean colIsEven = false;
	  for (int go = 0; go < random.nextInt(3000); go++)
	  {
		  int randomRow = random.nextInt(pixelRef.length - 16);
		  int randomCol = random.nextInt(pixelRef[0].length -16);
		  
		  
		  for (int row = randomRow; row < randomRow + random.nextInt((pixelRef.length - randomRow) - 2); row++)
		  {
			  for(int col = randomCol; col < randomCol + random.nextInt((pixelRef[0].length - randomCol) - 2); col++)
			  {
				  startPixel = pixelRef[row][col];
				  
				  
				  int endRowMax = (pixelRef.length - row - 1);
				  int endColMax = (pixelRef[0].length - col - 1);
				  
				  startPixel.setColor(pixelRef[row][col].getColor());
				
				  endPixel = pixelRef[row + random.nextInt(endRowMax)][col + random.nextInt(endColMax)];
				  
				  endPixel.setColor(startPixel.getColor());
				  
				  
				  
				  if(endPixel.getRed() > 127)
				  {
					  endPixel.setRed(startPixel.getRed() - random.nextInt(startPixel.getRed()));
				  }
				  if(endPixel.getRed() < 128)
				  {
					  endPixel.setRed(startPixel.getRed() + random.nextInt(256 - startPixel.getRed()));
				  }
				  
				
				  if(endPixel.getGreen() > 127)
				  {
					  endPixel.setGreen(startPixel.getGreen() - random.nextInt(startPixel.getGreen()));
				  }
				  if(endPixel.getGreen() < 128)
				  {
					  endPixel.setGreen(startPixel.getGreen() + random.nextInt(256 - startPixel.getGreen()));
				  }
				  
				 
				  if(endPixel.getBlue() > 127)
				  {
					  endPixel.setBlue(startPixel.getBlue() - random.nextInt(startPixel.getBlue()));
				  }
				  if(endPixel.getBlue() < 128)
				  {
					  endPixel.setBlue(startPixel.getBlue() + random.nextInt(256 - startPixel.getBlue()));
				  }				  			 
			  }
		  }	  
	  }
  }
  
  public void fizzle()
  {
	  Pixel[][] pixelRef = this.getPixels2D();
	  Picture sub = new Picture(this);
	  Pixel[][] dupe = sub.getPixels2D();
	  Pixel original = null;
	  Pixel replace = null;
	  
	  int maxRow = pixelRef.length;
	  int maxCol = pixelRef[0].length;
	 
	 
	  
	  for(int reps = 0; reps < 30; reps++)
	  {  
		  int startRow = getR(maxRow - (maxRow / 4));
		  int startCol = getR(maxCol - (maxCol / 4));
		  
		  int endRow = startRow + getR((maxRow - startRow) / 2);
		  int endCol = startCol + getR((maxCol - startCol) / 2);
		  
		  for(int row = startRow; row < endRow; row++)
		  {
			  for(int col = startCol; col < endCol; col++)
			  {
				  int newRow = ((endRow - startRow) / row); 
				  int newCol = ((endCol - startCol) / col);
				
				  original = pixelRef[newRow][newCol];
				  replace = original;
				  dupe[row][col].setColor(replace.getColor());
				 
						  
				  
			
			  }  
		  }
		  
		  for(int row = 0; row < pixelRef.length; row++)
		  {
			  for(int col = 0; col < pixelRef[0].length; col++)
			  {				 
				  pixelRef[row][col].setColor(dupe[row][col].getColor());
			  }
		  }
		  
	  }
  }
  
  
  
  public void shiftLeftRight(int amount)
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Picture temp = new Picture(this);
	  Pixel[][] copied = temp.getPixels2D();
	  
	  int shiftedValue = amount;
	  int width = pixels[0].length;
	  
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = 0; col < pixels[0].length; row++)
		  {
			  shiftedValue = (col + amount) % width;
			  copied[row][col].setColor(pixels[row][shiftedValue].getColor());
		  }
	  }
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = 0; col < pixels.length; row++)
			  pixels[row][col].setColor(copied[row][col].getColor());
	  }
  }
  
  /*
  public void mirrorHorizontal()
  {
	 Pixel totalHPixels[][] = this.getPixels2D();
	 int mirrorPoint = (totalHPixels[0].length / 2);
	 int count = 0;
	 
	
  }
  */

  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  
  

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  public int getR(int max)
  {
	  Random random = new Random();
	  int rInt = random.nextInt(max);
	  return rInt;
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture gull = new Picture("seagull.jpg");
    gull.explore();
    gull.zeroGreen();
    gull.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
