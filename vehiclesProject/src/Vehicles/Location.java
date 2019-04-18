package Vehicles;
/**
 * A Location class.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public class Location {
	private Point p;
	private Orientation ori;
	public Location(){
		p = new Point();
		ori = Orientation.East;
	}

	public Location(Point p, Orientation ori){
		this.p = p;
		this.ori = ori;
	}

	public boolean setOrientation(Orientation ori){
		this.ori = ori;
		return true;
		}
	public boolean setPoint(Point p){
		this.p = p;
		return true;
	}
	public Point getPoint(){return this.p;}
	public Orientation getOrientation(){return this.ori;}
	@Override
	public String toString(){return "[Point:"+this.p+", Direction:"+this.ori+"]";}
//	public void addX(){this.p.setX(this.p.getX()+1);}
//	public void addY(){this.p.setY(this.p.getY()+1);}
//	public void subX(){this.p.setX(this.p.getX()-1);}
//	public void subY(){this.p.setY(this.p.getY()-1);}
}
