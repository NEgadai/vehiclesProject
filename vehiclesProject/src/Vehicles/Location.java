package Vehicles;
/**
 * A Location class.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class Location {
	private Point p;
	private Orientation ori;
	/**
	 * A Class Constructor.
	 */
	public Location(){
		p = new Point();
		ori = Orientation.East;
	}
	/**
	 * A Class Constructor.
	 * 
	 * @param p
	 * 		  A point object.
	 * @param ori
	 * 		  A Orientation.
	 */
	public Location(Point p, Orientation ori){
		this.p = p;
		this.ori = ori;
	}
	/**
	 * Set Orientation.
	 * 
	 * @param dire
	 * 		  A Orientation.
	 * @return true.
	 */
	public boolean setOrientation(Orientation ori){
		this.ori = ori;
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
	 * Get Orientation.
	 * 
	 * @return Orientation.
	 */
	public Orientation getOrientation(){return this.ori;}
	/**
	 * Creates a string representation.
	 * 
	 * @return A string representation.
	 */
	@Override
	public String toString(){return "[Point:"+this.p+", Direction:"+this.ori+"]";}
//	public void addX(){this.p.setX(this.p.getX()+1);}
//	public void addY(){this.p.setY(this.p.getY()+1);}
//	public void subX(){this.p.setX(this.p.getX()-1);}
//	public void subY(){this.p.setY(this.p.getY()-1);}
}
