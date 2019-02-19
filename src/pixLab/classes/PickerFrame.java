package pixLab.classes;

public class PickerFrame
{
	private PicturePicker picPick;
	private PickerPanel pickPanel;
	
	public PickerFrame(PicturePicker picPick)
	{
		super();
		this.pickPanel = new PickerPanel(picPick);
	}

}
