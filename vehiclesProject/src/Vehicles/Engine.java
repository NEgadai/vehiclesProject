package Vehicles;
/**
 * A Engine abstract class.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public abstract class Engine {
//	private int fuelConsumption;
	private int fuelTankCapacity;
	public Engine(int fuelTankCapacity){
		this.fuelTankCapacity = fuelTankCapacity;
//		this.fuelConsumption = 0;
	}
	@Override
	public String toString(){
		return "[Type:"+this.getClass().getSimpleName()+", Fuel Tank Capacity:"+this.fuelTankCapacity+"]";
	}
//	public void addFuelConsumption(int fuelConsumption){this.fuelConsumption = this.fuelConsumption + fuelConsumption;}
	public int getFuelTankCapacity(){return this.fuelTankCapacity;}
//	public int getFuelConsumption(){return this.fuelConsumption;}
}
