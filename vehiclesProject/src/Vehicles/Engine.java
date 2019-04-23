package Vehicles;
/**
 * A Engine abstract class.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public abstract class Engine implements IEngine {
	private int fuelTankCapacity;
	public Engine(int fuelTankCapacity){
		this.fuelTankCapacity = fuelTankCapacity;
	}
	@Override
	public String toString(){
		return "[Type:"+this.getClass().getSimpleName()+", Fuel Tank Capacity:"+this.fuelTankCapacity+"]";
	}
	public int getFuelTankCapacity(){return this.fuelTankCapacity;}
}
