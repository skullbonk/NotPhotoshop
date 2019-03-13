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
	
	private JToggleButton showProgressToggle;
	private JLabel progressDisplay;
	
	private JButton openOriginalButton;
	private JLabel hideDisplay;
	
	
	public JLabel notPhotoshopLabel;
	private JLabel availableGlitchLabel; 
	
	private JButton saveButton;
	
	public Picture preGlitchedImage;
	public BufferedImage preGlitchedBuffer;
	
	public PickerPanel(PicturePicker picker)
	{
		super();
		
		this.picker = picker;
		
		this.loadButton = new JButton("load");		
		this.saveButton = new JButton("save");
		this.saveCustomButton = new JButton("save (custom title)");
		saveCustomButton.setSize(150, 30);
		saveCustomButton.setLocation(300, 115);
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
		longoSortButton.setSize(150, 30);
		longoSortButton.setLocation(450, 320);


		
		this.showProgressToggle = new JToggleButton("Watch glitch in real-time?");
		showProgressToggle.setEnabled(false);
		this.progressDisplay = new JLabel("false");
		progressDisplay.setEnabled(false);
		progressDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.openOriginalButton = new JButton("Open original");
		openOriginalButton.setLocation(525, 100);
		openOriginalButton.setSize(225, 30);
		this.hideDisplay = new JLabel("false");
		hideDisplay.setEnabled(false);
		hideDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		hideDisplay.setLocation(525, 130);
		hideDisplay.setFont(new Font("Courier", Font.PLAIN, 20));
		hideDisplay.setForeground(Color.WHITE);
		hideDisplay.setSize(225, 20);
		
		this.notPhotoshopLabel = new JLabel("NotPhotoshop");
		
		this.availableGlitchLabel = new JLabel("available glitches: ");
		
		
		setupPanel();
		setupLayout();
		setupListeners();		
	}
	

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
		
		this.add(showProgressToggle);
		this.add(progressDisplay);
		
		this.add(openOriginalButton);
		this.add(hideDisplay);
		

		

	}
	
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
		saveButton.setBounds(375, 85, 75, 30);
		loadButton.setBounds(300, 85, 75, 30);
			
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
		
			// progress toggle
		showProgressToggle.setBounds(0, 100, 225, 30);
		
			// progress label
		progressDisplay.setFont(new Font("Courier", Font.PLAIN, 20));
		progressDisplay.setForeground(Color.WHITE);
		progressDisplay.setBounds(5, 130, 225, 20);
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
		
		
		showProgressToggle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				if(showProgressToggle.isSelected())
				{
					picker.image.setShowProgress(true);
					progressDisplay.setText(picker.image.getShowProgressString());
				}
				else
				{
					picker.image.setShowProgress(false);
					progressDisplay.setText(picker.image.getShowProgressString());
				}
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
//				picker.explorerInstance.repaint();
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
//				picker.explorerInstance.repaint();
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
//				picker.explorerInstance.repaint();
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
//				picker.explorerInstance.repaint();
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
//				picker.explorerInstance.repaint();
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
//				picker.explorerInstance.repaint();
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
//				picker.explorerInstance.repaint();
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
//				picker.explorerInstance.repaint();
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
//				picker.explorerInstance.repaint();
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
//				picker.explorerInstance.repaint();
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
//				picker.explorerInstance.repaint();
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
//				picker.explorerInstance.repaint();
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
