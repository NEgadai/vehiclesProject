package Vehicles;
/**
 * A Engine abstract class.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public abstract class Engine {
	private int fuelConsumption;
	private int fuelTankCapacity;
	/**
	 * A Class Constructor.
	 * 
	 * @param fuelConsumption
	 * 		  The fuel consumption.
	 * @param fuelTankCapacity
	 * 		  The fuel capacity.
	 */
	public Engine(int fuelConsumption, int fuelTankCapacity){
		this.fuelConsumption = fuelConsumption;
		this.fuelTankCapacity = fuelTankCapacity;
	}
	/**
	 * Creates a string representation.
	 * 
	 * @return A string representation.
	 */
	@Override
	public String toString(){
		return "[Type:"+this.getClass().getSimpleName()+", Fuel Consumption:"+this.fuelConsumption+", Fuel Tank Capacity:"+this.fuelTankCapacity+"]";
	}
	/**
	 * Get fuel capacity.
	 * 
	 * @return fuel capacity.
	 */
	public int getFuelTankCapacity(){return this.fuelTankCapacity;}
	/**
	 * Get fuel consumption.
	 * 
	 * @return fuel consumption.
	 */
	public int getFuelConsumption(){return this.fuelConsumption;}
}
