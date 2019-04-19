package model;

import java.util.ArrayList;
public class Veterinary{
	
	//constants
	public final static int ROOM = 8;
	
	//attributes
	
	
	//relations
	private ArrayList <Owner> people;
	private Room [] rooms;
	private ArrayList <Drug> drugs;
	
	//methods
	
	/**
	* init relations of a Owner<br>
	*/
	
	public Veterinary(){
		
		drugs = new ArrayList<Drug> ();
		people = new ArrayList <Owner> ();
		rooms = new Room[ROOM];
		for(int i = 0;i<ROOM;i++){
			Room room = new Room(++i);
			rooms[i] = room;
		}
	}
	
	/**
	* get the owners exist<br>
	* @return people is the owners exist<br>
	*/
	
	public ArrayList <Owner> getPeople(){
		return people;
	}
	
	/**
	* add a new owner exist<br>
	* @param owner is a new owner <br>
	*/
	
	public void addPeople(Owner owner){
		people.add(owner);
	}
	
	/**
	* get the rooms exist<br>
	* @return rooms is the rooms exist<br>
	*/
	
	public Room[] getRooms(){
		return rooms;
	}
	
	/**
	* get the drugs exist<br>
	* @return drugs is the drugs exist<br>
	*/
	
	public ArrayList <Drug> getDrugs(){
		return drugs;
	}
	
	/**
	* add a new drug <br>
	* @param newDrug is a new drug <br>
	*/
	
	public void addDrugs(Drug newDrug){
		drugs.add(newDrug);
	}
	
	/**
	* look if a room is free<br>
	* @return free is if a room can be ocuped by a pet<br>
	*/
	
	public boolean freeRoom(){
		boolean free = false;
		int num = 0;
		for (int i = 0; i < people.size();i++){
			num += people.get(i).freeRoom();
		}
			if(num < 8){
				free = true;
			}
		
		return free;
	}
	
	/**
	* create a new clinic history <br>
	* @param idOwner is the owner id of the pet will be hospitalized. idOwner != ""<br>
	* @param petName is the name of pet for the clinic history. petName != "" <br>
	* @param day is the day the clinic history is created <br>
	* @param month is the month the clinic history is created <br>
	* @param year is the year the clinic history is created <br>
	* @param sintoms are the sintoms the pet have <br>
	* @param diagnostic is the diagnostic of what the pet have <br>
	* @param drugName are the name of the drugs the pet is going to use <br>
	* @see Owner.getId()<br>
	* @see getFreeRoomNumber<br>
	* @see Owner.createClinicHistory( String, Owner, int, int, int, String, String, Room, Drug[])<br>
	* @see Drug.getName()<br>
	*/
	
	public void createClinicHistory(String idOwner, String petName, int day,int month, int year, 
									String sintoms, String diagnostic, String[]drugName){
	Drug[]cDrugs = new Drug[drugName.length];
	Room freeRoom = null;
	boolean exit = false;
	Pet pet= null;
	for(int i = 0;i < people.size() && !exit;i++){
		if(idOwner .equals(people.get(i).getId())){
			exit = true;
			freeRoom = getFreeRoomNumber( );

			pet = people.get(i).createClinicHistory(petName, people.get(i), day, month, year, sintoms, diagnostic, freeRoom, cDrugs); 
			
		}
	}
	for(int j = 0;j < drugName.length;j++){
		for(int k = 0;k < drugs.size();k++){
			if(drugs.get(k).getName() .equals(drugName[j]))
				cDrugs[j] = drugs.get(k);
		}
	}
	}
	
	/**
	* search a free room <br>
	* @see Owner.getRoomNumber()<br>
	* @see Room.getNumber()<br>
	* @return freeRoom is the empty room that can be used<br>
	*/
	
	public Room getFreeRoomNumber(){
		Room freeRoom = null;
		int [] roomNumber = new int [ROOM];
		int numberFreeRoom = 0;
		for(int c = 0;c < ROOM;c++){
			roomNumber[c] = c + 1;
		}
		boolean exit = false;
		for(int i = 0;i < people.size();i++){
			for(int j = 0;j < people.get(i).getPets().size();j++){
				for(int k = 0;k < ROOM; k++){
				if(people.get(i).getRoomNumber(j)== roomNumber[k]){
					roomNumber[k] = 0;
				}
				}
			}
		}
		for(int t = 0; t < ROOM && !exit;t++){
			if(roomNumber[t] != 0){
				numberFreeRoom = roomNumber[t];
				exit = true;
			}
		}
		for(int u = 0;u < ROOM && exit;u++){
			if(rooms[u].getNumber() == numberFreeRoom){
				freeRoom = rooms[u];
				exit = false;
			}
		}
		return freeRoom;
	}
	
	/**
	* search the drugs of a clinic history of a pet <br>
	* @param idOwner is the owner id of the pet is hospitalized. idOwner != ""<br>
	* @param petName is the name of the pet. petName != ""<br>
	* @param day is the day the clinic history was created <br>
	* @param month is the month the clinic history was created <br>
	* @param year is the year the clinic history was created <br>
	* @see Owner.findDrugs()<br>
	* @see Owner.getId()<br>
	* @return ArrayList of Drug is the drugs of a clinic history <br> 
	*/
	
	public ArrayList<Drug> findDrugsOfAClinicHistory(String idOwner, String petName,int day, int month, int year ){
		ArrayList<Drug> cDrugs = new ArrayList<Drug>();
		boolean find = false;
		for(int i = 0;i < people.size() && !find; i++){
			if(people.get(i).getId() .equals(idOwner)){
				find = true;
				cDrugs = people.get(i).findDrugs(petName, day, month, year);
			}
				
		}
		return cDrugs;
	}
	
	/**
	* see the clinic histories are open <br>
	* @see Owner.seeClinicHistoriesOpen()<br>
	* @return ArrayList of ClinicHistory are the clinic histories open<br>
	*/
	
	public ArrayList<ClinicHistory> seeClinicHistoriesOpen(){
		ArrayList<ClinicHistory> cHistoryOpen = new ArrayList<ClinicHistory>();
		for(int i = 0;i < people.size();i++){
			Owner owner = people.get(i);
			for(int j = 0;j <owner.seeClinicHistoriesOpen().size();j++){
				cHistoryOpen.add(owner.seeClinicHistoriesOpen().get(j));
			}
		}
		return cHistoryOpen;
	}
	
	/**
	* close a clinic history of a pet<br>
	* @param idOwner is the owner id of the pet is hospitalized. idOwner != ""<br>
	* @param petName is the name of the pet. petName != ""<br>
	* @param date is the ot date<br>
	* @see Owner.getId()<br>
	* @see Owner.closeClinicHistoryOpen()<br>
	* @return msj is a message that say if the clinic history close successfully<br>
	*/
	
	public String closeClinicHistoryOpen(String idOwner, String petName, int[]date){
		String msj = "";
		
		boolean find = false;
		for(int i = 0;i < people.size() && !find; i++){
			if(people.get(i).getId() .equals(idOwner)){
				find = true;
				msj = people.get(i).closeClinicHistoryOpen(petName,date);
			}
		}
		
		return msj;
	}
	
	/**
	* search the room number of a pet with owner id and pet name<br>
	* @param idOwner is the owner id of the pet is hospitalized. idOwner != ""<br>
	* @param petName is the name of the pet. petName != ""<br>
	* @see Owner.roomNumberOfAPet()<br>
	* @see Owner.getId()<br>
	* @return roomNumber is the room number the pet is using<br> 
	*/
	
	public int roomNumberOfAPet(String idOwner, String petName){
		int roomNumber = 0;
		
		boolean find = false;
		for(int i = 0;i < people.size() && !find; i++){
			if(people.get(i).getId() .equals(idOwner)){
				find = true;
				roomNumber = people.get(i).roomNumberOfAPet(petName);
			}
		}
		
		return roomNumber;
	}
	
	/**
	* calculate the cost of all clinic histories open and closed<br>
	* @see Owner.costOfAllClinicHistories()<br>
	* @return cost is the cost of all clinic histories<br>
	*/
	
	public double costOfAllClinicHistories(){
		double cost = 0;
		for(int i = 0;i < people.size();i++){
			cost += people.get(i).costOfAllClinicHistories();
		}
		return cost;
	}
	
	/**
	* get the contact of a owner <br>
	* @param idOwner is the owner id of the pet is hospitalized. idOwner != ""<br>
	* @param petName is the name of the pet. petName != ""<br>
	* @see Owner.getId()<br>
	* @see Owner.contactWithOwner()<br>
	* @return ArrayList of Owner with all possible owner <br>
	*/
	
	public ArrayList<Owner> contactWithOwner(String idOwner, String petName){
		ArrayList<Owner> owners = new ArrayList<Owner>();
		boolean theOwners = false;
		boolean find = false;
		if(idOwner != ""){
			for(int i = 0;i < people.size() && !find; i++){
				if(people.get(i).getId() .equals(idOwner)){
					find = true;
					owners.add(people.get(i));
				}
			}
		}
		else{
			for(int j =0;j < people.size();j++){
				theOwners = people.get(j).contactWithOwner(petName);
				if(theOwners)
					owners.add(people.get(j));
				}
			}
		
		return owners;
	}
}