package ru.specialist;

//import ru.specialist.stuff.Stuff;
//import static java.lang.Math.sin;

import static ru.specialist.Course.printCounter;

public class App {

	public static void main(String[] args) {
		//System.out.println("Hello world!");
		
		//Course.printCounter();
		printCounter();
		
		// Course c; // объект не создаётся!!! есть только ссылка, которая по умолчанию будет null
		
		Course c1 = new Course("Java 2. OOP", 40);
		//c1.title = "Java 2. OOP";
		//c1.length = 40;
		
		c1.print(); // this = c1
		
		Course c2 = new Course("Pattern OOP");
		//c2.title = "Pattern OOP";
		c2.setLength(24);
		System.out.println(c2.getLength());
		
		c2.print(); // this = c2
		
		Course c3 = new Course();
		//c3.setTitle("  ");
		c3.print(); // this = c3
		System.out.println(c3.getTitle());
		
		//ru.specialist.stuff.Stuff s;
		//Stuff s;
		
		Course.printCounter();
		
		// Course c4 = new Course();
		// c4.setLength(17);
		// c4.print();
		
		new Course()
			.setLength(17)
			.print();
		
		// объекты в одном состоянии, но разные identity
		var c5 = new Course("Spring Intro", 40);
		var c6 = new Course("Spring Intro", 40);
		
		c5.print();
		c6.print();
		
		System.out.println( c5 == c6 ); // сравнение ссылок (только identity)
		System.out.println( c5.equals(c6) ); // сравнение по полям
		
		System.out.println( c5.hashCode() );
		System.out.println( c6.hashCode() );
		
		//var str1 = new String("abc");
		//var str2 = new String("abc");
		//System.out.println( str1 == str2 ); 
		//System.out.println( str1.equals(str2) );
		
		
		
	}

}
