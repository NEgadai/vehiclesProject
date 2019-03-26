package Vehicles;
/**
 * A Point class.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class Point {
	private float x;
	private float y;
	/**
	 * A Class Constructor.
	 */

	public Point(){this.x = this.y = 0;}
	/**
	 * A Class Constructor.
	 * 
	 * @param x
	 * 		  x axis value.
	 * @param y
	 * 		  y axis value.
	 */
	public Point(float x,float y){
		this.x = x;
		this.y = y;
	}
	/**
	 * Set x axis value.
	 * 
	 * @param x
	 * 		  x axis value.
	 * @return true.
	 */
	public boolean setX(float x){
		this.x = x;
		return true;
	}
	/**
	 * Set y axis value.
	 * 
	 * @param y
	 * 		  y axis value.
	 * @return true.
	 */
	public boolean setY(float y){
		this.y = y;
		return true;
	}
	/**
	 * Get x axis value.
	 * 
	 * @return x axis.
	 */
	public float getX(){return this.x;}
	/**
	 * Get y axis value.
	 * 
	 * @return y axis.
	 */
	public float getY(){return this.y;}
	/**
	 * Creates a string representation.
	 * 
	 * @return A string representation.
	 */
	@Override
	public String toString(){return "("+this.x+","+this.y+")";}
	/**
	 * Check if is equal.
	 * 
	 * @param p
	 * 		  A Point object.
	 * @return true, else false.
	 */
	public boolean isEquals(Point p){
		if(this.getX() == p.getX() && this.getY() == p.getY())
			return true;
		return false;
	}
	/**
	 * Get Distanse.
	 * @param p
	 * 		  A Point object.
	 * @return Distanse.
	 */
	public float getDistance(Point p){
		return (float)Math.sqrt((float)Math.pow((this.getX()-p.getX()),2)+(float)Math.pow((this.getY() - p.getY()),2));
	}
}
