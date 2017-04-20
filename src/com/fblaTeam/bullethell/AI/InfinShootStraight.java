package com.alexnaustin.bullethell.AI;

import com.alexnaustin.bullethell.AI.bulletPatterns.ShootBullet;
import com.alexnaustin.bullethell.entities.Enemy;
import com.alexnaustin.bullethell.main.Handler;

public class InfinShootStraight extends AI{
	public boolean isMoving;
	public double shootAngle, moveAngle;
	public int frameGap, currentFrame;
	public ShootBullet pattern;

	public InfinShootStraight(Handler handler, Enemy e, double shootAngle, int frameGap) {
		super(handler, e);
		this.shootAngle = shootAngle;
		this.frameGap = frameGap;
		isMoving = false;
		pattern = new ShootBullet(handler, e, shootAngle);
	}
	public InfinShootStraight(Handler handler, Enemy e, double shootAngle, double moveAngle, int frameGap) {
		super(handler, e);
		this.shootAngle = shootAngle;
		this.moveAngle = moveAngle;
		this.frameGap = frameGap;
		isMoving = true;
		pattern = new ShootBullet(handler, e, shootAngle);
	}

	@Override
	public void reset(Enemy e) {
		start();
	}

	@Override
	public void tick() {
		if(isRunning()){
			if(currentFrame >= frameGap){
				currentFrame = 0;
				pattern.fillBullets();
			}else
				currentFrame++;
			if(isMoving){
				e.setVelx(handler.getXSpeed(moveAngle, e.getSpeed()));
				e.setVely(handler.getYSpeed(moveAngle, e.getSpeed()));
				if(isAtDestination()){
					e.setRemoved(true);
					succeed();
				}
				
			}
				
		}
	}
	
	private boolean isAtDestination(){
		if((e.getX() <= -32 || e.getX() >= handler.getWidth()) || (e.getY() <= -32 || e.getY() >= handler.getHeight()))
			return true;
		else
			return false;
	}

}
