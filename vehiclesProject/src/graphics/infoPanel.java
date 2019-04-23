package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import Vehicles.Vehicle;

public class infoPanel extends JPanel {
	private JTable j;
	private static final String[] columnNames = { "Vehicle","ID","Color","Wheels","Speed","Fuel/Energy","Distance","Fuel/Energy consumption","Lights" }; ;
	private static final ArrayList<String[]> listOfVehicles = new ArrayList<String[]>();
	private static final ArrayList<Integer> IDs = new ArrayList<Integer>();
	private static String[][] data = new String[listOfVehicles.size()][];;
	public infoPanel(){
		j = new JTable(data, columnNames); 
		j.setPreferredScrollableViewportSize(j.getPreferredSize());
		j.setFillsViewportHeight(true);
		JScrollPane sp = new JScrollPane(j); 
		if(listOfVehicles.size() == 0){
			JLabel noVehicles = new JLabel("There were no vehicles yet",SwingConstants.CENTER);
			noVehicles.setForeground(Color.RED);
			setSize(1400,80); 
			setLayout(new GridLayout(2,1));
			add(sp);
			add(noVehicles);
			
		}
		else{
			setSize(1400,55+j.getPreferredSize().height); 
			setLayout(new GridLayout(1,1));
			add(sp);
		}
	}
	
	public static void setVehicle(Vehicle vehicle){
		if(vehicle != null){
			if(IDs.contains(vehicle.getID())){
				for(int i=0;i<listOfVehicles.size();i++)
					if(listOfVehicles.get(i)[1].equals(String.valueOf(vehicle.getID())))
						listOfVehicles.set(i, new String[]{vehicle.getVehicleName(),String.valueOf(vehicle.getID()),vehicle.getColor(),String.valueOf(vehicle.getWheels()),String.valueOf(vehicle.getSpeed()),String.valueOf(vehicle.getFuel()),String.valueOf(vehicle.getDistance()),String.valueOf(vehicle.getFuelConsumption()),vehicle.getLights()});
			}		
			else{
				listOfVehicles.add(new String[]{vehicle.getVehicleName(),String.valueOf(vehicle.getID()),vehicle.getColor(),String.valueOf(vehicle.getWheels()),String.valueOf(vehicle.getSpeed()),String.valueOf(vehicle.getFuel()),String.valueOf(vehicle.getDistance()),String.valueOf(vehicle.getFuelConsumption()),vehicle.getLights()});
				IDs.add(vehicle.getID());
			}
		}
		data = new String[listOfVehicles.size()][];
		for(int i=0;i<listOfVehicles.size();i++){
			data[i] = listOfVehicles.get(i);
		}
	}
}
