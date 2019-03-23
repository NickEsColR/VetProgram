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
	public void findOwnerWithId(String idOwner, String petName, int days){
	Room freeRoom = null;
	boolean exit = false;
	Pet pet= null;
	for(int i = 0;i < people.size() && !exit;i++){
		if(idOwner .equals(people.get(i).getId())){
			exit = true;
			freeRoom = getFreeRoomNumber( people.get(i));

			pet = people.get(i).findPetWithName(petName, people.get(i), days, freeRoom); 
			
		}
	}

	}
	public Room getFreeRoomNumber(Owner owner){
		ArrayList<int[]> roomNumber = new ArrayList<int[]>();
		roomNumber.add(owner.get(i).numberFreeRoom());
		ArrayList <int[]> compareNumber = new ArrayList<int[]>();
		int free = 0;
		Room freeRoom = null;
		for(int i = 1;i < 9;i++){
			compareNumber.add(i);
		}
		for(int j = 0;j < roomNumber.size(); j++){
			boolean exit = false;
			for(int k = 0;k < 8 && !exit ;k++){
				if(roomNumber.get(i)== compareNumber(k)){
					compareNumber.remove(k);
					exit = true;
				}
			}
		}
		if(compareNumber.size() != 0){
			free = compareNumber.get(0);
			freeRoom = rooms.get(--free);
		}
		return freeRoom;
	}

	
}