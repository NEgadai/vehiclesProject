package Vehicles;

public class vehicleArea {
	private static final int SIZE = 65;
	private Point point;
	private int width;
	private int height;
	public vehicleArea(Point point, Orientation orient){
		this.point = point;
		if(orient == Orientation.East || orient == Orientation.West){
			this.width = SIZE*2;
			this.height = SIZE;
		}else if(orient == Orientation.North || orient == Orientation.South){
			this.width = SIZE;
			this.height = SIZE*2;
		}
	}
	public void setNewPoint(Point point, Orientation orient){
		this.point = point;
		if(orient == Orientation.East || orient == Orientation.West){
			this.width = SIZE*2;
			this.height = SIZE;
		}else if(orient == Orientation.North || orient == Orientation.South){
			this.width = SIZE;
			this.height = SIZE*2;
		}
	}
	public Point getPoint(){return this.point;}
	public int getWidth(){return this.width;}
	public int getHeight(){return this.height;}
//	private final Point[] areaPoints = new Point[4];
//	public vehicleArea(Point point, Orientation orient) throws CloneNotSupportedException{
//		for(int i=0;i<areaPoints.length;i++)
//			areaPoints[i] = (Point)point.clone();
//		if(orient == Orientation.East || orient == Orientation.West){
//			areaPoints[1].setX(areaPoints[1].getX()+SIZE*2);
//			areaPoints[2].setY(areaPoints[2].getY()+SIZE);
//			areaPoints[3].setX(areaPoints[3].getX()+SIZE*2);
//			areaPoints[3].setY(areaPoints[3].getY()+SIZE);
//		}else if(orient == Orientation.North || orient == Orientation.South){
//			areaPoints[1].setX(areaPoints[1].getX()+SIZE);
//			areaPoints[2].setY(areaPoints[2].getY()+SIZE*2);
//			areaPoints[3].setX(areaPoints[3].getX()+SIZE);
//			areaPoints[3].setY(areaPoints[3].getY()+SIZE*2);
//		}
//	}
	public static boolean overlaps(vehicleArea r1,vehicleArea r2) {
	    return r1.getPoint().getX() < r2.getPoint().getX() + r2.getWidth() && r1.getPoint().getX() + r1.getWidth() > r2.getPoint().getX() && r1.getPoint().getY() < r2.getPoint().getY() + r2.getHeight() && r1.getPoint().getY() + r1.getHeight() > r2.getPoint().getY();
	}
}
