package Vehicles;

import graphics.IAnimal;

public class PackAnimal implements IAnimal, Cloneable {
	private String animalName;
	private static final int MAX_OF_ENERGY = 1000;
	//Each KM that the animal made - his energy reducing of 20
	public String getAnimalName() {
		return null;
	}
	public boolean eat() {
		return false;
	}
}
