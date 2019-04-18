package Vehicles;
/**
 * A class inherits from Engine, and represents a solar engine.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class solarEngine extends Engine {
	public solarEngine(int fuelTankCapacity){
		super(fuelTankCapacity);
	}
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
}
