package Vehicles;

import graphics.CityPanel;

/**
 * A class inherits from Vehicle, and represents a Carriage.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class Carriage extends Vehicle {
	private PackAnimal packAnimal = null;
	/**
	 * The number of wheels.
	 */
	private final int Durabilit = 4;
	private static final int NUMBER_OF_WHEELS = 4;
	/**
	 * The Carriage speed.
	 */
	private static final int Speed = 1;
//	private static final int numberOfPassengers = 2;
	/**
	 * A Class Constructor.
	 * 
	 * @param color
	 * 		  The Carriage color.
	 * @param pan
	 * 		  A CityPanel object.
	 */
	public Carriage(Color color,CityPanel pan){
		super(color,NUMBER_OF_WHEELS,pan);
		packAnimal = new PackAnimal("Dogs");//Meanwhile, the default is dogs. but in the next exercise i believe we'll need to get from the user the name of the animal.
	}
	/**
	 * Creates a string representation.
	 * 
	 * @return A string representation.
	 */
	@Override
	public String toString(){
		return this.getClass().getSimpleName()+super.toString()+", animal:"+this.packAnimal+"]";
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
	public boolean moveable() {
		if(this.packAnimal.getEnergy() > 0)
			return true;
		return false;
		}
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
	public float getFuel() {return this.packAnimal.getEnergy();}
	/**
	 * Refuel.
	 * 
	 * @return true.
	 */
	@Override
	public boolean Refuel() {
		this.packAnimal.ReEnergy();
		this.fuelConsumption += this.packAnimal.getEnergy();
		return true;
	}
	/**
	 * Drive.
	 * 
	 * @param p
	 * 		  A Point object.
	 * @return coordinates.
	 */
	public boolean drive(Point p){
		this.packAnimal.eat();
		return super.drive(p);
	}
	@Override
	public int getDurability() {
		return Durabilit;
	}
}
