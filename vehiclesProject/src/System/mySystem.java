package System;

import java.util.Scanner;

import Vehicles.Bike;
import Vehicles.Car;
import Vehicles.Carriage;
import Vehicles.Color;
import Vehicles.Direction;
import Vehicles.Engine;
import Vehicles.Location;
import Vehicles.Point;
import Vehicles.Vehicle;
import Vehicles.benzineEngine;
import Vehicles.solarEngine;

public class mySystem {
	public void drive(int carID, Point point){
	}
	
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		int ID, fuel, minimumAge, numberOfPassagers, typeOfEngine, numberOfWheels, numberOfGears;
		Color color;
		float KM;
		String animal;
		System.out.println("Enter the size of the array:");
		int size = sc.nextInt();
		Vehicle[] vehicles = new Vehicle[size];
		for(int i=0;i<size;i++){
			System.out.println("Enter the details of the "+i+" car:");
			System.out.println("Enter Y if the car is motorized or N if not:");
			String motor = sc.next();
			if(motor.equals("Y")){
				System.out.println("Choose the engine option:");
				System.out.println("1.Car.");
				System.out.println("Input - ");
				int choosing = sc.nextInt();
				switch(choosing){
				case 1:
					System.out.println("Enter the ID of the car:");
					ID = sc.nextInt();
					System.out.println("Enter the color of the car (RED,GREEN,WHITE,GRAY):");
					color = Color.valueOf(sc.next());
					System.out.println("Enter the current KM of the car:");
					KM = sc.nextFloat();
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
					i--;
					continue;
				}
			}
			else{
				System.out.println("Choose the engine option:");
				System.out.println("1.Carriage.\n2.Bike.");
				System.out.println("Input - ");
				int choosing = sc.nextInt();
				switch(choosing){
				case 1:
					System.out.println("Enter the ID of the carriage:");
					ID = sc.nextInt();
					System.out.println("Enter the color of the carriage (RED,GREEN,WHITE,GRAY):");
					color = Color.valueOf(sc.next());
					System.out.println("Enter the current KM of the carriage:");
					KM = sc.nextFloat();
					System.out.println("Enter the animal of the carriage:");
					animal = sc.next();
					vehicles[i] = new Carriage(ID,color,KM,animal);
					break;
				case 2:
					System.out.println("Enter the ID of the bike:");
					ID = sc.nextInt();
					System.out.println("Enter the color of the bike (RED,GREEN,WHITE,GRAY):");
					color = Color.valueOf(sc.next());
					System.out.println("Enter the current number of the wheels of the bike:");
					numberOfWheels = sc.nextInt();
					System.out.println("Enter the current KM of the bike:");
					KM = sc.nextFloat();
					System.out.println("Enter the current number of the gears of the bike:");
					numberOfGears = sc.nextInt();
					vehicles[i] = new Bike(ID,color,numberOfWheels,KM,numberOfGears);
					break;
				default:
					System.out.println("Wrong input, please try again.");
					i--;
					continue;
				}
			}
			
		}
		for(int i=0;i<size;i++){
			System.out.println(vehicles[i]);
		}
	}
}
