package Vehicles;

import graphics.IAnimal;

public class PackAnimal implements IAnimal, Cloneable {
	private int energy;
	private String animalName;
	private static final int MAX_OF_ENERGY = 1000;
	//Each KM that the animal made - his energy reducing of 20
	public PackAnimal(String animalName){
		this.animalName = animalName;
		ReEnergy();
	}
	public String getAnimalName() {return animalName;}
	public boolean eat() {
		this.energy = this.energy - 20;
		return true;
	}
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
	public void ReEnergy(){
		this.energy = MAX_OF_ENERGY;
		
	}
	public int getEnergy(){return this.energy;}
}
