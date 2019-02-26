package pixLab.classes;

import java.awt.GridBagLayout;
import pixLab.classes.PicturePicker;
import pixLab.classes.PictureTester;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

public class PickerFrame extends JFrame
{
	private PicturePicker picker;
	private PickerPanel pickPanel;
	
	public PickerFrame(PicturePicker picker)
	{
		super();
		this.pickPanel = new PickerPanel(picker);
		SpringLayout pickerLayout = new SpringLayout();
		
		pickPanel.setLayout(null);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(pickPanel);
		this.setSize(800, 500);
		this.setTitle("Not Photoshop");
		this.setResizable(true);
		this.setVisible(true);
	}

}
