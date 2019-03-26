package Vehicles;
/**
 * A class inherits from Engine, and represents a benzine engine.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class benzineEngine extends Engine {
	private static final int FUEL_CONSUMPTION = 9;
	/**
	 * A Class Constructor.
	 * 
	 * @param fuelTankCapacity
	 * 		  The fuel capacity.
	 */
	public benzineEngine(int fuelTankCapacity){
		super(FUEL_CONSUMPTION,fuelTankCapacity);
		
	}
}
