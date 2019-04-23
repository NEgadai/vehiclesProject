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
	private static final long serialVersionUID = 1L;
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
        g.drawImage(background, 0, 0,getSize().width, getSize().height,0, 0, background.getWidth(), background.getHeight(), this);//set the background in 0,0 location (drawing the background)
        if(thereVehicle()){
        	infoPanel.setVehicle(currentVehicle);
        	int Speed = currentVehicle.getSpeed(), size = 65-65%Speed;
        	int endX = (int)backgroundSize.getWidth()-size*3, endY = (int)backgroundSize.getHeight()-size*4,middleY = (int)backgroundSize.getHeight()/2-size*2;
        	endX = endX-endX%Speed;
        	endY = endY-endY%Speed;
        	middleY = middleY-middleY%Speed;
        	Random rand = new Random();
        	if(currentVehicle.getCurLocation().getPoint().getX() == endX && currentVehicle.getCurLocation().getOrientation() == Orientation.East){
        		currentVehicle.getCurLocation().setOrientation(Orientation.South);
        		currentVehicle.getCurLocation().setPoint(new Point((int)(endX+size*1.5),currentVehicle.getCurLocation().getPoint().getY()+size));
        	}else if(currentVehicle.getCurLocation().getPoint().getY() == middleY && currentVehicle.getCurLocation().getOrientation() == Orientation.South){
        		if(rand.nextBoolean()){
        			currentVehicle.getCurLocation().setOrientation(Orientation.West);
        			currentVehicle.getCurLocation().setPoint(new Point(endX,middleY+size));
        		}
        	}else if(currentVehicle.getCurLocation().getPoint().getY() == endY && currentVehicle.getCurLocation().getOrientation() == Orientation.South){
        		currentVehicle.getCurLocation().setOrientation(Orientation.West);
        		currentVehicle.getCurLocation().setPoint(new Point(endX,(int)(endY+size*1.5)));
        	}else if(currentVehicle.getCurLocation().getPoint().getX() == size && currentVehicle.getCurLocation().getOrientation() == Orientation.West){
        		currentVehicle.getCurLocation().setOrientation(Orientation.North);
        		currentVehicle.getCurLocation().setPoint(new Point(0,currentVehicle.getCurLocation().getPoint().getY()-size));
        	}else if(currentVehicle.getCurLocation().getPoint().getY() == middleY+size && currentVehicle.getCurLocation().getOrientation() == Orientation.North){
        		if(rand.nextBoolean()){
        			currentVehicle.getCurLocation().setOrientation(Orientation.East);
            		currentVehicle.getCurLocation().setPoint(new Point(size,middleY+size));
        		}
        	}else if(currentVehicle.getCurLocation().getPoint().getY() == size && currentVehicle.getCurLocation().getOrientation() == Orientation.North){
        		currentVehicle.getCurLocation().setOrientation(Orientation.East);
        		currentVehicle.getCurLocation().setPoint(new Point(size,0));
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
	public Vehicle getVehicle(){return currentVehicle;}
	public void removeVehicle(){
		currentVehicle = null;
		vehicleExists = false;
		repaint();
	}
}
