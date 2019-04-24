package Vehicles;

import graphics.IAnimal;

public class PackAnimal implements IAnimal, Cloneable {
	private int energy;
	private String animalName;
	private static final int MAX_OF_ENERGY = 1000;
	//Each KM that the animal made - his energy reducing of 20
	/**
	 * A Class Constructor.
	 * 
	 * @param animalName
	 * 		  Animal Name.
	 */
	public PackAnimal(String animalName){
		this.animalName = animalName;
		ReEnergy();
	}
	/**
	 * Get Animal Name.
	 * 
	 * @return animal name.
	 */
	public String getAnimalName() {return animalName;}
	/**
	 * Eat,updating a energy.
	 * 
	 * @return true.
	 */
	public boolean eat() {
		this.energy = this.energy - 20;
		return true;
	}
	/**
	 * Clone Object.
	 * 
	 * @return New copy of this object.
	 *
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
	/**
	 * Re Energy.
	 */
	public void ReEnergy(){
		this.energy = MAX_OF_ENERGY;
		
	}
	/**
	 * Get Energy.
	 * 
	 * @return energy.
	 */
	public int getEnergy(){return this.energy;}
}
