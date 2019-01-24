package pixLab.classes;
/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
import javax.swing.JOptionPane;



//import java.lang.invoke.MethodHandles;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;


import java.util.ArrayList;
public class PictureTester
{
	public static ArrayList<String> images = new ArrayList<String>();
	
	public static void imageSelector()
	{
		String response;
		String check;
		createImageList();
		
		
		response = JOptionPane.showInputDialog(null, "which image would you like to screw up?"
				+ " type collection to do the best ones."
				+ " just be aware that this will take a"
				+ " few minutes to load, because I'm "
				+ "great at programming");
		
		if(response.equalsIgnoreCase("collection"))
		{
			Picture collectionEntry;
			String[] pictureNames = {"lob.PNG","vollog.jpg", "pozzo.jpg", "sock.PNG", "goy.PNG"};
			for(int index = 0; index < pictureNames.length; index++)
			{
				collectionEntry = new Picture(pictureNames[index]);
				collectionEntry.explore();
				collectionEntry.fizzleRemastered();
				collectionEntry.explore();
			}
		}
		else
		for(int listIndex = 0; listIndex < images.size() - 1; listIndex++)
		{
			check = images.get(listIndex);
			if(response.equalsIgnoreCase(check))
			{
				Picture nicePicture = new Picture(response);
				nicePicture.explore();
				glitchSelector(nicePicture);
				nicePicture.explore();	
			}
		}
	}
	
	public static void glitchSelector(Picture image)
	{
		String response;
		String hideResponse;
		Picture toHide;
		
		
		response = JOptionPane.showInputDialog(null, "which glitch would you like to apply?");
		
		if(response.equalsIgnoreCase("zero blue") || response.equalsIgnoreCase("zeroblue"))
		{
			image.zeroBlue();
		}
		else if(response.equalsIgnoreCase("mirrorvertical") || response.equalsIgnoreCase("mirror vertical"))
		{
			image.mirrorVertical();
		}
		else if(response.equalsIgnoreCase("mirror temple") || response.equalsIgnoreCase("mirrortemple"))
		{
			image.mirrorTemple();
		}
		else if(response.equalsIgnoreCase("mirror gull") || response.equalsIgnoreCase("mirrorgull"))
		{
			image.mirrorGull();
		}
		else if(response.equalsIgnoreCase("glitch gang") || response.equalsIgnoreCase("glitchgang"))
		{
			image.glitchGang();
		}
		else if(response.equalsIgnoreCase("fizzle"))
		{
			image.fizzle();
		}
		else if(response.equalsIgnoreCase("fizzle remastered") || response.equalsIgnoreCase("fizzleremastered"))
		{
			image.fizzleRemastered();
		}
		else if(response.equalsIgnoreCase("hide picture") || response.equalsIgnoreCase("hidepicture"))
		{
			hideResponse = JOptionPane.showInputDialog(null, "which image do you want to hide?");
			toHide = new Picture(hideResponse);
			image.hidePicture(toHide);
		}
		else if(response.equalsIgnoreCase("reveal picture") || response.equalsIgnoreCase("revealpicture"))
		{
			image.revealPicture();
		}	
	}
	
	
	public static void createImageList()
	{
		images.add("640x480.jpg");
		images.add("7inX95in.jpg");
		images.add("arch.jpg");
		images.add("barbaraS.jpg");
		images.add("betsoaccused.JPG");
		images.add("betsoinvestigate.JPG");
		images.add("blue-mark.jpg");
		images.add("blueMotorcycle.jpg");
		images.add("butterfly1.jpg");
		images.add("caterpillar.jpg");
		images.add("cliff'd.png");
		images.add("CumberlandIsland.jpg");
		images.add("femaleLionAndHall.jpg");
		images.add("flower1.jpg");
		images.add("flower2.jpg");
		images.add("gorge.jpg");
		images.add("goy.PNG");
		images.add("jenny-red.jpg");
		images.add("KatieFancy.jpg");
		images.add("kitten2.jpg");
		images.add("koala.jpg");
		images.add("lob.PNG");
		images.add("moon-surface.jpg");
		images.add("msg.jpg");
		images.add("pozzo.JPG");
		images.add("redMotorcycle.jpg");
		images.add("robot.jpg");
		images.add("seagull.jpg");
		images.add("smolgoy.png");
		images.add("snowman.jpg");
		images.add("sock.PNG");
		images.add("swan.jpg");
		images.add("temple.jpg");
		images.add("thruDoor.jpg");
		images.add("vollog.jpg");
		images.add("wall.jpg");
		images.add("water.jpg");
		images.add("wendo.PNG");
		images.add("whiteFlower.jpg");	
	}
	
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  public static void testMirrorGull()
  {
	  Picture gull = new Picture("seagull.jpg");
	  gull.explore();
	  gull.mirrorGull();
	  gull.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testGlitchGang()
  {
	  Picture temple = new Picture("temple.jpg");
	  temple.explore();
	  temple.glitchGang();
	  temple.explore();
  }
  
  public static void testFizzle()
  {
	  Picture kitten2 = new Picture("kitten2.jpg");
	  kitten2.explore();
	  kitten2.fizzle();
	  kitten2.explore();  
  }
  
  public static void testFizzleRemastered()
  {
	  Picture ratpic = new Picture("cliff'd.png");
	  ratpic.explore();
	  ratpic.fizzleRemastered();
	  ratpic.explore();  
  }
  
  public static void testSortAttempt1()
  {
	  Picture ratpic = new Picture("cliff'd.png");
	  ratpic.explore();
	  ratpic.fizzleRemastered();
	  ratpic.explore();
  }
  
  public static void testCollection()
  {
	  Picture collectionEntry;
	  String[] pictureNames = {"lob.PNG","vollog.jpg", "pozzo.jpg", "sock.PNG", "goy.PNG"};
	  for(int index = 0; index < pictureNames.length; index++)
	  {
		  collectionEntry = new Picture(pictureNames[index]);
		  collectionEntry.explore();
		  collectionEntry.fizzleRemastered();
		  collectionEntry.explore();
	  }
  }
  
  public static void testStagenography()
  {
	  
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
	//testFizzle();
	//testFizzleRemastered();
	//testSortAttempt1();
	//testCollection();
	  imageSelector();
  }
}