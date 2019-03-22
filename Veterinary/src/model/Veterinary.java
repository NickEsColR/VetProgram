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
		int max = 0;
		for (int i = 0; i < people.size();i++){
			if(people.get(i).freeRoom() == 1){
				max++;
			}
		}
		if(max < 8){
			free = true;
		}
		return free;
	}
	
}