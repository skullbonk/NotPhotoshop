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
	public static Picture image;
	public static BufferedImage buffer;
	public static String picPath;
	public static PickerFrame frame;
	public static PickerPanel panel;
	
	public PicturePicker()
	{
		frame = new PickerFrame(this);
		panel = new PickerPanel(this);
	}

	public static void pickImage()
	{
		setPath(FileChooser.pickPath(new JFileChooser()));
		image = new Picture(getPath());
		panel.updatePath(image.getFileName());
		image.setGlitched(false);
		image.explore();
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
		try
		{
			ImageIO.write(buffer, "png", new File("/Users/rfai3591/Desktop/NotPhotoshop_output" + image.getTitle() + ".png"));
		}
		catch(IOException ioerror)
		{
			System.out.println("Colossal error: ");
			System.out.println(ioerror);
		}
	}
	
	public static void main(String[] args)
	{
		pickImage();

	}

}
