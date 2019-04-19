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
  
	/**
	* init attributes and relations of a Owner<br>
	* <b>Pos:</b> the owner has been created<br>
	* @param name of a owner. This param couldn´t be empty<br>
	* @param id of owner.This param couldn´t be empty<br>
	* @param adress of the owner. This param couldn´t be empty.<br>
	* @param phone of the owner.This param couldn´t be empty.<br>
	*/
	
  public Owner(String name, String id, String adress, String phone){
    this.name = name; 
    this.id = id;
    this.adress = adress;
    this.phone = phone;
	pets = new ArrayList<Pet>();
  }
  
	/**
	* get the name of a owner<br>
	* @return name of the owner<br>
	*/
	
  public String getName(){
	  return name;
  }
  
	/**
	* set the name of a owner<br>
	* @param name of the owner. This param couldn´t be empty. <br>
	*/
	
  public void setName(String name){
	  this.name = name;
  }
  
	/**
	* get the id of a owner<br>
	* @return id of the owner<br>
	*/
	
  public String getId(){
	  return id;
  }
  
	/**
	* set the id of a owner<br>
	* @param id of the owner.This param couldn´t be empty<br>
	*/
	
  public void setId(String id){
	  this.id = id;
  }
  
	/**
	* get the address of a owner<br>
	* @return adress of the owner<br>
	*/
	
  public String getAdress(){
	  return adress;
  }
	
	/**
	* set the address of a owner<br>
	* @param adress of the owner. This param couldn´t be empty<br>
	*/
	
  public void setAdress(String adress){
	  this.adress = adress;
  }
  
	/**
	* get the phone of a owner<br>
	* @return phone of the owner<br>
	*/
	
  public String getPhone(){
	  return phone;
  }
  
	/**
	* set the phone of a owner<br>
	* @param phone of the owner.This param couldn´t be empty<br>
	*/
	
  public void setPhone(String phone){
	  this.phone = phone;
  }
  
	/**
	* get the pets of a owner<br>
	* @return ArrayList of Pet of the owner<br>
	*/
	
  public ArrayList<Pet> getPets(){
	  return pets;
  }
  
  	/**
	* set the pets of a owner<br>
	* @paramm  newPet of the owner<br>
	*/
	
  public void setPets(Pet newPet){
	  pets.add(newPet);
  }
  
	/**
	* get the room number of a owner<br>
	* @param pos is the position the pet is save <br>
	* @see Pet.getRoomNumber()<br>
	* @return free is the room number in use<br>
	*/
	
  public int getRoomNumber(int pos){
	  int free = 0;
		  if(pets.get(pos).getRoom() != null)
			free = pets.get(pos).getRoomNumber();
	  
	  return free;
	  
  }
  
  /**
  * search if a room is ocuped<br>
  * @see Pet.freeRoom()<br>
  * @return free is how many rooms are ocuped<br>
  */
  
	public int freeRoom(){
	  int free = 0;
	  for (int i = 0; i<pets.size();i++){
		  if(pets.get(i).freeRoom() == 1)
			free ++;
	  }
	  return free;
	}
	
	/**
	* create a new clinic history <br>
	* @param petName is the name of pet for the clinic history. petName != "" <br>
	* @param owner is the owner of the pet. owner != null <br>
	* @param day is the day the clinic history is created <br>
	* @param month is the month the clinic history is created <br>
	* @param year is the year the clinic history is created <br>
	* @param sintoms are the sintoms the pet have <br>
	* @param diagnostic is the diagnostic of what the pet have <br>
	* @param freeRoom is the room the pet is hospitalize. freeRoom != null <br>
	* @param cDrugs are the drugs the pet is going to use <br>
	* @see Pet.getName()<br>
	* @see Pet.createClinicHistory(Owner, Pet, int, int, int, String, String, Room, Drug[])<br>
	*/
	
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
	
	/**
	* search the drugs of a clinic history of a pet <br>
	* @param petName is the name of the pet. petName != ""<br>
	* @param day is the day the clinic history was created <br>
	* @param month is the month the clinic history was created <br>
	* @param year is the year the clinic history was created <br>
	* @see Pet.findDrugs()<br>
	* @see Pet.getName()<br>
	* @return ArrayList of Drug is the drugs of a clinic history <br> 
	*/
	
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
	
	/**
	* search for all clinic histories open<br>
	* @see Pet.seeClinicHistoriesOpen()<br>
	* @return ArrayList of ClinicHistory is the clinic histories open <br>
	*/
	
	 public ArrayList<ClinicHistory> seeClinicHistoriesOpen(){
		ArrayList<ClinicHistory> historyOpen = new ArrayList<ClinicHistory>();
		for(int i= 0;i < pets.size();i++){
			if(pets.get(i).seeClinicHistoriesOpen()!= null){
				historyOpen.add(pets.get(i).seeClinicHistoriesOpen());
			}
		}
		return historyOpen;
	 }
	 
	 /**
	 * close a clinic history open<br>
	 * @param petName is the name of a pet<br>
	 * @param date is the date the clinic history was created<br>
	 * @see Pet.closeClinicHistoryOpen()<br>
	 * @return msj is a message that say if the clinic history was closed<br>
	 */
	 
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
	 
	 /**
	 * get the room number a pet have in the moment<br>
	 * @param petName is the name of a pet. petName != ""<br>
	 * @see Pet.roomNumberOfAPet()<br>
	 * @return roomNumber is the number a pet have<br>
	 */
	 
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
	 
	 /**
	 * see the cost of all clinic histories exist <br>
	 * @see Pet.costOfAllClinicHistories()<br>
	 * @return cost is the cost of all clinic histories <br>
	 */
	 
	 public double  costOfAllClinicHistories(){
		 double cost = 0;
		 for(int i = 0;i < pets.size();i++){
			 cost += pets.get(i).costOfAllClinicHistories();
		 }
		 return cost;
	 }
	 
	 /**
	 * see if the pet is the pet of the owner<br>
	 * @param petName is the name of a pet<br>
	 * @see Pet.getName()<br>
	 * @return find is if the pet is or not of the owner<br>
	 */
	 
	 
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