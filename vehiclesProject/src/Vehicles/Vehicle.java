package Vehicles;
import java.util.Random;
/**
 * A Vehicle abstract class.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public abstract class Vehicle {
	private static final int MIN_ID = 1000;
	private static final int MAX_ID = 1000000;
	private int ID;
	private Color color;
	private int numberOfWheels;
	private Location curLocation;
	private float KM;
	private boolean lights;
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
	 */
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
	/**
	 * Get Current Location.
	 * 
	 * @return Current Location.
	 */
	public Location getCurLocation(){return this.curLocation;}
	/**
	 * Change a vehicles Location,and kilometer.
	 * @param p
	 * 		  A Point object that describes the vehicle location.
	 * @return true, else false.
	 */
	public boolean drive(Point p){
		System.out.println("Vehicle drive");
		if(p == null)
			return false;
		this.KM += getCurLocation().getPoint().getDistance(p);
		getCurLocation().setPoint(p);
		return true;
	}
	/**
	 * Creates a string representation.
	 * 
	 * @return A string representation.
	 */
	@Override
	public String toString(){
		return " "+this.ID+" - [color:"+this.color+", number of wheels:"+this.numberOfWheels+", KM:"+this.KM+", current location:"+this.curLocation;
	}
	/**
	 * Set lights.
	 * 
	 * @return true.
	 */
	public boolean lightsOnOff(){this.lights = !this.lights; return true;}
	/**
	 * Get ID.
	 * 
	 * @return ID.
	 */
	public int getID(){return this.ID;}
	/**
	 * Set ID.
	 * 
	 * @param ID
	 * 		  The Vehicle ID.
	 * @return true,else if ID wrong - false.
	 */
	public boolean setID(int ID){
		if(ID < MIN_ID || ID > MAX_ID)
			return false;
		this.ID = ID;
		return true;
	}
	/**
	 * Get Random ID.
	 * 
	 * @return Random ID.
	 */
	public static int getRandomNumberID(){
		Random rand = new Random();
		return rand.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
	}
}
