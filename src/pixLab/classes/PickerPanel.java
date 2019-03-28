package pixLab.classes;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PickerPanel extends JPanel
{
	private PicturePicker picker;
	
	private JButton loadButton;
	private JButton saveCustomButton;
	
	
	public String picPath;
	public String nameOfGlitch;
	private String showDisplayStatus;
	
	private JButton zeroGreenButton;
	private JButton mirrorVerticalButton;
	private JButton glitchGangButton;
	private JButton fizzleButton;
	private JButton fizzleRemasteredButton;
	private JButton hidePictureButton;
	private JButton revealPictureButton;
	private JButton mathClassButton;
	private JButton takeChunksButton;
	private JButton onlyHighestButton;
	private JButton destrucButton;
	private JButton sweepButton;
	private JButton clumberizeButton;
	private JButton boringSortButton;
	private JButton elongateButton;
	private JButton longoSortButton;
	
	private JLabel progressDisplay;
	
	private JButton openOriginalButton;
	private JLabel hideDisplay;
	
	
	public JLabel notPhotoshopLabel;
	private JLabel availableGlitchLabel; 
	
	private JButton saveButton;
	
	public Picture preGlitchedImage;
	public BufferedImage preGlitchedBuffer;
	
	
/**
 * 
 */
	public PickerPanel(PicturePicker picker)
	{
		super();
		
		this.picker = picker;
		
		this.loadButton = new JButton("load");		
		this.saveButton = new JButton("save");
		this.saveCustomButton = new JButton("save (custom title)");
		saveCustomButton.setSize(200, 30);
		saveCustomButton.setLocation(275, 115);
		this.zeroGreenButton = new JButton("zero green");
		this.mirrorVerticalButton = new JButton("mirror vertical");
		this.glitchGangButton = new JButton("glitch gang");
		this.fizzleButton = new JButton("fizzle");
		this.fizzleRemasteredButton = new JButton("fizzle remastered");
		this.hidePictureButton = new JButton("hide picture");
		this.revealPictureButton = new JButton("reveal picture");
		this.mathClassButton = new JButton("math class");
		this.takeChunksButton = new JButton("take chunks");
		this.onlyHighestButton = new JButton("only highest");
		this.destrucButton = new JButton("destruc");
		this.sweepButton = new JButton("sweep");
		this.clumberizeButton = new JButton("clumberize");
		this.boringSortButton = new JButton("sort");
		this.elongateButton = new JButton("elongate");
		this.longoSortButton = new JButton("longo sort");
		
		this.openOriginalButton = new JButton("original");
		
		this.notPhotoshopLabel = new JLabel("NotPhotoshop");
		
		this.availableGlitchLabel = new JLabel("available glitches: ");
		
		
		setupPanel();
		setupLayout();
		setupListeners();		
	}
	
/**
 * Adds all GUI elements to the panel
 */
	public void setupPanel()
	{
		this.setPreferredSize(new Dimension(750, 400));
		this.setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		this.add(loadButton);
		this.add(saveButton);
		this.add(saveCustomButton);
		
		this.add(notPhotoshopLabel);
		this.add(availableGlitchLabel);
		
		this.add(zeroGreenButton);
		this.add(mirrorVerticalButton);
		this.add(glitchGangButton);
		this.add(fizzleButton);
		this.add(fizzleRemasteredButton);
		this.add(hidePictureButton);
		this.add(revealPictureButton);
		this.add(takeChunksButton);
		this.add(onlyHighestButton);
		this.add(destrucButton);
		this.add(sweepButton);
		this.add(clumberizeButton);
		this.add(boringSortButton);
		this.add(elongateButton);
		this.add(longoSortButton);
		this.add(openOriginalButton);
	}
	
	
/**
* Sets all layout constraints for GUI elements
*/
	public void setupLayout()
	{
		// labels
			// pickPathLabel
		notPhotoshopLabel.setHorizontalAlignment(SwingConstants.CENTER);
		notPhotoshopLabel.setFont(new Font("Futura", Font.PLAIN, 65));
		notPhotoshopLabel.setForeground(Color.WHITE);
		notPhotoshopLabel.setBounds(0, 0, 750, 88);
		
			// availableGlitchesLabel
		availableGlitchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		availableGlitchLabel.setFont(new Font("Courier", Font.ITALIC, 20));
		availableGlitchLabel.setForeground(Color.WHITE);
		availableGlitchLabel.setSize(750, 20);
		availableGlitchLabel.setLocation(0, 160);
		
		// buttons
			// save/load
		saveButton.setBounds(425, 85, 75, 30);
		loadButton.setBounds(250, 85, 75, 30);
		
			// open original
		openOriginalButton.setLocation(325, 85);
		openOriginalButton.setSize(100, 30);
			
			// glitch buttons
		zeroGreenButton.setBounds(0, 240, 150, 30);
		mirrorVerticalButton.setBounds(150, 240, 150, 30);
		glitchGangButton.setBounds(300, 240, 150, 30);
		fizzleButton.setBounds(600, 240, 150, 30);
		fizzleRemasteredButton.setBounds(0, 280, 150, 30);
		hidePictureButton.setBounds(375, 200, 150, 30);
		revealPictureButton.setBounds(225, 200, 150, 30);
		takeChunksButton.setBounds(150, 280, 150, 30);
		onlyHighestButton.setBounds(450, 240, 150, 30);
		destrucButton.setBounds(450, 280, 150, 30);
		sweepButton.setBounds(300, 280, 150, 30);
		clumberizeButton.setSize(150, 30);
		clumberizeButton.setLocation(600, 280);
		boringSortButton.setSize(150, 30);
		boringSortButton.setLocation(150, 320);
		elongateButton.setSize(150, 30);
		elongateButton.setLocation(300, 320);
		longoSortButton.setSize(150, 30);
		longoSortButton.setLocation(450, 320);
	}
	
	public void setupListeners()
	{
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.pickImage();
				picPath = picker.image.getTitle();
			}
		});
	
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.saveImage();
			}
		});
		
		saveCustomButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.saveCustomName();
			}
		});
		
		
		openOriginalButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.openOriginal();
			}
		});
		
		
		zeroGreenButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.zeroGreen();
				nameOfGlitch = "zeroGreen";
				picker.image.explorer.setVisible(picker.image.getShowAfterCompletion());
				picker.image.repaintExplorer();
			}
		});
		
		
		mirrorVerticalButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.mirrorVertical();
				nameOfGlitch = "mirrorVertical";
				picker.image.explorer.setVisible(picker.image.getShowAfterCompletion());
				picker.image.repaintExplorer();
			}
		});
		
		
		glitchGangButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.glitchGang();
				nameOfGlitch = "glitchGang";
				picker.image.explorer.setVisible(picker.image.getShowAfterCompletion());
				picker.image.repaintExplorer();
			}
		});
		
		
		fizzleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.fizzle();
				nameOfGlitch = "glitchGang";
				picker.image.explorer.setVisible(picker.image.getShowAfterCompletion());
				picker.image.repaintExplorer();
			}
		});
		
		
		fizzleRemasteredButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.fizzleRemastered();
				nameOfGlitch = "fizzleRemastered";
				picker.image.explorer.setVisible(picker.image.getShowAfterCompletion());
				picker.image.repaintExplorer();
			}
		});
		
		
		hidePictureButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				String imageToHidePath = FileChooser.pickPath(new JFileChooser());
				Picture imageToHide = new Picture(imageToHidePath);
				picker.image.hidePicture(imageToHide);
				nameOfGlitch = "hidePicture";
				picker.image.explorer.setVisible(picker.image.getShowAfterCompletion());
				picker.image.repaintExplorer();
			}
		});
		
		
		revealPictureButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.revealPicture();
				nameOfGlitch = "revealPicture";
				picker.image.explorer.setVisible(picker.image.getShowAfterCompletion());
				picker.image.repaintExplorer();
			}
		});
		
		
		takeChunksButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.takeChunks();
				nameOfGlitch = "takeChunks";
				picker.image.explorer.setVisible(picker.image.getShowAfterCompletion());
				picker.image.repaintExplorer();
			}
		});
		
		
		onlyHighestButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.onlyHighest();
				nameOfGlitch = "onlyHighest";
				picker.image.explorer.setVisible(picker.image.getShowAfterCompletion());
				picker.image.repaintExplorer();
			}
		});
		
		
		destrucButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.destruc();
				nameOfGlitch = "destruc";
				picker.image.explorer.setVisible(picker.image.getShowAfterCompletion());
				picker.image.repaintExplorer();
			}
		});
		
		
		sweepButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.sweep();
				nameOfGlitch = "sweep";
				picker.image.explorer.setVisible(picker.image.getShowAfterCompletion());
				picker.image.repaintExplorer();
			}
		});
		
		
		clumberizeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.clumberize();
				nameOfGlitch = "clumberize";
				picker.image.explorer.setVisible(picker.image.getShowAfterCompletion());
				picker.image.repaintExplorer();
			}
		});
		
		
		boringSortButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.boringSort();
				nameOfGlitch = "sort";
				picker.image.explorer.setVisible(picker.image.getShowAfterCompletion());
				picker.image.repaintExplorer();
			}
		});
		
		
		elongateButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.elongate();
				nameOfGlitch = "elongate";
				picker.image.explorer.setVisible(picker.image.getShowAfterCompletion());
				picker.image.repaintExplorer();				
			}
		});
		
		
		longoSortButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.longoSort();
				nameOfGlitch = "longoSort";
				picker.image.explorer.setVisible(picker.image.getShowAfterCompletion());
				picker.image.repaintExplorer();
			}
		});
	}
}
