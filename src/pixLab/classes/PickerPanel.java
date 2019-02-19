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
		
		picPathLabel = new JLabel("Image: " + picPath);
		
	}

}
