package Vehicles;

import graphics.CityPanel;
import graphics.infoPanel;

import java.awt.Dimension;
import java.util.Random;

public class vehicleThread extends Thread {
	private static final Dimension backgroundSize = CityPanel.getBackgroundSize();
	private Vehicle vehicle;
	public vehicleThread(Vehicle vehicle){
		this.vehicle = vehicle;
	}
	public Vehicle getVehicle(){return this.vehicle;}
	public void locationConfiguration(){
		int Speed = vehicle.getSpeed(), size = 65-65%Speed;
    	int endX = (int)backgroundSize.getWidth()-size*3, endY = (int)backgroundSize.getHeight()-size*4,middleY = (int)backgroundSize.getHeight()/2-size*2;
    	endX = endX-endX%Speed;
    	endY = endY-endY%Speed;
    	middleY = middleY-middleY%Speed;
    	Random rand = new Random();
    	if(vehicle.getCurLocation().getPoint().getX() == endX && vehicle.getCurLocation().getOrientation() == Orientation.East){
    		vehicle.getCurLocation().setOrientation(Orientation.South);
    		vehicle.getCurLocation().setPoint(new Point((int)(endX+size*1.5),vehicle.getCurLocation().getPoint().getY()+size));
    	}else if(vehicle.getCurLocation().getPoint().getY() == middleY && vehicle.getCurLocation().getOrientation() == Orientation.South){
    		if(rand.nextBoolean()){
    			vehicle.getCurLocation().setOrientation(Orientation.West);
    			vehicle.getCurLocation().setPoint(new Point(endX,middleY+size));
    		}
    	}else if(vehicle.getCurLocation().getPoint().getY() == endY && vehicle.getCurLocation().getOrientation() == Orientation.South){
    		vehicle.getCurLocation().setOrientation(Orientation.West);
    		vehicle.getCurLocation().setPoint(new Point(endX,(int)(endY+size*1.5)));
    	}else if(vehicle.getCurLocation().getPoint().getX() == size && vehicle.getCurLocation().getOrientation() == Orientation.West){
    		vehicle.getCurLocation().setOrientation(Orientation.North);
    		vehicle.getCurLocation().setPoint(new Point(0,vehicle.getCurLocation().getPoint().getY()-size));
    	}else if(vehicle.getCurLocation().getPoint().getY() == middleY+size && vehicle.getCurLocation().getOrientation() == Orientation.North){
    		if(rand.nextBoolean()){
    			vehicle.getCurLocation().setOrientation(Orientation.East);
    			vehicle.getCurLocation().setPoint(new Point(size,middleY+size));
    		}
    	}else if(vehicle.getCurLocation().getPoint().getY() == size && vehicle.getCurLocation().getOrientation() == Orientation.North){
    		vehicle.getCurLocation().setOrientation(Orientation.East);
    		vehicle.getCurLocation().setPoint(new Point(size,0));
    	}
	}
	@Override
	public void run() {
		while(isAlive()){
			locationConfiguration();
			vehicle.move(vehicle.nextLocation());
			infoPanel.setVehicle(vehicle);
			int overlapID = vehicle.overlapVehicle();
			if(overlapID != -1){
				try {
		            Thread.sleep(100);
		         } 
				catch (Exception e) {
					System.out.println(e);
		         }
				vehicle.getCity().overlapVehicles(vehicle.getID(), overlapID);
				break;
			}
		}
	}
}
