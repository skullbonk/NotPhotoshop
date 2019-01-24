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
	  
	  int startRow;
	  int startCol;
	  int endRow;
	  int endCol;
	  
	  int newRow;
	  int newCol;
	 
	 
	  
	  for(int reps = 0; reps < 30; reps++)
	  {  
		  startRow = getR(maxRow - 2);
		  startCol = getR(maxCol - 2);
		  
		  endRow = startRow + getR((maxRow - startRow) / 2);
		  endCol = startCol + getR((maxCol - startCol) / 2);
		  
		  for(int row = startRow; row < endRow; row++)
		  {
			  for(int col = startCol; col < endCol; col++)
			  {
				  newRow = (startRow + endRow / maxRow); 
				  newCol = (startCol + endCol / maxCol);
				
				  original = pixelRef[newRow][newCol];
				  original.setColor(pixelRef[newRow][newCol].getColor());
				  replace = original;
				  replace.setColor(original.getColor());
				  replace.setBlue(pixelRef[getR(newRow)][getR(newCol)].getBlue() - getR(original.getRed()) );
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
  
  
  
  public void fizzleRemastered()
  {
	  Pixel[][] grid = this.getPixels2D();
	  Picture soap = new Picture(this);
	  Pixel[][] frickedGrid = soap.getPixels2D();
	  Pixel old;
	  Pixel shiny;
	  
	  Pixel revOld;
	  Pixel revShiny;
	  
	  Pixel test;
	  Pixel flip;
	  
	  int maxRow = grid.length;
	  int maxCol = grid[0].length;
	  
	  int startRow = 0;
	  int startCol = 0; 
	  
	  int revEndRow = 0;
	  int revEndCol = 0;
	  
	  int average;
	  
	  int pixelsFricked = 0;
	  
	  
	  int rMod;
	  
	  
	  for(int iterations = 0; iterations < 150; iterations++)
	  {
		  startRow = getR(maxRow);
		  startCol = getR(maxCol);
		  
		  
		  /*
		   * Passes all pixels, changes if they meet requirements
		   */
		  for(int row = 0; row < maxRow; row ++)
		  {
			  for(int col = 0; col < maxCol; col ++)
			  {
				  test = grid[row][col];
				  flip = test;
				  
				  int[] mods = {test.getRed(), test.getGreen(), test.getBlue(), test.getRow(), test.getCol(), (int) test.getAverage(), flip.getRed(), flip.getGreen(), flip.getBlue(), flip.getRow(), flip.getCol(), row, col, maxRow, maxCol};
				  
				  int modMax = mods.length;
				  rMod = mods[getR(modMax)];
				 
				  
				  
				
				  
				  
				  if(test.getRed() > 190 && test.getGreen() > getR(196))
				  {
					  average = (int) test.getAverage();
					  flip.setRed(test.getRed() - (test.getGreen() / notZero(mods[getR(modMax)])));
					  flip.setGreen(test.getGreen() - (test.getRed() / notZero(rMod)));
					  test.setBlue((int)average * getR(average) / notZero(average));
				  }
				  
				  if(test.getGreen() > getR(256))
				  {
					  flip.setGreen(flip.getGreen() - rMod % notZero(getR(rMod)) * getR(4));
				  }
				  
				  if(test.getRed() > getR(256) && test.getBlue() > 150)
				  {
					  flip.setRed(flip.getRed() * flip.getBlue());
					  flip.setGreen(maxRow * rMod / notZero(getR(rMod)));
					  flip.setBlue(grid[getR(maxRow)][getR(maxCol)].getRed());
				  }
				  
				  
				  
				  if(flip.getRed() < 60)
				  {
					  flip.setRed((flip.getRed() / (notZero(col))));
				  }
				  
				  
				  if(test.getRed() < 30 && test.getGreen() < 30 && test.getBlue() < 30)
				  {
					//  flip.setGreen(test.getGreen() * (rMod + test.getBlue()) / (notZero(row) * notZero(col) * notZero(getR(notZero(rMod)))));
					  flip.setBlue(flip.getBlue() * rMod / notZero(rMod));
				  }
				  
//				  flip.setRed(256 - flip.getRed());
//				  flip.setGreen(256 - flip.getGreen());
//				  flip.setBlue(256 - flip.getBlue());
				
				  
			  }
		  }
		  
		  
		  for(int row = startRow; row < startRow + getR((maxRow - startRow)); row ++)
		  {
				  for(int col = startCol; col < startCol + getR((maxCol - startCol)); col ++)
				  {
					  pixelsFricked = 0;
					  
					  
					  
					  while(pixelsFricked < 256)
					  {
						  old = grid[row][col];
						  
						  shiny = old;		
						  
						  int[] mods = {old.getRed(), old.getGreen(), old.getBlue(), old.getRow(), old.getCol(), (int) old.getAverage(), shiny.getRed(), shiny.getGreen(), shiny.getBlue(), shiny.getRow(), shiny.getCol()};
						  int modMax = mods.length;
						  rMod = mods[getR(modMax)];

						  if(old.getAverage() > grid[startRow][startCol].getAverage())
						  {
							  average = (int) old.getAverage();
							 
							  shiny.setRed(rMod);
							  shiny.setGreen(old.getGreen() * getR(rMod));
							  shiny.setBlue(old.getBlue() * 2);
						  }
						  
						  
						  
						  
						  
						  
						  frickedGrid[row][col].setColor(shiny.getColor());
						  
						  pixelsFricked ++;  
					  }	  
				  } 
		  }
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  int maxRowReduced = maxRow - 1;
		  int maxColReduced = maxCol - 1;
		  
		  revEndRow = getR(maxRowReduced);
		  revEndCol = getR(maxColReduced);
		  
		  for(int row = maxRowReduced, col = getR(maxColReduced); row > revEndRow && col > revEndCol; row--, col--)
		  {
			  
			  revOld = grid[row][col];
			  revShiny = revOld;
			  
			  if(revOld.getCol() > startCol)
			  {
				  revShiny.setGreen(revOld.getGreen() / 3);
				  revShiny.setBlue(getR(256));
			  }
			  
			  frickedGrid[row][col].setColor(revShiny.getColor());
		  }
			  
			  
		  for(int row = 0, col = 0; row < maxRow && col < maxCol; row++, col++)
		  {
			  grid[row][col].setColor(frickedGrid[row][col].getColor());  
		  }
	  }
  }
  
  public void hidePicture(Picture hidden)
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel[][] hiddenPixels = hidden.getPixels2D();
	  
	  for(int row = 0; row < pixels.length && row < hiddenPixels.length; row++)
	  {
		  for(int col = 0; col < pixels[0].length && col < hiddenPixels[0].length; col++)
		  {
			  if(hiddenPixels[row][col].colorDistance(Color.WHITE) > 5)
			  {
				  if(pixels[row][col].getRed() > 0 && pixels[row][col].getRed() % 2 != 1)
				  {
					  pixels[row][col].setRed(pixels[row][col].getRed() - 1);
				  }
			  }
			  else if(pixels[row][col].getRed() > 0 && pixels[row][col].getRed() % 2 == 1)
			  {
				  pixels[row][col].setRed(pixels[row][col].getRed() - 1);
			  }
		  }
	  }
  }
  
  public void revealPicture()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  
	  for(int row = 0; row < pixels.length; row++)
	  {
		for(int col = 0; col < pixels[0].length; col++)
		{
			if(pixels[row][col].getRed() % 2 != 1)
			{
				pixels[row][col].setColor(Color.darkGray);
			}
			else if(pixels[row][col].getRed() % 2 == 1)
			{
				pixels[row][col].setColor(Color.lightGray);
			}
		}
	  }
  }
  
  public void mathClass()
  {
	  MathClass math = new MathClass(this);
  }
  
  
  public void sortAttempt1()
  {
	  Pixel[][] grid = this.getPixels2D();
	  Picture temp = new Picture(this);
	  Pixel[][] newGrid = temp.getPixels2D();
	  
	  Pixel previousPixel;
	  Pixel nextPixel;
	  
	  int maxRow = grid.length;
	  int maxCol = grid[0].length;
	  
	  double difference;
	  
	  for(int row = 0, col = 0; row < maxRow && col < maxCol; row++, col++)
	  {
		  previousPixel = grid[row][col];
		  nextPixel = grid[row + 1][col + 1];
		  
		  difference = nextPixel.colorDistance(previousPixel.getColor());
		  
		  if(difference < 3)
		  {
			  
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
	  while(max < 1)
	  {
		  max ++;
	  }
	  int rInt = random.nextInt(max);
	  
	  while(rInt < 1)
	  {
		  rInt ++;
	  }
	  return rInt;
  }
  
  public boolean willFrick()
  {
	  int rInt = 0;
	  rInt = getR(1);
	  
	  if(rInt == 1)
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
  }
  
  
  public int makeHalf(int input)
  {
	  int half = input / 2;
	  return half;
  }
  
  public int notZero(int input)
  {
	  int toUnZero = input;
	  while(toUnZero < 1)
	  {
		  toUnZero ++;
	  }
	  return toUnZero;
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
