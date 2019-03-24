package System;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Vehicles.Bike;
import Vehicles.Car;
import Vehicles.Carriage;
import Vehicles.Color;
import Vehicles.Point;
import Vehicles.Vehicle;
import Vehicles.benzineEngine;
import Vehicles.solarEngine;

public class mySystem {
	private static Map<Integer, Vehicle> IDtoVehicle = new HashMap<Integer, Vehicle>();
	private static int size;
	private static Scanner sc = new Scanner(System.in);
	private static Vehicle[] vehicles;
	private static Point[] zone = new Point[4];
	private static boolean zoneCreated;
	public static boolean drive(int carID, Point point){
		if(!validationPoint(point)){
			System.out.println("(*) The point is not valid.");
			return false;
			}
		if(!IDtoVehicle.get(carID).drive(point)){
			System.out.println("(*) Couldn't make drive.");
			return false;
		}
		return true;
	}
	public static void buildVehicles(){
		System.out.println("Enter the size of the array:");
		size = sc.nextInt();
		vehicles = new Vehicle[size];
		int ID, fuel, minimumAge, numberOfPassagers, typeOfEngine, numberOfWheels, numberOfGears;
		Color color;
		float KM;
		String animal;
		for(int i=0;i<size;i++){
			System.out.println("Enter the details of the "+(i+1)+" vehicle:");
			System.out.println("Enter the ID of the vehicle:");
			ID = sc.nextInt();
			System.out.println("Enter the color of the vehicle (RED,GREEN,WHITE,GRAY):");
			try {
				color = Color.valueOf(sc.next());
			}catch(IllegalArgumentException exception){
				System.out.println("Wrong color input, the system set to this vehicle WHITE color.");
				color = Color.WHITE;
			}
			System.out.println("Enter the current KM of the vehicle:");
			KM = sc.nextFloat();
			
			System.out.println("\nEnter Y if the car is motorized or N if not:");
			String motor = sc.next();
			
			switch(motor){
			case "Y":
				
				System.out.println("Choose the vehicle:");
				System.out.println("1.Car.");
				System.out.println("Input - ");
				int choosing = sc.nextInt();
				switch(choosing){
				case 1:
					System.out.println("Enter the current fuel of the car:");
					fuel = sc.nextInt();
					System.out.println("Enter the minimum age that needs to be for a drive on this car:");
					minimumAge = sc.nextInt();
					System.out.println("Enter the number of passegers that can be in this car:");
					numberOfPassagers = sc.nextInt();
					System.out.println("Enter 1 if the car is using benzine engine and 2 if the car is using solar engine:");
					typeOfEngine = sc.nextInt();
					if(typeOfEngine == 1)
						vehicles[i] = new Car(ID,color,KM,new benzineEngine(1),fuel,minimumAge,numberOfPassagers);
					else
						vehicles[i] = new Car(ID,color,KM,new solarEngine(1),fuel,minimumAge,numberOfPassagers);
					break;
				default:
					System.out.println("Wrong input, please try again.");
					break;
				}
				
				break;
			case "N":
				System.out.println("Choose the engine option:");
				System.out.println("1.Carriage.\n2.Bike.");
				System.out.println("Input - ");
				int choosing2 = sc.nextInt();
				switch(choosing2){
				case 1:
					System.out.println("Enter the animal of the carriage:");
					animal = sc.next();
					vehicles[i] = new Carriage(ID,color,KM,animal);
					break;
				case 2:
					System.out.println("Enter the current number of the wheels of the bike:");
					numberOfWheels = sc.nextInt();
					System.out.println("Enter the current number of the gears of the bike:");
					numberOfGears = sc.nextInt();
					vehicles[i] = new Bike(ID,color,numberOfWheels,KM,numberOfGears);
					break;
				default:
					System.out.println("Wrong input, please try again.");
				}
				break;
			default:
				break;
			}
			IDtoVehicle.put(vehicles[i].getID(), vehicles[i]);
		}
	}
	public static boolean validationPoint(Point point){
		if(zoneCreated == false)
			return false;
		boolean result = false;
	      for (int i = 0, j = zone.length - 1; i < zone.length; j = i++) {
	        if ((zone[i].getY() > point.getY()) != (zone[j].getY() > point.getY()) &&
	            (point.getX() < (zone[j].getX() - zone[i].getX()) * (point.getY() - zone[i].getY()) / (zone[j].getX()-zone[i].getY()) + zone[i].getX())) 
	          result = !result;
	      }
	    return result;
	}
	public static boolean setZonePoints(){
		int x = 0,y = 0;
		System.out.println("Enter 4 points for create the polygon that the vehicles can drive there:");
		for(int i=0;i<4;i++){
			System.out.println("The "+(i+1)+" point:");
			System.out.println("Enter the x parameter:");
			x = sc.nextInt();
			System.out.println("Enter the y parameter:");
			y = sc.nextInt();
			zone[i] = new Point(x,y);
		}
		if(!zone[0].isEquals(zone[1]) && !zone[1].isEquals(zone[2]) && !zone[2].isEquals(zone[3]) && !zone[0].isEquals(zone[3]))
			return true;
		return false;
	}
	public static void printVehicles(){
		for(int i=0;i<size;i++){
			System.out.println((i+1)+" -> "+vehicles[i]);
		}
	}
	public static void main(String []args){
		zoneCreated = setZonePoints();
		buildVehicles();
		int choose = 0;
		while(choose != -1){
			printVehicles();
			System.out.println("Choose from the vehicles with which one you want to work:");
			choose = sc.nextInt();
			choose--;
			if(choose > vehicles.length-1 || choose < -1){
				System.exit(0);
			}
			System.out.println(vehicles[choose]);
			System.out.println("Enter the Point -> (x,y) to there you want to drive with the vehicle:");
			System.out.println("Enter the x parameter:");
			float x = sc.nextFloat();
			System.out.println("Enter the y parameter:");
			float y = sc.nextFloat();
			drive(vehicles[choose].getID(),new Point(x,y));
			System.out.println(vehicles[choose]);
			System.out.println("(*) For exit the system -> enter -1.");
		}
		System.exit(0);
	}
}
