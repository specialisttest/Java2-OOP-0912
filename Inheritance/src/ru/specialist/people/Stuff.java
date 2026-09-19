package ru.specialist.people;

public class Stuff extends Person {
	
	public static final int DEFAULT_SALARY = 100; // константа
	
	final int salary; // не константа
	
	public Stuff(String name, int age, String position) {
		this(name, age, position, DEFAULT_SALARY);
	}
	public Stuff(String name, int age, String position, int salary) {
		super(name, age);
		//super();
		this.salary = salary;
		System.out.println("Stuff ctor(String, int, String)");
		// since java 25
		// но только до вызовов методов объекта
		// super(name, age);
		
		//super(name, age);
		//setName(name);
		//setAge(age);
		setPosition(position);
		
		// нельзя
		// super(name, age);
	}
	
	private String position;
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	@Override 
	public  void print() {
		System.out.print("Stuff.print()\t");
		System.out.printf("%s\t%d ", getPosition(), this.salary);
		super.print();
		
		//System.out.printf("%-15s : %d\n", getName(), getAge());
		//System.out.printf("%-15s : %d\n%s\n", getName(), getAge(),getPosition());
		//System.out.printf("%s - %s\n", getName(), getPosition());
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s", getPosition(), getName());
	}
	
	/*@Override
	public void show() {
		System.out.println(this); // toString()
		
	}*/
	

}
