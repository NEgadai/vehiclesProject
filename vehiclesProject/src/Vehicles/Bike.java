package Vehicles;

public class Bike extends Vehicle {
	private static int Speed = 2;
	private int numberOfGears;
	public Bike(int ID, Color color, int numberOfWheels, float KM,int numberOfGears){
		super(ID,color,numberOfWheels,KM);
		this.numberOfGears = numberOfGears;
	}
	@Override
	public String toString(){
		return this.getClass().getSimpleName()+super.toString()+", number of gears:"+this.numberOfGears+"]";
	}
	
}
