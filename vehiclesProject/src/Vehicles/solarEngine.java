package Vehicles;
/**
 * A class inherits from Engine, and represents a solar engine.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class solarEngine extends Engine {
	private static final int FUEL_CONSUMPTION = 6;
	/**
	 * A Class Constructor.
	 * 
	 * @param fuelTankCapacity
	 * 		  The fuel capacity.
	 */
	public solarEngine(int fuelTankCapacity){
		super(FUEL_CONSUMPTION,fuelTankCapacity);
	}

}
