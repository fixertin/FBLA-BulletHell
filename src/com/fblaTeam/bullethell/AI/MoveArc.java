package com.fblaTeam.bullethell.AI;

import com.fblaTeam.bullethell.entities.Enemy;
import com.fblaTeam.bullethell.main.Handler;

public class MoveArc extends AI{
	public double distance;
	public double angleChange;
	public double startingAngle;
	public int movementAmount, currentIndex;
	public MoveTo[] amountOfMovements;
	
	//DOUBLE distance until angle change
	//DOUBLE angle change amount
	//DOUBLE starting angle
	//int amount of changes
	public MoveArc(Handler handler, Enemy e, double distance, double angleChange, double startingAngle, int movementAmount) {
		super(handler, e);
		this.distance = distance;
		this.angleChange = angleChange;
		this.startingAngle = startingAngle;
		this.movementAmount = movementAmount;
		
		System.out.println(Math.sin((5*3.14)/6) + " " + Math.cos((5*3.14)/6));
		
		amountOfMovements = new MoveTo[movementAmount];
		for(int i=0; i<amountOfMovements.length; i++){
			double tempAngle = startingAngle + (angleChange*i);
			
			if(tempAngle < 0){
				long temp = (long)tempAngle/360;
				tempAngle = 360*(Math.abs(temp)) + tempAngle;
			} else if (tempAngle > 360){
				long temp = (long)tempAngle/360;
				tempAngle -= 360*temp;
			}
			System.out.println(tempAngle);
			amountOfMovements[i] = new MoveTo(handler, distance, e, tempAngle);

		}
	}

	public void resetEnemyPosition(Enemy e){
		this.e = e;
	}
	
	@Override
	public void reset(Enemy e) {
		this.e = e;
		amountOfMovements[currentIndex].reset(e);
		start();
	}

	@Override
	public void tick() {
		if(isRunning()){
			MoveTo current = amountOfMovements[currentIndex];
			
			if(current.getState() == null){
				current.start();
			} else if(!current.isSuccess()){
				current.tick();
			} else if(current.isSuccess() && currentIndex+1 < amountOfMovements.length){
				System.out.println(currentIndex + 1);
				currentIndex++;
				amountOfMovements[currentIndex].reset(e);
			} else if(current.isSuccess() && currentIndex+1 >= amountOfMovements.length){
				succeed();
			}
		}
	}

}
