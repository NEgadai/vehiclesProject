package Vehicles;
/**
 * A Engine abstract class.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public abstract class Engine implements IEngine {
	private int fuelTankCapacity;
	/**
	 * A Class Constructor.
	 * 
	 * @param fuelTankCapacity
	 * 		  The fuel capacity.
	 */
	public Engine(int fuelTankCapacity){
		this.fuelTankCapacity = fuelTankCapacity;
	}
	/**
	 * Creates a string representation.
	 * 
	 * @return A string representation.
	 */
	@Override
	public String toString(){
		return "[Type:"+this.getClass().getSimpleName()+", Fuel Tank Capacity:"+this.fuelTankCapacity+"]";
	}
	/**
	 * Get fuel capacity.
	 * 
	 * @return fuel capacity.
	 */
	public int getFuelTankCapacity(){return this.fuelTankCapacity;}
}
