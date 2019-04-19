package model;

import java.util.ArrayList;
public class Drug{

	//attributes
	private String name;
	private double cost;
	private int dosis;
	private int frecuency;
	
	//methods
	
	/**
	* init attributes and relations of a drug<br>
	* <b>Pos:</b> the drug has been created<br>
	* @param name is the name of the drug <br>
	* @param cost is the cost of the drug <br>
	* @param dosis is the dosis of the drug <br>
	* @param frecuency is the frecuency of the drug <br>
	*/
	
  public Drug(String name, double cost, int dosis, int frecuency){
    this.name = name;
    this.cost = cost;
    this.dosis = dosis;
    this.frecuency = frecuency;
  }
  
	/**
	* get the name of a drug <br>
	* @return name is the name of a drug <br>
	*/
	
  public String getName(){
    return name;
  }
  
	/**
	* set the name of a drug <br>
	* @param name is the name of a drug<br>
	*/
	
  public void setName(String name){
	this.name = name;
  }
  
	/**
	* get the cost of a drug <br>
	* @return cost is the cost of a drug <br>
	*/
	
  public double getCost(){
    return cost;
  }
  
  	/**
	* set the cost of a drug <br>
	* @param cost is the cost of a drug<br>
	*/
	
  public void setCost(double cost){
	this.cost = cost;
  }
  
	/**
	* get the dosis of a drug <br>
	* @return dosis is the dosis of a drug <br>
	*/
	
  public int getDosis(){
    return dosis;
  }
  
  	/**
	* set the dosis of a drug <br>
	* @param dosis is the dosis of a drug<br>
	*/
	
  public void setDosis(int dosis){
	this.dosis = dosis;
  }
  
	/**
	* get the frecuency of a drug <br>
	* @return frecuency is the frecuency of a drug <br>
	*/
	
  public int getFrecuency(){
    return frecuency;
  }
  
  	/**
	* set the frecuency of a drug <br>
	* @param frecuency is the frecuency of a drug<br>
	*/
	
  public void setFrecuency(int frecuency){
	this.frecuency = frecuency;
  }
 
} 