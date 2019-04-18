package graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Vehicles.Orientation;
import Vehicles.Point;
import Vehicles.Vehicle;

public class CityPanel extends JPanel {
	private Vehicle currentVehicle;
	private BufferedImage background = loadImage();
	private Dimension backgroundSize = new Dimension(background.getWidth(),background.getHeight());
	public Dimension getBackgroundSize(){return this.backgroundSize;}
	private static boolean vehicleExists = false;
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
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);//Call the default method due to overriding.
        setPreferredSize(backgroundSize);
        Dimension size = getSize();//get the size of this panel and set it into Dimension(size) object.
        g.drawImage(background, 0, 0,size.width, size.height,0, 0, background.getWidth(), background.getHeight(), this);//set the background in 0,0 location (drawing the background)
        if(thereVehicle()){
        	Random rand = new Random();
        	boolean bool = rand.nextBoolean();
        	if(currentVehicle.getCurLocation().getPoint().getX() == 920 && currentVehicle.getCurLocation().getOrientation() == Orientation.East){
        		currentVehicle.getCurLocation().setOrientation(Orientation.South);
        		currentVehicle.getCurLocation().getPoint().setX(986+66);
        		currentVehicle.getCurLocation().getPoint().setY(70);
        	}else if(currentVehicle.getCurLocation().getPoint().getY() == 202 && currentVehicle.getCurLocation().getOrientation() == Orientation.South){
        		if(bool){
        			currentVehicle.getCurLocation().setOrientation(Orientation.West);
        			currentVehicle.getCurLocation().getPoint().setX(920);
        			currentVehicle.getCurLocation().getPoint().setY(280);
        		}
        	}else if(currentVehicle.getCurLocation().getPoint().getY() == 562 && currentVehicle.getCurLocation().getOrientation() == Orientation.South){
        		currentVehicle.getCurLocation().setOrientation(Orientation.West);
        		currentVehicle.getCurLocation().getPoint().setX(920);
    			currentVehicle.getCurLocation().getPoint().setY(630);
        	}else if(currentVehicle.getCurLocation().getPoint().getX() == 0 && currentVehicle.getCurLocation().getOrientation() == Orientation.West){
        		currentVehicle.getCurLocation().setOrientation(Orientation.North);
        	}else if(currentVehicle.getCurLocation().getPoint().getY() == 0 && currentVehicle.getCurLocation().getOrientation() == Orientation.North){
        		currentVehicle.getCurLocation().setOrientation(Orientation.East);
        	}
        	currentVehicle.drawObject(g);
        	currentVehicle.move(currentVehicle.nextLocation());
        }
    }
	public static boolean thereVehicle(){
		return vehicleExists;
	}
	public void setVehicle(Vehicle vehicle){
		currentVehicle = vehicle;
		vehicleExists = true;
		repaint();
	}
}
