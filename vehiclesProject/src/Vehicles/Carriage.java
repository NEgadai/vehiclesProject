package Vehicles;

import java.awt.Graphics;

/**
 * A class inherits from Vehicle, and represents a Carriage.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class Carriage extends Vehicle {
	private PackAnimal packAnimal = null;
	private static final int NUMBER_OF_WHEELS = 4;
	private static int speed = 1;
	public Carriage(int ID, Color color, float KM, String animal){
		super(ID,color,NUMBER_OF_WHEELS,KM);
		this.packAnimal = packAnimal;
	}
	@Override
	public String toString(){
		return this.getClass().getSimpleName()+super.toString()+", animal:"+this.packAnimal+"]";
	}
	@Override
	public String getVehicleName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getFuelConsumption() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean move(Point p) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void loadImages(String nm) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void drawObject(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}
}
