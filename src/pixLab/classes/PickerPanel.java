package pixLab.classes;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Component;

public class PickerPanel extends JPanel
{
	private PicturePicker picPick;
	
	private JButton loadButton;
	
	private String picPath = picPick.getPath();
	
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
	
	public PickerPanel(PicturePicker picPick)
	{
		super();
		
		this.picPick = picPick;
		
		loadButton = new JButton("load an image");
		
		zeroBlueButton = new JButton("zero blue");
		mirrorVerticalButton = new JButton("mirror vertical");
		glitchGangButton = new JButton("glitch gang");
		fizzleButton = new JButton("fizzle");
		fizzleRemasteredButton = new JButton("fizzle - remastered");
		hidePictureButton = new JButton("hide picture");
		revealPictureButton = new JButton("reveal picture");
//		mathClassButton = new JButton("math class");
		takeChunksButton = new JButton("take chunks");
		onlyHighestButton = new JButton("only highest");
		destrucButton = new JButton("destruc");
		sweepButton = new JButton("sweep");

		picPathLabel = new JLabel("Image: " + picPath);
		
		saveButton = new JButton("Save image");
		
		greatLayout = new SpringLayout();
		
		
		
		
		setButtonTips();
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	public void setButtonTips()
	{
		zeroBlueButton.setToolTipText("deletes blue");
		mirrorVerticalButton.setToolTipText("mirrors vertically");
		glitchGangButton.setToolTipText("i forgot what this does but i bet it's boring and broken");
		fizzleButton.setToolTipText("the original glitch - simultaneously boring and interesting");
		fizzleRemasteredButton.setToolTipText("fizzle's big brother that was actually born later somehow, but we'll ignore that");
		hidePictureButton.setToolTipText("hide a picture in another picture, probably doesn't work");
		revealPictureButton.setToolTipText("reveals a hidden picture, probably doesn't work");
		takeChunksButton.setToolTipText("turns everything into fuzzy squares and does some whacky purple red shiz");
		onlyHighestButton.setToolTipText("deletes every color but the highest one. boring but could be useful");
		destrucButton.setToolTipText("I forgot what this does but it's probably underwhelming");
		sweepButton.setToolTipText("crisps it up and also makes phantoms in the corner");
		
		saveButton.setToolTipText("saves your freshly busted image");
	}

	public void setupPanel()
	{
		this.setLayout(greatLayout);
		
		this.setPreferredSize(new Dimension(800, 600));
		this.setBackground(Color.DARK_GRAY);
		
		this.add(loadButton);
		this.add(saveButton);
		this.add(picPathLabel);
		
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
				picPick.pickImage();
			}
		});
	}
}
