package graphics;

import Vehicles.Point;

public interface IMoveable {
	public String getVehicleName();
	public String getSimpleVehicleName();
	public int getSpeed();
	public int getFuelConsumption();
	public void move(Point p);
	public boolean moveable();
}
