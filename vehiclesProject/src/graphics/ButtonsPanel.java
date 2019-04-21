package graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Vehicles.Car;

public class ButtonsPanel extends JPanel implements ActionListener {
	private JButton addVehibleButton,clearButton,fuelFoodButton,lightsButton,infoButton,exitButton;
	private static AddVehicleDialog avd;
	private CityPanel city;
	private infoFrame info;
	public ButtonsPanel(CityPanel city){
		this.city = city;
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();//for configure the buttons
	    c.fill = GridBagConstraints.BOTH;//Fill all size space of the frame
		addVehibleButton = new JButton("Add Vehicle");
		addVehibleButton.addActionListener(this);
		c.weightx = 10/6;//the division of space for 6 buttons.
	    c.weighty = 1.0;//fill all Y space 
	    c.gridx = 0;//set the items like on the graph 
	    c.gridy = 0;
		add(addVehibleButton,c);
		clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
	    c.gridx = 1;
		add(clearButton,c);
		fuelFoodButton = new JButton("Fuel/Food");
		fuelFoodButton.addActionListener(this);
	    c.gridx = 2;
		add(fuelFoodButton,c);
		lightsButton = new JButton("Lights");
		lightsButton.addActionListener(this);
	    c.gridx = 3;
		add(lightsButton,c);
		infoButton = new JButton("Info");
		infoButton.addActionListener(this);
	    c.gridx = 4;
		add(infoButton,c);
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
	    c.gridx = 5;
		add(exitButton,c);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addVehibleButton){
			if(CityPanel.thereVehicle())//Check if CityPanel exists current vehicle.
				JOptionPane.showMessageDialog(null, "Error,There is already a vehicle.");
			else{
				avd = new  AddVehicleDialog(city);
				avd.setVisible(true);
			}
		}
		else if(e.getSource() == clearButton){
			city.removeVehicle();
		}else if(e.getSource() == fuelFoodButton){
			if(city.getVehicle() instanceof Car)
				city.getVehicle().Refuel();
		}else if(e.getSource() == lightsButton){
			city.getVehicle().lightsOnOff();
		}else if(e.getSource() == infoButton){
			info =new infoFrame(city.getVehicle());
			info.setVisible(true);
		}else if(e.getSource() == exitButton){
			System.exit(0);
		}
	}
	public static void unVisible(){avd.setVisible(false);}
}
