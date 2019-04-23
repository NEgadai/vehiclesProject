package Vehicles;

import graphics.CityPanel;


/**
 * A class inherits from Vehicle, and represents a Bike.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class Bike extends Vehicle {
	private static final int Speed = 4;
	private int numberOfGears;
//	private static final int numberOfPassengers = 1;
	private static final int numberOfWheels = 2;
	public Bike(Color color,int numberOfGears,CityPanel pan){
		super(color,numberOfWheels,pan);
		this.numberOfGears = numberOfGears;
	}
	@Override
	public String toString(){
		return this.getClass().getSimpleName()+super.toString()+", number of gears:"+this.numberOfGears+"]";
	}
	@Override
	public String getVehicleName() {return this.getClass().getSimpleName();}
	@Override
	public int getSpeed() {return Speed;}
	@Override
	public String getSimpleVehicleName() {return this.getClass().getSimpleName();}
	@Override
	public boolean moveable() {return true;}
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
	@Override
	public float getFuel() {
		return 0;
	}
	public boolean Refuel(){return true;}
}
