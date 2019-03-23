package model;

import java.util.ArrayList;
public class ClinicHistory{
	
	//attributes
	
	private Pet pet;
	private Owner owner;
	private Room room;
	private boolean open;
	private double cost;
	private int numberOfDays;
	private ArrayList <ClinicHistory> clinicHistories; 
	
	//relations
	private ArrayList <Drug> drugs;
	
	//methods
	public ClinicHistory(Pet pet, Owner owner, boolean open, double cost,int days, Room room){
	  this.open = open;
	  this.cost = cost;
	  this.pet = pet;
	  this.owner = owner;
	  this.room = room;
	  numberOfDays = days;
	  clinicHistories = new ArrayList <ClinicHistory> ();
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
	public int getDays(){
		return numberOfDays;
	}
	public void setDays(int days){
		numberOfDays = days;
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
	public void addDrug(Drug drug){
		drugs.add(drug);
	}
}