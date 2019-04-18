package Vehicles;
/**
 * A Point class.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class Point {
	private int x;
	private int y;
	public Point(){this.x = this.y = 0;}
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}
	public boolean setX(int x){
		this.x = x;
		return true;
	}
	public boolean setY(int y){
		this.y = y;
		return true;
	}
	public int getX(){return this.x;}
	public int getY(){return this.y;}
	@Override
	public String toString(){return "("+this.x+","+this.y+")";}
	public boolean isEquals(Point p){
		if(this.getX() == p.getX() && this.getY() == p.getY())
			return true;
		return false;
	}
	public int getDistance(Point p){
		return (int)Math.sqrt((int)Math.pow((this.getX()-p.getX()),2)+(int)Math.pow((this.getY() - p.getY()),2));
	}
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
}
