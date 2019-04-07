package Vehicles;

import java.awt.Graphics;

/**
 * A class inherits from Vehicle, and represents a Bike.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class Bike extends Vehicle {
	/**
	 * The Bike speed.
	 */
	private static int Speed = 2;
	private int numberOfGears;
	/**
	 * A Class Constructor.
	 * 
	 * @param ID
	 * 		  The Bike ID.
	 * @param color
	 * 		  The Bike Color.
	 * @param numberOfWheels
	 * 		  The number of wheels.
	 * @param KM
	 * 		  The number of kilometers.
	 * @param numberOfGears
	 * 		  The number of gears.
	 */
	public Bike(int ID, Color color, int numberOfWheels, float KM,int numberOfGears){
		super(ID,color,numberOfWheels,KM);
		this.numberOfGears = numberOfGears;
	}
	/**
	 * Creates a string representation.
	 * 
	 * @return A string representation.
	 */
	@Override
	public String toString(){
		return this.getClass().getSimpleName()+super.toString()+", number of gears:"+this.numberOfGears+"]";
	}
	@Override
	public String getVehicleName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getFuelConsumption() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean move(Point p) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void loadImages(String nm) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void drawObject(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}
}
