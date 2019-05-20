package graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
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
	/**
	 * This method is responsible for all action listener of the buttons and components
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttons[0]){
			if(CityPanel.thereAreFiveVehicles())//Check if CityPanel exists current vehicle.
				JOptionPane.showMessageDialog(null, "Error,There are 5 vehicles.");
			else{
				avd = new  AddVehicleDialog(city);
				avd.setVisible(true);
			}
		}
		else if(e.getSource() == buttons[1]){
			city.clear();
		}else if(e.getSource() == buttons[2]){
			
			city.Refuel();
		}else if(e.getSource() == buttons[3]){
			city.lightsOnOff();
		}else if(e.getSource() == buttons[4]){
			info = infoDialog.getInstance();
			info.setVisible(true);
		}else if(e.getSource() == buttons[5]){
			city.interuptAll();
			System.exit(0);
		}
	}
	/**
	 * Invisible
	 */
	public static void unVisible(){avd.setVisible(false);}
}
