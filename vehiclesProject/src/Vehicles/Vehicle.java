package Vehicles;
import graphics.CityPanel;
import graphics.IDrawable;
import graphics.IMoveable;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
/**
 * A Vehicle abstract class.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public abstract class Vehicle implements IMoveable, IDrawable, Cloneable{
	private static final int MIN_AGE = 18;
	private static final int MIN_ID = 1000;
	private static final int MAX_ID = 1000000;
	private static int count = MIN_ID;
	protected final int size = 65;
	protected int id;
	protected Boolean lights;
	protected Color col;
	protected int wheels;
	protected Location loc;
	protected int fuelConsumption;
	protected CityPanel pan;
	protected BufferedImage[] images = new BufferedImage[4];
//	protected BufferedImage img1 = null, img2 = null, img3 = null, img4 = null;
	protected float KM;
	public Vehicle(Color color,int numberOfWheels,CityPanel pan){
		setID(count++);
		this.KM = 0;
		this.col = color;
		this.wheels = numberOfWheels;
		this.lights = false;
		this.loc = new Location();
		this.pan = pan;
		loadImages();
//		System.out.println(PICTURE_PATH+String.valueOf(this.col).toLowerCase()+this.getSimpleVehicleName()+String.valueOf(Orientation.values()[0])+".png");
	}
	public Location getCurLocation(){return this.loc;}
	public boolean drive(Point p){
		if(p == null)
			return false;
		this.KM += getCurLocation().getPoint().getDistance(p);
		getCurLocation().setPoint(p);
		return true;
	}
	public String toString(){
		return " "+this.id+" - [color:"+this.col+", number of wheels:"+this.wheels+", KM:"+this.KM+", current location:"+this.loc+", Fuel Consumption:"+this.fuelConsumption;
	}
	public boolean lightsOnOff(){this.lights = !this.lights; return true;}
	public int getID(){return this.id;}
	public boolean setID(int ID){
		if(ID < MIN_ID || ID > MAX_ID)
			return false;
		this.id = ID;
		return true;
	}
	public String getColor() {return String.valueOf(this.col);}
	public static int getRandomNumberID(){
		Random rand = new Random();
		return rand.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
	}
	public int getFuelConsumption(){return this.fuelConsumption;}
	public void addFuelConsumption(int fuelConsumption){this.fuelConsumption = this.fuelConsumption + fuelConsumption;}
	public void loadImages() {
		for(int i=0;i<images.length;i++){
			try { images[i] = ImageIO.read(new File(PICTURE_PATH+String.valueOf(this.col).toLowerCase()+this.getSimpleVehicleName()+String.valueOf(Orientation.values()[i])+".png")); } 
			  catch (IOException e) { System.out.println("Cannot load image"); }
		}
	}
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
	public void drawObject(Graphics g) {
		if(loc.getOrientation()==Orientation.North)
			g.drawImage(images[0], this.getCurLocation().getPoint().getX(), this.getCurLocation().getPoint().getY(), size, size*2, pan);
		else if(this.getCurLocation().getOrientation()==Orientation.South)
			g.drawImage(images[1], this.getCurLocation().getPoint().getX(), this.getCurLocation().getPoint().getY(), size, size*2, pan);
		else if(this.getCurLocation().getOrientation()==Orientation.East)
			g.drawImage(images[2], this.getCurLocation().getPoint().getX(), this.getCurLocation().getPoint().getY(), size*2, size, pan);
		else if(this.getCurLocation().getOrientation()==Orientation.West)
			g.drawImage(images[3], this.getCurLocation().getPoint().getX(), this.getCurLocation().getPoint().getY(), size*2, size, pan);
	}
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
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
}
