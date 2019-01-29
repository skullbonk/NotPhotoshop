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
	public static ArrayList<String> glitches = new ArrayList<String>();
	
	public static MathClass mathClass = new MathClass();
	
	public static String glitch;
	
	public static Picture image; // Creates an image when run with imageSelector() as a parameter
	
	public static String imageSelector()
	{
		String request;
		

			request = JOptionPane.showInputDialog(null, "which image would you like to screw up?"
					+ " type collection to do the best ones."
					+ " just be aware that this will take a"
					+ " few minutes to load, because I'm "
					+ "great at programming");
			
		return request;
	}
	
	public static String glitchSelector()
	{
		String response;
		
		
		response = JOptionPane.showInputDialog(null, "which glitch would you like to apply? type help if you need a list.");
		
		
		
		return response;
		
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
		images.add("streetsaber.png");
	}
	
	public static void createGlitchList()
	{
		glitches.add("zero blue");
		glitches.add("mirror vertical");
		glitches.add("mirror temple");
		glitches.add("mirror gull");
		glitches.add("glitch gang");
		glitches.add("fizzle");
		glitches.add("fizzle remastered");
		glitches.add("hide picture");
		glitches.add("reveal picture");
		glitches.add("math class");
		glitches.add("take chunks");
	}
	
	public static void setupGlitch()
	{
		boolean imageIsValid = false;
		String imageToGlitch = "NO";
		String glitchToRun = "NO";
		createImageList();
		createGlitchList();
		
		
		while(!imageIsValid)
		{
			imageToGlitch = imageSelector();
			if(images.contains(imageToGlitch))
			{
				imageIsValid = true;
			}
		}
		
		image = new Picture(imageToGlitch);
		
		image.explore();
		
		glitch = glitchSelector();
		
		for(int glitchIndex = 0; glitchIndex < glitches.size(); glitchIndex++)
		{
			if(glitches.get(glitchIndex).equals(glitch))
			{
				glitchToRun = glitch;
				System.out.println("glitch successfully selected");
			}
		}
		
		System.out.println(glitchToRun);
		runGlitch(glitch);
		System.out.println("glitch " + glitchToRun);
		image.explore();
	}
	
	public static void runGlitch(String glitch)
	{
		String method = glitch;
		
		if(method.equals(glitches.get(0)))
		{
			image.zeroBlue();
		}
		

		if(method.equals(glitches.get(1)))
		{
			image.mirrorVertical();
		}
		

		if(method.equals(glitches.get(2)))
		{
			image.mirrorTemple();
		}
		

		if(method.equals(glitches.get(3)))
		{
			image.mirrorGull();
		}
		

		if(method.equals(glitches.get(4)))
		{
			image.glitchGang();
		}
		

		if(method.equals(glitches.get(5)))
		{
			image.fizzle();
		}
		

		if(method.equals(glitches.get(6)))
		{
			image.fizzleRemastered();
		}
		

/*
		if(method.equals(glitches.get(7)))
		{
			image.hidePicture();
		}
*/		
		
		if(method.equals(glitches.get(8)))
		{
			image.revealPicture();
		}
		

		if(method.equals("math class"))
		{
			image.mathClass();
		}
		
		if(method.equals("take chunks"))
		{
			image.takeChunks();
		}
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
	  setupGlitch();
  }
}