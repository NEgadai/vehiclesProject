package Vehicles;

import java.awt.Graphics;

/**
 * A class inherits from hasEngine, and represents a Car.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class Car extends hasEngine {
	private static final int MAX_FUEL_CAPACITY = 40;
	private static final int NUMBER_OF_WHEELS = 4;
	private static int Speed = 4;
	private int numberOfPassengers;
	/**
	 * A Class Constructor.
	 * 
	 * @param ID
	 * 		  The Car ID.
	 * @param color
	 * 		  The Car color.
	 * @param KM
	 * 		  The number of kilometers.
	 * @param engine
	 * 		  An engine object.
	 * @param minimumAge
	 * 		  The minimum age allowed.
	 * @param numberOfPassengers
	 * 		  The number of allowed passengers.
	 */
	public Car(int ID, Color color, float KM,Engine engine,int minimumAge,int numberOfPassengers){
		super(ID,color,NUMBER_OF_WHEELS,KM,engine,MAX_FUEL_CAPACITY,minimumAge);
		this.numberOfPassengers = numberOfPassengers;
	}
	/**
	 * Creates a string representation.
	 * 
	 * @return A string representation.
	 */
	@Override
	public String toString(){
		return this.getClass().getSimpleName()+super.toString()+", number of passengers:"+this.numberOfPassengers+"]";
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
