package com.alexnaustin.bullethell.creatures;

import java.awt.Graphics;

import com.alexnaustin.bullethell.main.Handler;



public abstract class Entity {
	protected double x, y, velx, vely;
	protected Handler handler;
	
	public Entity(Handler handler, double x, double y){
		this.x = x;
		this.y = y;
		this.handler = handler;
		velx = 0;
		velx = 0;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getVelx() {
		return velx;
	}

	public void setVelx(double velx) {
		this.velx = velx;
	}

	public double getVely() {
		return vely;
	}

	public void setVely(double vely) {
		this.vely = vely;
	}

}
