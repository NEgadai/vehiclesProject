package Vehicles;

import graphics.CityPanel;

/**
 * A abstract class inherits from Vehicle, and represents a hasEngine.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public abstract class hasEngine extends Vehicle {
	private Engine engine;
	private float fuel;
	/**
	 * A Class Constructor.
	 * 
	 * @param color
	 * 		  The Vehicle color.
	 * @param engine
	 * 		  An engine object.
	 * @param numberOfWheels
	 * 		  The number of wheels.
	 * @param pan
	 * 		  A CityPanel object.
	 */
	public hasEngine(Color color,Engine engine,int numberOfWheels,CityPanel pan){
		super(color,numberOfWheels,pan);
		if (engine instanceof solarEngine)
			this.engine = new solarEngine(engine.getFuelTankCapacity());
		else { if (engine instanceof benzineEngine)
			this.engine = new benzineEngine(engine.getFuelTankCapacity());
		}
		Refuel();
	}
	/**
	 * Update fuel to maximum quantity if doesn't full.
	 * 
	 * @return true, else false if full.
	 */
	public boolean Refuel(){
		if (this.engine.getFuelTankCapacity() == this.fuel)
			return false;
		else{
			setFuel(this.engine.getFuelTankCapacity());
			this.fuelConsumption += this.engine.getFuelTankCapacity();
			return true;
		}
	}
	/**
	 * Creates a string representation.
	 * 
	 * @return A string representation.
	 */
	@Override
	public String toString(){
		return super.toString()+",Engine:"+engine+", Current Fuel:"+this.fuel;
	}
	/**
	 * Get for the engine.
	 * 
	 * @return An engine object.
	 */
	public Engine getEngine(){return this.engine;}
	/**
	 * Get for the fuel.
	 * 
	 * @return The fuel.
	 */
	public float getFuel(){return this.fuel;}
	/**
	 * Set for fuel.
	 * @param fuel
	 * 		  The fuel in the vehicle.
	 * @return true.
	 */
	public boolean setFuel(float fuel){
		this.fuel = fuel;
		return true;
	}
	/**
	 * Vehicle travels to the new location, and update fuel consumption.
	 * 
	 * @param p
	 * 		  A Point object that describes the vehicle location.
	 * 
	 * @return true if the vehicle moved, else false.
	 */
	@Override
	public boolean drive(Point p){
		float dis = this.getCurLocation().getPoint().getDistance(p);
		if(!super.drive(p)) return false;
		this.setFuel(this.getFuel()-dis*engine.getLiterPerKM());
		return true;
	}
	/**
	 * Moveable.
	 * 
	 * @return true.
	 */
	public boolean moveable(){
		return this.fuel>0;
	}
	/**
	 * Clone Object.
	 * 
	 * @return New copy of this object.
	 */
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
}
