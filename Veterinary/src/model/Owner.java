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
  public int getRoomNumber(int pos){
	  int free = 0;
		  if(pets.get(pos).getRoom() != null)
			free = pets.get(pos).getRoomNumber();
	  
	  return free;
	  
  }
	public int freeRoom(){
	  int free = 0;
	  for (int i = 0; i<pets.size();i++){
		  if(pets.get(i).freeRoom() == 1)
			free ++;
	  }
	  return free;
	}
	public Pet createClinicHistory(String petName, Owner owner, int days, String sintoms, String diagnostic, Room freeRoom){
		Pet pet = null;
		boolean exit = false;
		for(int i = 0;i < pets.size() && !exit;i++){
			if(pets.get(i).getName() .equals(petName)){
				pet = pets.get(i);
				exit = true;
			}
		}
		if (pet != null){
			
			pet.createClinicHistory(owner, pet, days,sintoms, diagnostic, freeRoom);
		}
		return pet;
	}
	 
}