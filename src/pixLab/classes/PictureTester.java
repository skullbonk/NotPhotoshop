package pixLab.classes;
import javax.swing.JFileChooser;
/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
import javax.swing.JOptionPane;

import java.awt.image.BufferedImage;

//import java.lang.invoke.MethodHandles;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;


import java.util.ArrayList;
public class PictureTester
{
	public static ArrayList<String> images = new ArrayList<String>();
	public static ArrayList<String> glitches = new ArrayList<String>();
	public static ArrayList<Picture> dennysPngs = new ArrayList<Picture>();
	
	public static MathClass mathClass = new MathClass();
	
	public static String glitch;
	
	public static boolean isDennys;
	
	public static Picture image; // Creates an image when run with imageSelector() as a parameter
	
	public static String imageSelector()
	{
		String request;
		

			request = JOptionPane.showInputDialog(null, "which image would you like to screw up?"
					+ " type collection to do the best ones."
					+ " just be aware that this will take a"
			 		+ " few minutes to load, because I'm "
					+ "great at programming. type help for a list");
			
			if(request == "help")
			{
				request = JOptionPane.showInputDialog(null, "options are: " + images.toString());
			}
			
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
		images.add("betsoaccused.jpg");
		images.add("betsoinvestigate.jpg");
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
		images.add("goy.png");
		images.add("jenny-red.jpg");
		images.add("KatieFancy.jpg");
		images.add("kitten2.jpg");
		images.add("koala.jpg");
		images.add("lob.png");
		images.add("moon-surface.jpg");
		images.add("msg.jpg");
		images.add("pozzo.jpg");
		images.add("redMotorcycle.jpg");
		images.add("robot.jpg");
		images.add("seagull.jpg");
		images.add("smolgoy.png");
		images.add("snowman.jpg");
		images.add("sock.png");
		images.add("swan.jpg");
		images.add("temple.jpg");
		images.add("thruDoor.jpg");
		images.add("vollog.jpg");
		images.add("wall.jpg");
		images.add("water.jpg");
		images.add("wendo.png");
		images.add("whiteFlower.jpg");	
		images.add("streetsaber.png");
		images.add("lobchunkd.png");
		images.add("sacknpillo.jpg");
		images.add("sacknpillo-chunkd.png");
		images.add("sacknpillo-chunkfirst.png");
		images.add("sacknpillo-fizzle.png");
		images.add("goyinclass.jpg");
		images.add("goyinclass-chunkd.png");
		images.add("sacknpillo-chunkd2.png");
		images.add("levys.png");
		images.add("levyschunkd.png");
		images.add("levyschunkd2.png");
		images.add("koda.png");
		images.add("kodachunkd.png");
		images.add("lasanya.png");
		images.add("randotextkid.jpg");
		images.add("lasanya_chunkd.png");
		images.add("youaregay.png");
		images.add("schnuppy.png");
		images.add("lablur.png");
		images.add("roy.jpg");
		images.add("labehair.jpg");
		images.add("anyablur.png");
		images.add("krez.jpg");
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
		glitches.add("only highest");
		glitches.add("destruc");
		glitches.add("sweep");
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
			if(imageSelector().equals("dennys"))
			{
				imageIsValid = true;
				isDennys = true;
			}
			else if(images.contains(imageToGlitch))
			{
				imageIsValid = true;
			}
			else
			{
				images.add(imageToGlitch);
				System.out.println("added image " + imageToGlitch + " to list 'images'");
			}
		}
		
		if(isDennys == true)
		{
			String indexToString;
			String indexFix = "0";
			for(int index = 0; index < 169; index ++)
			{
				if(index < 10)
				{
					indexFix = "00" + Integer.toString(index);
				}
				else if(index > 9 && index < 100)
				{
					indexFix = "0" + Integer.toString(index);
				}
				else
				{
					indexFix = Integer.toString(index);
				}
				indexToString = "dennys-snap" + indexFix + ".png";
				image = new Picture(indexToString);
				dennysPngs.add(image);
			}
			glitch = glitchSelector();
			
			runGlitch(glitch);
		}
		else
		{
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
//		save(image);
		}
	}
	
	
	
	public static void runGlitch(String glitch)
	{
		String method = glitch;
		
		if(isDennys == true)
		{
			String savePath = FileChooser.pickPath(new JFileChooser());
			if(method.contains(glitches.get(0)))
			{
				savePath += "/dennysglitch/";
				System.out.println("Running glitch " + method);
				for(int index = 0; index < 169; index ++)
				{
					image = dennysPngs.get(index);
					image.zeroBlue();
					image.write(savePath + " - " + index);
					System.out.println("completed image " + index);
				}
			}
			if(method.contains(glitches.get(1)))
			{
				savePath += "/dennysglitch/";
				System.out.println("Running glitch " + method);
				for(int index = 0; index < 169; index ++)
				{
					image = dennysPngs.get(index);
					image.mirrorVertical();
					image.write(savePath + " - " + index);
					System.out.println("completed image " + index);
				}
			}
			if(method.contains(glitches.get(2)))
			{
				savePath += "/dennysglitch/";
				System.out.println("Running glitch " + method);
				for(int index = 0; index < 169; index ++)
				{
					image = dennysPngs.get(index);
					image.mirrorTemple();
					image.write(savePath + " - " + index);
					System.out.println("completed image " + index);
				}
			}
			if(method.contains(glitches.get(3)))
			{
				savePath += "/dennysglitch/";
				System.out.println("Running glitch " + method);
				for(int index = 0; index < 169; index ++)
				{
					image = dennysPngs.get(index);
					image.mirrorGull();
					image.write(savePath + " - " + index);
					System.out.println("completed image " + index);
				}
			}
			if(method.contains(glitches.get(4)))
			{
				savePath += "/dennysglitch/";
				System.out.println("Running glitch " + method);
				for(int index = 0; index < 169; index ++)
				{
					image = dennysPngs.get(index);
					image.glitchGang();
					image.write(savePath + " - " + index);
					System.out.println("completed image " + index);
				}
			}
			if(method.contains(glitches.get(5)))
			{
				savePath += "/dennysglitch/";
				System.out.println("Running glitch " + method);
				for(int index = 0; index < 169; index ++)
				{
					image = dennysPngs.get(index);
					image.fizzle();
					image.write(savePath + " - " + index);
					System.out.println("completed image " + index);
				}
			}
			if(method.contains(glitches.get(6)))
			{
				savePath += "/dennysglitch/";
				System.out.println("Running glitch " + method);
				for(int index = 0; index < 169; index ++)
				{
					image = dennysPngs.get(index);
					image.fizzleRemastered();
					image.write(savePath + " - " + index);
					System.out.println("completed image " + index);
				}
			}
			if(method.contains(glitches.get(8)))
			{
				savePath += "/dennysglitch/";
				System.out.println("Running glitch " + method);
				for(int index = 0; index < 169; index ++)
				{
					image = dennysPngs.get(index);
					image.revealPicture();
					image.write(savePath + " - " + index);
					System.out.println("completed image " + index);
				}
			}
			if(method.contains("math class"))
			{
				savePath += "/dennysglitch/";
				System.out.println("Running glitch " + method);
				for(int index = 0; index < 169; index ++)
				{
					image = dennysPngs.get(index);
					image.mathClass();
					image.write(savePath + " - " + index);
					System.out.println("completed image " + index);
				}
			}
			if(method.contains("take chunks"))
			{
				savePath += "/dennysglitch/";
				System.out.println("Running glitch " + method);
				for(int index = 0; index < 169; index ++)
				{
					image = dennysPngs.get(index);
					image.takeChunks();
					image.write(savePath + " - " + index);
					System.out.println("completed image " + index);
				}
			}
			if(method.contains("only highest"))
			{
				savePath += "/dennysglitch/";
				System.out.println("Running glitch " + method);
				for(int index = 0; index < 169; index ++)
				{
					image = dennysPngs.get(index);
					image.onlyHighest();
					image.write(savePath + " - " + index);
					System.out.println("completed image " + index);
				}
			}
			if(method.contains("destruc"))
			{
				savePath += "/dennysglitch/";
				System.out.println("Running glitch " + method);
				for(int index = 0; index < 169; index ++)
				{
					image = dennysPngs.get(index);
					image.destruc();
					image.write(savePath + " - " + index);
					System.out.println("completed image " + index);
				}
			}
			if(method.contains("sweep"))
			{
				savePath += "/dennysglitch/";
				System.out.println("Running glitch " + method);
				for(int index = 0; index < 169; index ++)
				{
					image = dennysPngs.get(index);
					image.sweep();
					image.write(savePath + " - " + index);
					System.out.println("completed image " + index);
				}
			}
		}
		
		else
		{	
			if(method.equals(glitches.get(0)))
			{
				System.out.println("Running glitch " + method);
				image.zeroBlue();
			}
			
			
			if(method.equals(glitches.get(1)))
			{
				System.out.println("Running glitch " + method);
				image.mirrorVertical();
			}
			
			
			if(method.equals(glitches.get(2)))
			{
				System.out.println("Running glitch " + method);
				image.mirrorTemple();
			}
			
			
			if(method.equals(glitches.get(3)))
			{
				System.out.println("Running glitch " + method);
				image.mirrorGull();
			}
			
			
			if(method.equals(glitches.get(4)))
			{
				System.out.println("Running glitch " + method);
				image.glitchGang();
			}
			
			
			if(method.equals(glitches.get(5)))
			{
				System.out.println("Running glitch " + method);
				image.fizzle();
			}
			
			
			if(method.equals(glitches.get(6)))
			{
				System.out.println("Running glitch " + method);
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
				System.out.println("Running glitch " + method);
				image.revealPicture();
			}
			
			
			if(method.equals("math class"))
			{
				System.out.println("Running glitch " + method);
				image.mathClass();
			}
			
			if(method.equals("take chunks"))
			{
				System.out.println("Running glitch " + method);
				image.takeChunks();
			}
			
			if(method.equals("only highest"))
			{
				System.out.println("Running glitch " + method);
				image.onlyHighest();
			}
			
			if(method.equals("destruc"))
			{
				System.out.println("Running glitch " + method);
				image.destruc();
			}
			
			if(method.equals("sweep"))
			{
				System.out.println("Running glitch " + method);
				image.sweep();
			}
			
			System.out.println("complete");
		}
	}
	
	public static void save(Picture image)
	{
		String response = JOptionPane.showInputDialog(null, "Save image? y/n");
		if(response.equals("y"))
		{
			String path = JOptionPane.showInputDialog(null, "What do you want to call it?");
			image.write(path);
			System.out.println("saved");
			JOptionPane.showMessageDialog(null, "Success(?)");
		}
	}
	
	
	public static void testDennys()
	{
		Picture image;
		PictureFrame frame = new PictureFrame();
		String indexString = "dennys-snap";
		String savePath = FileChooser.pickPath(new JFileChooser());
		ArrayList<BufferedImage> bufferedDennysPngs = new ArrayList<BufferedImage>();
		
		savePath += "/dennysglitch";
		for(int index = 0; index < 169; index++)
		{
			indexString = "dennys-snap";
			if(index < 10)
			{
				indexString += "00" + index + ".png";
			}
			else
			if(index < 100)
			{
				indexString += "0" + index + ".png";
			}
			else
			{
				indexString += index + ".png";
			}
			image = new Picture(indexString);
			dennysPngs.add(image);
		}
		
		for(int index = 0; index < dennysPngs.size(); index ++)
		{
			image = dennysPngs.get(index);
			image.takeChunks();
			Picture glitchedImage = new Picture(image.getBufferedImage());
			glitchedImage.write(savePath + " - " + index);
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