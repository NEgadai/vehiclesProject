package Vehicles;

public class Car extends hasEngine {
	private int numberOfPassengers;
	public Car(int ID, Color color, float KM,Engine engine,int minimumAge,int numberOfPassengers){
		super(ID,color,4,KM,engine,40,minimumAge);
		this.numberOfPassengers = numberOfPassengers;
	}
	@Override
	public String toString(){
		return this.getClass().getSimpleName()+super.toString()+", number of passengers:"+this.numberOfPassengers+"]";
	}

}
