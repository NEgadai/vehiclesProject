package Vehicles;

import graphics.CityPanel;

/**
 * A class inherits from Vehicle, and represents a Carriage.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class Carriage extends Vehicle {
	private PackAnimal packAnimal = null;
	private static final int NUMBER_OF_WHEELS = 4;
	private static final int Speed = 1;
//	private static final int numberOfPassengers = 2;
	public Carriage(Color color,CityPanel pan){
		super(color,NUMBER_OF_WHEELS,pan);
		packAnimal = new PackAnimal("Dogs");//Meanwhile, the default is dogs. but in the next exercise i believe we'll need to get from the user the name of the animal.
	}
	@Override
	public String toString(){
		return this.getClass().getSimpleName()+super.toString()+", animal:"+this.packAnimal+"]";
	}
	@Override
	public String getVehicleName() {return this.getClass().getSimpleName();}
	@Override
	public int getSpeed() {return Speed;}
	@Override
	public String getSimpleVehicleName() {return this.getClass().getSimpleName();}
	@Override
	public boolean moveable() {
		if(this.packAnimal.getEnergy() > 0)
			return true;
		return false;
		}
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
	@Override
	public float getFuel() {return this.packAnimal.getEnergy();}
	@Override
	public boolean Refuel() {
		this.packAnimal.ReEnergy();
		this.fuelConsumption += this.packAnimal.getEnergy();
		return true;
	}
	public boolean drive(Point p){
		this.packAnimal.eat();
		return super.drive(p);
	}
}
