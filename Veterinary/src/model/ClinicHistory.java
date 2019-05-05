package model;

import java.util.ArrayList;
public class ClinicHistory{
	
	//attributes
	
	private Pet pet;
	private Owner owner;
	private boolean open;
	private double cost;
	private String sintoms;
	private String diagnostic;
	private ArrayList <ClinicHistory> clinicHistories; 
	private int [] date;
	private Room room;
	
	//relations
	private ArrayList <Drug> drugs;
	
	
	//methods
	
	
	/**
	* create the clinic history for a pet <br>
	* @param owner is the owner of the pet. owner != null <br>
	* @param pet is the pet for the clinic history. pet != null <br>
	* @param day is the day the clinic history is created <br>
	* @param month is the month the clinic history is created <br>
	* @param year is the year the clinic history is created <br>
	* @param sintoms are the sintoms the pet have <br>
	* @param diagnostic is the diagnostic of what the pet have <br>
	* @param freeRoom is the room the pet is hospitalize. freeRoom != null <br>
	* @param cDrugs are the drugs the pet is going to use <br>
	*/
	
	public ClinicHistory(Pet pet, Owner owner, boolean open, double cost, String sintoms, String diagnostic, Room room){
	  this.open = open;
	  this.cost = cost;
	  this.pet = pet;
	  this.owner = owner;
	  this.room = room;
	  this.sintoms = sintoms;
	  this.diagnostic = diagnostic;
	  clinicHistories = new ArrayList <ClinicHistory> ();
	  date = new int[3];
	}
	
	/**
	* get the owner of a clinic history <br>
	* @return owner is the owner of a pet that have a clinic history <br>
	*/
	
	
	public Owner getOwner(){
		return owner;
	}
	
	/**
	* set the owner of a clinic history <br>
	* @param owner is the owner of a pet that have a clinic history <br>
	*/
	
	public void setOwner(Owner owner){
		this.owner = owner;
	}
	
	/**
	* get the pet of a clinic history <br>
	* @return pet is the pet  that have a clinic history <br>
	*/
	
	public Pet getPet(){
		return pet;
	}
	
	/**
	* set the pet of a clinic history <br>
	* @param pet is the pet  that have a clinic history <br>
	*/
	
	public void setPet(Pet pet){
		this.pet = pet;
	}
	
	/**
	* get the room of a clinic history <br>
	* @return room is the room of a pet that have a clinic history <br>
	*/
	
	public Room getRoom(){
		return room;
	}
	
	/**
	* get if the  clinic history is open <br>
	* @return open is if the clinic history is open<br>
	*/
	
	public boolean getOpen(){
	  return open;
	}
	
	/**
	* set if the  clinic history is open <br>
	* @param open is if the clinic history is open<br>
	*/
	
	public void setOpen(boolean open){
		this.open = open;
	}
	
	/**
	* get the cost of a clinic history <br>
	* @return cost is the cost of a clinic history <br>
	*/
	
	public double getCost(){
	  return cost;
	}
	
	/**
	* set the cost of a clinic history depending with the drugs<br>
	* @see Drug.getCost()<br>
	*/
	
	public void setCost(){
		for(int i = 0;i<drugs.size();i++){
			cost += drugs.get(i).getCost();
		}
	}
	
	/**
	* get the clinic histories preview  of a pet <br>
	* @return Arraylist of a clinic history is the preview histories of a pet <br>
	*/
	
	public ArrayList<ClinicHistory> getHistory(){
		return clinicHistories;
	}
	
	/**
	* set the clinic histories preview  of a pet <br>
	* @param Arraylist of a clinic history is the preview histories of a pet <br>
	*/
	
	public void setHistory(ArrayList<ClinicHistory> clinicHistories){
		this.clinicHistories = clinicHistories;
	}
	
	/**
	* get the drugs of a clinic history <br>
	* @return ArrayList of Drug is the drugs  that have a clinic history <br>
	*/
	
	public ArrayList<Drug> getDrug(){
		return drugs;
	}
	
	/**
	* set the drugs of a clinic history <br>
	* @param Array of Drug is the drugs  that have a clinic history <br>
	*/
	
	public void setDrug(Drug[] drug){
		for(int i = 0;i < drug.length;i++){
			drugs.add(drug[i]);
		}
	}
	
	/**
	* set the date of a clinic history <br>
	* @param day is the day  a clinic history open <br>
	* @param month is the month  a clinic history open <br>
	* @param year is the year  a clinic history open <br>
	*/
	public void setDate(int day, int month, int year){
		date[0] = day;
		date[1] = month;
		date[2] = year;
	}
	
	/**
	* get the date of a clinic history <br>
	* @return date is the date the clinic history open <br>
	*/
	
	public int[] getDate(){
		return date;
	}
	
	/**
	* get the day of a clinic history <br>
	* @return day is the day  a clinic history open <br>
	*/
	
	public int getDay(){
		return date[0];
	}
	
	/**
	* get the month of a clinic history <br>
	* @return month is the month  a clinic history open <br>
	*/
	
	public int getMonth(){
		return date[1];
	}
	
	/**
	* get the year of a clinic history <br>
	* @return year is the year  a clinic history open <br>
	*/
	
	public int getYear(){
		return date[2];
	}
	
	/**
	* see the drugs a clinic history have<br>
	* @return ArrayList of Drug is the drugs a clinic history have<br> 
	*/
	
	public ArrayList<Drug> findDrugs(){
		ArrayList<Drug> cDrugs = new ArrayList<Drug>();
		for(int i = 0;i < drugs.size();i++){
			cDrugs.add(drugs.get(i));
		}
		return cDrugs;
		
	}
	
	/**
	* calculate the difference between the date a clinic history was open and the date that close<br>
	* @param outDate is the date the clinic history will close<br>
	* @return difference is how many days pass since the clinic history open and when it close<br>
	*/
	
	public int differenceBetweenEnterDateAndOutDate(int[]outDate){
		int difference = 0;
		for(int i = 2; i >= 0;i--){
			difference += outDate[i] - date[i];
			if(i == 2){
				difference *= 365;
			}
			else if(i == 1){
				difference *= 30;
			}
		}
		return difference;
	}
	
	/**
	* add the cost for the drugs the pet recieve for the hospitalization <br>
	* @param days is how many days pass since the clinic history open and close <br>
	*/
	
	public void addCostWithDrugs(int days){
	for(int i = 0;i < drugs.size();i++){
		cost += drugs.get(i).getCost() * days;
	}
	}
	
	/**
	*Description This method allows to add new medicines that were prescription during the hospitalization at the patient stories.
	*<b>Pre:</b> The patient clinic story must be not null.
	*<b>Post: </b>New medicines were added to the patient clinic story.
	*@param The medicine name. This param must be not null.
	*@param The medicine dose, this param refers to the amount of medicine supplied to the pet each time according the frequence assigned. This param must be not null.
	*@param The medicine cost by each dose. This param could be empty.
	*@param The frequency of medicine application. This param could be empty.
	*@return A message that indiques if medicine was added to the patient clinic story
	*/

	public String addDrugToExistentCH(String name, double cost, int dosis, int frecuency){
		String msj = "la medicina se agrego correctamente";
		drugs.add(new Drug( name,  cost,  dosis,  frecuency));
		return msj;
	}
	
	/**
	*Description This method allows to add new notes to the possible diagnostic during the hospitalization at the patient stories.
	*pre: The patient clinic story must be not null.
	*post: New notes were added to the possible diagnostic in the patient clinic story.
	*@param The notes of possible diagnostic. This param must be not null.
	*/


	public void addDiagnosticNotes(String notes){
		diagnostic += notes;
	}
	
	/**
	*Description This method allows to add a new symptom presented during the hospitalization at the patient stories.
	*pre: The patient clinic story must be not null.
	*post: A new symptom were added to the patient clinic story.
	*@param The new symptom presented. This param must be not null.
	*/

	
	public void addSintomsNotes(String notes){
		sintoms += notes;
	}
	
	/**
	* get a determinate position of a date of a service<br>
	* @param pos is a position on the date<br>
	* @return date is the date the service was taking<br>
	*/
	
	public int getDatePos(int pos){
		return date[pos];
	}
} //end of class