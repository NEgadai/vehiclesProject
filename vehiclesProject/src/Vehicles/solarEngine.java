package Vehicles;
/**
 * A class inherits from Engine, and represents a solar engine.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class solarEngine extends Engine {
	private static final int literPerKM = 1;
	public solarEngine(int fuelTankCapacity){
		super(fuelTankCapacity);
	}
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
	public int getLiterPerKM(){return literPerKM;}
}
