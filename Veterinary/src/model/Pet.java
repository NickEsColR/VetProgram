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
	private double height;
	private ArrayList <ClinicHistory> clinicHistories;
	
	//relations
	
	private Room room;
	private ClinicHistory cHistory;
	private ArrayList<Service> services;
	
	//methods
	
	/**
	* init attributes and relations of a pet<br>
	* <b>Pos:</b> the pet has been created<br>
	* @param name of a pet. This param couldn´t be empty<br>
	* @param type of pet. This param couldn´t be empty<br>
	* @param age of the pet. This param couldn´t be empty.<br>
	* @param weight of the pet. weight > 0.<br>
	* @param height of the pet. height > 0.<br>
	*/
	
	public Pet(String name, String type, int age, double weight,double height){
	  this.name = name;
	  this.type = type;
	  this.age = age;
	  this.weight = weight;
	  this.height = height;
	  clinicHistories = new ArrayList <ClinicHistory>();
	  services = new ArrayList <Service>();
	}
	
	/**
	* get the name of a pet<br>
	* @return name of the pet<br>
	*/
	
	public String getName(){
		return name;
	}
	
	/**
	* set the name of a pet<br>
	* @param name of the pet. name != ""<br>
	*/
	
	public void setName(String name){
		this.name = name;
	}
	
	/**
	* get the tyoe of a pet<br>
	* @return type of the pet<br>
	*/
	
	public String getType(){
		return type;
	}
	
	/**
	* set the type of a pet<br>
	* @param type of the pet. type != ""<br>
	*/
	
	public void setType(String type){
		this.type = type;
	}
	
	/**
	* get the age of a pet<br>
	* @return age of the pet<br>
	*/
	
	public int getAge(){
		return age;
	}
	
	/**
	* set the age of a pet<br>
	* @param age of the pet. <br>
	*/
	
	public void setAge(){
		this.age = age;
	}
	
	/**
	* get the weight of a pet<br>
	* @return weight of the pet<br>
	*/
	
	public double getWeight(){
		return weight;
	}
	
	/**
	* set the weight of a pet<br>
	* @param weight of the pet. weight > 0<br>
	*/
	
	public void setWeight(double weight){
		this.weight = weight;
	}
	
	/**
	* get the clinic history open of a pet<br>
	* @return cHistory of the pet<br>
	*/
	
	public ClinicHistory getClinicHistory(){
		return cHistory;
	}
	
	/**
	* set the clinic history of a pet<br>
	* @param ch of the pet. ch != null<br>
	*/
	
	public void setClinicHistory(ClinicHistory ch){
		cHistory = ch;
	}
	
	/**
	* get the room of a pet<br>
	* @return room of the pet<br>
	*/
	
	public Room getRoom(){
		return room;
	}
	
	/**
	* set the room of a pet<br>
	* @param room of the pet. room != null <br>
	*/
	
	public void setRoom(Room room){
		this.room = room;
	}
	
	/**
	* get the clinicHistories of a pet<br>
	* @return ArrayList of ClinicHistory of the pet<br>
	*/
	
	public ArrayList<ClinicHistory> getClinicHistories(){
		return clinicHistories;
	}
	
	/**
	* add the clinic histories of a pet<br>
	* @param newCH of the pet. type != null<br>
	*/
	
	public void addClinicHistories(ClinicHistory newCH){
		clinicHistories.add(newCH);
	}
	
	/**
	* see if the cHistory is not null <br>
	* @return free is a number that say if is null or not <br>
	*/
	
	public int freeRoom(){
		int free = 0;
		if(cHistory != null){
			free = 1;
		}
		return free;
	}
	
	/**
	* get the number of the room in use <br>
	* @return room number of the room in use <br>
	*/
	
	public int getRoomNumber(){
		
		return room != null ? room.getNumber() : 0;
	}
	
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
	* @see ClinicHistory.setHistory()<br>
	* @see ClinicHistory.setDate()<br>
	* @see ClinicHistory.setDrug()<br>
	*/
	
	public void createClinicHistory(Owner owner, Pet pet, int day,int month, int year, String sintoms, String diagnostic,
									Room freeRoom, Drug[]cDrugs){
		ClinicHistory ch = new ClinicHistory(pet, owner, true, makeCost(),sintoms, diagnostic,  freeRoom);
		setClinicHistory(ch);
		ch.setHistory( clinicHistories);
		ch.setDate( day,  month,  year);
		ch.setDrug( cDrugs);
	}
	
	/**
	* calculate the cost of a hospitalization <br>
	* @return cost is the cost base for a hospitalization <br>
	*/
	
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
	
	/**
	* search the drugs for a clinic history of a determinated date <br>
	* @param day is the day the clinic history was created <br>
	* @param month is the month the clinic history was created <br>
	* @param year is the year the clinic history was created <br>
	* @see ClinicHistory.findDrugs()<br>
	* @return ArrayList of drugs <br>
	*/
	
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
			if(clinicHistories.get(i).getDay()== day && clinicHistories.get(i).getMonth() == month && clinicHistories.get(i).getYear() == year){
				cDrugs = clinicHistories.get(i).findDrugs( );
				find = true;
			}
		}
		
		return cDrugs;
	}
	
	/**
	* return a clinic history open <br>
	* @return historyOpen is the clinic history open of the pet <br>
	*/
	
	public ClinicHistory seeClinicHistoriesOpen(){
		ClinicHistory historyOpen = null;
		if(cHistory != null)
			historyOpen = cHistory;
		return historyOpen;
	}
	
	/**
	* close a clinic history open <br>
	* @param date is the date the pet is out of hospitalization <br>
	* @see ClinicHistory.addCostWithDrugs()<br>
	* @return msj is a messaje that the clinic history is closed <br>
	*/
	
	public String closeClinicHistoryOpen(int[]date){
		String msj = "";
		cHistory.setOpen(false);
		int days = cHistory.differenceBetweenEnterDateAndOutDate(date);
		cHistory.addCostWithDrugs( days);
		clinicHistories.add(cHistory);
		cHistory = null;
		msj = "el animal se dio de alta correctamente";
		return msj;
	}
	
	/**
	* get the room number the pet is hospitalized <br>
	* @see Room.getRoom()<br>
	* @return the room number the pet is hospitalized <br>
	*/
	
	public int roomNumberOfAPet(){
		
		
		return cHistory!=null ? cHistory.getRoom().getNumber() : 0;
		
		
	}
	
	/**
	* calculate the cost of the clinic histories the pet have <br>
	* @see ClinicHistory.getCost()<br>
	* @return cost is the cost of all clinic histories a pet have <br>
	*/
	
	public double  costOfAllClinicHistories(){
		double cost = 0;
		if(cHistory != null){
			cost += cHistory.getCost();
		}
		for(int i = 0;i < clinicHistories.size();i++){
			cost += clinicHistories.get(i).getCost();
		}
		return cost;
	}
	
	/**
	*Description This method allows to calculate the body mass index for a pet.
	*pre: The pet was created before and its attributes height and weight are not null neither height must be zero.
	*post: The BMI is calculated.
	*@return The pet body mass index. Returns -1 if the height is zero  due to the division on zero does not exist.
	*/

	
	public double calculateBodyMassIndex(){
		double bmi = weight;
		if(height == 0){
			bmi = -1;
		}
		else{
			bmi /= height * height;
		}
		return bmi;
	}
	
	
	
	/**
	* calculate the earnings per service<br>
	* @param type is the service type wanna know the earning<br>
	* @return cost is the earning of a service<br>
	*/
	
	public double costOfAService(String type){
		double cost = 0;
		for(int i = 0; i < services.size();i++){
			if(services.get(i).getName().equals(type)){
				cost += services.get(i).getCost();
			}
		}
		return cost;
	}
	
	/**
	* add a service to a pet<br>
	* <b>Pos:</b> the service has been created<br>
	* @param name is the name of the service <br>
	* @param theDate is the date  the service was loan<br>
	* @param idPet is the  pet id taken the service <br>
	* @param idOwner is the owner id for the pet take the service<br>
	*/
	
	public void addService(String name, int[]theDate, String idPet, String idOwner){
		services.add(new Service(name,theDate,idPet,idOwner));
	}
	
	/**
	* calculate cost of service and count the total of services on a define week<br>
	* @param date is the week start and finish. date is exactly a week<br>
	* @return costAndApparitions are the cost of all services and how many services are<br>
	*/
	/**
	public double[] costAndApparitionOfAWeek(int[] date){
		double[] costAndApparitons = new double[2];
		for(int i = 0;i < services.size();i++){
			if()
		}
		return costAndApparitions;
	}
	*/
	
	/**
	* look for the services are in a determinate start and finish date<br>
	* @param theDate is the start and finish date<br>
	* @return theServices are the services that are on the delimited date<br>
	*/
	
	public ArrayList<Service> getServicesOfADelimitedDate(int[] theDate){
		ArrayList<Service> theServices = new ArrayList<Service>();
		while(theDate[0] != theDate[3] | theDate[1] != theDate[4] | theDate[2] != theDate[5]){
			for(int i = 0;i < services.size();i++){
				if(services.get(i).getDatePos(0) == theDate[0] && services.get(i).getDatePos(1) == theDate[1] && services.get(i).getDatePos(2) == theDate[2]){
					theServices.add(services.get(i));
				}
			}
			theDate[2]++;
			if(theDate[2] == 31){
				theDate[2] = 1;
				theDate[1]++;
				if(theDate[1] == 13){
					theDate[1] = 1;
					theDate[0]++;
				}
			}
			
		}		
		return theServices;
	}
} //end of class