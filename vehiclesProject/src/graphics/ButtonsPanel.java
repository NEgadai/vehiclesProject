package graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Vehicles.Car;
import Vehicles.Carriage;

public class ButtonsPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final int NUM_OF_BUTTONS = 6;
	private JButton[] buttons = new JButton[NUM_OF_BUTTONS];
	private String[] buttonsText = new String[]{"Add Vehicle","Clear","Fuel/Food","Lights","Info","Exit"};
	private static AddVehicleDialog avd;
	private CityPanel city;
	private infoDialog info;
	public ButtonsPanel(CityPanel city){
		this.city = city;
		setLayout(new GridLayout(1,6));
		for(int i=0;i<buttons.length;i++){
			buttons[i] = new JButton(buttonsText[i]);
			buttons[i].addActionListener(this);
			add(buttons[i]);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttons[0]){
			if(CityPanel.thereVehicle())//Check if CityPanel exists current vehicle.
				JOptionPane.showMessageDialog(null, "Error,There is already a vehicle.");
			else{
				avd = new  AddVehicleDialog(city);
				avd.setVisible(true);
			}
		}
		else if(e.getSource() == buttons[1]){
			if(CityPanel.thereVehicle())
				city.removeVehicle();
			else
				JOptionPane.showMessageDialog(null, "No vehicles.");
		}else if(e.getSource() == buttons[2]){
			if(CityPanel.thereVehicle()){
				city.getVehicle().Refuel();
			}else
				JOptionPane.showMessageDialog(null, "No vehicles.");
		}else if(e.getSource() == buttons[3]){
			if(CityPanel.thereVehicle())
				city.getVehicle().lightsOnOff();
			else
				JOptionPane.showMessageDialog(null, "No vehicles.");
		}else if(e.getSource() == buttons[4]){
			info = infoDialog.getInstance();
			info.setVisible(true);
		}else if(e.getSource() == buttons[5]){
			System.exit(0);
		}
	}
	public static void unVisible(){avd.setVisible(false);}
}
