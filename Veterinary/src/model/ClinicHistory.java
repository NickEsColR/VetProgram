package model;

import java.util.ArrayList;
public class ClinicHistory{
	
	//attributes
	private boolean open;
	private double cost;
	private int numberOfDays;
	private ArrayList <ClinicHistory> history; 
	
	//relations
	private ArrayList <Drug> drugs;
	
	//methods
	public ClinicHistory(boolean open, double cost,int days){
	  this.open = open;
	  this.cost = cost;
	  numberOfDays = days;
	  clinicHistories = new ArrayList <ClinicHistory> ();
	}
	public boolean getOpen(){
	  return open;
	}
	public double getCost(){
	  return cost;
	}
  public void setCost(){
    for(int i = 0;i<drugs.size();i++){
      cost += drugs.get(i).getCost();
    }
  }
}