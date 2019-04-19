package model;

import java.util.ArrayList;
public class Room{
	
	//attributes
	private int number;
	
	//methods
	
	/**
	* init attributes and relations of a room<br>
	* <b>Pos:</b> the room has been created<br>
	* @param number is the number of the room <br>
	*/
	
	public Room(int number){
		this.number = number;
	}
	
	/**
	* get the number of a room <br>
	* @return number is the number of a room <br>
	*/
	
	public int getNumber(){
		return number;
	}
	
	/**
	* set the number of a room <br>
	* @param number is the number of a room<br>
	*/
	
	public void setNumber(int number){
		this.number = number;
	}
}