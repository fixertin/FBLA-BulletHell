package com.alexnaustin.bullethell.creatures;

import java.awt.Rectangle;

import com.alexnaustin.bullethell.entities.Creature;
import com.alexnaustin.bullethell.main.Handler;

public abstract class Bullet extends Entity{
	protected double angle;
	protected Creature shooter;
	protected double speed;
	protected Rectangle hitbox = new Rectangle();
	protected boolean isDestructable;
	

	public Bullet(Handler handler, double x, double y, double angle, Creature shooter) {
		super(handler, x, y);
		this.angle = angle;
		this.shooter = shooter;
	}


	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}
	public Creature getShooter() {
		return shooter;
	}
	public void setShooter(Creature shooter) {
		this.shooter = shooter;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public Rectangle getHitbox() {
		return hitbox;
	}
	public void setHitbox(Rectangle hitbox) {
		this.hitbox = hitbox;
	}


	protected double getXSpeed(){
		double temp = Math.cos(Math.toRadians(angle)) * speed;
		return temp;
		
	}
	protected double getYSpeed(){
		double temp = Math.sin(Math.toRadians(angle)) * speed;
		return temp;
	}
	public boolean isAtEdge(){
		if((x <= -64) || (x >= handler.getWidth()+64) || (y <= -64) || (y >= handler.getHeight()+64)){
			return true;
		}
		else
			return false;
	}
	public boolean hasIntersectedPlayer(){
		if((hitbox.intersects(handler.getWorld().getP().getHitbox())&&(shooter != handler.getWorld().getP())))
			return true;
		else
			return false;
	}
	public boolean hasIntersectedEnemy(int i){
		if((handler.getWorld().getEnemies().get(i) != shooter)&&(hitbox.intersects(handler.getWorld().getEnemies().get(i).getHitbox())))
			return true;
		else
			return false;
	}
}
