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
	
	//relations
	private Room room;
	private ClinicHistory cHistories;
}