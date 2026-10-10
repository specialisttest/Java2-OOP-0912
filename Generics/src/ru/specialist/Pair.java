package ru.specialist;

public class Pair<T extends Comparable<? super T>> {
	
	private T x, y; // Object 
	
	// true x > y
	// else false
	public boolean isGreater() {
		return x.compareTo(y) > 0; // x > y
	}
	
	public Pair(T x, T y) {
		this.x = x;
		this.y = y;
	}

	public T getX() {
		return x;
	}

	public T getY() {
		return y;
	}

}
