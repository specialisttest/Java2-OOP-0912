package ru.specialist.graph;

//C++
//нечто масштабируемое
//pure abstract class - чисто абстрактный класс
//	нет полей
//	все методы  - абстрактные
//abstract class Scaleable {
//	public abstract void scale(double factor);
//}

//class Circle : Shape, Scaleable
//class Point  : Shape 

public interface Scaleable {
	
	public static final double DEFAULT_FACTOR = 2D;
	
	public static void scaleScene(Scene scene) {
		scene.scale(DEFAULT_FACTOR);
	}
	
	//public abstract 
	void scale(double factor); 
	// void scale(); // classic Java (until Java 8)
	
	// since Java 8
	// public
	default void scale() {
		this.scaleImpl();
	}
	
	// since Java 9
	private void scaleImpl() {
		this.scale(DEFAULT_FACTOR);
	}
}

interface AnotherScaleable {
	default void scale() {
		
		
	}
}

interface Scaleable3D extends Scaleable/*, ..... */ {
	void scale3D(double factorX, double factorY, double factorZ); 
}

//автоматически реализует и Scaleable, т.к. Scaleable3D наследник Scaleable
class Sphere implements Scaleable3D {

	@Override
	public void scale(double factor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scale3D(double factorX, double factorY, double factorZ) {
		// TODO Auto-generated method stub
		
	}
	
}
