package pixLab.classes;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
//import java.lang.invoke.MethodHandles;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Handles all GUI operations.
 * @author rfai3591
 */
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
	
	/**
	 * Determines operating system and initializes frame and panel.
	 */
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
	 * then opens the image in a new Explorer window.
	 */
	public static void pickImage()
	{
		setPath(FileChooser.pickPath(new JFileChooser()));
		image = new Picture(picPath);
		image.explorer = new PictureExplorer(image);
	}
	
	/**
	 * Displays the original image.
	 */
	public static void openOriginal()
	{
		image.show();
	}
	
	/**
	 * Sets the picPath variable for the path of the image.
	 * @param path The path to be used.
	 */
	public static void setPath(String path)
	{
		picPath = path;
	}
	
	/**
	 * @return The path of the image.
	 */
	public static String getPath()
	{
		return picPath;
	}
	
	/**
	 * Requests the current Picture.
	 * @return The image that's currently in use.
	 */
	public static Picture getImage()
	{
		return image;
	}
	
// Method for mass saving files in specific directories. Now irrelevant.
	/*
	public static void saveImage()
	{
		buffer = image.getBufferedImage();
		String saveTitle = image.getTitle();
		
		String saveFolder = null;			
		if(onWindows)
		{
			saveFolder = "H:\\notphotoshop-output";
			saveTitle = saveTitle.substring(saveTitle.lastIndexOf("\\"), saveTitle.lastIndexOf("."));
			saveTitle += "-" + panel.nameOfGlitch + ".png";
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
	*/
	
	/**
	 * Saves the image in a user supplied directory with a user supplied name.
	 */
	public static void saveCustomName()
	{
		boolean saved = false;
		buffer = image.getBufferedImage();
		String saveFolder = FileChooser.pickADirectory();
		String originalTitle = image.getTitle();
		if(!onWindows)
		{			
			originalTitle = originalTitle.substring(originalTitle.lastIndexOf("/"));
		}
		else
		{
			originalTitle = originalTitle.substring(originalTitle.lastIndexOf("\\"));			
		}
		String saveTitle = JOptionPane.showInputDialog(null, "Enter a name for the new file", "Original: " + saveFolder + originalTitle, JOptionPane.INFORMATION_MESSAGE);
		try
		{
			if(saveTitle == null || saveFolder == null)
			{
				throw new IOException("Invalid path/title");
			}
			else
			{
				if(saveTitle.contains("."))
				{
					saveTitle = saveTitle.substring(0, saveTitle.indexOf("."));
				}
				if(!onWindows)
				{
					ImageIO.write(buffer, "png", new File(saveFolder + "/" + saveTitle + ".png"));
				}
				else
				{
					ImageIO.write(buffer, "png", new File(saveFolder + "\\" + saveTitle + ".png"));
				}
				saved = true;
			}
		}
		catch(IOException ioerror)
		{
			System.out.println("Colossal error: ");
			System.out.println(ioerror);
			JOptionPane.showMessageDialog(null, "An error occurred while saving " + saveTitle + ": " + ioerror);
		}
		finally
		{
			if(saved)
			{
				if(onWindows)
				{
					JOptionPane.showMessageDialog(null, "Image successfully saved to " + saveFolder + "\\" + saveTitle + ".png");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Image successfully saved to " + saveFolder + "/" + saveTitle + ".png");
				}
			}
		}	
	}
	
	/**
	 * @return The user's operating system
	 */
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
