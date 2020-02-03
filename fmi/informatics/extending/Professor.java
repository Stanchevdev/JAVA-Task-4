package fmi.informatics.extending;

import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

public class Professor extends Person {

	private String title;


	public Professor(String name, String lname, String title, int egn, int age, char gender, int height, int weight) {
		setName(name);
		setFamily(lname);
		setTitle(title);
		setEgn(egn);
		setAge(age);
		setGender(gender);
		setHeight(height);
		setWeight(weight);
	}



	@Override
	public String toString() {
		return String.format("The professor %s is with title %s", 
							 this.getName(), this.getTitle());
	}

	// Имплементация на абстрактен метод
	@Override
	protected String getTypicalDrink() {
		return "50 years Black Johny";
	}

	// Пренаписване на метод от супер клас
	@Override
	public void goBar() {
		super.goBar();
		System.out.println("After second drink the Professor is happy");
	}

	// Имплементация на методите от двата интерфейса (без getShower(), който е
	// имплементиран в абстрактният клас. Ако е необходимо getShower() може да се пренапише)
	@Override
	public void getUpEarly(Calendar hour) {
		System.out.println("The professor usually gets up at" + hour);
	}

	@Override
	public void run(int minutes) {
		// TODO Auto-generated method stub
	}

	@Override
	public void study() {
		// TODO Auto-generated method stub
	}

	@Override
	public void think() {
		// TODO Auto-generated method stub
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
	}

	// Getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	// Създаваме клас ProfessorGenerator
	public static class ProfessorGenerator {

		private static String[] MaleNames = {"Ivan", "Georgi", "Stoyan", "Petyr", "Dimitur", "Filip"};
		private static String[] FemaleNames = {"Ivana", "Gergana", "Stoyanka", "Petya", "Dimitrinka", "Filareta"};
		private static String[] familyName = {"Petrov", "Ivanov", "Marinov", "Iliev", "Georgiev", "Denishev"};
		private static String[] titles = {"Professor", "PhD", "Asociate assisstant"};
		private static Character[] genders = {'M', 'F'};
		
		public static Professor make() {
			int arrayIndexMale = ThreadLocalRandom.current().nextInt(0, MaleNames.length);
			String Mname = MaleNames[arrayIndexMale];

			int arrayIndexFemale = ThreadLocalRandom.current().nextInt(0, FemaleNames.length);
			String Fname = FemaleNames[arrayIndexFemale];

			int arrayIndexFam = ThreadLocalRandom.current().nextInt(0, familyName.length);
			String Lname = familyName[arrayIndexFam];

			int arrayIndexTitles = ThreadLocalRandom.current().nextInt(0, titles.length);
			String title = titles[arrayIndexTitles];

			int arrayIndexGender = ThreadLocalRandom.current().nextInt(0, genders.length);
			char gender = genders[arrayIndexGender];

			int egn = ThreadLocalRandom.current().nextInt(111111, 999999);
			
			int age = ThreadLocalRandom.current().nextInt(18, 80);

			int height =  ThreadLocalRandom.current().nextInt(150, 220);
			
			int weight = ThreadLocalRandom.current().nextInt(50, 220);
			String Name;
			String Family;
			if (gender == 'F'){
				String Lnameplus = (Lname + "a");
				Name = Fname;
				Family = Lnameplus;
			}
			else{
				Name=Mname ;
				Family=Lname;
			}
			return new Professor(Name, Family, title, egn, age, gender, height, weight);
		}
	}
}
