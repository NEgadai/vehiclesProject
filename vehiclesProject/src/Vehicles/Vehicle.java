package Vehicles;
import graphics.CityPanel;
import graphics.IDrawable;
import graphics.IMoveable;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * A Vehicle abstract class.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public abstract class Vehicle implements IMoveable, IDrawable, Cloneable,IVehicle{
	private static final int MIN_ID = 1000;
	private static final int MAX_ID = 1000000;
	private static final int SIZE = 65;
	private static int count = MIN_ID;
	protected static final int MIN_AGE = 18;
	protected int id;
	protected Boolean lights;
	protected Color col;
	protected int wheels;
	protected Location loc;
	protected int fuelConsumption;
	protected CityPanel pan;
	protected final BufferedImage[] images = new BufferedImage[4];
	protected float Distance;
	/**
	 * A Class Constructor.
	 * 
	 * @param color
	 * 		  The Vehicle color.
	 * @param numberOfWheels
	 * 		  The number of wheels.
	 * @param pan
	 * 		  A CityPanel object.
	 */
	public Vehicle(Color color,int numberOfWheels,CityPanel pan){
		setID(count++);
		this.Distance = 0;
		this.col = color;
		this.wheels = numberOfWheels;
		this.lights = false;
		this.loc = new Location();
		this.pan = pan;
		loadImages();
	}
	/**
	 * Get Current Location.
	 * 
	 * @return Current Location.
	 */
	public Location getCurLocation(){return this.loc;}
	/**
	 * Change a vehicles Location,and kilometer.
	 * @param p
	 * 		  A Point object that describes the vehicle location.
	 * @return true, else false.
	 */
	public boolean drive(Point p){
		if(p == null)
			return false;
		this.Distance += getCurLocation().getPoint().getDistance(p);
		getCurLocation().setPoint(p);
		return true;
	}
	/**
	 * Creates a string representation.
	 * 
	 * @return A string representation.
	 */
	public String toString(){
		return " "+this.id+" - [color:"+this.col+", number of wheels:"+this.wheels+", KM:"+this.Distance+", current location:"+this.loc+", Fuel Consumption:"+this.fuelConsumption;
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
	public int getID(){return this.id;}
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
		this.id = ID;
		return true;
	}
	/**
	 * Get Wheels.
	 * 
	 * @return wheels.
	 */
	public int getWheels(){return this.wheels;}
	/**
	 * Get Color.
	 * 
	 * @return color.
	 */
	public String getColor() {return String.valueOf(this.col);}
	/**
	 * Get Distance.
	 * 
	 * @return Distance.
	 */
	public float getDistance(){return this.Distance;}
	/**
	 * Get Lights.
	 * 
	 * @return lights.
	 */
	public String getLights(){
		if(lights)
			return "On";
		return "Off";
	}
	/**
	 * Get Fuel Consumption.
	 * 
	 * @return fuel consumption.
	 */
	public int getFuelConsumption(){return this.fuelConsumption;}
	/**
	 * Add Fuel Consumption.
	 * 
	 * @param fuelConsumption
	 * 		  A fuel consumption.
	 */
	public void addFuelConsumption(int fuelConsumption){this.fuelConsumption = this.fuelConsumption + fuelConsumption;}
	/**
	 * A loader Images.
	 */
	public void loadImages() {
		for(int i=0;i<images.length;i++){
			try { images[i] = ImageIO.read(new File(PICTURE_PATH+String.valueOf(this.col).toLowerCase()+this.getSimpleVehicleName()+String.valueOf(Orientation.values()[i])+".png")); } 
			  catch (IOException e) { System.out.println("Cannot load image"); }
		}
	}
	/**
	 * Moving object on a road.
	 */
	public void move(Point p) {
		if(this.moveable()){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.drive(p);
		}
		pan.repaint();
	}
	/**
	 * Drawing object on a road.
	 */
	public void drawObject(Graphics g) {
		if(loc.getOrientation()==Orientation.North)
			g.drawImage(images[0], this.getCurLocation().getPoint().getX(), this.getCurLocation().getPoint().getY(), SIZE, SIZE*2, pan);
		else if(this.getCurLocation().getOrientation()==Orientation.South)
			g.drawImage(images[1], this.getCurLocation().getPoint().getX(), this.getCurLocation().getPoint().getY(), SIZE, SIZE*2, pan);
		else if(this.getCurLocation().getOrientation()==Orientation.East)
			g.drawImage(images[2], this.getCurLocation().getPoint().getX(), this.getCurLocation().getPoint().getY(), SIZE*2, SIZE, pan);
		else if(this.getCurLocation().getOrientation()==Orientation.West)
			g.drawImage(images[3], this.getCurLocation().getPoint().getX(), this.getCurLocation().getPoint().getY(), SIZE*2, SIZE, pan);
	}
	/**
	 * The next location of the object.
	 * 
	 * @return location.
	 */
	public Point nextLocation(){
		if(loc.getOrientation() == Orientation.East){
			return new Point(loc.getPoint().getX()+getSpeed(),loc.getPoint().getY());
		}else if(loc.getOrientation() == Orientation.North){
			return new Point(loc.getPoint().getX(),loc.getPoint().getY()-getSpeed());
		}else if(loc.getOrientation() == Orientation.West){
			return new Point(loc.getPoint().getX()-getSpeed(),loc.getPoint().getY());
		}else if(loc.getOrientation() == Orientation.South){
			return new Point(loc.getPoint().getX(),loc.getPoint().getY()+getSpeed());
		}
		return loc.getPoint();
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
