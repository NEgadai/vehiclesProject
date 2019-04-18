package Vehicles;

import graphics.CityPanel;

import java.awt.Graphics;

/**
 * A class inherits from Vehicle, and represents a Carriage.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class Carriage extends Vehicle {
	private PackAnimal packAnimal = null;
	private static final int NUMBER_OF_WHEELS = 4;
	private static int Speed = 1;
	private static final int numberOfPassengers = 2;
	public Carriage(Color color,CityPanel pan){
		super(color,NUMBER_OF_WHEELS,pan);
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
	public boolean moveable() {return true;}
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
}
