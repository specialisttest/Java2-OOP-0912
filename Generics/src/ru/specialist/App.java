package ru.specialist;

import static java.lang.System.out;

public class App {
	
	/*public static boolean isGreater(int x, int y) {
		return x > y;
	}

	public static boolean isGreater(double x, double y) {
		return x > y;
	}
	
	public static boolean isGreater(String x, String y) {
		return x.compareTo(y) > 0;
	}*/
	
	public static <T extends Comparable<? super T>> boolean isGreater(T x, T y) {
		return x.compareTo(y) > 0;
	}
	
	public static void main(String[] args) {
		
		out.println( isGreater(5, 6));
		out.println( isGreater(2.5, 6.1));
		out.println( isGreater("abc", "cde"));
		
		out.println ( App.<Integer>isGreater(11, 6) );
		
		Pair<Integer> p1 = new Pair<Integer>(6, 5);
		out.printf("%d %d\n", p1.getX(), p1.getY());
		out.printf("%d\n", p1.getX() * p1.getY());
		out.printf("%s\n", p1.isGreater());
		
		//Pair<Double> p2 = new Pair<Double>(2.5, 6.1);
		var p2 = new Pair<Double>(2.5, 6.1);
		out.printf("%f %f\n", p2.getX(), p2.getY());
		
		//Pair<String> p3 = new Pair<String>("abc", "cde");
		Pair<String> p3 = new Pair<>("abc", "cde");
		out.printf("%s %s\n", p3.getX(), p3.getY());
		
		// type check
		// Pair<App> p33 = new Pair<App>(new App(), "cde");
		//Pair<App> p33 = new Pair<App>(new App(), new App());
		
		
		Pair2<String, Integer> p4 = new Pair2<String, Integer>("abc", 56);
		out.printf("%s %d\n", p4.getX(), p4.getY());
		
		//Pair<Object> p5 = new Pair<Object>("abc", 56);
		Pair p5 = new Pair("abc", 56); // raw type
		
		


	}

}
