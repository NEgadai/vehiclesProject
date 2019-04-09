package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class AddVehicleDialog extends JDialog {
	public AddVehicleDialog(){
//		super(new JFrame(),"Add Vehicle");
		setTitle("Add Vehicle");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//get the screen size.
		setSize(new Dimension(200,200));
		setLocation(screenSize.width/2-getSize().width/2, screenSize.height/2-getSize().height/2);
	}
}
