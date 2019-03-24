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
	
	//Veterinary init 
	
	public Veterinary(){
		
		drugs = new ArrayList<Drug> ();
		people = new ArrayList <Owner> ();
		rooms = new Room[ROOM];
		for(int i = 0;i<ROOM;i++){
			Room room = new Room(++i);
			rooms[i] = room;
		}
	}
	
	public ArrayList <Owner> getPeople(){
		return people;
	}
	public void addPeople(Owner owner){
		people.add(owner);
	}
	public Room[] getRooms(){
		return rooms;
	}
	public void addRoom(Room newRoom, int pos){
		rooms[pos] = newRoom;
	}
	public ArrayList <Drug> getDrugs(){
		return drugs;
	}
	public void addDrugs(Drug newDrug){
		drugs.add(newDrug);
	}
	public boolean freeRoom(){
		boolean free = false;
		for (int i = 0; i < people.size();i++){
			if(people.get(i).freeRoom() < 8){
				free = true;
			}
		}
		
		return free;
	}
	public void createClinicHistory(String idOwner, String petName, int day,int month, int year, 
									String sintoms, String diagnostic, String[]drugName){
	Drug[]cDrugs = new Drug[drugName.length];
	Room freeRoom = null;
	boolean exit = false;
	Pet pet= null;
	for(int i = 0;i < people.size() && !exit;i++){
		if(idOwner .equals(people.get(i).getId())){
			exit = true;
			freeRoom = getFreeRoomNumber( people.get(i));

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
	public Room getFreeRoomNumber(Owner owner){
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
	
	public double costOfAllClinicHistories(){
	double cost = 0;
	for(int i = 0;i < people.size();i++){
		cost += people.get(i).costOfAllClinicHistories();
	}
	return cost;
	}
}