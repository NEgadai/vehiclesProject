package graphics;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

import Vehicles.Bike;
import Vehicles.Car;
import Vehicles.Carriage;
import Vehicles.Color;
import Vehicles.Vehicle;
import Vehicles.benzineEngine;
import Vehicles.solarEngine;
/**
 * A class inherits from JPanel
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class AddVehibleDialogPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final int NUM_OF_OPTIONS = 4;
	private JPanel topPanel,buttomPanel,centerPanel,buttonsPanel,vehicleType,vehicleColor;
	private final JRadioButton[] typeButtons = new JRadioButton[NUM_OF_OPTIONS],colorButtons = new JRadioButton[NUM_OF_OPTIONS];
	private final String[] typeTexts = {"Benzine Car","Solar Car","Bike","Carriage"},colorTexts = {"Red","Green","Silver","White"};
	private final ButtonGroup vtGroup = new ButtonGroup(), vcGroup = new ButtonGroup();
	private JButton Submit,Cancel;
	private JSlider gears;
	private final GridBagConstraints c = new GridBagConstraints();
	private static final int FPS_MIN = 0, FPS_MAX = 10, FPS_INIT = 5;
	private CityPanel city;
	public AddVehibleDialogPanel(CityPanel city){
		this.city = city;
		setLayout(new BorderLayout());
		
		topPanel = new JPanel(new GridLayout());
		
		c.fill = GridBagConstraints.BOTH;
		
		vehicleType = new JPanel(new GridBagLayout());
		vehicleType.setBorder(BorderFactory.createTitledBorder("Choose a vehicle type"));
		vehicleColor = new JPanel(new GridBagLayout());
		vehicleColor.setBorder(BorderFactory.createTitledBorder("Choose a color"));
		
		for(int i=0;i<NUM_OF_OPTIONS;i++){
			typeButtons[i] = new JRadioButton(typeTexts[i]);
			typeButtons[i].setActionCommand(typeTexts[i]);
			colorButtons[i] = new JRadioButton(colorTexts[i]);
			colorButtons[i].setActionCommand(colorTexts[i]);
			if(i == 0){
				typeButtons[i].setSelected(true);
				colorButtons[i].setSelected(true);
			}
			typeButtons[i].addActionListener(this);
			colorButtons[i].addActionListener(this);
			vtGroup.add(typeButtons[i]);
			vcGroup.add(colorButtons[i]);
			if(i>1){
				c.gridy = 1;
				vehicleType.add(typeButtons[i],c);
				vehicleColor.add(colorButtons[i],c);
			}else{
				c.gridy = 0;
				vehicleType.add(typeButtons[i],c);
				vehicleColor.add(colorButtons[i],c);
			}
		}
		
		topPanel.add(vehicleType);
		topPanel.add(vehicleColor);
		
		add(topPanel,BorderLayout.PAGE_START);
		
		buttomPanel = new JPanel(new GridBagLayout());

		centerPanel = new JPanel(new GridLayout(1,1));
		gears = new JSlider(JSlider.HORIZONTAL,FPS_MIN, FPS_MAX, FPS_INIT);
		Hashtable<Integer, JLabel> gearsNumbers = new Hashtable<Integer, JLabel>();
		for(int i=0;i<=10;i = i+2)
			gearsNumbers.put(new Integer(i),(new JLabel(""+i+"")));
		gears.setLabelTable(gearsNumbers);
		gears.setMajorTickSpacing(10);
		gears.setValue(5);
		gears.setMinorTickSpacing(1);
		gears.setPaintTicks(true);
		gears.setPaintLabels(true);
		centerPanel.add(gears);
		centerPanel.setVisible(false);
		centerPanel.setBorder(BorderFactory.createTitledBorder("Choose bike gears"));
		
		c.gridy = 0;
		c.weightx = 1;
		buttomPanel.add(centerPanel,c);
		
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(1,2));
		Submit = new JButton("OK");
		Submit.addActionListener(this);
		Cancel = new JButton("Cancel");
		Cancel.addActionListener(this);
		c.gridy = 1;
		buttonsPanel.add(Submit);
		buttonsPanel.add(Cancel);
		
		buttomPanel.add(buttonsPanel,c);
		add(buttomPanel,BorderLayout.PAGE_END);
		
	}
	/**
	 * This method is responsible for all action listener of the buttons and components
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Submit){
			Vehicle vehicle = null;
			String colorSelection = vcGroup.getSelection().getActionCommand();
			String typeSelection = vtGroup.getSelection().getActionCommand();
			switch(typeSelection){
			case "Benzine Car":
				vehicle = new Car(Color.valueOf(colorSelection),new benzineEngine(40),city);
				break;
			case "Solar Car":
				vehicle = new Car(Color.valueOf(colorSelection),new solarEngine(40),city);
				break;
			case "Bike":
				vehicle = new Bike(Color.valueOf(colorSelection),gears.getValue(),city);
				break;
			case "Carriage":
				vehicle = new Carriage(Color.valueOf(colorSelection),city);
				break;
			}
			infoPanel.setVehicle(vehicle);
			city.addVehicle(vehicle);
			ButtonsPanel.unVisible();
		}else if(e.getSource() == Cancel){
			ButtonsPanel.unVisible();
		}else if(e.getSource() == typeButtons[2]){
			centerPanel.setVisible(true);
		}else if(e.getSource() == typeButtons[0] || e.getSource() == typeButtons[1] || e.getSource() == typeButtons[3])
			centerPanel.setVisible(false);
	}
}
