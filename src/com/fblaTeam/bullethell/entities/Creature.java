package com.alexnaustin.bullethell.entities;

import java.awt.Rectangle;

import com.alexnaustin.bullethell.creatures.Entity;
import com.alexnaustin.bullethell.main.Handler;

public abstract class Creature extends Entity{
	
	protected int health;
	protected double speed;
	protected Rectangle hitbox;

	public Creature(Handler handler, double x, double y) {
		super(handler, x, y);
		health = 100;
		speed = 4;
	}
	
	public void move(){
		x += velx;
		y += vely;
	}
	
	public abstract void setHitboxBounds();
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
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

}
