package ru.specialist;

import java.util.Objects;

// @Deprecated
public class Course implements Comparable<Course> {
	// константы - значения определены на этапе компиляции
	public static final String DEFAULT_TITLE = "Новый курс";
	public static final int DEFAULT_LENGTH = 8;
	public static final int MAX_LENGTH = 60;
	public static final int MIN_LENGTH = 4;
	
	public static final String DEFAULT_ORGANIZTION = "Specialist.ru";
	
	// поле класса (статическое)
	private static int counter = 0;
	
	// статический блок инициализации
	static {
		//counter = 0;
	}
	
	// финализированное поле - значение определяется в runtime, но только при создании объекта
	
	public final String organization;
	
	// поля описывают данные (состояние) объекта (нестатические)
	
	private String title = "New Course"; // 1. выражение инициализации
	private int length;
	
	// 2. блок инициализации (редко встречается)
	{
		length = 16;
	}
	
	// 3. конструкторы
	public Course() {
		//this.title = "Новый курс";
		//this.length = 8;
		this(DEFAULT_TITLE);
	}
	
	public Course(String title) {
		//this.title = title;
		//this.length = 8;
		this(title, DEFAULT_LENGTH); // первый оператор (c Java 25 необязательно)
		//System.out.println("Course(String)");
	}
	
	public Course(String title, int length) {
		this(title, length, DEFAULT_ORGANIZTION);
	}
	
	public Course(String title, int length, String org) {
		this.organization = org;
		//this.title = title;
		//this.length = length;
		setTitle(title);
		setLength(length);
		
		// любый другие действия (почти ))
		//Course.counter++;
		counter++;
	}
	
	// private boolean checked;
	
	// boolean getChecked()
	// boolean hasChecked()
	// boolean isChecked()
	
	
	// Инкапсуляция с помощью геттера и сеттера
	// Свойство (property) - Length
	public int getLength() {
		return length;
	}
	
	public Course setLength(int length) {
		if (length >= MIN_LENGTH && length <= MAX_LENGTH) // length in [min, max]
			this.length = length;
		else
			throw new IllegalArgumentException("length out of ["+MIN_LENGTH+", "+MAX_LENGTH+"]");
		
		return this;
	}
	
	// Свойство (property) - readonly (world) Title
	public String getTitle() {
		return title;
	}

	private void setTitle(String title) {
		if (title != null && !title.isBlank())
			this.title = title;
		else
			throw new IllegalArgumentException("course title is blank or null");
	}
	
	// Свойство (property) readonly - Teacher
	public String getTeacher() {
		return "Неизвестный";
	}
	

	// статические методы (просто функции)
	public static void printCounter() {
		// this недоступна!!!
		// доступны статические поля и параметры (если есть)
		System.out.printf("Всего курсов: %d\n", Course.counter);
	}
	
	// Свойство только для чтения - readonly property - Code
	public String getCode() {
		return String.format("%c%c%c%c", 
				getTitle().charAt(0), getTitle().charAt(2),
				getTitle().charAt(4), getTitle().charAt(6)
				);
	}
	
	// методы описывают операции (поведение) объектов
	
	public void print() {
		int length = -1;
	
		// this - автоматическая переменная содержит ссылку на объект для которого вызван данный метод
		// Название (title) : Длительность (length)
		System.out.printf("%s. %s : %d\n", getCode(), getTitle() , this.getLength());
	}
	
	
	@Override
	public boolean equals(Object o) {
		// this  obj
		if (this == o) return true;
		if (o == null) return false;
		
		if (getClass() != o.getClass()) return false;
		
		Course c = (Course)o;
		return this.getTitle().equals(c.getTitle()) &&
				   this.getLength() == c.getLength() &&
				   this.getTeacher().equals(c.getTeacher()) &&
				   this.organization.equals(c.organization);		
		
//		Может выдавать истину в том числе при сравнении Course с наследником Course		
//		if (o instanceof Course c) {
//			return this.getTitle().equals(c.getTitle()) &&
//				   this.getLength() == c.getLength() &&
//				   this.organization.equals(c.organization);
//		}
//		else
//			return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getTitle(), getLength(), getTeacher(), this.organization);
	}

	@Override
	public String toString() {
		return String.format("%-21s : %-3d", getTitle(), getLength());
	}
	
	@Override
	public int compareTo(Course c) {
		// 1  this > c
		// 0  this == c
		// -1 this < c
		
		//if (this.getLength() > c.getLength()) return 1;
		//if (this.getLength() < c.getLength()) return -1;
		//return 0;
		
		//return this.getLength() - c.getLength();
		return this.getTitle().compareTo(c.getTitle());
	}
	
}
