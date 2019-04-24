package graphics;

import Vehicles.Point;
/**
 * A Moveable Interface.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public interface IMoveable {
	public String getVehicleName();
	public String getSimpleVehicleName();
	public int getSpeed();
	public int getFuelConsumption();
	public void move(Point p);
	public boolean moveable();
}
