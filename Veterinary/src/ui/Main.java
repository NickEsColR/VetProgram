package ui;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import model.*; 
public class Main{

	//relation
	
	private Veterinary vet;
	
	//methods
	
	public static void main (String[]args){
		Main m = new Main();
	}
	
	//metodo init
	
	public Main(){
		vet = new Veterinary();
		Scanner option = new Scanner(System.in);
		int cont = 0;
		
		Pet pet2 = new Pet("Misi", "cat", 7, 7.56);//Second pet for owner 1
		Pet pet1 = new Pet( "Firu", "dog",  5 ,  15.4);//First pet for owner 1
		Owner owner1 = new Owner( "Seamus",  "19820402",  "Avenida 4 calle 2-4",  "3234567898");//Owner 1
		owner1.setPets(pet1 );
		owner1.setPets(pet2 );		
		vet.addPeople( owner1);
		Drug drug1 = new Drug("vetriderm", 25000.0, 2, 3);
		while (cont !=8){
			int election = option.nextInt();
			switch(election){
				case 1:
				
				break;
				case 2:
				
				break;
				case 3:
				
				break;
				case 4:
				
				break;
				case 5:
				
				break;
				case 6:
				
				break;
				case 7:
				
				break;
				case 8:
					System.out.println("*************************************************************************");
					System.out.println("que vuelva pronto");
					System.out.println("*************************************************************************");
					cont = 8;
				break;
				default:
					System.out.println("*************************************************************************");
					System.out.println("Porfavor elija una opcion valida");
					System.out.println("*************************************************************************");
				break;
			}
		}
	}
	
	//Menu method
	
	public void showMenu(){
		System.out.println("digite el numero de la opcion que desea");
		System.out.println("1. Ver si hay un cuarto disponible");
		System.out.println("2. Crear una nueva historia clinica");
		System.out.println("3. Ver historias clinicas abiertas");
		System.out.println("4. Consultar datos de contacto del dueño");
		System.out.println("5. Dar una mascota de alta");
		System.out.println("6. Ver los ingresos por ospitalizacion");
		System.out.println("7. Ver el cuarto en el que se encuentra una mascota");
		System.out.println("8. Salir del programa ");
	}
}