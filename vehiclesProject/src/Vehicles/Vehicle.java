package Vehicles;

public abstract class Vehicle {
	private int ID;
	private Color color;
	private int numberOfWheels;
	private Location curLocation;
	private float KM;
	private boolean lights;
	public Vehicle(int ID, Color color, int numberOfWheels, float KM){
		this.ID = ID;
		this.color = color;
		this.numberOfWheels = numberOfWheels;
		this.KM = KM;
		this.lights = false;
		this.curLocation = new Location();
	}
	public void drive(Point p){
		KM += (float)Math.sqrt((float)Math.pow((curLocation.getPoint().getX()-p.getX()),2)+(float)Math.pow((curLocation.getPoint().getY() - p.getY()),2));
		curLocation.setPoint(p);
	}
	@Override
	public String toString(){
		return " "+this.ID+" - [color:"+this.color+", number of wheels:"+this.numberOfWheels+", KM:"+this.KM+", current location:"+this.curLocation;
	}
}
