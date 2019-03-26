package Vehicles;
/**
 * A Location class.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class Location {
	private Point p;
	private Direction dire;
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
	public Location(Point p, Direction dire){
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
	public boolean setDirection(Direction dire){
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
	public Direction getDirection(){return this.dire;}
	/**
	 * Creates a string representation.
	 * 
	 * @return A string representation.
	 */
	@Override
	public String toString(){return "[Point:"+this.p+", Direction:"+this.dire+"]";}
}
