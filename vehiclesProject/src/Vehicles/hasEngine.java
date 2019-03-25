package Vehicles;

public abstract class hasEngine extends Vehicle {
	private Engine engine;
	private float fuel;
	private int minimumAge;
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
	public boolean Refuel(){
		if (this.engine.getFuelTankCapacity() == this.fuel)
			return false;
		else{
			fuel = this.engine.getFuelTankCapacity();
			return true;
		}
	}
	@Override
	public String toString(){
		return super.toString()+",Engine:"+engine+", Current Fuel:"+this.fuel+", Minimum Age:"+this.minimumAge;
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
		this.setFuel(this.getFuel()-dis*this.engine.getFuelConsumption());
		System.out.println("hasEngine drive");
		return true;
	}
}
