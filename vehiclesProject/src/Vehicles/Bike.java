package Vehicles;

import graphics.CityPanel;


/**
 * A class inherits from Vehicle, and represents a Bike.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class Bike extends Vehicle {
	/**
	 * The Bike speed.
	 */
	private static final int Speed = 4;
	private int numberOfGears;
//	private static final int numberOfPassengers = 1;
	/**
	 * The number of wheels.
	 */
	private static final int numberOfWheels = 2;
	/**
	 * A Class Constructor.
	 * 
	 * @param color
	 * 		  The Bike Color.
	 * @param numberOfGears
	 * 		  The number of gears.
	 * @param pan
	 * 		  A CityPanel object.
	 */
	public Bike(Color color,int numberOfGears,CityPanel pan){
		super(color,numberOfWheels,pan);
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
	/**
	 * Get Vehicle Name.
	 * 
	 * @return Vehicle name.
	 */
	@Override
	public String getVehicleName() {return this.getClass().getSimpleName();}
	/**
	 * Get Speed.
	 * 
	 * @return Speed.
	 */
	@Override
	public int getSpeed() {return Speed;}
	/**
	 * Get Simple Vehicle Name.
	 * 
	 * @return Simple Vehicle Name.
	 */
	@Override
	public String getSimpleVehicleName() {return this.getClass().getSimpleName();}
	/**
	 * Moveable.
	 * 
	 * @return true.
	 */
	@Override
	public boolean moveable() {return true;}
	/**
	 * Clone Object.
	 * 
	 * @return New copy of this object.
	 */
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
	/**
	 * Get Fuel.
	 * 
	 * @return Fuel.
	 */
	@Override
	public float getFuel() {
		return 0;
	}
	/**
	 * Refuel.
	 * 
	 * @return true.
	 */
	public boolean Refuel(){return true;}
}
