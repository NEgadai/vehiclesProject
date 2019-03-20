package Vehicles;

public abstract class Engine {
	private int fuelConsumption;
	private int fuelTankCapacity;
	public Engine(int fuelConsumption, int fuelTankCapacity){
		this.fuelConsumption = fuelConsumption;
		this.fuelTankCapacity = fuelTankCapacity;
	}
	@Override
	public String toString(){
		return "";
	}
	public int getFuelTankCapacity(){return this.fuelTankCapacity;}
	public int getFuelConsumption(){return this.fuelConsumption;}
}
