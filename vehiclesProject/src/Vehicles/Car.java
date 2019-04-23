package Vehicles;

import graphics.CityPanel;


/**
 * A class inherits from hasEngine, and represents a Car.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class Car extends hasEngine {
//	private static final int MAX_FUEL_CAPACITY = 40;
	private static final int NUMBER_OF_WHEELS = 4;
	private static final int Speed = 4;
	private static final int numberOfPassengers = 5;
	public Car(Color color,Engine engine,CityPanel pan){
		super(color,engine,NUMBER_OF_WHEELS,pan);
	}
	@Override
	public String toString(){
		return this.getClass().getSimpleName()+super.toString()+", number of passengers:"+numberOfPassengers+"]";
	}
	@Override
	public String getVehicleName() {
		if(this.getEngine() instanceof solarEngine)
			return "Solar "+this.getClass().getSimpleName();
		else
			return "Benzine "+this.getClass().getSimpleName();
	}
	@Override
	public int getSpeed() {return Speed;}
	@Override
	public String getSimpleVehicleName() {return this.getClass().getSimpleName();}
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
}
