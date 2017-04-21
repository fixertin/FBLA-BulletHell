package com.fblaTeam.bullethell.AI.bulletPatterns;


import com.fblaTeam.bullethell.creatures.BasicBullet;
import com.fblaTeam.bullethell.entities.Enemy;
import com.fblaTeam.bullethell.main.Handler;

public class Circle extends Pattern{
	public double shotGap;

	public Circle(Handler handler, Enemy shooter, double shotGap) {
		super(handler, shooter);
		this.shotGap = shotGap;
	}
	
	public void fillBullets(){
		for(int i=0; i<(360/shotGap); i++){
			handler.getWorld().getBullets().add(new BasicBullet(handler, shooter.getX(), shooter.getY(), i*shotGap, shooter));
		}
	}



}
