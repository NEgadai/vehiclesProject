package graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Vehicles.Orientation;
import Vehicles.Point;
import Vehicles.Vehicle;
import Vehicles.vehicleThread;
/**
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class CityPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static boolean AreTherefiveArchive = false;
	private HashMap<Integer, vehicleThread> currentVehicles = new HashMap<Integer, vehicleThread>();
	private Queue<Vehicle> archiveVehicles = new LinkedList<>();
//	private HashMap<Integer, vehicleThread> archiveVehicles = new HashMap<Integer, vehicleThread>();
//	private ArrayList<vehicleThread> currentVehicles = new ArrayList<vehicleThread>();
//	private ArrayList<vehicleThread> archiveVehicles = new ArrayList<vehicleThread>();
	private BufferedImage background = loadImage();
	private static Dimension backgroundSize;
	public static Dimension getBackgroundSize(){return backgroundSize;}
	public CityPanel(){
		backgroundSize = new Dimension(background.getWidth(),background.getHeight());
	}
	/**
	 * This method is responsible for the loading the background into the panel. 
	 * 
	 * @return result.
	 */
	private BufferedImage loadImage(){
        URL imagePath = getClass().getResource("/images/cityBackground.png");
        BufferedImage result = null;
        try {
            result = ImageIO.read(imagePath);//read the image file with ImageIO class.
        } catch (IOException e) {//Catch due to try to read the image file.
            System.out.println("Error, wrong path.");
        }
        return result;
    }
	/**
	 * This method is responsible for the pain of the panel.
	 */
	public void Refuel(){
		synchronized(currentVehicles){
			currentVehicles.forEach((id,vThread)->{
				vThread.getVehicle().Refuel();
				vThread.notify();
			});
		}
	}
	public static boolean thereAreFiveVehicles(){
		return AreTherefiveArchive;
	}
	public void lightsOnOff(){
		currentVehicles.forEach((id,vThread)->{
			vThread.getVehicle().lightsOnOff();
		});
	}
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);//Call the default method due to overriding.
        setPreferredSize(backgroundSize);
        g.drawImage(background, 0, 0,getSize().width, getSize().height,0, 0, background.getWidth(), background.getHeight(), this);//set the background in 0,0 location (drawing the background)
        synchronized(this) {
	        currentVehicles.forEach((id,vThread)->{
	        	vThread.getVehicle().drawObject(g);
	        });
        }
        
    }
	/**
	 * 
	 * @return vehicle exists.
	 */
	public static boolean thereVehicle(){
		return vehicleExists;
	}
	/**
	 * Set Vehicle.
	 * 
	 * @param vehicle
	 * 		  A Vehicle object.
	 */
	public void addVehicle(Vehicle vehicle){
		if(currentVehicles.size() == 5){
			if(archiveVehicles.size() < 5)
				archiveVehicles.add(vehicle);
			else
				AreTherefiveArchive = true;
		}
		else{
			currentVehicles.put(vehicle.getID(),new vehicleThread(vehicle));
			currentVehicles.get(vehicle.getID()).start();
		}
		repaint();
	}
//	public Vehicle getVehicle(){return currentVehicle;}
	/**
	 * Remove vehicle.
	 */
	public void clear(){
		currentVehicles = new HashMap<Integer, vehicleThread>();
		archiveVehicles = new LinkedList<>();
		AreTherefiveArchive = false;
		repaint();
	}
	public void overlapVehicles(int ID1, int ID2){
		synchronized (this) {
			if(currentVehicles.containsKey(ID1) && currentVehicles.containsKey(ID2)){
				Vehicle[] crashedVehicles = {currentVehicles.get(ID1).getVehicle(),currentVehicles.get(ID2).getVehicle()};
				if(crashedVehicles[0].getDurability() > crashedVehicles[1].getDurability()){
					currentVehicles.get(ID1).interrupt();
					currentVehicles.remove(ID1);
					infoPanel.setCrashed(ID1, ID2);
					POP();
				}else if(crashedVehicles[0].getDurability() < crashedVehicles[1].getDurability()){
					currentVehicles.get(ID2).interrupt();
					currentVehicles.remove(ID2);
					infoPanel.setCrashed(ID2, ID1);
					POP();
				}else{
					for(int i=0;i<2;i++){
						currentVehicles.get(crashedVehicles[i].getID()).interrupt();
						currentVehicles.remove(crashedVehicles[i].getID());
						POP();
						infoPanel.setCrashed(ID2, ID1);
						infoPanel.setCrashed(ID1, ID2);
					}
				}
			}
		}
		repaint();
	}
	public HashMap<Integer, vehicleThread> getActiveVehicles(){return currentVehicles;}
	public void POP(){
		if(archiveVehicles.size() > 0)
			addVehicle(archiveVehicles.poll());
	}
	public void interuptAll(){
		currentVehicles.forEach((id,vThread)->{
        	vThread.interrupt();
        });
	}
}
