package ru.specialist.people;

public /*final*/ /*abstract*/ class Person { // extends Object

	private String name;
	private int age;

	public Person() {
		System.out.println("Person ctor()");
	}
	
	public Person(String name, int age) {
		System.out.println("Person ctor(String, int)");
		setName(name);
		setAge(age);
	}
	
	public /*final*/ void print() {
		System.out.print("Person.print()\t");
		System.out.printf("%-15s : %d\n", getName(), getAge());
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	//public abstract void show();
	
}
