package com.alexnaustin.bullethell.clock;

public class Timer extends Clock {
	
	public double difference, limit, limitMS;
	
	public Timer(double limit)
	{
		this.limit =  limit;
		limitMS = limit * 1000;
	}

	@Override
	public void tick() {
		current = System.currentTimeMillis();
		difference = current - start;
	}
	
	public boolean hasReachedTime(){
		if(difference >= limitMS)
			return true;
		else
			return false;
	}

	
	public void reset() {
		// TODO Auto-generated method stub
		difference = 0;
		start = System.currentTimeMillis();
	}
	
	

}
