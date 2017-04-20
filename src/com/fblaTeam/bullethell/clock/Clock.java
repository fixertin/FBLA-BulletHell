package com.alexnaustin.bullethell.clock;

public abstract class Clock {
    
	protected double start, current;
	public abstract void tick();
	
	
	public double getStart() {
		return start;
	}
	public void setStart(double start) {
		this.start = start;
	}
	public double getCurrent() {
		return current;
	}
	public void setCurrent(double current) {
		this.current = current;
	}
	
	
}


