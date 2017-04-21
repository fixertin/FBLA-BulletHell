package com.fblaTeam.bullethell.AI;

import com.fblaTeam.bullethell.entities.Enemy;
import com.fblaTeam.bullethell.main.Handler;

public class MoveToEdge extends AI{
	private double angle;
	private double velX, velY;

	public MoveToEdge(Handler handler, Enemy e, double angle) {
		super(handler, e);
		this.angle = angle;
		init();
	}
	
	private void init(){
		velX = handler.getXSpeed(angle, 3);
		velY = handler.getYSpeed(angle, 3);
	}
	
	@Override
	public void reset(Enemy e) {
		start();
	}

	@Override
	public void tick() {
		if(isRunning()){
			if(!isAtDestination())
				moveEnemy();
			else{
				succeed();
				e.setRemoved(true);
			}
		}
	}
	
	private void moveEnemy(){
		e.setVelx(velX);
		e.setVely(velY);
	}
	
	private boolean isAtDestination(){
		if((e.getX() <= -32 || e.getX() >= handler.getWidth()) || (e.getY() <= -32 || e.getY() >= handler.getHeight()))
			return true;
		else
			return false;
	}

}
