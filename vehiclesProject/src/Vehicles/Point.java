package Vehicles;

public class Point {
	private float x;
	private float y;
	public Point(){this.x = this.y = 0;}
	public Point(float x,float y){
		this.x = x;
		this.y = y;
	}
	public boolean setX(float x){
		this.x = x;
		return true;
	}
	public boolean setY(float y){
		this.y = y;
		return true;
	}
	public float getX(){return this.x;}
	public float getY(){return this.y;}
@Override
	public String toString(){return "("+this.x+","+this.y+")";}
}
