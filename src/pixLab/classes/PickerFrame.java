package pixLab.classes;

import java.awt.GridBagLayout;
import pixLab.classes.PicturePicker;
import pixLab.classes.PictureTester;
import javax.swing.JFrame;

public class PickerFrame extends JFrame
{
	private PicturePicker picker;
	private PickerPanel pickPanel;
	
	public PickerFrame(PicturePicker picker)
	{
		super();
		this.pickPanel = new PickerPanel(picker);
		GridBagLayout gbl_pickPanel = new GridBagLayout();
		gbl_pickPanel.columnWidths = new int[]{0};
		gbl_pickPanel.rowHeights = new int[]{0};
		gbl_pickPanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_pickPanel.rowWeights = new double[]{Double.MIN_VALUE};
		pickPanel.setLayout(gbl_pickPanel);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(pickPanel);
		this.setSize(800, 800);
		this.setTitle("Not Photoshop");
		this.setResizable(true);
		this.setVisible(true);
	}

}
