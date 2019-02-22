package pixLab.classes;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	private String picPath;
	
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
	
	private JLabel picPathLabel;
	private JLabel availableGlitchLabel; 
	
	private JButton saveButton;
	
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
		
		this.picPathLabel = new JLabel("image path: " + picker.getPath());
		
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
		this.setPreferredSize(new Dimension(800, 600));
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
	}
	
	public void setupLayout()
	{
		// labels
			// pickPathLabel
		picPathLabel.setHorizontalAlignment(SwingConstants.CENTER);
		picPathLabel.setFont(new Font("Courier", Font.PLAIN, 30));
		picPathLabel.setForeground(Color.WHITE);
		picPathLabel.setBounds(6, 237, 788, 52);
		
			// availableGlitchesLabel
		availableGlitchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		availableGlitchLabel.setFont(new Font("Courier", Font.ITALIC, 20));
		availableGlitchLabel.setForeground(Color.WHITE);
		availableGlitchLabel.setSize(788, 20);
		availableGlitchLabel.setLocation(6, 341);
		
		// buttons
			// save/load
		saveButton.setBounds(386, 301, 75, 29);
		loadButton.setBounds(301, 301, 75, 29);
			
			// glitch buttons
		zeroBlueButton.setBounds(107, 380, 102, 29);
		mirrorVerticalButton.setBounds(221, 380, 133, 29);
		glitchGangButton.setBounds(360, 380, 115, 29);
		fizzleButton.setBounds(478, 380, 78, 29);
		fizzleRemasteredButton.setBounds(202, 462, 152, 29);
		hidePictureButton.setBounds(317, 421, 119, 29);
		revealPictureButton.setBounds(448, 421, 129, 29);
		takeChunksButton.setBounds(361, 462, 121, 29);
		onlyHighestButton.setBounds(183, 421, 122, 29);
		destrucButton.setBounds(568, 380, 91, 29);
		sweepButton.setBounds(478, 462, 83, 29);
	}
	
	public void setupListeners()
	{
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.pickImage();
			}
		});
	
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.saveImage();
			}
		});
		
		zeroBlueButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.zeroBlue();
			}
		});
		
		mirrorVerticalButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.mirrorVertical();
			}
		});
		
		glitchGangButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.glitchGang();
			}
		});
		
		fizzleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.fizzle();
			}
		});
		
		fizzleRemasteredButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.fizzleRemastered();
			}
		});
		
		hidePictureButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				String imageToHidePath = FileChooser.pickPath(new JFileChooser());
				Picture imageToHide = new Picture(imageToHidePath);
				picker.image.hidePicture(imageToHide);
			}
		});
		
		revealPictureButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.revealPicture();
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
			}
		});
		
		onlyHighestButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.onlyHighest();
			}
		});
		
		destrucButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.destruc();
			}
		});
		
		sweepButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				picker.image.sweep();
			}
		});
	}
}
