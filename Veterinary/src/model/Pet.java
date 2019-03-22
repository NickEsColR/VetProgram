package model;

import java.util.ArrayList;
public class Pet{
	
	//constants
	public final static String TypeDog = "dog";
	public final static String TypeCat = "cat";
	public final static String TypeBird = "bird";
	public final static String TypeOther = "other";

	//atributes
	private String name;
	private String type;
	private int age;
	private double weight;
	private ArrayList <ClinicHistory>  clinicHistories;

	//relations
	private Room room;
	private ClinicHistory cHistories;
	
	//methods
	public Pet(String name, String type, int age, double weight){
	  this.name = name;
	  this.type = type;
	  this.age = age;
	  this.weight = weight;
	  clinicHistories = new ArrayList <ClinicHistory> ();
	}
}