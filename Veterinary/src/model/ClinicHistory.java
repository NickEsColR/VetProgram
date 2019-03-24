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
	
	//relations
	private ArrayList <Drug> drugs;
	private Room room;
	
	//methods
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
	public Owner getOwner(){
		return owner;
	}
	public void setOwner(Owner owner){
		this.owner = owner;
	}
	public Pet getPet(){
		return pet;
	}
	public void setPet(Pet pet){
		this.pet = pet;
	}
	public Room getRoom(){
		return room;
	}
	public void setRoom(Room room){
		this.room = room;
	}
	public boolean getOpen(){
	  return open;
	}
	public void setOpen(boolean open){
		this.open = open;
	}
	public double getCost(){
	  return cost;
	}
	public void setCost(){
		for(int i = 0;i<drugs.size();i++){
			cost += drugs.get(i).getCost();
		}
	}
	
	public ArrayList<ClinicHistory> getHistory(){
		return clinicHistories;
	}
	public void setHistory(ArrayList<ClinicHistory> clinicHistories){
		this.clinicHistories = clinicHistories;
	}
	public ArrayList<Drug> getDrug(){
		return drugs;
	}
	public void setDrug(Drug[] drug){
		for(int i = 0;i < drug.length;i++){
			drugs.add(drug[i]);
		}
	}
	public void setDate(int day, int month, int year){
		date[0] = day;
		date[1] = month;
		date[2] = year;
	}
	public int[] getDate(){
		return date;
	}
	public int getDay(){
		return date[0];
	}
	public int getMonth(){
		return date[1];
	}
	public int getYear(){
		return date[2];
	}
	public ArrayList<Drug> findDrugs(){
		ArrayList<Drug> cDrugs = new ArrayList<Drug>();
		for(int i = 0;i < drugs.size();i++){
			cDrugs.add(drugs.get(i));
		}
		return cDrugs;
		
	}
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
	public void addCostWithDrugs(int days){
	for(int i = 0;i < drugs.size();i++){
		cost += drugs.get(i).getCost() * days;
	}
	}
}