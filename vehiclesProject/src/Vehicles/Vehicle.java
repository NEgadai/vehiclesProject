package Vehicles;

import java.util.Random;

public abstract class Vehicle {
	private static final int MIN_ID = 1000;
	private static final int MAX_ID = 1000000;
	private int ID;
	private Color color;
	private int numberOfWheels;
	private Location curLocation;
	private float KM;
	private boolean lights;
	public Vehicle(int ID, Color color, int numberOfWheels, float KM){
		if(!setID(ID)){
			this.ID = getRandomNumberID();
			System.out.println("The ID number which you entered for this vehicle is not valid.\nThe car was get a random id and the ID is: "+this.ID+"\n");
		}
		this.color = color;
		this.numberOfWheels = numberOfWheels;
		this.KM = KM;
		this.lights = false;
		this.curLocation = new Location();
	}
	public Location getCurLocation(){return this.curLocation;}
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
		return " "+this.ID+" - [color:"+this.color+", number of wheels:"+this.numberOfWheels+", KM:"+this.KM+", current location:"+this.curLocation;
	}
	public boolean lightsOnOff(){this.lights = !this.lights; return true;}
	public int getID(){return this.ID;}
	public boolean setID(int ID){
		if(ID < MIN_ID || ID > MAX_ID)
			return false;
		this.ID = ID;
		return true;
	}
	public static int getRandomNumberID(){
		Random rand = new Random();
		return rand.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
	}
}
