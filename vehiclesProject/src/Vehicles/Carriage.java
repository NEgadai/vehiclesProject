package Vehicles;

public class Carriage extends Vehicle {
	private static final int NUMBER_OF_WHEELS = 4;
	private static int speed = 1;
	private String animal;
	public Carriage(int ID, Color color, float KM, String animal){
		super(ID,color,NUMBER_OF_WHEELS,KM);
		this.animal = animal;
	}
	@Override
	public String toString(){
		return this.getClass().getSimpleName()+super.toString()+", animal:"+this.animal+"]";
	}
}
