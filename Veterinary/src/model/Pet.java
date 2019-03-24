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
	public int getRoomNumber(){
		return room.getNumber();
	}
	public void createClinicHistory(Owner owner, Pet pet, int day,int month, int year, String sintoms, String diagnostic,
									Room freeRoom, Drug[]cDrugs){
		ClinicHistory ch = new ClinicHistory(pet, owner, true, makeCost(),sintoms, diagnostic,  freeRoom);
		setClinicHistory(ch);
		ch.setHistory( clinicHistories);
		ch.setDate( day,  month,  year);
		ch.setDrug( cDrugs);
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
	else if(type .equals(TYPE_DOG)){
		if(weight >= 1 && weight <= 3)
			cost = 15000.0;
		else if(weight > 3 && weight <= 10)
			cost = 17000.0;
		else if(weight > 10 && weight <= 20)
			cost = 20000.0;
		else 
			cost = 25000.0;
	}
	else if(type .equals(TYPE_BIRD)){
		if(weight >= 1 && weight <= 3)
			cost = 10000.0;
		else if(weight > 3 && weight <= 10)
			cost = 12000.0;
		else if(weight > 10 && weight <=20)
			cost = 20000.0;
		else
			cost = 25000.0;
	}
	else{
		if(weight >= 1 && weight <= 3)
			cost = 10000.0;
		else if(weight > 3 && weight <= 10)
			cost = 17000.0;
		else if(weight > 10 && weight <= 20)
			cost = 30000.0;
		else 
			cost = 33000.0;
	}
	return cost;
	}
	public ArrayList<Drug> findDrugs(int day, int month, int year){
		ArrayList<Drug> cDrugs = new ArrayList<Drug>();
		boolean find = false;
		if(cHistory != null){
			if(cHistory.getDay()== day && cHistory.getMonth() == month && cHistory.getYear() == year){
				cDrugs = cHistory.findDrugs( );
				find = true;
			}
		}
		for(int i = 0;i < clinicHistories.size()&&!find;i++){
			if(clinicHistories.getDay()== day && clinicHistories.getMonth == month && clinicHistories.getYear == year){
				cDrugs = clinicHistories.findDrugs( );
				find = true;
			}
		}
		return cDrugs;
	}
	public ClinicHistory seeClinicHistoriesOpen(){
		ClinicHistory historyOpen = null;
		if(cHistory != null)
			historyOpen = cHistory;
		return historyOpen;
	}
}