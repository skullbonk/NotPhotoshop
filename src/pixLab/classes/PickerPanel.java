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
	
	private JButton saveButton;
	
	private SpringLayout pickerLayout;
	
	public PickerPanel(PicturePicker picker)
	{
		super();
		
		this.picker = picker;
		
		this.loadButton = new JButton("load");
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
		
		pickerLayout = new SpringLayout();
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
		this.setLayout(pickerLayout);
		this.setPreferredSize(new Dimension(800, 600));
		this.setBackground(Color.DARK_GRAY);
		
		this.add(loadButton);
		
		this.add(picPathLabel);
		this.add(saveButton);
		
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
