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
  
  public boolean showProgress = false; // This is meant to control a realtime view of the glitch, but it doesn't really work with my buttons
  public Random random = new Random(); // For generating random numbers
  public PictureExplorer explorer; // The picture explorer window
  public boolean showAfterCompletion = false; // Whether or not the glitched image pops up after glitch completion. Only used for one specific personal project. 
  
  /**
   * Attempts to stretch out bits of the image.
   * It kinda sucks, I plan to implement some 
   * sort of edge detection to improve it.
   */
  public void elongate()
  {
	  Pixel[][] grid = this.getPixels2D(); // Grid of pixels in the original image
	  Pixel[][] toast = grid; // Post-glitch grid
	  Pixel prev, here, next; // Pixels for the previous, current, and next locations on the grid
	  int maxRow = grid.length - 1, maxCol = grid[0].length - 1; // Used for preventing ArrayIndexOutOfBounds errors
	  int diffRed, diffGreen, diffBlue; // Difference between color values
	  int extendUntil; // The next pixel with sufficient differences
	  Pixel overlapped; // The hidden pixel below
	  int olDiffRed, olDiffGreen, olDiffBlue; // Differences between color values for the overlapped pixel
	  
	  // This entire section is just for preventing array index issues
	  for(int row = 0; row < maxRow; row ++)
	  {
		  for(int col = 0; col < maxCol; col ++)
		  {
			  if(!(row == 0))
			  {
				  if(!(col == 0))
				  {					  
					  prev = grid[row][(col - 1)];
				  }
				  else
				  {
					  prev = grid[(row - 1)][maxCol-1];
				  }
			  }
			  else
			  {
				  if(!(col == 0))
				  {
					  prev = grid[row][(col - 1)];
				  }
				  else
				  {
					  prev = grid[row][col];
				  }
			  }  
			  here = grid[row][col];
			  
			  if(!(row == maxRow - 1))
			  {
				  if(!(col == maxCol - 1))
				  {
					  next = grid[row][(col + 1)];
				  }
				  else
				  {
					  next = grid[(row + 1)][0];
				  }
			  }
			  else
			  {
				  if(!(col == maxCol - 1))
				  {
					  next = grid[row][(col + 1)];
				  }
				  else
				  {
					  next = grid[maxRow - 1][maxCol - 1];
				  }
			  }
			  
			  // This is where the actual glitch code begins. It compares pixels to eachother and determines whether or not and how far to extend pieces of the image.
			  diffRed = difference(red(here), red(next));
			  diffGreen = difference(green(here), green(next));
			  diffBlue = difference(blue(here), blue(next));
			  
			  if(diffRed > 20 + getR(10) || diffGreen > 20 + getR(10) || diffBlue > 20 + getR(10))
			  {
				  extendUntil = col + getR(getR(getR(maxCol / 12)));
				  while(extendUntil >= maxCol) {extendUntil --;}
				  
				  for(int index = col; index < (extendUntil) ; index ++)
				  {
					  overlapped = grid[row][index];
					  olDiffRed = difference(red(next), red(overlapped));
					  olDiffGreen = difference(green(next), green(overlapped));
					  olDiffBlue = difference(blue(next), blue(overlapped));
					  
					  if(olDiffRed > diffRed || olDiffGreen > diffGreen || olDiffBlue > diffBlue)
					  {
						  index = extendUntil - 1;
					  }
					  toast[row][index].setColor(here.getColor());
				  }
			  }
		  }
	  }
	  
	  // Basically a second iteration of the glitch, but in a different direction
	  for(int col = 0; col < maxCol; col ++)
	  {
		  for(int row = 0; row < maxRow; row ++)
		  {
			  here = grid[row][col];
			  
			  if(!(col == maxCol - 1))
			  {
				  if(!(row == maxRow - 1))
				  {
					  next = grid[(row + 1)][col];
				  }
				  else
				  {
					  next = grid[0][(col + 1)];
				  }
			  }
			  else
			  {
				  if(!(row == maxRow - 1))
				  {
					  next = grid[0][(col + 1)];
				  }
				  else
				  {
					  next = grid[maxRow - 1][maxCol - 1];
				  }
			  }
			  
			  diffRed = difference(red(here), red(next));
			  diffGreen = difference(green(here), green(next));
			  diffBlue = difference(blue(here), blue(next));
			  
			  if(diffRed > 20 + getR(16) || diffGreen > 20 + getR(16) || diffBlue > 20 + getR(16))
			  {
				  extendUntil = row + getR(getR(getR(maxRow / 12)));
				  while(extendUntil >= maxRow) {extendUntil --;}
				  
				  for(int index = row; index < (extendUntil) ; index ++)
				  {
					  overlapped = toast[index][col];
					  olDiffRed = difference(red(next), red(overlapped));
					  olDiffGreen = difference(green(next), green(overlapped));
					  olDiffBlue = difference(blue(next), blue(overlapped));
					  
					  if(olDiffRed > diffRed || olDiffGreen > diffGreen || olDiffBlue > diffBlue)
					  {
						  index = extendUntil - 1;
					  }
					  toast[index][col].setColor(here.getColor());
				  }
			  }
		  }
	  }
	  
	  // commit to grid
	  for(int row = 0; row < maxRow; row ++)
	  {
		  for(int col = 0; col < maxCol; col ++)
		  {
			  grid[row][col].setColor(toast[row][col].getColor());
		  }
	  }
  }
  
  /**
   * Returns the difference between two supplied color values, subtracting the lesser from the greater of the two
   * @param color1 A color
   * @param color2 Another color
   * @return The difference between the two colors
   */
  public int difference(int color1, int color2)
  {
	  if(color1 > color2)
	  {
		  return color1 - color2;
	  }
	  else if(color2 > color1)
	  {
		  return color2 - color1;
	  }
	  else
	  {
		  return 0;
	  }
  }
  
 /**
  * Attempts to combine elongate() and boringSort(). Doesn't really work as well as I'd hoped. Yet.
  */
  public void longoSort()
  {
	  Pixel[][] grid = this.getPixels2D();
	  Pixel[][] sampleGrid =  grid;
	  int maxRow = grid.length - 1; int maxCol = grid[0].length - 1;
	  boolean[][] sortedAtCoord = new boolean[maxRow + 1][maxCol + 1];
	  
	  int testRowIndex = 0;
	  int testColIndex = 0;
	  Pixel test;
	  Pixel next;
	  int edgeCol;
	  int currentTotal, nextTotal;
	  int maxPossibleColor = 256 + 256 + 256;
	  
	  int colorDifference;
	  
	  for(int testTotal = maxPossibleColor; testTotal > 0; testTotal --)
	  {
		  for(int row = 0; row < maxRow; row ++)
		  {
			  for(int col = 0; col < maxCol; col ++)
			  {
				  test = grid[row][col];
				  
				  if(!(row == maxRow - 1))
				  {
					  if(!(col == maxCol - 1))
					  {
						  next = grid[row][col + 1];
					  }
					  else
					  {
						  next = grid[row][maxCol];
					  }
				  }
				  else
				  {
					  next = grid[row][col];
				  }
				  
				  currentTotal = totalColor(test);
				  nextTotal = totalColor(next);
				  
				  colorDifference = currentTotal - nextTotal;
				  if(colorDifference > 24 && currentTotal == testTotal)
				  {
					  edgeCol = next.getCol();
					  testColIndex = edgeCol;
					  while(sortedAtCoord[row][testColIndex] && testColIndex < maxCol)
					  {
						  testColIndex ++;
					  }
					  sampleGrid[row][testColIndex].setColor(test.getColor());
					  sortedAtCoord[row][testColIndex] = true;
				  }
				  
			  }
		  }
	  }
  }
  
  
  public int avgColorDifference(Pixel source, Pixel next)
  {
	  int avgSourceTotal = (red(source) + green(source) + blue(source)) / 3;
	  int avgNextTotal = (red(next) + green(next) + blue(next)) / 3;
	  return difference(avgSourceTotal, avgNextTotal);
  }
  
  
  public void boringSort()
  {
	  Pixel[][] grid = this.getPixels2D();
	  Pixel[][] sampleGrid =  grid;
	  int maxRow = grid.length - 1; int maxCol = grid[0].length - 1;
	  boolean[][] sortedAtCoord = new boolean[maxRow + 1][maxCol + 1];
	  
	  int testColIndex = 0;
	  Pixel test;
	  int maxPossibleColor = 256 + 256 + 256;
	  
	  // analyze pixels, build sorted grid
	  for(int testTotal = (maxPossibleColor); testTotal > 0; testTotal --)
	  {
		  for(int row = 0; row < maxRow; row ++)
		  {
			  for(int col = 0; col < maxCol; col ++)
			  {
				  test = grid[row][col];
				  
				  if(totalColor(test) == testTotal)
				  {
					  testColIndex = 0;
					  while(sortedAtCoord[row][testColIndex] && testColIndex < maxCol)
					  {
						  testColIndex ++;
					  }
					  sampleGrid[row][testColIndex].setColor(test.getColor());
					  sortedAtCoord[row][testColIndex] = true;
				  }
			  }
		  }
	  }
	  
	  // replace displayed grid with sorted grid
	  for(int row = 0; row < maxRow - 1; row ++)
	  {
		  for(int col = 0; col < maxCol - 1; col ++)
		  {
			  grid[row][col].setColor(sampleGrid[row][col].getColor());
		  }
	  }
  }
  
  
  /**
   * Gets the sum of all the pixel's color values
   * @param source The pixel whose colors are to be summed
   * @return The total color value of the pixel
   */
  public int totalColor(Pixel source)
  {
	  return (red(source) + green(source) + blue(source));
  }
  
  
  /**
   * Gets the average of the colors of the source pixel
   * @param source Pixel to get the average color value of
   * @return The average of all color values of the pixel
   */
  public int getAverage(Pixel source)
  {
	  int average = (red(source) + green(source) + blue(source)) / 3;
	  return average;
  }
  
 
  /**
   * amplifies colors to the point where everything ends up just kind of grayscale-y purple. not super interesting.
   */
  public void clumberize()
  {
	  Pixel[][] grid = this.getPixels2D();
	  Pixel[][] modGrid = this.getPixels2D();
	  Pixel source;
	  Pixel result;
	  
	  int maxRow = grid.length;
	  int maxCol = grid[0].length;
	  
	  int midRow = maxRow / 2;
	  int midCol = maxCol / 2;
	  
	  int initialRow;
	  int finalRow;
	  int initialCol;
	  int finalCol;
	  
	  // begin tests
	  
	  for(int iterations = 0; iterations < 100; iterations ++)
	  {
		  initialRow = getR(maxRow);
		  initialCol = getR(maxCol);
		  
		  finalRow = (maxRow - getR(maxRow));
		  if(finalRow <= initialRow) {finalRow += initialRow;} // prevents glitch from doing nothing
		  while(finalRow > maxRow) {finalRow --;} // prevents indexOutOfBounds exception
		  
		  for(int row = initialRow; row < finalRow; row ++)
		  {
			  finalCol = (maxCol - getR(maxCol));
			  for(int col = initialCol; col < finalCol; col ++)
			  { 
				  source = grid[row][col];
				  result = modGrid[row][col];
				  if(red(source) <= green(source) && red(source) <= blue(source)) // red is smallest
				  {
					  result.setRed((int) (red(source) * 1.19)); result.setGreen((int) (green(source) * 0.98)); result.setBlue((int) (blue(source) * 0.98));
				  }
				  else if(green(source) <= blue(source) && green(source) <= red(source)) // green is smallest
				  {
					  result.setRed((int) (red(source) * 0.98)); result.setGreen((int) (green(source) * 1.19)); result.setBlue((int) (blue(source) * 0.98)); 	
				  }
				  else if(blue(source) <= red(source) && blue(source) <= green(source)) // blue is smallest
				  {
					  result.setBlue((int) (red(source) * 0.98)); result.setGreen((int) (green(source) * 0.98)); result.setBlue((int) (blue(source) * 1.19));
				  }
				  modGrid[row][col] = result;
			  }
		  }
		 
		  for(int commitRow = 0; commitRow < maxRow; commitRow ++)
		  {
			  if(getShowProgress())
			  {
				  if(commitRow % 2 == 0)
				  {
					  this.repaintExplorer();
				  }
			  }
			  
			  for(int commitCol = 0; commitCol < maxCol; commitCol ++)
			  {
				  grid[commitRow][commitCol].setColor(modGrid[commitRow][commitCol].getColor());
			  }
		  }  
	  }  
  }
  
 
  // return color value for specified pixel
  public int red(Pixel source)
  {
	  return source.getRed();
  }
  public int green(Pixel source)
  {
	  return source.getGreen();
  }
  public int blue(Pixel source)
  {
	  return source.getBlue();
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
  
  
  public void zeroGreen()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixelObj : rowArray)
		  {
			  pixelObj.setGreen(0);
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
				  newPixel.setColor(oldPixel.getColor());
			  }
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
	  
	  
	  Pixel test;
	  Pixel flip;
	  
	  Pixel original;
	  Pixel update;
	  
	  int maxRow = grid.length;
	  int maxCol = grid[0].length;
	  
	  int startRow = 0;
	  int startCol = 0; 
	  
	  int average;
	  
	  int pixelsFricked = 0;
	  
	  
	  int rotations;

	  for(int iterations = 0; iterations < 8; iterations++)
	  {
		 
		  for(int row = 0; row < maxRow; row ++)
		  {
			  for(int col = 0; col < maxCol; col ++)
			  {
				  test = grid[row][col];
				  flip = test;
				  
				  int[] mods = {test.getRed(), test.getGreen(), test.getBlue(), test.getRow(), test.getCol(), (int) test.getAverage(), flip.getRed(), flip.getGreen(), flip.getBlue(), flip.getRow(), flip.getCol(), row, col, maxRow, maxCol};
				 
				  if(test.getRed() > 190 && test.getGreen() > getR(196))
				  {
					  average = (int) test.getAverage();
					  flip.setRed(test.getRed() - (test.getGreen() / notZero(rMod(mods))));
					  flip.setGreen(test.getGreen() - (test.getRed() / notZero(rMod(mods))));
					  test.setBlue((int)average * getR(average) / notZero(average));
				  }
				  
				  if(test.getGreen() > getR(256))
				  {
					  flip.setGreen(flip.getGreen() % notZero(getR(rMod(mods))) * getR(4));
				  }
				  
				  if(test.getRed() > getR(256) && test.getBlue() > 150)
				  {
					  flip.setRed(flip.getRed() * flip.getBlue());
					  flip.setGreen(maxRow - rMod(mods) / notZero(getR(rMod(mods))));
					  flip.setBlue(grid[getR(maxRow)][getR(maxCol)].getRed());
				  }
				  			  
				  if(flip.getRed() < 60)
				  {
					  flip.setRed((flip.getRed() / (notZero(col))));
				  }
				  
				  if(row % 5 == 0 && col % 5 == 0)
				  {
					  flip.setGreen(flip.getGreen() + test.getGreen());
				  }
				  
				  if(test.getRed() < 30 && test.getGreen() < 30 && test.getBlue() < 30)
				  {
					  flip.setBlue(flip.getBlue() * rMod(mods) / notZero(rMod(mods)));
				  }   
				  
				  
				  
				  if(flip.getGreen() < 30)
				  {
					  flip.setGreen((flip.getGreen() + flip.getBlue()) / 3);
				  }
				  
				  frickedGrid[row][col].setColor(flip.getColor());
				  
				  
				  
				  rotations = 0;
				  
				  while(rotations < 3)
				  {
					  
					  original = grid[row][col];
					  update = frickedGrid[row][col];
					  
					  if(original.getRed() < update.getRed() && original.getBlue() < (256 - getR(255)))
					  {
						  update.setGreen(update.getGreen() - (int) ((double) rotations * 1.22));
					  }
					  frickedGrid[row][col].setColor(update.getColor());

					  rotations += 1;
				  }
				  
				  
			
			  }
			  if(showProgress)
			  {				  
				  if(row % 2 == 0)
				  {
					  this.repaintExplorer();
				  }
			  }
		  }
		  
		  startRow = getR(maxRow);
		  startCol = getR(maxCol);
		  
		  // little chips
		  for(int row = startRow; row < startRow + getR((maxRow - startRow) / 4); row ++)
		  {
				  for(int col = startCol; col < startCol + getR((maxCol - startCol) / 4); col ++)
				  {
					  pixelsFricked = 0;
					  while(pixelsFricked < 32)
					  {
						  old = grid[row][col];
						  
						  shiny = old;		
						  
						  int[] mods = {old.getRed(), old.getGreen(), old.getBlue(), old.getRow(), old.getCol(), (int) old.getAverage(), shiny.getRed(), shiny.getGreen(), shiny.getBlue(), shiny.getRow(), shiny.getCol()};

						  if(old.getAverage() > grid[startRow][startCol].getAverage())
						  {
							  average = (int) old.getAverage();
							 
							  shiny.setRed(rMod(mods));
							  shiny.setGreen(old.getGreen() / notZero(getR(rMod(mods))));
							  shiny.setBlue(old.getBlue() * 2);
							  frickedGrid[row][col].setColor(shiny.getColor());
							  pixelsFricked ++;
						  }
						  else pixelsFricked ++;
						  frickedGrid[row][col].setColor(shiny.getColor());
					  }
				  }
		  }
		  
		
		  
		  for(int row = getR(maxRow - 1), col = getR(maxCol - 1); row < maxRow && col < maxCol; row ++, col ++)
		  {
			  
			  frickedGrid[row][col].setGreen(frickedGrid[maxRow - row][maxCol - col].getGreen() + iterations * 3);
			  frickedGrid[row][col].setBlue(frickedGrid[row][col].getBlue() - getR(256 - iterations));
			  
			  if(showProgress)
			  {				  
				  if(row % 2 == 0)
				  {
					  this.repaintExplorer();
				  }
			  }
		  }
		  
		  for(int gRow = getR(maxRow); gRow < maxRow - getR(maxRow - gRow) / 2; gRow ++)
		  {
			  for(int gCol = getR(maxCol); gCol < maxCol - getR(maxCol - gCol); gCol ++)
			  {
				  
				  
				  pixelsFricked = 0;
				  while(pixelsFricked < 32)
				  {
					  old = grid[gRow][gCol];
					  
					  shiny = old;		
					 

					  if(old.getAverage() > grid[startRow][startCol].getAverage())
					  {
						  average = (int) old.getAverage();
						 
						  shiny.setBlue(old.getBlue() * 2);
						  frickedGrid[gRow][gCol].setColor(shiny.getColor());
						  pixelsFricked ++;
					  }
					  else pixelsFricked ++;
					  frickedGrid[gRow][gCol].setColor(shiny.getColor());
				  }
			  }
			  
			  if(showProgress)
			  {				  
				  if(gRow % 2 == 0)
				  {
					  this.repaintExplorer();
				  }
			  }
		  }

		  
		  
//		 COMMIT TO GRID AND DISPLAY
			  
		  for(int row = 0; row < maxRow; row++)
		  {
			  for(int col = 0; col < maxCol; col++)
			  {
				  grid[row][col].setColor(frickedGrid[row][col].getColor());  
			  }
		  }
		  System.out.println(iterations);
	  }
  }
  
  public void takeChunks()
  {
	  Pixel[][] grid = this.getPixels2D();
	  Picture temp = new Picture(this);
	  Pixel[][] freshGrid = temp.getPixels2D();	
	  Pixel[][] subGrid = freshGrid;
	  
	  
	  Pixel source;
	  Pixel result;
	  
	  Pixel previous;
	  Pixel postSource;
	  Pixel postResult;
	  
	  
	  int maxRow = grid.length;
	  int maxCol = grid[0].length;
	  
	  int colLength;
	  
	  int clumpRow;
	  int clumpCol;
	  
	  if(showProgress)
	  {		  
		  this.show();
	  }
	  
	  for(int iterations = 0; iterations < 2; iterations ++)
	  {
		  for(int row = 0; row < maxRow; row += getR(12))
		  {	
			  for(int col = 0; col < maxCol; col += getR(12))
			  {
				  
				  for(int rowMod = row; rowMod < (row + getR(48) + 5) && rowMod < maxRow; rowMod++)
				  {
					  colLength = col + getR(64) + 5;
					  while(colLength + col > maxCol)
					  {
						  colLength -= getR(10);
					  }
					  for(int colMod = col; colMod < col + colLength; colMod++)
					  {
						  source = grid[row][col];
						  result = subGrid[row][col];
						  
						  result.setColor(source.getColor()); 
						  
//					  // BEGIN MESSING OF UP //
						  
						  if((source.getBlue() + source.getRed() + source.getGreen()) / 2 > (row))
						  {
							  result.setRed(256 - source.getRed());  
							  result.setGreen(256 - source.getGreen());
							  result.setBlue(256 - source.getBlue());
						  }
						  
						  if(col % 3 == 0)
						  {
							 result.setRed((result.getRed() + source.getRed()) / 2);
						  }
						  
						  if(source.getBlue() > 50  && source.getBlue() < 80)
						  {
							  result.setGreen(result.getBlue());
						  }
						  
						  if(source.getRed() < source.getBlue())
						  {
							  if(col % 4 == 0)
							  {
								  result.setRed(source.getRed() - (source.getBlue() / 3));
							  }
							  else
							  {
								  result.setRed(source.getRed() + (source.getBlue() / 3));
							  }
						  }
						  subGrid[rowMod][colMod].setColor(result.getColor());	    
					  }
				  }  
			  }
		  }
		  
		  for(int row = getR(maxRow); row < (maxRow - getR((int) ((double)(maxRow * .7)))); row ++)
		  {
			  for(int col = getR(maxCol); col < (maxCol - getR((int) ((double)(maxCol * .7)))); col ++)
			  {
				  source = subGrid[row][col];
				  result = source;
				  
				  result.setRed((int) ((double) source.getBlue() * 1.2));
				  result.setGreen((int) ((double) source.getRed() * 1.2));
				  result.setBlue((int) ((double) source.getGreen() * 1.2));
				  
				  freshGrid[row][col].setColor(result.getColor());
			  }
		  }
		  
//		  for(int row = 0; row < maxRow; row ++)
//		  {
//			  for(int col = 0; col < maxCol; col ++)
//			  {
//				  
//			  }
//		  }
		  
//	  // APPLY MESSING OF UP //
		  
		  for(int row = 0; row < maxRow; row++)
		  {
			  for(int col = 0; col < maxCol; col++)
			  {  
				  grid[row][col].setColor(freshGrid[row][col].getColor());
			  }
			  if(showProgress)
			  {				  
				  if(row % 2 == 0)
				  {
					  this.repaintExplorer();
				  }
			  }
		  }
//		  System.out.println("take chunks iterated " + iterations + " times");
	  }
  	}
  
  public void sweep()
  {
	  Pixel[][] grid = this.getPixels2D();
	  Pixel[][] swept = this.getPixels2D();
	  
	  Pixel test;
	  Pixel replace;
	  
	  int start;
	  int end;
	  int maxRow = grid.length;
	  int maxCol = grid[0].length;
	  
	  
	  for(int iterations = 0; iterations < 128; iterations ++)
	  {
//		  CYCLES THROUGH RIGHT TO LEFT
		  start = getR(getR(maxRow));
		  end = notZero(start - getR(maxRow - start));
		  for(int row = start; row > end; row --)
		  {
			  start = getR(getR(maxCol));
			  end = notZero(start - getR(maxCol - start));
			  for(int col = start; col > end; col --)
			  {
				  test = grid[row][col];
				  replace = test;
				  
				  for(int toastRow = row; toastRow < maxRow && toastRow < (maxRow - getR(getR(maxRow / 2))); toastRow += notZero(getR(4)))
				  {
					  for(int toastCol = col; toastCol < maxCol && toastCol < maxCol / notZero(getR((row + col + toastRow + toastCol) / 2)); toastCol ++)
					  {
						  test = grid[toastRow][toastCol];
						  replace = test;
						  
						  if(test.getRed() > 90 && test.getRed() < 120)
						  {
							  replace.setRed(test.getRed() - test.getGreen() + test.getBlue());
						  }
						  if(test.getGreen() < 30)
						  {
							  replace.setGreen(test.getGreen() / notZero(getR(test.getBlue()) - getR(test.getRed())));
						  }
						  if(test.getBlue() < getR(getR(256)))
						  {
							  replace.setBlue((int) ((double)(replace.getGreen() + replace.getRed() / 2) * 1.2)); 
						  }
						  
						  swept[toastRow][toastCol].setColor(replace.getColor());
					  }
				  }				 
				  if(swept[row][col].getBlue() > getR(100) || test.getBlue() < notZero(getR(7) * getR(7) * getR(7) / 4))
				  {
					  swept[maxRow - row][maxCol - col].setGreen((int) (grid[row][col].getGreen() * getRDouble()));
					  swept[maxRow - getR(row)][maxCol - getR(col)].setRed((int) (test.getRed() * (getRDouble() + getRDouble())));
				  }				  				  
				  grid[row][col].setColor(swept[row][col].getColor());
			  }
			  
			  if(showProgress)
			  {				  
				  if(row % 3 == 0)
				  {
					  this.repaintExplorer();
				  }
			  }
		  }
		  
		  
		  int colLimit;
		  int difference;
		  for(int row = start; row < getR(getR(maxRow)); row ++)
		  {
			  colLimit = getR(getR(maxCol));
			  for(int col = getR(getR(maxCol - 1)); col < colLimit; col ++)
			  {
				  test = grid[row][col];
				  replace = swept[getR(row)][getR(col)];
				  
				  difference = replace.getRed() - test.getRed();
				  if(difference > 30)
				  {
					  replace.setRed(test.getRed() / replace.getRed() + difference / 2);
				  }
				  
				  difference = replace.getBlue() - test.getBlue();
				  if(difference < 30)
				  {
					  replace.setBlue((int) (test.getRed() * getRDouble()));
				  }  
				  
				  swept[row][col].setColor(replace.getColor());
			  }
			  
			  if(showProgress)
			  {				  
				  if(row % 3 == 0)
				  {
					  this.repaintExplorer();
				  }
			  }
		  }
		  
	  }  
  }
  
  public void onlyHighest()
  {
	  Pixel[][] grid = this.getPixels2D();
	  Picture temp = new Picture(this);
	  Pixel[][] splitGrid = temp.getPixels2D();
	  
	  int maxRow = grid.length;
	  int maxCol = grid[0].length;
	  
	  Pixel test;
	  Pixel replace;
	  
//	   CYCLE THROUGH PIXELS
	  int red;
	  int green;
	  int blue;
	  
	  if(showProgress)
	  {		  
		  this.show();
	  }
	  
	  for(int row = 0; row < maxRow; row ++)
	  {
		  for(int col = 0; col < maxCol; col ++)
		  {
			  test = grid[row][col];
			  replace = test;
			  
			  red = test.getRed();
			  green = test.getGreen();
			  blue = test.getBlue();
			  
			  
			  
			  if(red > green && red > blue)
			  {
				  replace.setGreen(green / 8);
				  replace.setBlue(blue / 8);
				  replace.setRed(red);
			  }
			  else if(green > red && green > blue)
			  {
				  replace.setRed(red / 8);
				  replace.setBlue(blue / 8);
				  replace.setGreen(green);
			  }
			  else if(blue > green && blue > red)
			  {
				  replace.setRed(red / 8);
				  replace.setGreen(green / 8);
				  replace.setBlue(blue);
			  }
			  else
			  {
				  replace.setRed(256 - red);
				  replace.setGreen(256 - green);
				  replace.setBlue(256 - blue);
			  }
			  
			  
//			  else
//			  {
//				  replace.setRed((red + green + blue) / 3);
//				  replace.setGreen((red + green + blue) / 3);
//				  replace.setBlue((red + green + blue) / 3);
//			  }
			  
			  splitGrid[row][col].setColor(replace.getColor());
		  }
		  if(showProgress)
		  {			  
			  if(row % 2 == 0)
			  {
				  this.repaintExplorer();
			  }
		  }
	  }
	  
	  for(int row = 0; row < maxRow; row ++)
	  {
		  for(int col = 0; col < maxCol; col ++)
		  {
			  grid[row][col].setColor(splitGrid[row][col].getColor());
		  }
	  }
	  
	  
  }
  
  public void destruc()
  {
	  Pixel[][] grid = this.getPixels2D();
	  int maxRow = grid.length;
	  int maxCol = grid[0].length;
	  
//	  ArrayList<String> colors = new ArrayList<String>();
	  
	  Pixel source;
	  Pixel squash;
	  
	  int startRow;
	  int endRow;
	  int startCol;
	  int endCol;
	  
	  int keepColor;
	  int incDec;
	  
	  int iterations = 0;
	  while(iterations < 32)
	  {
		  startRow = getR(maxRow - (maxRow / 12));
		  startCol = getR(maxCol - (maxCol / 12));
		  endRow = startRow + getR(maxRow - startRow);
		  endCol = startCol + getR(maxCol - startCol);
		  
		  for(int row = startRow; row < endRow; row ++)
		  {
			  for(int col = startCol; col < endCol; col ++)
			  {
				  source = grid[row][col];
				  squash = source;
				  
				  
				  
//				  0 = R  |  1 = G  |  2 = B
				  keepColor = getR(3);
				  
// RED
				  
				  if(keepColor == 0) // keep source RED
				  {
					  incDec = getR(2);
					  if(incDec == 0) // increase GREEN & BLUE by half of RED
					  {		
						  squash.setGreen(source.getGreen() + (source.getRed() / 2));
						  squash.setBlue(source.getBlue() + (source.getRed() / 2));
					  }
					  if(incDec == 1) // decrease GREEN & BLUE by half of RED
					  {
						  squash.setGreen(source.getGreen() - (source.getRed() / 2));
						  squash.setBlue(source.getBlue() - (source.getRed() / 2)); 
					  }
					  squash.setRed(source.getRed());
				  }
				  
// GREEN
				  
				  if(keepColor == 1) // keep source GREEN
				  {
					 incDec = getR(2); 
					 if(incDec == 0) // increase RED & BLUE by half of GREEN
					 {
						 squash.setRed(source.getRed() + (source.getGreen() / 2));
						 squash.setBlue(source.getBlue() + (source.getGreen() / 2));
					 }
					 if(incDec == 1) // decrease RED & BLUE by half of GREEN
					 {
						 squash.setRed(source.getRed() - (source.getGreen() / 2));
						 squash.setBlue(source.getBlue() - (source.getGreen() / 2));
					 }
					 squash.setGreen(source.getGreen());
				  }
				 
// BLUE			  
				  
				  if(keepColor == 2) // keep source BLUE
				  {
					  incDec = getR(2);
					  if(incDec == 0) // increase RED & GREEN by half of BLUE
					  {
						  squash.setRed(source.getRed() + (source.getBlue() / 2));
						  squash.setGreen(source.getGreen() + (source.getBlue() / 2));
					  }
					  if(incDec == 1) // decrease  RED & GREEN by half of BLUE
					  {
						  squash.setRed(source.getRed() - (source.getBlue() / 2));
						  squash.setGreen(source.getGreen() - (source.getBlue() / 2));
					  }
					  squash.setBlue(source.getBlue());
				  }  
				  
				  grid[row][col] = squash;
			  }
			  if(showProgress)
			  {				  
				  if(row % 2 == 0)
				  {
					  this.repaintExplorer();
				  }
			  }
		  }
		  iterations ++;
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
  
//  math class
  public void tryMathClass()
  {
	  MathClass mathClass = new MathClass(this);
	  mathClass.greenUnder30Glitch(this);
  }
  
//  public void mc_gU30()
//  {
//	  Pixel[][] grid = this.getPixels2D();
//	  Pixel[][] newGrid = this.getPixels2D();
//	  Pixel sample;
//	  Pixel replace;
//	  
//	  int maxRow = grid.length;
//	  int maxCol = grid[0].length;
//	  
//	  int repeats = 0;
//	  
//	  while(repeats < 30)
//	  {
//		  for(int row = 0; row < maxRow; row++)
//		  {
//			  for(int col = 0; col < maxCol; col++)
//			  {
//				  sample = grid[row][col];
//				  
//				  if(sample.getGreen() < 30)
//				  {
//					  for(int gU30 = 0; gU30 < maxCol; gU30 = (int) ((Math.sqrt((double) row) / (col + row + getHypotenuse(row, col)))))
//					  {
//						  replace = sample;
//						  replace.setRed(sample.getGreen());
//						  replace.setBlue(gU30);
//						  replace.setGreen((int) sample.getGreen() + (col / 255));
//						  
//						  newGrid[row][col] = replace;
//					  }  
//				  }
//			  }
//		  }
//	  }
//  }
  
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
  
  public void setShowProgress(boolean tf)
  {
	  showProgress = tf;
  }
  
  
  public Pixel safeGrid(Pixel[][] grid, int row, int col)
  {
	  Pixel[][] safeGrid = grid;
	  while(row > safeGrid.length)
	  {
		  row --;
	  }
	  while(row > 0)
	  {
		  row ++;
	  }
	  
	  while(col > safeGrid[0].length)
	  {
		  col --;
	  }
	  while(col < 0)
	  {
		  col ++;
	  }
	  
	  return safeGrid[row][col];
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
  
  public boolean getShowProgress()
  {
	  return showProgress;
  }
  
  public String getShowProgressString()
  {
	  return String.valueOf(showProgress);
  }
  
  
  public void setShowAfterCompletion(boolean flag)
  {
	  showAfterCompletion = flag;
  }
  
  
  public boolean getShowAfterCompletion()
  {
	  return showAfterCompletion;
  }
  
  /**
   * 
   * @return Whether or not to show the 
   */
  public String getShowAfterCompletionString()
  {
	  return String.valueOf(showAfterCompletion);
  }
  
  /**
   * Returns a random double value
   * @return Random double
   */
  public double getRDouble()
  {
	  double rDouble = 0.0;
	  Random random = new Random();
	  
	  rDouble = random.nextDouble();
	  return rDouble;
  }
  
  /**
   * Cuts an integer in half for lazy people like me
   * @param input The value to halve
   * @return Half of the supplied integer
   */
  public int makeHalf(int input)
  {
	  int half = input / 2;
	  return half;
  }
  
  /**
   * Ensures the supplied integer is greater than 0, for safe division
   * @param input Integer to check
   * @returns An integer greater than 0
   */
  public int notZero(int input)
  {
	  int toUnZero = input;
	  while(toUnZero < 1)
	  {
		  toUnZero ++;
	  }
	  return toUnZero;
  }
  
  
  public double notZeroDouble(double input)
  {
	  double toUnZero = input;
	  while(toUnZero < 0)
	  {
		  toUnZero += (double) (getR(9) / 10);
	  }
	  return toUnZero;
  }
  
  
  public int rMod(int[] arrayOfMods)
  {
	  return arrayOfMods[getR(arrayOfMods.length)];
	  
  }
  
  
  public void containsFace(Pixel[][] sourceGrid)
  {
	  int maxRow = sourceGrid.length - 1;
	  int maxCol = sourceGrid[0].length - 1;
	  Pixel[][] face = new Pixel[sourceGrid.length][sourceGrid[0].length];
	  Pixel source;
	  
	  /**
	   * faceEdges index: 0 - top of face, 1 - bottom of face, 2 - left side of face, 3 - right side of face
	   */
	  int[] faceEdges = new int[4]; // 0 = top peak, 1 = bottom peak, 2 = left peak, 3 = right peak
	  
	  for(int row = 0; row < maxRow; row ++)
	  {
		  for(int col = 0; col < maxCol; col ++)
		  {
			  source = sourceGrid[row][col];
//			  if()
		  }
	  }
	  Pixel[][] dummyGrid = sourceGrid;
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
