package graphics;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;

import Vehicles.Vehicle;

public class infoFrame extends JDialog {
	public infoFrame(Vehicle vehicle){
//		super("Vehicle Info");
		setTitle("Vehicle Info");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//get the screen size.
//		setDefaultCloseOperation(JFrame.);
		final infoPanel pane = new infoPanel(vehicle);
		add(pane);
		setSize(new Dimension(pane.getSize().width,pane.getSize().height));//set size of the frame as the size of the background
		setLocation(screenSize.width/2-getSize().width/2, screenSize.height/2-getSize().height/2);//set the frame in the middle of the screen
		setResizable(false);
//		pack(); 
	}
	
}
