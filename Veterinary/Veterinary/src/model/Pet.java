package model;

import java.util.ArrayList;
public class Pet{
	
	//constants
	public final static String TYPE_DOG = "dog";
	public final static String TYPE_CAT = "cat";
	public final static String TYPE_BIRD = "bird";
	public final static String TYPE_OTHER = "other";

	//atributes
	private String name;
	private String type;
	private int age;
	private double weight;
	private ArrayList <ClinicHistory> clinicHistories;
	//relations
	private Room room;
	private ClinicHistory cHistory;
	
	//methods
	public Pet(String name, String type, int age, double weight){
	  this.name = name;
	  this.type = type;
	  this.age = age;
	  this.weight = weight;
	  clinicHistories = new ArrayList <ClinicHistory>();
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type = type;
	}
	public int getAge(){
		return age;
	}
	public void setAge(){
		this.age = age;
	}
	public double getWeight(){
		return weight;
	}
	public void setWeight(double weight){
		this.weight = weight;
	}
	public ClinicHistory getClinicHistory(){
		return cHistory;
	}
	public void setClinicHistory(ClinicHistory ch){
		cHistory = ch;
	}
	public Room getRoom(){
		return room;
	}
	public void setRoom(Room room){
		this.room = room;
	}
	public ArrayList<ClinicHistory> getClinicHistories(){
		return clinicHistories;
	}
	public void addClinicHistories(ClinicHistory newCH){
		clinicHistories.add(newCH);
	}
	public int freeRoom(){
		int free = 0;
		if(cHistory != null){
			free = 1;
		}
		return free;
	}
	
	public void goToPet(Owner owner, Pet pet){
	if(clinicHistories!= null){
	
	}
		
	
	}
	public double makeCost(){
	double cost = 0;
	if(type .equals(TYPE_CAT)){
		if(weight >= 1 && weight <= 3)
			cost = 10000.0;
		else if(weight > 3 && weight <= 10)
			cost = 12000.0;
		else if(weight > 10 && weight <= 20)
			cost = 15000.0;
		else
			cost = 20000.0;
	}
	if(type .equals(TYPE_DOG)){
		if(weight >= 1 && weight <= 3)
			cost = 15000.0;
	}
	return cost;
	}
}
