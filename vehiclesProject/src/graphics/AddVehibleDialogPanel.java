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

public class AddVehibleDialogPanel extends JPanel implements ActionListener {
	private JPanel topPanel,buttomPanel,centerPanel,buttonsPanel,vehicleType,vehicleColor;
	private final JRadioButton[] typeButtons = new JRadioButton[4],colorButtons = new JRadioButton[4];
	private final String[] typeTexts = {"Benzine Car","Solar Car","Bike","Carriage"},colorTexts = {"Red","Green","Silver","White"};
	private final ButtonGroup vtGroup = new ButtonGroup(), vcGroup = new ButtonGroup();
	private JButton Submit,Cancel;
	private JSlider gears;
	private final GridBagConstraints c = new GridBagConstraints();
	private final int FPS_MIN = 0, FPS_MAX = 10, FPS_INIT = 5;
	public AddVehibleDialogPanel(){
		setLayout(new BorderLayout());
		
		topPanel = new JPanel(new GridLayout());
		
		c.fill = GridBagConstraints.BOTH;
		
		vehicleType = new JPanel(new GridBagLayout());
		vehicleType.setBorder(BorderFactory.createTitledBorder("Choose a vehicle type"));
		vehicleColor = new JPanel(new GridBagLayout());
		vehicleColor.setBorder(BorderFactory.createTitledBorder("Choose a color"));
		
		for(int i=0;i<4;i++){
			typeButtons[i] = new JRadioButton(typeTexts[i]);
			if(i == 0)
				typeButtons[i].setSelected(true);
			typeButtons[i].addActionListener(this);
			vtGroup.add(typeButtons[i]);
			if(i>1){
				c.gridy = 1;
				vehicleType.add(typeButtons[i],c);
			}else{
				c.gridy = 0;
				vehicleType.add(typeButtons[i],c);
			}
		}
		for(int i=0;i<4;i++){
			colorButtons[i] = new JRadioButton(colorTexts[i]);
			if(i == 0)
				colorButtons[i].setSelected(true);
			colorButtons[i].addActionListener(this);
			vcGroup.add(colorButtons[i]);
			if(i>1){
				c.gridy = 1;
				vehicleColor.add(colorButtons[i],c);
			}else{
				c.gridy = 0;
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
		Cancel = new JButton("Cancel");
		c.gridy = 1;
		buttonsPanel.add(Submit);
		buttonsPanel.add(Cancel);
		
		buttomPanel.add(buttonsPanel,c);
		add(buttomPanel,BorderLayout.PAGE_END);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Submit){
			
		}else if(e.getSource() == Cancel){
			setVisible(false);
		}else if(e.getSource() == typeButtons[2]){
			centerPanel.setVisible(true);
		}else
			centerPanel.setVisible(false);
	}
}
