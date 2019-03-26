package Vehicles;
/**
 * A abstract class inherits from Vehicle, and represents a hasEngine.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public abstract class hasEngine extends Vehicle {
	private Engine engine;
	private float fuel;
	private int minimumAge;
	/**
	 * A Class Constructor.
	 * 
	 * @param ID
	 * 		  The Vehicle ID.
	 * @param color
	 * 		  The Vehicle color.
	 * @param numberOfWheels
	 * 		  The number of wheels.
	 * @param KM
	 * 		  The number of kilometers.
	 * @param engine
	 * 		  An engine object.
	 * @param fuel
	 * 		  The fuel in the vehicle.
	 * @param minimumAge
	 * 		  The minimum age allowed.
	 */
	public hasEngine(int ID, Color color, int numberOfWheels, float KM,Engine engine,int fuel,int minimumAge){
		super(ID,color,numberOfWheels,KM);
		if (engine instanceof solarEngine)
			this.engine = new solarEngine(engine.getFuelTankCapacity());
		else { if (engine instanceof benzineEngine)
			this.engine = new benzineEngine(engine.getFuelTankCapacity());
		}
		this.fuel = fuel;
		this.minimumAge = minimumAge;
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
			fuel = this.engine.getFuelTankCapacity();
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
		return super.toString()+",Engine:"+engine+", Current Fuel:"+this.fuel+", Minimum Age:"+this.minimumAge;
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
		this.setFuel(this.getFuel()-dis*this.engine.getFuelConsumption());
		System.out.println("hasEngine drive");
		return true;
	}
}
