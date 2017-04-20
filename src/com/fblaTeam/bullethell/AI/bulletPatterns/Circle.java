package com.alexnaustin.bullethell.AI.bulletPatterns;


import com.alexnaustin.bullethell.creatures.BasicBullet;
import com.alexnaustin.bullethell.entities.Enemy;
import com.alexnaustin.bullethell.main.Handler;

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
