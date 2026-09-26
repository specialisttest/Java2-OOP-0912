package ru.specialist.graph;

public class Coords {
	private int x = 0, y = 0;
	
	private double distance;
	private boolean invalidated = true;
	
	public Coords() {
		this(0, 0);
	}
	
	public Coords(int x, int y) {
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if (this.x != x) {
			this.x = x;
			invalidated = true;
		}
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if (this.y != y) {
			this.y = y;
			invalidated = true;
		}
	}
	
	public double distance() {
		if (invalidated) {
			distance = Math.sqrt( getX()*getX() + getY()*getY() );
			invalidated = false;
		}
		return distance;
	}
	
	@Override
	public String toString() {
		return String.format("(%d, %d)", getX(), getY());
	}
}
