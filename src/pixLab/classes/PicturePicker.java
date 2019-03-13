package pixLab.classes;
import javax.imageio.ImageIO;
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
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

//import java.lang.invoke.MethodHandles;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;


import java.util.ArrayList;

public class PicturePicker
{
	private static ArrayList<String> glitches = new ArrayList<String>();
	private static String glitch;
	public static boolean onWindows = false; // change to true if on home pc
	public static Picture image;
	public static BufferedImage buffer;
	public static String picPath;
	public static PickerFrame frame;
	public static PickerPanel panel;
	public static String operatingSystem;
	
	public PicturePicker()
	{
		if(fetchOS().contains("windows"))
		{
			onWindows = true;
		}
		else
		{
			onWindows = false;
		}
		System.out.println(fetchOS());
		frame = new PickerFrame(this);
		panel = new PickerPanel(this);
	}

	/**
	 * Opens a file explorer window for selecting an image,
	 * then opens the image in a new Explorer window
	 */
	public static void pickImage()
	{
		setPath(FileChooser.pickPath(new JFileChooser()));
		image = new Picture(picPath);
		image.explorer = new PictureExplorer(image);
	}
	
	public static void openOriginal()
	{
		image.show();
	}
	
	public static void setPath(String path)
	{
		picPath = path;
	}
	
	public static String getPath()
	{
		return picPath;
	}
	
	public static Picture getImage()
	{
		return image;
	}
	
	
	public static void saveImage()
	{
		buffer = image.getBufferedImage();
		String saveTitle = image.getTitle();
		
		String saveFolder = null;			
		if(onWindows)
		{
			saveFolder = "H:\\notphotoshop-output";
			saveTitle = saveTitle.substring(saveTitle.lastIndexOf("\\"));
		}
		else
		{
			saveFolder = "/Users/rfai3591/Desktop/NotPhotoshop_output";
			saveTitle = saveTitle.substring(saveTitle.lastIndexOf("/"), saveTitle.lastIndexOf("."));
			saveTitle += "-" + panel.nameOfGlitch + ".png";
		}
		
		try
		{
			ImageIO.write(buffer, "png", new File(saveFolder + saveTitle));
		}
		catch(IOException ioerror)
		{
			System.out.println("Colossal error: ");
			System.out.println(ioerror);
		}
		JOptionPane.showMessageDialog(null, "Image successfully saved to " + saveFolder + saveTitle);
	}
	
	public static void saveCustomName()
	{
		buffer = image.getBufferedImage();
		String saveFolder = "/Users/rfai3591/Desktop/NotPhotoshop_output/";
		String originalTitle = image.getTitle();
		originalTitle = originalTitle.substring(originalTitle.lastIndexOf("/"));
		String saveTitle = JOptionPane.showInputDialog(null, "File name: ", "Original image: " + originalTitle);
		try
		{
			ImageIO.write(buffer, "png", new File(saveFolder + saveTitle));
		}
		catch(IOException ioerror)
		{
			System.out.println("Colossal error: ");
			System.out.println(ioerror);
		}
		JOptionPane.showMessageDialog(null, "Image successfully saved to " + saveFolder+ saveTitle);	
	}
	
	public static String fetchOS()
	{
		operatingSystem  = System.getProperty("os.name").toLowerCase();
		return operatingSystem;
	}
	
	public static void main(String[] args)
	{
		pickImage();
	}

}
