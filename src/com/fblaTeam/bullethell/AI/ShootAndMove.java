package com.fblaTeam.bullethell.AI;

import java.awt.Rectangle;

import com.fblaTeam.bullethell.AI.bulletPatterns.ShootBullet;
import com.fblaTeam.bullethell.entities.Enemy;
import com.fblaTeam.bullethell.main.Handler;

public class ShootAndMove extends AI{
	private double destX;
	private double destY;
	private double distance;
	private double velx, vely, speed, frameGap;
	public double angle;
	public double originalAngle;
	public int currentFrame;
	public ShootBullet pattern;

	public ShootAndMove(Handler handler, double distance, Enemy e, double angle, double shootAngle, double frameGap) {
		super(handler, e);
		this.distance = distance;
		this.angle = angle;
		this.frameGap = frameGap;
		speed = e.getSpeed();
		
		pattern = new ShootBullet(handler, e, shootAngle);
		
		setValues();
	}
	public ShootAndMove(Handler handler, double distance, Enemy e, double angle, double shootAngle, double frameGap, double speed) {
		super(handler, e);
		this.distance = distance;
		this.angle = angle;
		this.frameGap = frameGap;
		this.speed = speed;
		pattern = new ShootBullet(handler, e, shootAngle);
		setValues();
	}
	
	private void setValues(){
		destX = (Math.cos(Math.toRadians(this.angle)) * distance)+ (e.getX() + 32-8);
		destY = (Math.sin(Math.toRadians(this.angle)) * distance)+ (e.getY() + 32-8);
		e.test.setBounds((int)destX, (int)destY, 16, 16);
		velx = handler.getXSpeed(angle, speed);
		vely = handler.getYSpeed(angle, speed);
		hitbox = new Rectangle();
		setBounds();
	}
	
	public void setBounds(){
		hitbox.setBounds((int)destX, (int)destY, 16, 16);
	}

	@Override
	public void reset(Enemy e) {
		this.e = e;
		setValues();
		start();
	}

	@Override
	public void tick() {
		setBounds();
		if(isRunning()){
			if(!isAtDestination()){
				moveEnemy();
				if(currentFrame >= frameGap){
					pattern.fillBullets();
					currentFrame = 0;
				}else
					currentFrame++;
			}else{
				succeed();
				e.setVelx(0);
				e.setVely(0);
			}
		}
	}
	
	private void moveEnemy(){
		e.setVelx(velx);
		e.setVely(vely);
	}
	private boolean isAtDestination(){
		if(e.getMovementHitbox().getBounds().intersects(hitbox))
			return true;
		else 
			return false;
		
	}
}
