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
	public hasEngine(Color color,Engine engine,int numberOfWheels,CityPanel pan){
		super(color,numberOfWheels,pan);
		if (engine instanceof solarEngine)
			this.engine = new solarEngine(engine.getFuelTankCapacity());
		else { if (engine instanceof benzineEngine)
			this.engine = new benzineEngine(engine.getFuelTankCapacity());
		}
		Refuel();
	}
	public boolean Refuel(){
		if (this.engine.getFuelTankCapacity() == this.fuel)
			return false;
		else{
			setFuel(this.engine.getFuelTankCapacity());
			this.fuelConsumption += this.engine.getFuelTankCapacity();
			return true;
		}
	}
	@Override
	public String toString(){
		return super.toString()+",Engine:"+engine+", Current Fuel:"+this.fuel;
	}
	public Engine getEngine(){return this.engine;}
	public float getFuel(){return this.fuel;}
	public boolean setFuel(float fuel){
		this.fuel = fuel;
		return true;
	}
	@Override
	public boolean drive(Point p){
		float dis = this.getCurLocation().getPoint().getDistance(p);
		if(!super.drive(p)) return false;
		this.setFuel(this.getFuel()-dis);
		return true;
	}
	public boolean moveable(){
		return this.fuel>0;
	}
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
}
