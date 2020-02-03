package fmi.informatics.extending;

import java.util.Calendar;

import java.util.concurrent.ThreadLocalRandom;

// Дефиниране на клас Student, който разширява абстрактния клас Person.
// Като наследник притежава всички характеристики и методи на класа родител
public class Student extends Person {

	private String university;
	private String speciality;
	private int facNumber;


	public Student(String name, String lname, int egn, String university, String speciality, int facNumber, int age, char gender, int height, int weight) {
		setName(name);
		setFamily(lname);
		setEgn(egn);
		setUniversity(university);
		setSpeciality(speciality);
		setFak(facNumber);
		setAge(age);
		setGender(gender);
		setHeight(height);
		setWeight(weight);

	}


	/*
	 * Пренаписване на метод от клас родител. В runtime всички обекти от тип Student ще
	 * извикват само пренаписаният метод, дори и да са дефинирани като обекти от базовият тип
	 */
	@Override
	public void run() {
		System.out.println("The student is running");
	}
	
	@Override
	public String toString() {
		return String.format("The student %s is learning in %s speciality", 
							 this.getName(), this.getSpeciality());
	}

	public void study() {
		System.out.println("The student is studying");
	}

	public void takeExam() {
		System.out.println("The student passed the exam");
	}

	public void goBar(String drink) {
		System.out.println("The student " + getName() +  " drinking " + drink);
	}
	
	// Имплементация на абстрактен метод от супер клас
	@Override
	protected String getTypicalDrink() {
		return "Vodka";
	}
	
	// Имплементация на методите от двата интерфейса (без getShower(), който е
	// имплементиран в абстрактният клас. Ако е необходимо getShower() може да се пренапишe)
	@SuppressWarnings("static-access")
	@Override
	public void getUpEarly(Calendar hour) {
		System.out.println("The student usually gets up at " + hour.HOUR);
	}

	@Override
	public void run(int minutes) {
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
	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public int getFacNumber() {
		return facNumber;
	}

	public void setFacNumber(int facNumber) {
		this.facNumber = facNumber;
	}
	
	// Пример за статичен вложен клас
	// Добавяме в класа Student помощен клас за произволно създаване на студенти - StudentGenerator
	public static class StudentGenerator {
		private static String[] MaleNames = {"Ivan", "Georgi", "Stoyan", "Petyr", "Dimitur", "Filip"};
		private static String[] familyName = {"Petrov", "Ivanov", "Marinov", "Iliev", "Georgiev", "Denishev"};
		private static String[] FemaleNames = {"Ivana", "Gergana", "Stoyanka", "Petya", "Dimitrinka", "Filareta"};
		private static String[] specialities = {"Informatics", "STD", "BIT", "Mathematics"};
		private static String[] universities = {"PU", "NBU", "SU", "UHT"};
		private static Character[] genders = {'M', 'F'};

		public static Student make() {
			int arrayIndexMale = ThreadLocalRandom.current().nextInt(0, MaleNames.length);
			String Mname = MaleNames[arrayIndexMale];

			int arrayIndexFemale = ThreadLocalRandom.current().nextInt(0, FemaleNames.length);
			String Fname = FemaleNames[arrayIndexFemale];

			int arrayIndexFam = ThreadLocalRandom.current().nextInt(0, familyName.length);
			String Lname = familyName[arrayIndexFam];

			int arrayIndexSpec = ThreadLocalRandom.current().nextInt(0, specialities.length);
			String speciality = specialities[arrayIndexSpec];


			int arrayIndexUni = ThreadLocalRandom.current().nextInt(0, universities.length);
			String university = universities[arrayIndexUni];

			int arrayIndexGender = ThreadLocalRandom.current().nextInt(0, genders.length);
			char gender = genders[arrayIndexGender];

			int facNumber = ThreadLocalRandom.current().nextInt(111111, 999999);
			
			int egn = ThreadLocalRandom.current().nextInt(111111, 999999);
			
			// добавяме генериране на години, височина и тегло
			int age = ThreadLocalRandom.current().nextInt(18, 30);
			
			int height =  ThreadLocalRandom.current().nextInt(150, 220);
			
			int weight = ThreadLocalRandom.current().nextInt(50, 220);
			String Name;
			String Lnameplus;
			if (gender == 'F'){
				Lnameplus = (Lname + "a");
				Name = Fname;
			}else{
				Lnameplus = Lname;
				Name = Mname;
			}
			return new Student(Name, Lnameplus, egn, university, speciality, facNumber, age, gender, height, weight);

		}
	}
}