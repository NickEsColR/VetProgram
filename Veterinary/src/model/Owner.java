package model;

import java.util.ArrayList;
public class Owner{
	
	//attributes
	private String name;
	private String id;
	private String adress;
	private String phone;
	
	//relations
	private ArrayList<Pet> pets;

  //methods
  public Owner(String name, String id, String adress, String phone){
    this.name = name; 
    this.id = id;
    this.adress = adress;
    this.phone = phone;
	pets = new ArrayList<Pet>();
  }
  public String getName(){
	  return name;
  }
  public void setName(String name){
	  this.name = name;
  }
  public String getId(){
	  return id;
  }
  public void setId(String id){
	  this.id = id;
  }
  public String getAdress(){
	  return adress;
  }
  public void setAdress(String adress){
	  this.adress = adress;
  }
  public String getPhone(){
	  return phone;
  }
  public void setPhone(String phone){
	  this.phone = phone;
  }
  public ArrayList<Pet> getPets(){
	  return pets;
  }
  public void setPets(Pet newPet){
	  pets.add(newPet);
  }
  public int freeRoom(){
	  int free = 0;
	  for (int i = 0; i<pets.size();i++){
		  if(pets.get(i).freeRoom() == 1)
			free ++;
	  }
	  return free;
	  
  }
  	 public ArrayList<int> numberFreeRoom(){
	  ArrayList<int> free = new ArrayList<int>();
	  for (int i = 0; i<pets.size();i++){
		  if(pets.get(i).freeRoom() == 1)
			 free.add(pets.get(i).roomNumber());
	  }
	  return free;
  }
 
	public Pet findPetWithName(String petName, Owner owner, int days, Room freeRoom){
		Pet pet = null;
		boolean exit = false;
		for(int i = 0;i < pets.size() && !exit;i++){
			if(pets.get(i).getName() .equal(petName)){
				pet = pets.get(i);
				exit = true;
			}
		}
		if (pet != null){
			
			pet.goToPet(owner, pet, days, freeRoom);
		}
		return pet;
	}
	 
}