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
			free = 1;
	  }
	  return free;
	  
  }
}