package com.alexnaustin.bullethell.AI.bulletPatterns;

import java.util.Random;

import com.alexnaustin.bullethell.creatures.LargeBullet;
import com.alexnaustin.bullethell.entities.Enemy;
import com.alexnaustin.bullethell.main.Handler;

public class Flurry extends Pattern{
	public int angle;
	public Random r;
	
	public Flurry(Handler handler, Enemy shooter) {
		super(handler, shooter);
		r = new Random();
	}

	public void setNewAngle(int angle){
		this.angle = angle;
	}
	
	@Override
	public void fillBullets() {
		handler.getWorld().getBullets().add(new LargeBullet(handler, shooter.getX(), shooter.getY(), angle, shooter, r.nextInt(6-4)+4));
	}

}
