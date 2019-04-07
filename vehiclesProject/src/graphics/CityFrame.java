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

public class CityFrame extends JFrame {
	private static Dimension frameSize;
	JMenuBar menuBar;
	public CityFrame(String str){
		super(str);
		this.setMenu();
	}
	
	private void setMenu(){
		JMenuItem exitItem,helpItem;
		JMenu fileMenu, helpMenu;
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//setting action into the Exit button for exit the system.
			}
		});
		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
		helpMenu = new JMenu("Help");
		helpItem = new JMenuItem("Help");
		helpItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Home Work 2\nGUI");//setting action into the Help button for open the dialog message.
			}
		});
		helpMenu.add(helpItem);
		menuBar.add(helpMenu);
		this.setJMenuBar(menuBar);
	}
	public static void main(String []args){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//get the screen size.
		CityFrame frame = new CityFrame("City"); 
		final CityPanel backgroundPanel = new CityPanel();
		frameSize = new Dimension((int)backgroundPanel.getBackgroundSize().getWidth(),(int)backgroundPanel.getBackgroundSize().getHeight());
		final ButtonsPanel buttonsPanel = new ButtonsPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(0,0));//set border layout for set 2 panels - one for the city background and one for the below buttons
		frame.add(backgroundPanel);
		System.out.println(frameSize);
		buttonsPanel.setPreferredSize(new Dimension(frameSize.width,50));
		frame.add(buttonsPanel,BorderLayout.SOUTH);
//		frame.getContentPane().add(panel); 
		frame.setPreferredSize(new Dimension(frameSize.width+17,(int)(frameSize.height+buttonsPanel.getSize().getHeight())));//set size of the frame as the size of the background
		frame.setLocation(screenSize.width/2-frame.getPreferredSize().width/2, screenSize.height/2-frame.getPreferredSize().height/2);//set the frame in the middle of the screen
		frame.pack(); 
		frame.setVisible(true); 
	}
	public static Dimension getFrameSize(){return frameSize;}
}