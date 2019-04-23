package graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class CityFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static Dimension frameSize;
	private JMenuBar menuBar;
	private JMenuItem exitItem,helpItem;
	private JMenu fileMenu, helpMenu;
	private CityFrame(String str){
		super(str);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//get the screen size.
		setMenu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(0,0));//set border layout for set 2 panels - one for the city background and one for the below buttons
		final CityPanel backgroundPanel = new CityPanel();
		frameSize = new Dimension((int)backgroundPanel.getBackgroundSize().getWidth(),(int)backgroundPanel.getBackgroundSize().getHeight());
		final ButtonsPanel buttonsPanel = new ButtonsPanel(backgroundPanel);
		add(backgroundPanel);
		add(buttonsPanel,BorderLayout.SOUTH);//stick the panel of the buttons in the SOUTH location.  
		setPreferredSize(new Dimension(frameSize.width,(int)(frameSize.height+buttonsPanel.getSize().getHeight())));//set size of the frame as the size of the background
//		setPreferredSize(new Dimension(800,600));//set size of the frame as the size of the background
		setLocation(screenSize.width/2-getPreferredSize().width/2, screenSize.height/2-getPreferredSize().height/2);//set the frame in the middle of the screen
		setResizable(false);
		pack(); 
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
		CityFrame frame = new CityFrame("City");
		frame.setVisible(true); 
	}
	public static Dimension getFrameSize(){return frameSize;}
}