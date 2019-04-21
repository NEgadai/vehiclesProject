package Vehicles;

public interface IVehicle {
	public String getVehicleName();
	public int getID();
	public String getColor();
	public int getWheels();
	public int getSpeed();
	public float getFuel();
	public float getDistance();
	public int getFuelConsumption();
	public String getLights();
	public Object clone() throws CloneNotSupportedException;
	public boolean Refuel();
}
