package model;

import java.util.ArrayList;
public class Owner{
	
	//attributes
	private String name;
	private String id;
	private String adress;
	private String phone;
	
	//relations
	private ArrayList<Pet> pet;

  //methods
  public Owner(String name, String id, String adress, String phone){
    this.name = name; 
    this.id = id;
    this.adress = adress;
    this.phone = phone;
  }
}