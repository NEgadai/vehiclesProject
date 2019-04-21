package graphics;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Vehicles.Vehicle;

public class infoPanel extends JPanel {
	private JTable j;
	private String[] columnNames = { "Vehicle","ID","Color","Wheels","Speed","fuelAmount","Distance","Fuel consumption","Lights" }; ;
	private static ArrayList<String[]> listOfVehicles = new ArrayList<String[]>();
	private static ArrayList<Integer> IDs = new ArrayList<Integer>();
	private String[][] data;
	public infoPanel(Vehicle vehicle){
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
//		String[][] data = {{vehicle.getVehicleName(),String.valueOf(vehicle.getID()),vehicle.getColor(),String.valueOf(vehicle.getWheels()),String.valueOf(vehicle.getSpeed()),String.valueOf(vehicle.getFuel()),String.valueOf(vehicle.getDistance()),String.valueOf(vehicle.getFuelConsumption()),vehicle.getLights()}}; 
		j = new JTable(data, columnNames); 
		j.setSize(new Dimension(1000,80));
		j.setPreferredScrollableViewportSize(j.getSize());
		j.setFillsViewportHeight(true);
//		j.setFont(new Font("Arial",Font.,15));
		setSize(j.getSize().width+10,j.getSize().height+10*(listOfVehicles.size()-1)); 
		JScrollPane sp = new JScrollPane(j); 
		add(sp);
	}
}
