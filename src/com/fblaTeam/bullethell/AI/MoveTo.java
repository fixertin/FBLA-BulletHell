package com.alexnaustin.bullethell.AI;

import java.awt.Rectangle;

import com.alexnaustin.bullethell.entities.Enemy;
import com.alexnaustin.bullethell.main.Handler;

public class MoveTo extends AI {
	private double destX;
	private double destY;
	private double distance;
	private double velx, vely;
	public double angle;
	public double originalAngle;

	public MoveTo(Handler handler, double distance, Enemy e, double angle) {
		super(handler, e);
		this.distance = distance;
		this.angle = angle;
		setValues();
	}
	
	private void setValues(){
		destX = (Math.cos(Math.toRadians(this.angle)) * distance)+ (e.getX() + 32-8);
		destY = (Math.sin(Math.toRadians(this.angle)) * distance)+ (e.getY() + 32-8);
		e.test.setBounds((int)destX, (int)destY, 16, 16);
		velx = handler.getXSpeed(angle, 3);
		vely = handler.getYSpeed(angle, 3);
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
			if(!isAtDestination())
				moveEnemy();
			else{
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
