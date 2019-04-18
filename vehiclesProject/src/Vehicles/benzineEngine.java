package Vehicles;
/**
 * A class inherits from Engine, and represents a benzine engine.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class benzineEngine extends Engine {
	public benzineEngine(int fuelTankCapacity){
		super(fuelTankCapacity);
		
	}
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
}
