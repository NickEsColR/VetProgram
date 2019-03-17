package model;

import java.util.ArrayList;
public class Veterinary{
	
	//constants
	public final static int room = 8;
	
	//attributes
	private ArrayList <ClinicHistory>  clinicHistories;
	
	//relations
	private ArrayList <Owner> person;
	private Room [] rooms;

	//methods
	public Veterinary(){
		clinicHistories = new ArrayList <ClinicHistory> ();
		person = new ArrayList <Owner> ();
		rooms = new Room[room]; 
	}
	
}