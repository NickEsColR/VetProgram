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
		String typeName = "";
		String idOwner = "";
		int num = 0;
		int[]date = new int[3];
		String freeRoom = "";
		Scanner option = new Scanner(System.in);
		int cont = 0;
		int[] determinateDate = new int[6];
		ArrayList <Drug> cDrugs = new ArrayList <Drug>();
		String id = "";
		String petName ="";
		Drug drug1 = new Drug("vetriderm", 25000.0, 2, 3);//First drug
		Pet pet2 = new Pet("Misi", "cat", 7, 7.56, 2.50);//Second pet for owner 1
		Pet pet1 = new Pet( "Firu", "dog",  5 ,  15.4, 4.57);//First pet for owner 1
		Owner owner = new Owner( "Seamus",  "19820402",  "Avenida 4 calle 2-4",  "3234567898");//Owner 1
		owner.setPets(pet1 );
		owner.setPets(pet2 );	
		vet.addDrugs(drug1);
		Room room = vet.getFreeRoomNumber(); //free room
		vet.addPeople( owner);
		ClinicHistory ch1 = new ClinicHistory(pet1, owner, true, 20000.0, "problemas en la piel", "Alergia", room);
		pet1.setClinicHistory(ch1);
		ch1.setDate(23, 03, 2019);
		pet1 = new Pet( "Zeus", "dog",  2 ,  7.22, 1.9);//First pet for owner 2
		pet2 = new Pet("Felix", "cat", 4, 5.8, 3);//Second pet for owner 2
		owner = new Owner( "Jea Eun Kim",  "1509286426",  "Calle 4 kra 12-40",  "3576890729");//Owner 2
		owner.setPets(pet1 );
		owner.setPets(pet2 );
		room = vet.getFreeRoomNumber(); //free room
		vet.addPeople( owner);
		ch1 = new ClinicHistory(pet1, owner, false, 35000.0, "escamas en la piel", "Enfermedad de la piel", room);
		pet1.addClinicHistories(ch1);
		ch1.setDate(05, 07, 2018);
		date[0] = 2019;
		date[1] = 02;
		date[2] = 25;
		vet.addService(Service.SHOWER_PET, date,"Firu","19820402");
		date[0] = 2018;
		date[1] = 12;
		date[2] = 15;
		vet.addService(Service.NAIL_CUT, date,"Misi","19820402");
		date[0] = 2019;
		date[1] = 04;
		date[2] = 07;
		vet.addService(Service.VACCINE, date,"Zeus","1509286426");
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
					if(cDrugs.size() == 0){
					System.out.println("No se encontraron drogas. ");
					System.out.println("Es posible que digitara mal la cedula, el nombre de la mascota o la fecha ");
					System.out.println("Tambien es posible que la historia clinica no exista ");
						
					}
					else{
					System.out.println("Lo(s) medicamentos son:  "+cDrugs);
						
					}
					System.out.println("*************************************************************************");
				break;
				case 4:
					System.out.println("*************************************************************************");
					if(vet.seeClinicHistoriesOpen().size() == 0){
					System.out.println("no hay historias clinicas abiertas");	
					}
					else{
						System.out.println(vet.seeClinicHistoriesOpen());
					}
					System.out.println("*************************************************************************");
				break;
				case 5:
					System.out.println("*************************************************************************");
					System.out.println("Digite la cedula del duenho si puede");
					id = option.nextLine();
					System.out.println("Digite el nombre de la mascota cuyos medicamentos de hospitalizacion desea conocer	");
					petName = option.nextLine();
					System.out.println(vet.contactWithOwner(id, petName));
					System.out.println("*************************************************************************");
				break;
				case 6:
					System.out.println("*************************************************************************");
					System.out.println("Digite la cedula del duenho");
					id = option.nextLine();
					System.out.println("Digite el nombre de la mascota cuyos medicamentos de hospitalizacion desea conocer	");
					petName = option.nextLine();
					System.out.println("Digite el dia actual ");
					 date[0] = option.nextInt();
					System.out.println("Digite el mes actual ");
					 date[1] = option.nextInt();
					System.out.println("Digite el anho actual ");
					 date[2] = option.nextInt();
					System.out.println(vet.closeClinicHistoryOpen(id, petName,date));
					System.out.println("*************************************************************************");
				break;
				case 7:
					System.out.println("*************************************************************************");
					System.out.println("El costo de las hospitalizaciones es: "+vet.costOfAllClinicHistories());
					System.out.println("*************************************************************************");
				break;
				case 8:
					
					System.out.println("*************************************************************************");
					System.out.println("Digite la cedula del duenho");
					id = option.nextLine();
					System.out.println("Digite el nombre de la mascota cuyos medicamentos de hospitalizacion desea conocer	");
					petName = option.nextLine();
					int roomNumber = vet.roomNumberOfAPet(id, petName);
					if(roomNumber == 0){
						
						System.out.println("La mascota que busca no esta hospitalizada");
					}
					else{
						System.out.println("el numero de cuarto donde se encuentra la mascota es: "+ roomNumber);	
					}
					System.out.println("*************************************************************************");
				break;
				case 9:
					serviceMenu();
					int type = option.nextInt();
					option.nextLine();
					switch(type){
						case 1:
							typeName = Service.SHOWER_PET;
						break;
						case 2:
							typeName = Service.SHOWER_DOMICILE;
						break;
						case 3:
							typeName = Service.NAIL_CUT;
						break;
						case 4:
							typeName = Service.DENTAL_PROPHYLAXIS;
						break;
						case 5:
							typeName = Service.VACCINE;
						break;
					}
					System.out.println("Los ingresos del servicio "+ typeName + " son "+ vet.calculateAverageOfAService(typeName));
				break;
				case 10:
					System.out.println("*************************************************************************");
					System.out.println("los ingresos totales son "+ vet.earningOfTheVet());
					System.out.println("*************************************************************************");
				break;
				case 11:
					System.out.println("*************************************************************************");
					
					serviceMenu();
					type = option.nextInt();
					option.nextLine();
					System.out.println("escriba el documento de identificacion del dueño ");
					idOwner = option.nextLine();
					System.out.println("escriba el nombre de la mascota");
					petName = option.nextLine();
					System.out.println("digite el anho que se presto el servicio");
					date[0] = option.nextInt();
					option.nextLine();
					System.out.println("digite el mes que se presto el servicio");
					date[1] = option.nextInt();
					option.nextLine();
					System.out.println("digite el dia que se presto el servicio");
					date[2] = option.nextInt();
					option.nextLine();
					
					switch(type){
						case 1:
							typeName = Service.SHOWER_PET;
						break;
						case 2:
							typeName = Service.SHOWER_DOMICILE;
						break;
						case 3:
							typeName = Service.NAIL_CUT;
						break;
						case 4:
							typeName = Service.DENTAL_PROPHYLAXIS;
						break;
						case 5:
							typeName = Service.VACCINE;
						break;
					}
					vet.addService( typeName, date,  petName,  idOwner);
					System.out.println("*************************************************************************");
				break;
				case 12:
					serviceMenu();
					 type = option.nextInt();
					option.nextLine();
					switch(type){
						case 1:
							typeName = Service.SHOWER_PET;
						break;
						case 2:
							typeName = Service.SHOWER_DOMICILE;
						break;
						case 3:
							typeName = Service.NAIL_CUT;
						break;
						case 4:
							typeName = Service.DENTAL_PROPHYLAXIS;
						break;
						case 5:
							typeName = Service.VACCINE;
						break;
					}
					System.out.println("El promedio de ingresos por el servicio de "+typeName+ " es "+vet.calculateAverageOfAService( typeName));
				break;
				case 13:
					System.out.println("*************************************************************************");
					System.out.println("digite el dia de inicio de la semana");
					determinateDate[0] = option.nextInt();
					option.nextLine();
					System.out.println("digite el mes de inicio de la fecha esperada");
					determinateDate[1] = option.nextInt();
					option.nextLine();
					System.out.println("digite el anho de inicio de la fecha esperada");
					determinateDate[2] = option.nextInt();
					option.nextLine();
					System.out.println("digite el dia de cierre de la fecha esperada");
					determinateDate[3] = option.nextInt();
					option.nextLine();
					System.out.println("digite el mes de cierre de la fecha esperada");
					determinateDate[4] = option.nextInt();
					option.nextLine();
					System.out.println("digite el anho de cierre de la fecha esperada");
					determinateDate[5] = option.nextInt();
					option.nextLine();
					System.out.println(vet.calculateAverageOfAWeek(determinateDate));
						
					System.out.println("*************************************************************************");
				break;
				case 14:
					System.out.println("*************************************************************************");
					System.out.println("digite el anho de inicio de la fecha esperada");
					determinateDate[0] = option.nextInt();
					option.nextLine();
					System.out.println("digite el mes de inicio de la fecha esperada");
					determinateDate[1] = option.nextInt();
					option.nextLine();
					System.out.println("digite el dia de inicio de la fecha esperada");
					determinateDate[2] = option.nextInt();
					option.nextLine();
					System.out.println("digite el anho de cierre de la fecha esperada");
					determinateDate[3] = option.nextInt();
					option.nextLine();
					System.out.println("digite el mes de cierre de la fecha esperada");
					determinateDate[4] = option.nextInt();
					option.nextLine();
					System.out.println("digite el dia de cierre de la fecha esperada");
					determinateDate[5] = option.nextInt();
					
					for(int i = 0;i < vet.getServicesOfADelimitedDate(determinateDate).size();i++){
						System.out.println(vet.getServicesOfADelimitedDate(determinateDate).get(i));
						System.out.println(" ");
					}
					System.out.println("*************************************************************************");
				break;
				case 15:
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
		System.out.println("9. Ver los ingresos por un servicio");
		System.out.println("10. Ver los ingresos totales de la veterinaria");
		System.out.println("11. agregar un nuevo servicio prestado");
		System.out.println("12. Ver el promedio de los ingresos de un servicio");
		System.out.println("13. ver promedio de ingresos en una semana determinada");
		System.out.println("14. reporte de los servicios prestados en una fecha determinada");
		System.out.println("15. Salir del programa ");
	}
	
	public void serviceMenu(){
		System.out.println("escoja el tipo de servicio que busca ");
		System.out.println("1. banho de mascotas en la veterinaria");
		System.out.println("2. banho de mascotas a domicilio");
		System.out.println("3. corte de unhas");
		System.out.println("4. profilaxis dental");
		System.out.println("5. vacunacion");
	}
} //end of class