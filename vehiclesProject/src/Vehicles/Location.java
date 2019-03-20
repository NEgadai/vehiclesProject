package Vehicles;
public class Location {
	private Point p;
	private Direction dire;
	public Location(){
		p = new Point();
	}
	public Location(Point p, Direction dire){
		this.p = p;
		this.dire = dire;
	}
	public boolean setDirection(Direction dire){
		this.dire = dire;
		return true;
		}
	public boolean setPoint(Point p){
		this.p = p;
		return true;
	}
	public Point getPoint(){return this.p;}
	public Direction getDirection(){return this.dire;}
	@Override
	public String toString(){return "[Point:"+this.p+", Direction:"+this.dire+"]";}
}
