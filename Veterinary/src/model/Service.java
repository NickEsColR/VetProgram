package model;

import java.util.ArrayList;
public class Service{

	//Constants
	
	public final static String SHOWER_PET = " banho de mascotas en la veterinaria";
	public final static String SHOWER_DOMICILE = "banho de mascotas a domicilio" ;
	public final static String NAIL_CUT = "corte de unhas";
	public final static String DENTAL_PROPHYLAXIS = "profilaxis dental" ;
	public final static String VACCINE = "aplicacion de vacunas";
	public final static double COST_SHOWER_PET = 20000;
	public final static double COST_SHOWER_DOMICILE = 30000;
	public final static double COST_NAIL_CUT = 8000;
	public final static double COST_DENTAL_PROPHYLAXIS = 12000;
	public final static double COST_VACCINE = 45000;
	
	//attributes
	
	private String name;
	private double cost;
	private int[] date;
	private String idPet;
	private String idOwner;
	
	//methods
	
	/**
	* init attributes  of a Service<br>
	* <b>Pos:</b> the service has been created<br>
	* @param name is the name of the service <br>
	* @param theDate is the date  the service was loan. format year/month/day<br>
	* @param idPet is the  pet id taken the service <br>
	* @param idOwner is the owner id for the pet take the service<br>
	*/
	
	
	public Service(String name, int[]theDate, String idPet, String idOwner){
		this.name = name;
		this.cost = cost;
		date = new int[3];
		date = theDate;
		this.idPet = idPet;
		this.idOwner = idOwner;
	}
	
	/**
	* get the name of a service<br>
	* @return name is the name of a service<br>
	*/
	
	public String getName(){
		return name;
	}
	/**
	* define the cost of a service<br>
	* <b>pre:</b> the name is one of the constants of type service<br>
	* <b>pos:</b> the cost is added <br>
	*/
	
	public void setCost(){
		if(name .equals(SHOWER_PET))
			cost = COST_SHOWER_PET;
		else if(name .equals(SHOWER_DOMICILE))
			cost = COST_SHOWER_DOMICILE;
		else if(name .equals(NAIL_CUT))
			cost = 	COST_NAIL_CUT;
		else if(name .equals(DENTAL_PROPHYLAXIS))
			cost = COST_DENTAL_PROPHYLAXIS;
		else if(name .equals(VACCINE))
			cost = COST_VACCINE;
	}
	
	/**
	* get the cost of a service<br>
	* <b>pre:</b> cost > 0<br>
	* @return cost is the cost of a service <br>
	*/
	
	public double getCost(){
		return cost;
	}
	
	/**
	* get a determinate position of a date of a service<br>
	* @param pos is a position on the date<br>
	* @return date is the date the service was taking<br>
	*/
	
	public int getDatePos(int pos){
		return date[pos];
	}
	
	/** 
	* modify the toString method<br>
	* @return  msg a message that contain the attributes of a service<br>
	*/
	
	public String toString(){
		String msg = ("el servicio "+name+" prestado en la fecha "+ date[2]+"/"+date[1]+"/"+date[0]+" para la mascota "+idPet+" del dueño con el numero de identificacion"+
		idOwner+" presento un costo de "+cost +" por servicios prestados");
		return msg;
	}
}//end of classs