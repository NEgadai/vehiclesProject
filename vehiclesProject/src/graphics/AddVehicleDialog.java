package graphics;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;
/**
 * A class inherits from Dialog
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class AddVehicleDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	public AddVehicleDialog(CityPanel city){
//		super(new JFrame(),"Add Vehicle");
		setTitle("Add a vehicle to the city");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//get the screen size.
		setSize(new Dimension(550,300));
		setLocation(screenSize.width/2-getSize().width/2, screenSize.height/2-getSize().height/2);
		add(new AddVehibleDialogPanel(city));
	}
}
