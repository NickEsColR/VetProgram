package model;

import java.util.ArrayList;
public class Veterinary{
	
	//constants
	public final static int room = 8;
	
	
	//relations
	private ArrayList <Owner> person;
	private Room [] rooms;

	//methods
	public Veterinary(){
		
		person = new ArrayList <Owner> ();
		rooms = new Room[room]; 
	}
	
}