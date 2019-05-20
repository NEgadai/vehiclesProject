package graphics;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import Vehicles.Vehicle;
/**
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class infoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable j;
	private static final String[] columnNames = { "Vehicle","ID","Color","Wheels","Speed","Fuel/Energy","Distance","Fuel/Energy consumption","Lights","Crashed With.." }; ;
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
	/**
	 * Set Vehicle
	 * 
	 * @param vehicle
	 * 		  A Vehicle object.
	 */
	public static void setVehicle(Vehicle vehicle){
		if(vehicle != null){
			if(IDs.contains(vehicle.getID())){
				for(int i=0;i<listOfVehicles.size();i++)
					if(listOfVehicles.get(i)[1].equals(String.valueOf(vehicle.getID())))
						listOfVehicles.set(i, new String[]{vehicle.getVehicleName(),String.valueOf(vehicle.getID()),vehicle.getColor(),String.valueOf(vehicle.getWheels()),String.valueOf(vehicle.getSpeed()),String.valueOf(vehicle.getFuel()),String.valueOf(vehicle.getDistance()),String.valueOf(vehicle.getFuelConsumption()),vehicle.getLights(),""});
			}		
			else{
				listOfVehicles.add(new String[]{vehicle.getVehicleName(),String.valueOf(vehicle.getID()),vehicle.getColor(),String.valueOf(vehicle.getWheels()),String.valueOf(vehicle.getSpeed()),String.valueOf(vehicle.getFuel()),String.valueOf(vehicle.getDistance()),String.valueOf(vehicle.getFuelConsumption()),vehicle.getLights(),""});
				IDs.add(vehicle.getID());
			}
		}
		data = new String[listOfVehicles.size()][];
		for(int i=0;i<listOfVehicles.size();i++)
			data[i] = listOfVehicles.get(i);
	}
	public static void setCrashed(int ID1, int ID2){
		for(int i=0;i<listOfVehicles.size();i++)
			if(listOfVehicles.get(i)[1].equals(String.valueOf(ID1)))
				listOfVehicles.set(i, new String[]{listOfVehicles.get(i)[0],listOfVehicles.get(i)[1],listOfVehicles.get(i)[2],listOfVehicles.get(i)[3],listOfVehicles.get(i)[4],listOfVehicles.get(i)[5],listOfVehicles.get(i)[6],listOfVehicles.get(i)[7],listOfVehicles.get(i)[8],String.valueOf(ID2)});

	}
}
