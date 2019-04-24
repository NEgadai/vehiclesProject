package Vehicles;
/**
 * A class inherits from Engine, and represents a solar engine.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class solarEngine extends Engine {
	private static final int literPerKM = 1;
	/**
	 * A Class Constructor.
	 * 
	 * @param fuelTankCapacity
	 * 		  The fuel capacity.
	 */
	public solarEngine(int fuelTankCapacity){
		super(fuelTankCapacity);
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
	 * Get Liter per kilometer.
	 * 
	 * @return Liter per kilometer.
	 */
	public int getLiterPerKM(){return literPerKM;}
}
