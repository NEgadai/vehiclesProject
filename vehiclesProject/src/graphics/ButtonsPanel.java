package graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsPanel extends JPanel implements ActionListener {
	private JButton addVehibleButton,clearButton,fuelFoodButton,lightsButton,infoButton,exitButton;
	public ButtonsPanel(){
		super();
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
			AddVehicleDialog avd = new  AddVehicleDialog();
			avd.setVisible(true);
		}
		else if(e.getSource() == clearButton){
			
		}else if(e.getSource() == fuelFoodButton){
			
		}else if(e.getSource() == lightsButton){
			
		}else if(e.getSource() == infoButton){
			
		}else if(e.getSource() == exitButton){
			System.exit(0);
		}
	}
}
