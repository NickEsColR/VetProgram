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
	public Pet createClinicHistory(String petName, Owner owner, int day,int month, int year, 
									String sintoms, String diagnostic, Room freeRoom, Drug[]cDrugs){
		Pet pet = null;
		boolean exit = false;
		for(int i = 0;i < pets.size() && !exit;i++){
			if(pets.get(i).getName() .equals(petName)){
				pet = pets.get(i);
				exit = true;
			}
		}
		if (pet != null){
			
			pet.createClinicHistory(owner, pet, day, month, year, sintoms, diagnostic, freeRoom, cDrugs);
		}
		return pet;
	}
	public ArrayList<Drug> findDrugs(String petName,int day, int month, int year){
		ArrayList<Drug> cDrugs = new ArrayList<Drug>();
		boolean find = false;
		for(int i = 0;i < pets.size() && !find;i++){
			if(pets.get(i).getName() .equals(petName)){
				find = true;
				cDrugs = pets.get(i).findDrugs(day, month, year);
			}
		}
		return cDrugs;
	}
	 public ArrayList<ClinicHistory> seeClinicHistoriesOpen(){
		ArrayList<ClinicHistory> historyOpen = new ArrayList<ClinicHistory>();
		for(int i= 0;i < pets.size();i++){
			if(pets.get(i).seeClinicHistoriesOpen()!= null){
				historyOpen.add(pets.get(i).seeClinicHistoriesOpen());
			}
		}
		return historyOpen;
	 }
	 public String closeClinicHistoryOpen(String petName, int[]date){
		 String msj = "";
		 boolean find = false;
		 for(int i = 0;i < pets.size()&& !find ;i++){
			 if(pets.get(i).getName() .equals(petName)){
				 find = true;
				 msj = pets.get(i).closeClinicHistoryOpen(date);
			 }
		 }
		 return msj;
	 }
	  public int roomNumberOfAPet(String petName){
		 int roomNumber = 0;
		 boolean find = false;
		 for(int i = 0;i < pets.size()&& !find ;i++){
			 if(pets.get(i).getName() .equals(petName)){
				 find = true;
				 roomNumber = pets.get(i).roomNumberOfAPet();
			 }
		 }
		 return roomNumber;
	 }
	 public double  costOfAllClinicHistories(){
		 double cost = 0;
		 for(int i = 0;i < pets.size();i++){
			 cost += pets.get(i).costOfAllClinicHistories();
		 }
		 return cost;
	 }
	 public boolean contactWithOwner(String petName){
		boolean find = false;
		for(int k = 0;k < pets.size();k++){
			if(pets.get(k).getName() .equals(petName)){
				find = true;
			}
		}
		return find;
	 }
}