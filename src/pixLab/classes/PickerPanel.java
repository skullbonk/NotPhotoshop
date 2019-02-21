package pixLab.classes;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Font;

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
	
	private JButton saveButton;
	
	private SpringLayout greatLayout;
	
	public PickerPanel(PicturePicker picker)
	{
		super();
		
		this.picker = picker;
		
		loadButton = new JButton("load an image");

		picPathLabel = new JLabel("Image: " + picPath);
		picPathLabel.setHorizontalAlignment(SwingConstants.CENTER);
		picPathLabel.setFont(new Font("Courier", Font.PLAIN, 55));
		picPathLabel.setForeground(Color.WHITE);
		
		saveButton = new JButton("Save image");
		
		greatLayout = new SpringLayout();
		
		
		
		
		
//		setButtonTips();
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
		this.setLayout(greatLayout);
		
		this.setPreferredSize(new Dimension(800, 600));
		this.setBackground(Color.DARK_GRAY);
		
		this.add(loadButton);
		this.add(saveButton);
		this.add(picPathLabel);
	}
	
	public void setupLayout()
	{
		greatLayout.putConstraint(SpringLayout.NORTH, saveButton, 263, SpringLayout.NORTH, this);
		greatLayout.putConstraint(SpringLayout.NORTH, picPathLabel, 197, SpringLayout.NORTH, this);
		greatLayout.putConstraint(SpringLayout.SOUTH, picPathLabel, -343, SpringLayout.SOUTH, this);
		greatLayout.putConstraint(SpringLayout.NORTH, loadButton, 0, SpringLayout.NORTH, saveButton);
		greatLayout.putConstraint(SpringLayout.WEST, loadButton, 0, SpringLayout.WEST, picPathLabel);
		greatLayout.putConstraint(SpringLayout.EAST, loadButton, -414, SpringLayout.EAST, this);
		greatLayout.putConstraint(SpringLayout.WEST, saveButton, 424, SpringLayout.WEST, this);
		greatLayout.putConstraint(SpringLayout.EAST, saveButton, 0, SpringLayout.EAST, picPathLabel);
		greatLayout.putConstraint(SpringLayout.WEST, picPathLabel, 206, SpringLayout.WEST, this);
		greatLayout.putConstraint(SpringLayout.EAST, picPathLabel, -206, SpringLayout.EAST, this);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		greatLayout.putConstraint(SpringLayout.WEST, horizontalStrut, 6, SpringLayout.EAST, picPathLabel);
		greatLayout.putConstraint(SpringLayout.EAST, horizontalStrut, 0, SpringLayout.EAST, this);
		add(horizontalStrut);
		
		Component verticalGlue = Box.createVerticalGlue();
		greatLayout.putConstraint(SpringLayout.WEST, verticalGlue, 0, SpringLayout.WEST, this);
		greatLayout.putConstraint(SpringLayout.EAST, verticalGlue, 0, SpringLayout.WEST, this);
		add(verticalGlue);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		greatLayout.putConstraint(SpringLayout.NORTH, horizontalStrut, 0, SpringLayout.NORTH, horizontalStrut_1);
		greatLayout.putConstraint(SpringLayout.WEST, horizontalStrut_1, 0, SpringLayout.WEST, this);
		greatLayout.putConstraint(SpringLayout.EAST, horizontalStrut_1, -6, SpringLayout.WEST, picPathLabel);
		add(horizontalStrut_1);
		
		JLabel lblAvailableGlitches = new JLabel("Available glitches:");
		greatLayout.putConstraint(SpringLayout.NORTH, lblAvailableGlitches, 23, SpringLayout.SOUTH, loadButton);
		greatLayout.putConstraint(SpringLayout.WEST, lblAvailableGlitches, 0, SpringLayout.WEST, loadButton);
		greatLayout.putConstraint(SpringLayout.SOUTH, lblAvailableGlitches, 52, SpringLayout.SOUTH, loadButton);
		greatLayout.putConstraint(SpringLayout.EAST, lblAvailableGlitches, 594, SpringLayout.WEST, this);
		lblAvailableGlitches.setFont(new Font("Courier", Font.ITALIC, 25));
		lblAvailableGlitches.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvailableGlitches.setBackground(Color.DARK_GRAY);
		lblAvailableGlitches.setForeground(Color.WHITE);
		add(lblAvailableGlitches);
		
		Box horizontalBox = Box.createHorizontalBox();
		greatLayout.putConstraint(SpringLayout.NORTH, horizontalBox, 26, SpringLayout.SOUTH, lblAvailableGlitches);
		greatLayout.putConstraint(SpringLayout.SOUTH, horizontalBox, -182, SpringLayout.SOUTH, this);
		greatLayout.putConstraint(SpringLayout.SOUTH, horizontalStrut_1, -149, SpringLayout.NORTH, horizontalBox);
		greatLayout.putConstraint(SpringLayout.WEST, horizontalBox, 100, SpringLayout.WEST, this);
		greatLayout.putConstraint(SpringLayout.EAST, horizontalBox, -100, SpringLayout.EAST, this);
		add(horizontalBox);
		
		zeroBlueButton = new JButton("zero blue");
		zeroBlueButton.setToolTipText("deletes blue");
		zeroBlueButton.setBackground(Color.LIGHT_GRAY);
		horizontalBox.add(zeroBlueButton);
		greatLayout.putConstraint(SpringLayout.WEST, zeroBlueButton, 100, SpringLayout.WEST, this);
		greatLayout.putConstraint(SpringLayout.NORTH, zeroBlueButton, 114, SpringLayout.SOUTH, horizontalStrut_1);
		mirrorVerticalButton = new JButton("mirror vertical");
		mirrorVerticalButton.setToolTipText("mirrors vertically");
		horizontalBox.add(mirrorVerticalButton);
		glitchGangButton = new JButton("glitch gang");
		glitchGangButton.setToolTipText("I forgot what this does, but I bet it's boring and broken");
		horizontalBox.add(glitchGangButton);
		fizzleButton = new JButton("fizzle");
		fizzleButton.setToolTipText("The original glitch - simultaneously boring and interesting");
		horizontalBox.add(fizzleButton);
		fizzleRemasteredButton = new JButton("fizzle - remastered");
		fizzleRemasteredButton.setToolTipText("Fizzle's big brother that was actually born later somehow, but we'll ignore that");
		horizontalBox.add(fizzleRemasteredButton);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		greatLayout.putConstraint(SpringLayout.NORTH, horizontalBox_1, 424, SpringLayout.NORTH, this);
		greatLayout.putConstraint(SpringLayout.WEST, horizontalBox_1, 150, SpringLayout.WEST, this);
		greatLayout.putConstraint(SpringLayout.SOUTH, horizontalBox_1, 54, SpringLayout.SOUTH, horizontalBox);
		greatLayout.putConstraint(SpringLayout.EAST, horizontalBox_1, -50, SpringLayout.EAST, horizontalBox);
		add(horizontalBox_1);
		hidePictureButton = new JButton("hide picture");
		hidePictureButton.setToolTipText("Hide a picture in another picture, probably doesn't work");
		horizontalBox_1.add(hidePictureButton);
		revealPictureButton = new JButton("reveal picture");
		revealPictureButton.setToolTipText("Reveals a hidden picture, probably doesn't work");
		horizontalBox_1.add(revealPictureButton);
		mathClassButton = new JButton("math class");
		takeChunksButton = new JButton("take chunks");
		takeChunksButton.setToolTipText("Turns everything into fuzzy squares and does some whacky purple red shiz");
		horizontalBox_1.add(takeChunksButton);
		onlyHighestButton = new JButton("only highest");
		onlyHighestButton.setToolTipText("Deletes every color but the highest one. Boring, but could be useful");
		horizontalBox_1.add(onlyHighestButton);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		greatLayout.putConstraint(SpringLayout.NORTH, horizontalBox_2, 6, SpringLayout.SOUTH, horizontalBox_1);
		greatLayout.putConstraint(SpringLayout.WEST, horizontalBox_2, 250, SpringLayout.WEST, this);
		greatLayout.putConstraint(SpringLayout.SOUTH, horizontalBox_2, 54, SpringLayout.SOUTH, horizontalBox_1);
		greatLayout.putConstraint(SpringLayout.EAST, horizontalBox_2, -278, SpringLayout.EAST, this);
		add(horizontalBox_2);
		destrucButton = new JButton("destruc");
		destrucButton.setToolTipText("I forgot what this does, but it's probably underwhelming");
		horizontalBox_2.add(destrucButton);
		greatLayout.putConstraint(SpringLayout.WEST, destrucButton, 244, SpringLayout.WEST, this);
		greatLayout.putConstraint(SpringLayout.SOUTH, destrucButton, -10, SpringLayout.SOUTH, this);
		sweepButton = new JButton("sweep");
		sweepButton.setToolTipText("Crisps it up and also makes phantoms in the corner");
		horizontalBox_2.add(sweepButton);
		greatLayout.putConstraint(SpringLayout.WEST, sweepButton, 359, SpringLayout.WEST, this);
		greatLayout.putConstraint(SpringLayout.SOUTH, sweepButton, 0, SpringLayout.SOUTH, this);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		greatLayout.putConstraint(SpringLayout.NORTH, horizontalStrut_2, 169, SpringLayout.SOUTH, horizontalStrut_1);
		greatLayout.putConstraint(SpringLayout.WEST, horizontalStrut_2, 0, SpringLayout.WEST, verticalGlue);
		greatLayout.putConstraint(SpringLayout.SOUTH, horizontalStrut_2, -196, SpringLayout.SOUTH, this);
		greatLayout.putConstraint(SpringLayout.EAST, horizontalStrut_2, -6, SpringLayout.WEST, horizontalBox);
		add(horizontalStrut_2);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		greatLayout.putConstraint(SpringLayout.NORTH, horizontalStrut_3, 0, SpringLayout.NORTH, horizontalStrut_2);
		greatLayout.putConstraint(SpringLayout.WEST, horizontalStrut_3, 6, SpringLayout.EAST, horizontalBox);
		greatLayout.putConstraint(SpringLayout.SOUTH, horizontalStrut_3, -210, SpringLayout.SOUTH, this);
		greatLayout.putConstraint(SpringLayout.EAST, horizontalStrut_3, 0, SpringLayout.EAST, this);
		add(horizontalStrut_3);
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
	}
}
