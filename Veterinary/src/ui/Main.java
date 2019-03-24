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
		int num = 0;
		String freeRoom = "";
		Scanner option = new Scanner(System.in);
		int cont = 0;
		ArrayList <Drug> cDrugs = new ArrayList <Drug>();
		String id = "";
		String petName ="";
		Drug drug1 = new Drug("vetriderm", 25000.0, 2, 3);//First drug
		Pet pet2 = new Pet("Misi", "cat", 7, 7.56);//Second pet for owner 1
		Pet pet1 = new Pet( "Firu", "dog",  5 ,  15.4);//First pet for owner 1
		Owner owner1 = new Owner( "Seamus",  "19820402",  "Avenida 4 calle 2-4",  "3234567898");//Owner 1
		owner1.setPets(pet1 );
		owner1.setPets(pet2 );	
		vet.addDrugs(drug1);
		vet.addPeople( owner1);
		
		while (cont !=9){
			showMenu();
			int election = option.nextInt();
			option.nextLine();
			switch(election){
				case 1:
					System.out.println("*************************************************************************");
					if(vet.freeRoom())
						freeRoom = "hay un cuarto disponible";
					else
						freeRoom = "no hay caurtos disponibles";
					System.out.println(freeRoom);
					System.out.println("*************************************************************************");
				
				break;
				case 2:
					System.out.println("*************************************************************************");
					System.out.println("Digite la cedula del duenho");
					id = option.nextLine();
					System.out.println("Digite el nombre de la mascota");
					petName = option.nextLine();
					System.out.println("Digite el dia en el que ingresa la mascota en el cuarto ");
					int day = option.nextInt();
					System.out.println("Digite el mes en el que ingresa la mascota en el cuarto ");
					int month = option.nextInt();
					System.out.println("Digite el anho en el que ingresa la mascota en el cuarto ");
					int year = option.nextInt();
					option.nextLine();
					System.out.println("Escriba los sintomas presentados");
					String sintoms = option.nextLine();
					System.out.println("Escriba el diagnostico");
					String diagnostic = option.nextLine();
					System.out.println("Digite cuantos medicamentos se van a usar");
					int drugs = option.nextInt();
					String []drugName = new String [drugs];
					for(int i = 0;i < drugs;i++){
						System.out.println("Digite el nombre del medicamento");
						drugName[i] = option.nextLine();
					}
					vet.createClinicHistory(id, petName, day, month, year, sintoms, diagnostic, drugName);
					System.out.println("*************************************************************************");
				case 3:
					System.out.println("*************************************************************************");
					System.out.println("Digite la cedula del duenho");
					id = option.nextLine();
					System.out.println("Digite el nombre de la mascota cuyos medicamentos de hospitalizacion desea conocer	");
					petName = option.nextLine();
					System.out.println("Digite el dia en el que ingreso la mascota en el cuarto ");
					 day = option.nextInt();
					System.out.println("Digite el mes en el que ingreso la mascota en el cuarto ");
					 month = option.nextInt();
					System.out.println("Digite el anho en el que ingreso la mascota en el cuarto ");
					 year = option.nextInt();
					cDrugs = vet.findDrugsOfAClinicHistory( id,  petName, day,  month,  year );
					System.out.println("*************************************************************************");
				break;
				case 4:
					System.out.println("*************************************************************************");
					System.out.println(vet.seeClinicHistoriesOpen());
					System.out.println("*************************************************************************");
				break;
				case 5:
					System.out.println("*************************************************************************");
					System.out.println("que vuelva pronto");
					System.out.println("*************************************************************************");
				break;
				case 6:
					System.out.println("*************************************************************************");
					System.out.println("Digite la cedula del duenho");
					id = option.nextLine();
					System.out.println("Digite el nombre de la mascota cuyos medicamentos de hospitalizacion desea conocer	");
					petName = option.nextLine();
					System.out.println(vet.closeClinicHistoryOpen(id, petName));
					System.out.println("*************************************************************************");
				break;
				case 7:
					System.out.println("*************************************************************************");
					System.out.println("que vuelva pronto");
					System.out.println("*************************************************************************");
				break;
				case 8:
					System.out.println("*************************************************************************");
					System.out.println("que vuelva pronto");
					System.out.println("*************************************************************************");
				break;
				case 9:
					System.out.println("*************************************************************************");
					System.out.println("que vuelva pronto");
					System.out.println("*************************************************************************");
					cont = 9;
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
		System.out.println("3. Conocer los medicamentosque tiene una historia");
		System.out.println("4. Ver historias clinicas abiertas");
		System.out.println("5. Consultar datos de contacto del dueño");
		System.out.println("6. Dar una mascota de alta");
		System.out.println("7. Ver los ingresos por hospitalizacion");
		System.out.println("8. Ver el cuarto en el que se encuentra una mascota");
		System.out.println("9. Salir del programa ");
	}
}