package Vehicles;

import graphics.CityPanel;


/**
 * A class inherits from hasEngine, and represents a Car.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class Car extends hasEngine {
//	private static final int MAX_FUEL_CAPACITY = 40;
	/**
	 * The number of wheels.
	 */
	private static final int NUMBER_OF_WHEELS = 4;
	/**
	 * The Car speed.
	 */
	private static final int Speed = 4;
	/**
	 * The number of passengers.
	 */
	private static final int numberOfPassengers = 5;
	/**
	 * A Class Constructor.
	 * 
	 * @param color
	 * 		  The Car color.
	 * @param engine
	 * 		  An engine object.
	 * @param pan
	 * 		  A CityPanel object.
	 */
	public Car(Color color,Engine engine,CityPanel pan){
		super(color,engine,NUMBER_OF_WHEELS,pan);
	}
	/**
	 * Creates a string representation.
	 * 
	 * @return A string representation.
	 */
	@Override
	public String toString(){
		return this.getClass().getSimpleName()+super.toString()+", number of passengers:"+numberOfPassengers+"]";
	}
	/**
	 * Get Vehicle Name.
	 * 
	 * @return Vehicle Name.
	 */
	@Override
	public String getVehicleName() {
		if(this.getEngine() instanceof solarEngine)
			return "Solar "+this.getClass().getSimpleName();
		else
			return "Benzine "+this.getClass().getSimpleName();
	}
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
	 * Clone Object.
	 * 
	 * @return New copy of this object.
	 */
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
}
