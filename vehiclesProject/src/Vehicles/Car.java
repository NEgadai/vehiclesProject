package Vehicles;

public class Car extends hasEngine {
	private static final int MAX_FUEL_CAPACITY = 40;
	private static final int NUMBER_OF_WHEELS = 4;
	private int numberOfPassengers;
	public Car(int ID, Color color, float KM,Engine engine,int minimumAge,int numberOfPassengers){
		super(ID,color,NUMBER_OF_WHEELS,KM,engine,MAX_FUEL_CAPACITY,minimumAge);
		this.numberOfPassengers = numberOfPassengers;
	}
	@Override
	public String toString(){
		return this.getClass().getSimpleName()+super.toString()+", number of passengers:"+this.numberOfPassengers+"]";
	}

}
