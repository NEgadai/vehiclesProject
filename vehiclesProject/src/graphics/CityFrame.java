package graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class CityFrame extends JFrame implements ActionListener {
	
	private static CityFrame frame = null; 
	private static Dimension frameSize;
	private JMenuBar menuBar;
	private JMenuItem exitItem,helpItem;
	private JMenu fileMenu, helpMenu;
	private CityFrame(String str){
		super(str);
		setMenu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(0,0));//set border layout for set 2 panels - one for the city background and one for the below buttons
	}
	public static CityFrame getInstance() //Singelton - Design Pattern
    { 
        if (frame == null) 
        	frame = new CityFrame("City"); 
  
        return frame; 
    } 
	private void setMenu(){
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(this);
		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
		helpMenu = new JMenu("Help");
		helpItem = new JMenuItem("Help");
		helpItem.addActionListener(this);
		helpMenu.add(helpItem);
		menuBar.add(helpMenu);
		this.setJMenuBar(menuBar);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exitItem){
			System.exit(0);//setting action into the Exit button for exit the system.
		}else if(e.getSource() == helpItem){
			JOptionPane.showMessageDialog(null, "Home Work 2\nGUI");//setting action into the Help button for open the dialog message.
		}
	}
	//Static methods:
	public static void main(String []args){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//get the screen size.
		
		CityFrame frame = CityFrame.getInstance();
		
		final CityPanel backgroundPanel = new CityPanel();
		frameSize = new Dimension((int)backgroundPanel.getBackgroundSize().getWidth(),(int)backgroundPanel.getBackgroundSize().getHeight());
		final ButtonsPanel buttonsPanel = new ButtonsPanel();
		frame.add(backgroundPanel);
		frame.add(buttonsPanel,BorderLayout.SOUTH);//stick the panel of the buttons in the SOUTH location.  
		frame.setPreferredSize(new Dimension(frameSize.width,(int)(frameSize.height+buttonsPanel.getSize().getHeight())));//set size of the frame as the size of the background
		frame.setLocation(screenSize.width/2-frame.getPreferredSize().width/2, screenSize.height/2-frame.getPreferredSize().height/2);//set the frame in the middle of the screen
		
		frame.pack(); 
		frame.setVisible(true); 
	}
	public static Dimension getFrameSize(){return frameSize;}
	public static void addVehicleDialogs(){
		AddVehicleDialog avd = new  AddVehicleDialog();
		avd.setVisible(true);
//		Object[] typeOfVehicles = {"Carriage","Bike","Solar Engine Car","Benzine Engine Car"};
//		Object[] colors = {"RED","GREEN","WHITE","GRAY"};
//		int vehicleDialog = JOptionPane.showOptionDialog(frame,
//				"Which vehicle would you like to add?","Type of Vehicle",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,typeOfVehicles,typeOfVehicles[3]);
//		int colorDialog = JOptionPane.showOptionDialog(frame,
//				"What is the color of that vehicle?","Color Options",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,colors,colors[3]);
//		switch(vehicleDialog){
//		case 0:
//			
//			break;
//		case 1:
//			break;
//		case 2:
//			break;
//		case 3:
//			break;
//		default:
//			break;
//		}
	}
}