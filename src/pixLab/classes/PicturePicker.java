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
	public static String picPath;
	
	
//	public PicturePicker()
//	{
//		glitches = new ArrayList<String>();
//	}

	public static void pickImage()
	{
		picPath = FileChooser.pickPath(new JFileChooser());
		image = new Picture(picPath);
	}
	
	public static void pickGlitch()
	{
		String selectedGlitch = JOptionPane.showInputDialog(null, "Which glitch you wanna do?");
	}
	
	private static void buildGlitchList()
	{
		
	}
	
	public String getPath()
	{
		
		return picPath;
	}
	
	public static void main(String[] args)
	{
		pickImage();

	}

}
