package Vehicles;
/**
 * A class inherits from Engine, and represents a benzine engine.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class benzineEngine extends Engine {
	private static final int literPerKM = 2;
	/**
	 * A Class Constructor.
	 * 
	 * @param fuelTankCapacity
	 * 		  The fuel capacity.
	 */
	public benzineEngine(int fuelTankCapacity){
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
