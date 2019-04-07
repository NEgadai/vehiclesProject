package graphics;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsPanel extends JPanel implements ActionListener {
	JButton addVehibleButton,clearButton,fuelFoodButton,lightsButton,infoButton,exitButton;
	public ButtonsPanel(){
		super();
		int buttonSize = CityFrame.getFrameSize().width/6;
		setLayout(new FlowLayout(0,0,0));
		addVehibleButton = new JButton("Add Vehicle");
		addVehibleButton.setPreferredSize(new Dimension(buttonSize,(int)addVehibleButton.getPreferredSize().getHeight()));
		clearButton = new JButton("Clear");
		clearButton.setPreferredSize(new Dimension(buttonSize,(int)clearButton.getPreferredSize().getHeight()));
		fuelFoodButton = new JButton("Fuel/Food");
		fuelFoodButton.setPreferredSize(new Dimension(buttonSize,(int)fuelFoodButton.getPreferredSize().getHeight()));
		lightsButton = new JButton("Lights");
		lightsButton.setPreferredSize(new Dimension(buttonSize,(int)lightsButton.getPreferredSize().getHeight()));
		infoButton = new JButton("Info");
		infoButton.setPreferredSize(new Dimension(buttonSize,(int)infoButton.getPreferredSize().getHeight()));
		exitButton = new JButton("Exit");
		exitButton.setPreferredSize(new Dimension(buttonSize,(int)exitButton.getPreferredSize().getHeight()));
		setSize(new Dimension(getPreferredSize().width,(int)exitButton.getPreferredSize().getHeight()));
		add(addVehibleButton);
		add(clearButton);
		add(fuelFoodButton);
		add(lightsButton);
		add(infoButton);
		add(exitButton);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addVehibleButton){
			
		}
		else if(e.getSource() == clearButton){
			
		}else if(e.getSource() == fuelFoodButton){
			
		}else if(e.getSource() == lightsButton){
			
		}else if(e.getSource() == infoButton){
			
		}else if(e.getSource() == exitButton){
			
		}
	}
}
