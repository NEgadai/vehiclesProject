package graphics;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;

public class infoFrame extends JDialog {
	private static infoFrame frame = null;
	private infoPanel pane;
	public infoFrame(){
		setTitle("Vehicle Info");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//get the screen size.
		pane = new infoPanel();
		add(pane);
		setSize(new Dimension(pane.getSize().width,pane.getSize().height));//set size of the frame as the size of the background
		setLocation(screenSize.width/2-getSize().width/2, screenSize.height/2-getSize().height/2);//set the frame in the middle of the screen
		setResizable(false);
	}
	public void refreshPane(){
		remove(pane);
		pane = new infoPanel();
		add(pane);
		setSize(new Dimension(pane.getSize().width,pane.getSize().height));//set size of the frame as the size of the background
	}
	public static infoFrame getInstance(){
		if(frame == null){
			frame = new infoFrame();
		}
		frame.refreshPane();
		return frame;
	}
}
