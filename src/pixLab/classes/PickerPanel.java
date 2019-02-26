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
	
	public String picPath;
	
	private JButton zeroBlueButton;
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
	
	private JToggleButton showProgressToggle;
	private JLabel progressDisplay;
	
	
	
	public JLabel picPathLabel;
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
		this.zeroBlueButton = new JButton("zero blue");
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
		
		this.showProgressToggle = new JToggleButton("Watch glitch in real-time?");
		this.progressDisplay = new JLabel("false");
		
		this.picPathLabel = new JLabel("image path: " + picPath);
		
		this.availableGlitchLabel = new JLabel("available glitches: ");
		
		
		setupPanel();
		setupLayout();
		setupListeners();		
	}
	
//	public void setButtonTips()
//	{
////		zeroBlueButton.setToolTipText("deletes blue");
////		mirrorVerticalButton.setToolTipText("mirrors vertically");
////		glitchGangButton.setToolTipText("i forgot what this does but i bet it's boring and broken");
////		fizzleButton.setToolTipText("the original glitch - simultaneously boring and interesting");
////		fizzleRemasteredButton.setToolTipText("fizzle's big brother that was actually born later somehow, but we'll ignore that");
////		hidePictureButton.setToolTipText("hide a picture in another picture, probably doesn't work");
////		revealPictureButton.setToolTipText("reveals a hidden picture, probably doesn't work");
////		takeChunksButton.setToolTipText("turns everything into fuzzy squares and does some whacky purple red shiz");
////		onlyHighestButton.setToolTipText("deletes every color but the highest one. boring but could be useful");
////		destrucButton.setToolTipText("I forgot what this does but it's probably underwhelming");
////		sweepButton.setToolTipText("crisps it up and also makes phantoms in the corner");
//		
////		saveButton.setToolTipText("Saves your freshly busted image");
//	}

	public void setupPanel()
	{
		this.setPreferredSize(new Dimension(750, 400));
		this.setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		this.add(loadButton);
		this.add(saveButton);
		
		this.add(picPathLabel);
		this.add(availableGlitchLabel);
		
		this.add(zeroBlueButton);
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
		
		this.add(showProgressToggle);
		this.add(progressDisplay);
		

		

	}
	
	public void setupLayout()
	{
		// labels
			// pickPathLabel
		picPathLabel.setHorizontalAlignment(SwingConstants.CENTER);
		picPathLabel.setFont(new Font("Courier", Font.PLAIN, 30));
		picPathLabel.setForeground(Color.WHITE);
		picPathLabel.setBounds(0, 0, 750, 100);
		
			// availableGlitchesLabel
		availableGlitchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		availableGlitchLabel.setFont(new Font("Courier", Font.ITALIC, 20));
		availableGlitchLabel.setForeground(Color.WHITE);
		availableGlitchLabel.setSize(750, 20);
		availableGlitchLabel.setLocation(0, 150);
		
		// buttons
			// save/load
		saveButton.setBounds(375, 100, 75, 30);
		loadButton.setBounds(300, 100, 75, 30);
			
			// glitch buttons
		zeroBlueButton.setBounds(0, 250, 150, 30);
		mirrorVerticalButton.setBounds(150, 250, 150, 30);
		glitchGangButton.setBounds(300, 250, 150, 30);
		fizzleButton.setBounds(600, 250, 150, 30);
		fizzleRemasteredButton.setBounds(75, 300, 150, 30);
		hidePictureButton.setBounds(375, 200, 150, 29);
		revealPictureButton.setBounds(225, 200, 150, 30);
		takeChunksButton.setBounds(225, 300, 150, 30);
		onlyHighestButton.setBounds(450, 250, 150, 30);
		destrucButton.setBounds(525, 300, 150, 30);
		sweepButton.setBounds(375, 300, 150, 30);
		
			// progress toggle
		showProgressToggle.setBounds(0, 100, 225, 30);
		
			// progress label
		progressDisplay.setFont(new Font("Courier", Font.PLAIN, 20));
		progressDisplay.setForeground(Color.WHITE);
		progressDisplay.setBounds(5, 150, 225, 20);
	}
	
	public void setupListeners()
	{
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.pickImage();
//				picPathLabel.setText("image path: " + picker.image.getMediaPath(picker.image.getFileName()));
			}
		});
	
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.saveImage();
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
		
		
		
//		if(picker.image.getGlitched())
//		{
//			preGlitchedBuffer = picker.image.getBufferedImage();
//			preGlitchedRaster = preGlitchedBuffer.getRaster();
//			
//		}
//		else
//		{
//			
//		}
		
		
		
		zeroBlueButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.zeroBlue();
				picker.image.setGlitched(true);
				picker.image.explore();
			}
		});
		
		mirrorVerticalButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.mirrorVertical();
				picker.image.setGlitched(true);
				picker.image.explore();
			}
		});
		
		glitchGangButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.glitchGang();
				picker.image.setGlitched(true);
				picker.image.explore();
			}
		});
		
		fizzleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.fizzle();
				picker.image.setGlitched(true);
				picker.image.explore();
			}
		});
		
		fizzleRemasteredButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.fizzleRemastered();
				picker.image.setGlitched(true);
				picker.image.explore();
			}
		});
		
		hidePictureButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				String imageToHidePath = FileChooser.pickPath(new JFileChooser());
				Picture imageToHide = new Picture(imageToHidePath);
				picker.image.hidePicture(imageToHide);
				picker.image.setGlitched(true);
				picker.image.explore();
			}
		});
		
		revealPictureButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.revealPicture();
				picker.image.setGlitched(true);
				picker.image.explore();
			}
		});
		
//		mathClassButton.addActionListener(new ActionListener()
//		{
//			public void actionPerformed(ActionEvent mouseClick)
//			{
//				picker.image.mathClass();
//			}
//		});
		
		takeChunksButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.takeChunks();
				picker.image.setGlitched(true);
				picker.image.explore();
			}
		});
		
		onlyHighestButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.onlyHighest();
				picker.image.setGlitched(true);
				picker.image.explore();
			}
		});
		
		destrucButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.destruc();
				picker.image.setGlitched(true);
				picker.image.explore();
			}
		});
		
		sweepButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.sweep();
				picker.image.setGlitched(true);
				picker.image.explore();
			}
		});
	}
	
	
	public void updatePath(String path)
	{
		picPath = path;
		picPathLabel.setText("image path: " + path);
	}
}
