package Vehicles;
/**
 * A class inherits from Vehicle, and represents a Carriage.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class Carriage extends Vehicle {
	private static final int NUMBER_OF_WHEELS = 4;
	/**
	 * The Carriage speed.
	 */
	private static int speed = 1;
	private String animal;
	/**
	 * A Class Constructor.
	 * 
	 * @param ID
	 * 		  The Carriage ID.
	 * @param color
	 * 		  The Carriage color.
	 * @param KM
	 * 		  The number of kilometers.
	 * @param animal
	 * 		  The animal that is dragging the carriage.
	 */
	public Carriage(int ID, Color color, float KM, String animal){
		super(ID,color,NUMBER_OF_WHEELS,KM);
		this.animal = animal;
	}
	/**
	 * Creates a string representation.
	 * 
	 * @return A string representation.
	 */
	@Override
	public String toString(){
		return this.getClass().getSimpleName()+super.toString()+", animal:"+this.animal+"]";
	}
}
