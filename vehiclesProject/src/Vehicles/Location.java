package Vehicles;
/**
 * A Location class.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class Location {
	private Point p;
	private Orientation dire;
	/**
	 * A Class Constructor.
	 */
	public Location(){
		p = new Point();
	}
	/**
	 * A Class Constructor.
	 * 
	 * @param p
	 * 		  A Point object.
	 * @param dire
	 * 		  A Direction.
	 */
	public Location(Point p, Orientation dire){
		this.p = p;
		this.dire = dire;
	}
	/**
	 * Set Direction.
	 * 
	 * @param dire
	 * 		  A Direction.
	 * @return true.
	 */
	public boolean setDirection(Orientation dire){
		this.dire = dire;
		return true;
		}
	/**
	 * Set Location.
	 * 
	 * @param p
	 * 		  A Point object.
	 * @return true.
	 */
	public boolean setPoint(Point p){
		this.p = p;
		return true;
	}
	/**
	 * Get Location.
	 * 
	 * @return Location.
	 */
	public Point getPoint(){return this.p;}
	/**
	 * Get Direction.
	 * 
	 * @return Direction.
	 */
	public Orientation getDirection(){return this.dire;}
	/**
	 * Creates a string representation.
	 * 
	 * @return A string representation.
	 */
	@Override
	public String toString(){return "[Point:"+this.p+", Direction:"+this.dire+"]";}
}
