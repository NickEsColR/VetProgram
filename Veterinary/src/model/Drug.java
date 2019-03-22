package model;

import java.util.ArrayList;
public class Drug{

	//attributes
	private String name;
	private double cost;
	private int dosis;
	private int frecuency;
	
	//methods
  public Drug(String name, double cost, int dosis, int frecuency){
    this.name = name;
    this.cost = cost;
    this.dosis = dosis;
    this.frecuency = frecuency;
  }
  public String getName(){
    return name;
  }
  public void setName(String name){
	this.name = name;
  }
  public double getCost(){
    return cost;
  }
  public void setCost(double cost){
	this.cost = cost;
  }
  public int getDosis(){
    return dosis;
  }
  public void setDosis(int dosis){
	this.dosis = dosis;
  }
  public int getFrecuency(){
    return frecuency;
  }
  public void setFrecuency(int frecuency){
	this.frecuency = frecuency;
  }
 
} 