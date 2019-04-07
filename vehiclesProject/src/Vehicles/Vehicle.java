package Vehicles;
import graphics.CityPanel;
import graphics.IDrawable;
import graphics.IMoveable;

import java.awt.image.BufferedImage;
import java.util.Random;
/**
 * A Vehicle abstract class.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public abstract class Vehicle implements IMoveable, IDrawable, Cloneable{
	private static final int MIN_ID = 1000;
	private static final int MAX_ID = 1000000;
	protected int size;
	protected int id;
	protected Boolean lights;
	protected Color col;
	protected int wheels;
	protected Location loc;
	protected int fuelConsumption;
	protected CityPanel pan;
	protected BufferedImage img1, img2, img3, img4;
	protected float KM;
	public Vehicle(int ID, Color color, int numberOfWheels, float KM){
		if(!setID(ID)){
			this.id = getRandomNumberID();
			System.out.println("The ID number which you entered for this vehicle is not valid.\nThe car was get a random id and the ID is: "+this.id+"\n");
		}
		this.col = color;
		this.wheels = numberOfWheels;
		this.KM = KM;
		this.lights = false;
		this.loc = new Location();
	}
	public Location getCurLocation(){return this.loc;}
	public boolean drive(Point p){
		System.out.println("Vehicle drive");
		if(p == null)
			return false;
		this.KM += getCurLocation().getPoint().getDistance(p);
		getCurLocation().setPoint(p);
		return true;
	}
	@Override
	public String toString(){
		return " "+this.id+" - [color:"+this.col+", number of wheels:"+this.wheels+", KM:"+this.KM+", current location:"+this.loc;
	}
	public boolean lightsOnOff(){this.lights = !this.lights; return true;}
	public int getID(){return this.id;}
	public boolean setID(int ID){
		if(ID < MIN_ID || ID > MAX_ID)
			return false;
		this.id = ID;
		return true;
	}
	public static int getRandomNumberID(){
		Random rand = new Random();
		return rand.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
	}
}
